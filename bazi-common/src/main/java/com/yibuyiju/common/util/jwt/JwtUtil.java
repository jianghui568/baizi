package com.yibuyiju.common.util.jwt;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONUtil;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.yibuyiju.common.exception.JwtBizException;
import com.yibuyiju.common.response.ResponseCode;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/5 13:34
 */
public class JwtUtil {

    protected static String secret = "kJA12(^Njd&^78132";

    public static String generateToken(PayloadDTO payload) {
        return JwtUtil.generateToken(JSONUtil.toJsonStr(payload));
    }

    public static String generateToken(String payloadString) {
        try {
            // 准备JWS-header
            JWSHeader jwsHeader = new JWSHeader.Builder(JWSAlgorithm.HS256).type(JOSEObjectType.JWT).build();
            // 将负载信息装载到payload
            Payload payload = new Payload(payloadString);
            // 封装header和payload到JWS对象
            JWSObject jwsObject = new JWSObject(jwsHeader, payload);
            // 创建HMAC签名器
            JWSSigner jwsSigner = new MACSigner(SecureUtil.md5(JwtUtil.secret));
            // 签名
            jwsObject.sign(jwsSigner);
            return jwsObject.serialize();
        } catch (JOSEException e) {
            e.printStackTrace();
            throw new JwtBizException("token生成失败!");
        }
    }

    public static PayloadDTO verifyToken(String token) {
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            // 创建HMAC验证器
            JWSVerifier jwsVerifier = new MACVerifier(SecureUtil.md5(JwtUtil.secret));
            if (!jwsObject.verify(jwsVerifier)) {
                throw new JwtBizException(ResponseCode.UNAUTHORIZED, "token签名不合法!");
            }
            String payload = jwsObject.getPayload().toString();
            PayloadDTO payloadDto = JSONUtil.toBean(payload, PayloadDTO.class);
            if (payloadDto.getExp() < System.currentTimeMillis()) {
                throw new JwtBizException(ResponseCode.UNAUTHORIZED, "token已过期!");
            }
            return payloadDto;
        } catch (ParseException | JOSEException e) {
            e.printStackTrace();
            throw new JwtBizException(ResponseCode.UNAUTHORIZED, "token解析错误!");
        }
    }

    public static PayloadDTO getDefaultPayloadDTO() {
        Date now = new Date();
        Date exp = DateUtil.offsetSecond(now, 60 * 60);
        return PayloadDTO.builder()
                .sub("zsh")
                .iat(now.getTime())
                .exp(exp.getTime())
                .jti(UUID.randomUUID().toString())
                .username("zsh")
                .authorities(CollUtil.toList("ADMIN"))
                .build();
    }
}

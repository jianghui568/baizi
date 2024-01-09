package com.yibuyiju.common.util.jwt;

import org.springframework.util.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/5 13:51
 */
public class TestJwtUtil {

    @Test
    public void testJwt() {
        PayloadDTO payloadDTO = JwtUtil.getDefaultPayloadDTO();

        String token = JwtUtil.generateToken(payloadDTO);

        PayloadDTO payload = JwtUtil.verifyToken(token);

        Assert.isTrue(payload.getUsername().equals(payloadDTO.getUsername()), "except username:" + payloadDTO.getUsername() + "; but got:" + payloadDTO.getUsername());

        payloadDTO = JwtUtil.generatePayload(1, 1000);

        token = JwtUtil.generateToken(payloadDTO);

        payload = JwtUtil.verifyToken(token);

        Assert.isTrue(payload.getUsername().equals(payloadDTO.getUsername()), "except username:" + payloadDTO.getUsername() + "; but got:" + payloadDTO.getUsername());
    }
}

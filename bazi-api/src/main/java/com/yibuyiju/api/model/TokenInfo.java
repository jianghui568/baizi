package com.yibuyiju.api.model;

import lombok.Data;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/9 16:24
 */
@Data
public class TokenInfo {
    public static String BEARER = "Bearer";

    private String tokenType;
    private long expiresIn;
    private String token;

    public static TokenInfo generateJwtToken(String token, long expiresIn) {
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setToken(token);
        tokenInfo.setExpiresIn(expiresIn);
        tokenInfo.setTokenType(TokenInfo.BEARER);
        return tokenInfo;
    }
}

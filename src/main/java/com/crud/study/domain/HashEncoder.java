package com.crud.study.domain;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HashEncoder {

    // 서버 비밀키: 동일 입력에 대해 동일 해시를 만들기 위한 고정 키
    private final String secret;

    public HashEncoder(@Value("${app.hash.secret}") String secret) {
        this.secret = secret;
    }

    // 결정적 HMAC-SHA256: 같은 입력이면 항상 같은 해시가 생성됨
    // 조회가 필요한 식별자(이메일/전화번호)에 사용하고, 비밀번호에는 사용하지 않음
    public String hashEncode(String value) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] result = mac.doFinal(value.getBytes(StandardCharsets.UTF_8));
            return toHex(result);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalStateException("Failed to HMAC hash value", e);
        }
    }

    // 바이트 배열을 소문자 16진수 문자열로 변환
    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

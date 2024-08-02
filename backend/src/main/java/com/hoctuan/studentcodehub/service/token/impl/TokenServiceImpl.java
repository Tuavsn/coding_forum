package com.hoctuan.studentcodehub.service.token.impl;

import com.hoctuan.studentcodehub.config.AppConstant;
import com.hoctuan.studentcodehub.model.entity.account.User;
import com.hoctuan.studentcodehub.service.account.AuthService;
import com.hoctuan.studentcodehub.service.token.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import com.google.common.hash.Hashing;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private AppConstant appConstant;
    @Autowired
    private JwtEncoder jwtEncoder;
    @Autowired
    private AuthService authService;

    @Override
    public String buildToken(User user, HttpServletRequest request) {
        Instant now = Instant.now();
        Instant expiresAt = now.plus(appConstant.getExpiresTime(), ChronoUnit.DAYS);

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(expiresAt)
                .subject(user.getId().toString())
                .claim("role", user.getRole())
                .build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return token;
    }

    @Override
    public boolean validateToken(String token) {
        User user = authService.getUserAuthenticated();
        if(user == null) { return false; }
        return user.getDevices().stream().anyMatch(
                d -> d.getToken().equals(hashString(token))
        );
    }

    @Override
    public boolean compareToken(String tokenHash, String tokenPlain) {
        return tokenHash.equals(hashString(tokenPlain));
    }

    private String hashString(String str) {
        return Hashing
                .sha256()
                .hashString(str, StandardCharsets.UTF_8)
                .toString();
    }
}

package com.barretto.agendamento.service;


import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class JwtService {

    private static final String SECRET = "barretto-agendamento-api";

    public String gerarToken(String email) {

        return JWT.create()
                .withSubject(email)
                .withIssuer("agendamento")
                .sign(
                        Algorithm.HMAC256(SECRET)
                );
    }

    public String validarToken(String token) {

        try {

            return JWT.require(
                    Algorithm.HMAC256(SECRET)
            )

                    .withIssuer("agendamento")

                    .build()

                    .verify(token)

                    .getSubject();

        } catch (Exception e) {

            return null;
        }
    }
}

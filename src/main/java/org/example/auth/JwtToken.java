package org.example.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtToken {

    @Autowired
    public JwtToken() {}
    public String secretKey = "jys1107*";
    public Map<String, Object> makeHeader() {

        Map<String, Object> headerClaims = new HashMap<>();
        headerClaims.put("alg", "HMCA256");
        headerClaims.put("typ", "JWT");

        return headerClaims;
    }
    public Map<String, String> makePayload(User user) {

        Map<String, String> payloadClaims  = new HashMap<>();
        payloadClaims.put("UserId", Long.toString(user.getUserId()));
        payloadClaims.put("UserName", user.getUserName());

        return payloadClaims ;
    }
    public String create(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            Map<String, Object> headerClaims = makeHeader();
            Map<String, String> payloadClaims = makePayload(user);

            return JWT.create().withIssuer("sudo").withIssuedAt(new Date()).withHeader(headerClaims).withPayload(payloadClaims).sign(algorithm);
        }
        catch(JWTCreationException exception) {
            System.out.println("JWT CRETAE EXCEPT: " + exception.getMessage());
            return "ERR";
        }
    }

    public User verify(String token) {
        User user = new User();
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("sudo")
                    .acceptExpiresAt(60* 60) // 1시간 가량 유지
                    .build();
            DecodedJWT jwt = verifier.verify(token);


            user.setUserId(Long.parseLong(jwt.getClaim("UserId").asString()));
            user.setUserName(jwt.getClaim("UserName").asString());

            System.out.println("DEOCDE: " + jwt.getToken());
            System.out.println(user.getUserId());
        }
        catch(JWTVerificationException exception){
            System.out.println("JWT VERIFY EXCEPT: "+ exception.getMessage());
        }
        return user;
    }

}

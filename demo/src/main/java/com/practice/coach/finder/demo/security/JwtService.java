package com.practice.coach.finder.demo.security;

import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.Header;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class JwtService {
    //@Value("${security.jwt.key}")
    private String secretKey;

   // @Value("${security.jwt.expirationInMinutes}")
    private long expiration;

    public String extractSubject(String token) throws ParseException {
        return extractClaim(token, JWTClaimsSet::getSubject);
    }

    public String extractProfiloSelezionato(String token) throws ParseException {
        Map<String, Object> claims = extractClaim(token, JWTClaimsSet::getClaims);
        return (String) claims.get("profile");
    }

    public Date extractIssueTime(String token) throws ParseException {
        return extractClaim(token, JWTClaimsSet::getIssueTime);
    }

    public Date extractExpirationTime(String token) throws ParseException {
        return extractClaim(token, JWTClaimsSet::getExpirationTime);
    }
    public <T> T extractClaim(String token, Function<JWTClaimsSet, T> claimsResolver) throws ParseException {
        final JWTClaimsSet claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private JWTClaimsSet extractAllClaims(String token) throws ParseException {
        SignedJWT signedJWT = SignedJWT.parse(token);
        return signedJWT.getJWTClaimsSet();
    }

    public String buildToken(String username) throws Exception {
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issueTime(new Date(Instant.now().toEpochMilli()))
                .expirationTime(new Date(Instant.now().plusMillis(expiration * 60 * 1000).toEpochMilli()))
                .build();
        return generateToken(claimsSet);
    }

    public String buildToken(String username, String profile) throws Exception {
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issueTime(new Date(Instant.now().toEpochMilli()))
                .expirationTime(new Date(Instant.now().plusMillis(expiration * 60 * 1000).toEpochMilli()))
                .claim("profilo", profile)
                .build();
        return generateToken(claimsSet);
    }

    private String generateToken(JWTClaimsSet claimsSet) throws Exception {
        try {
            JWSHeader header = new JWSHeader(JWSAlgorithm.HS256, JOSEObjectType.JWT, null, null, null, null, null, null, null, null, null, true, null, null);
            SignedJWT signedJWT = new SignedJWT(header, claimsSet);
            JWSSigner signer = new MACSigner(Hex.decodeHex(secretKey));
            signedJWT.sign(signer);
            return signedJWT.serialize();
        } catch (JOSEException | DecoderException e) {
            log.error("Si è verificato un problema durante la generazione del token");
            throw new Exception(e.getMessage());
        }
    }

    public boolean isTokenValid(String token) throws Exception {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(Hex.decodeHex(secretKey));
            Header jwtHeader = signedJWT.getHeader();
            return signedJWT.verify(verifier) && isTokenExpirationTimeValid(token) &&
                    isTokenIssueTimeValid(token) &&
                    isTokenTimeToLiveValid(token) &&JWSAlgorithm.HS256.getName().equals(jwtHeader.getAlgorithm().getName()) &&
                    jwtHeader.getType().getType().equals(JOSEObjectType.JWT.getType());
        } catch (ParseException | DecoderException | JOSEException e) {
            log.error("Si è verificato un problema durante la validazione del token");
            throw new Exception(e.getMessage());
        }
    }

    public boolean isTokenExpirationTimeValid(String token) throws ParseException {
       Date expirationTime = extractExpirationTime(token);
       if(expirationTime == null) {
           log.error("Expiration time non può essere vuoto");
           return false;
       }
       if(expirationTime.before(new Date(Instant.now().toEpochMilli()))) {
           log.error("Token già scaduto");
           return false;
       }
        return true;
    }

    public boolean isTokenIssueTimeValid(String token) throws ParseException {
        Date issueTime = extractIssueTime(token);
        if(issueTime == null) {
            log.error("Issue time non può essere vuoto");
            return false;
        }
        if(!issueTime.before(new Date(Instant.now().toEpochMilli()))) {
            log.error("Issue time non può avere un valore maggiore o uguale all'istante corrente");
            return false;
        }
        return true;
    }

    public boolean isTokenTimeToLiveValid(String token) throws ParseException {
        Instant issueTime = extractIssueTime(token).toInstant();
        Instant expirationTime = extractExpirationTime(token).toInstant();
        if (expirationTime.minusMillis(issueTime.toEpochMilli()).toEpochMilli() != expiration * 60 * 1000) {
            log.error("Expiration time del token è diverso dal valore atteso");
            return false;
        }
        return true;
    }

}

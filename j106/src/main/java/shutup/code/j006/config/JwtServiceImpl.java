package shutup.code.j006.config;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

	private static final String securityKey = "T h I s Is S e C u R i T y  K e Y  a R e A";
	
	@Override
	public String createToken(String subject, long ttlMillis) {
		if (ttlMillis == 0) {
			throw new RuntimeException("토근 만료기간은 0 이상 이어야 합니다.");
		}
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(securityKey);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		JwtBuilder builder = Jwts.builder()
				.setSubject(subject)
				.signWith(signatureAlgorithm, signingKey);
		
		long nowMillis = System.currentTimeMillis();
		builder.setExpiration(new Date(nowMillis + ttlMillis));
		
		return builder.compact();
	}

	@Override
	public String getSubject(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(securityKey))
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}

	@Override
	public void isUsable(String jwt) throws Exception {
        Jws<Claims> claims = Jwts.parser().setSigningKey(securityKey).parseClaimsJws(jwt);
        log.debug(claims.toString());

	}

}

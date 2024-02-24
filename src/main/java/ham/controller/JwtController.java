package ham.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ham.bean.UserDTO;
import ham.service.UserService;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;

@RestController
@RequestMapping("/jwt")
public class JwtController {
	
	@Autowired
	private UserService userService;
	
	@Getter
	@Setter
	public static class TokenDTO {
		private String token;
		private long userSeq;
    }
	
	public static String generateBase64() {
        byte[] randomBytes = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);

        String base64String = Base64.getEncoder().encodeToString(randomBytes);

        return base64String;
    }
	
    @PostMapping("/getToken")
    public String getPublicData(@RequestBody TokenDTO tokenDTO) {
    	
    	long userSeq = tokenDTO.getUserSeq();
    	
    	String secret = generateBase64();
    	
    	userService.putSecretKey(userSeq,secret);
    	
    	Key key = Keys.hmacShaKeyFor(secret.getBytes());// 안전한 키 생성
        String token = Jwts.builder()
                .setSubject(String.valueOf(userSeq))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000L)) // 1달 (30일) 유효한 토큰
                .signWith(key)
                .compact();
        
        return token;
    }
    
    @PostMapping("/userByToken")
    public UserDTO userByToken(@RequestBody TokenDTO tokenDTO) {
        try {
        	String secret = userService.getSecretKey(tokenDTO.getUserSeq());
        	Key key = Keys.hmacShaKeyFor(secret.getBytes());
        	
            Claims claims = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(tokenDTO.getToken())
                    .getBody();

            // 토큰의 만료 기한 확인
            Date expirationDate = claims.getExpiration();
            Date now = new Date();
            if (expirationDate.before(now)) {
                return null;
            }
            
            // 유효한 경우, userSeq를 추출
            String userSeq = claims.getSubject();   
            
            return userService.getUserDTO(Long.parseLong(userSeq));
            
        } catch (ExpiredJwtException e) {
            System.out.println("Token has expired::"+e);
            return null;
        } catch (SignatureException e) {
            System.out.println("Invalid token signature::"+e);
            return null;
        } catch (Exception e) {
        	System.out.println("Invalid token::"+e);
            return null;
        }
    }
}
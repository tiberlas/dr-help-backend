package com.ftn.dr_help.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.ftn.dr_help.comon.TimeProvider;
import com.ftn.dr_help.model.pojo.UserPOJO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
	/*
	 *  This class is responsible for creating and validation JWT
	 *  AHTUNG: in JWT username is actually e-mail address!
	 * */
	
	@Value("${jwt.secret}")
	private String secret;

	@Value("spring-security-example")
	private String APP_NAME;

	@Value("somesecret")
	public String SECRET;

	//when JWT expires in ms
	@Value("300000")
	private int EXPIRES_IN;

	@Value("Authorization")
	private String AUTH_HEADER;

	//when JWT is createt
	@Autowired
	TimeProvider timeProvider;
	
	static final String AUDIENCE_WEB = "web";


	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

	// Funkcija za generisanje JWT token
	public String generateToken(UserPOJO user) {
		return Jwts.builder()
				.setIssuer(APP_NAME)
				.setSubject(user.getEmail())
				.setAudience(generateAudience())
				.setIssuedAt(timeProvider.now())
				.setExpiration(generateExpirationDate())
				//.claim("address", user.getAddress()) //postavljanje proizvoljnih podataka u telo JWT tokena
				//.claim("city", user.getCity())
				//.claim("state", user.getState())
				.claim("birthday", user.getBirthday())
				//.claim("phone_number", user.getPhoneNumber())
				//.claim("first_name", user.getFirstName())
				//.claim("last_name", user.getLastName())
				.signWith(SIGNATURE_ALGORITHM, SECRET).compact();
	}

	private String generateAudience() {
		return AUDIENCE_WEB;
	}

	private Date generateExpirationDate() {
		return new Date(timeProvider.now().getTime() + EXPIRES_IN);
	}

	// Funkcija za refresh JWT tokena
	public String refreshToken(String token) {
		String refreshedToken;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			claims.setIssuedAt(timeProvider.now());
			refreshedToken = Jwts.builder()
					.setClaims(claims)
					.setExpiration(generateExpirationDate())
					.signWith(SIGNATURE_ALGORITHM, SECRET).compact();
		} catch (Exception e) {
			refreshedToken = null;
		}
		return refreshedToken;
	}

	public Boolean canTokenBeRefreshed(String token) {
		return (!(this.isTokenExpired(token)));
	}

	// Funkcija za validaciju JWT tokena
	public Boolean validateToken(String token, UserDetails userDetails) {
		//UserPOJO user = (UserPOJO) userDetails;
		final String username = getUsernameFromToken(token);
		//final Date created = getIssuedAtDateFromToken(token);
		
		return (username != null && username.equals(userDetails.getUsername()));
	}

	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	public Date getIssuedAtDateFromToken(String token) {
		Date issueAt;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			issueAt = claims.getIssuedAt();
		} catch (Exception e) {
			issueAt = null;
		}
		return issueAt;
	}

	public String getAudienceFromToken(String token) {
		String audience;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			audience = claims.getAudience();
		} catch (Exception e) {
			audience = null;
		}
		return audience;
	}

	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	public int getExpiredIn() {
		return EXPIRES_IN;
	}

	// Funkcija za preuzimanje JWT tokena iz zahteva
	public String getToken(HttpServletRequest request) {
		String authHeader = getAuthHeaderFromHeader(request);

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}

		return null;
	}

	public String getAuthHeaderFromHeader(HttpServletRequest request) {
		return request.getHeader(AUTH_HEADER);
	}
	
	public Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
		return (lastPasswordReset != null && created.before(lastPasswordReset));
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = this.getExpirationDateFromToken(token);
		if(expiration == null) {
			return true;
		}
		return expiration.before(timeProvider.now());
	}

	// Funkcija za citanje svih podataka iz JWT tokena
	private Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

}
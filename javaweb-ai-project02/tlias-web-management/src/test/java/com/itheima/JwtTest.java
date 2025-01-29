package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * base64编解码地址：	https://base64.us/
 */
public class JwtTest {
	/**
	 * 生成JWT令牌 - Jwts.builder()
	 */
	@Test
	public void testGenerateJwt() {
		/*
		 * 构建自定义map信息
		 */
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("id", 1);
		dataMap.put("username", "admin");

		String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRoZWltYQ==") //自己指定加密算法, 秘钥
				.addClaims(dataMap) //添加自定义信息
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 1000)) //设置过期时间，60秒后过期
				.compact();//生成令牌
		System.out.println(jwt);    // eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTczODExNTgxNH0.6Fm1r6b18E3wkbwPPfskZDQHfEEwW-BiEplluLQwlJA
	}


	/*
	 * 解析JWT令牌
	 *
	 * 令牌报错的场景：
	 * 		1.令牌被篡改
	 * 		2.令牌过期了
	 */
	@Test
	public void testParseJWT() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTczODExNTgxNH0.6Fm1r6b18E3wkbwPPfskZDQHfEEwW-BiEplluLQwlJA";
		Claims claims = Jwts.parser().setSigningKey("aXRoZWltYQ==") //指定秘钥，需要与生成密钥一致
				.parseClaimsJws(token) //解析令牌
				.getBody(); //获取自定义信息
		System.out.println(claims);    //{id=1, username=admin, exp=1738115814}
	}

}

package com.macro.mall.tiny.common.utils;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname JwtTokenUtil
 * @Description JwtToken生成工具类
 * @Date 2020/7/3 17:32
 * @Creater by weiyao
 */
@Component
public class JwtTokenUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenUtil.class);

    private static final String CLAIM_KEY_USERNAME="sub";
    private static final String CLAIM_KEY_CREATED="created";


    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;


    /**
     * 生成token的国企时间
     * @return
     */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis()+expiration*1000);
    }


    /**
     * 生成JWT的token
     * @param claims
     * @return
     */
    private String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }


    /**
     * 从token中获取JWT的负载
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token){
        Claims claims  = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("JWT格式验证失败:{}",token);
        }
        return claims;
    }


    /**
     * 从token中获取登录用户名
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token){
        String userName;
        try {
            Claims claims = getClaimsFromToken(token);
            userName = claims.getSubject();
        } catch (Exception e) {
            userName = null;
        }
        return userName;
    }


    /**
     * 从token中获取过期时间
     * @param token
     * @return
     */
    private Date getExpirationDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
       return  claims.getExpiration();
    }


    /**
     * 判断token是否已经过期失效
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token){
        Date expirationDate = getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }


    /**
     * 判断token是否可以刷新
     * @param token
     * @return
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }


    /**
     * 验证token是否还有效
     * @param token 从客户端传入的token
     * @param userDetails   从数据库中获取到的用户信息
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails){
        String userName = getUserNameFromToken(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 根据输入的用户信息生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME,userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }


    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED,new Date());
        return generateToken(claims);
    }



}

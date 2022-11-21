package cc.lijad.blog.service.web;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * @author 李坚达
 * @create 2022/11/14 13:07
 */
@Component
public class TokenService {
    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;


    protected final long MILLIS_SECOND = 1000;

    protected final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;


    /**
     * 从数据声明生成令牌
     *
     * @param data 数据声明
     * @return 令牌
     */
    public String createToken(Map<String, Object> data) {

        long now = System.currentTimeMillis();

        JwtBuilder builder = Jwts.builder();
        String token = builder
                //Header
//                .setHeaderParam("typ", "JWT")
//                .setHeaderParam("alg", "HS256")
                //playload
                .setClaims(data)
                .setExpiration(new Date(now + (expireTime * MILLIS_MINUTE)))
                //signature
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return token;
    }


    /**
     * 解析token
     * @param token
     * @return
     */
    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}

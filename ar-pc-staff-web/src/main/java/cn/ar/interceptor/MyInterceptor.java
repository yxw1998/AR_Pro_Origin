package cn.ar.interceptor;

import cn.ar.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author YangXw
 * @date 2021/11/19 0019 10:20
 * @description
 */
@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    private RedisUtil redisUtil;

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userSessCode = request.getParameter("userSessCode");
        String comSessCode = request.getParameter("comSessCode");
        String token = request.getHeader("token");
        String key = comSessCode + userSessCode +  "loginToken";
        log.info("token---> " + token);
        log.info("key---> " + key);
        Object redisToken = redisUtil.get(key);
        log.info("redisToken---> " + redisToken);
        if (token==null||redisToken==null){
            throw new Exception("用户凭证已过期");
        }
        if (!token.equals(redisToken)){
            throw new Exception("用户凭证不匹配");
        }
        redisUtil.expire(key,1200);
        log.info("拦截器执行了-----");
        return true;
    }
}

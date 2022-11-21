package cc.lijad.blog.aspectj;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author 李坚达
 * @create 2022/11/13 9:40
 */
//aop记录日志
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);


    /**
     * 记录日志的切点表达式
     */
    @Pointcut(value = "execution(* cc.lijad.controller.*.*(..))")
    public void logPointCut() {
    }

    /**
     * 访问之前
     */
    @Before("logPointCut()")
    public void doBefore(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
        Object[] args = jp.getArgs();

        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
//        System.out.println(requestLog);
        logger.info("Request:{}", requestLog);
    }

    /**
     * 返回之后
     *
     * @param result 返回值
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void doAfterReturning(Object result) {
        logger.info("Result:{}", result);
    }


    /**
     * 记录日志内部类
     */
    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;


        public RequestLog() {
        }

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}

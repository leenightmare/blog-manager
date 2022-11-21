package cc.lijad.blog.exception.handler;


import cc.lijad.blog.domain.AjaxResult;
import cc.lijad.blog.exception.LoginException;
import cc.lijad.blog.exception.ServiceException;
import cc.lijad.blog.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 李坚达
 * @create 2022/11/12 22:36
 */

//全局异常处理器
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 登录异常
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(LoginException.class)
    public AjaxResult handleLoginException(Exception e, HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        log.error("请求地址'{}',登录异常", requestURL, e);
        return AjaxResult.error(e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public AjaxResult handleServiceException(ServiceException e, HttpServletRequest request) {
        log.error(e.getMessage(), e);
        Integer code = e.getCode();
        return StringUtils.isNotNull(code) ? AjaxResult.error(code, e.getMessage()) : AjaxResult.error(e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult handleRuntimeException(RuntimeException e, HttpServletRequest request)
    {
        String requestURL = request.getRequestURL().toString();
        log.error("请求地址'{}',发生未知异常.", requestURL, e);
        return AjaxResult.error(e.getMessage());
    }


    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e, HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        log.error("请求地址'{}',发生系统异常.", requestURL, e);
        return AjaxResult.error(e.getMessage());
    }


}

package com.ctg.flag.exception.handler;

import com.ctg.flag.exception.NoAuthenticationException;
import com.ctg.flag.exception.NoPermissionException;
import com.ctg.flag.pojo.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 日志记录
     */
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseDto defaultErrorHandler(HttpServletResponse response, Exception e) {
        // 获取异常栈
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(e.fillInStackTrace()).append("\n");

        for (StackTraceElement element : stackTrace) {
            sb.append("\tat ").append(element).append("\n");
        }

        // 记录日志
        logger.error(sb.toString());

        if (e instanceof NoAuthenticationException ||
                e instanceof NoPermissionException) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        return null;
    }
}

package com.ctg.flag.exception.handler;

import com.ctg.flag.exception.NoAuthenticationException;
import com.ctg.flag.exception.NoPermissionException;
import com.ctg.flag.pojo.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {NoPermissionException.class,
            NoAuthenticationException.class,
            HttpRequestMethodNotSupportedException.class,
            Exception.class})
    public ResponseDto defaultErrorHandler(HttpServletResponse response, Exception e) {
        // 获取异常栈
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(e.fillInStackTrace()).append("\n");

        for (StackTraceElement element : stackTrace) {
            sb.append("\tat ").append(element).append("\n");
        }

        ResponseDto responseDto = ResponseDto.failed();
        if (e instanceof NoAuthenticationException ||
                e instanceof NoPermissionException ) {
            logger.info(sb.toString());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            responseDto.setMessage(e.getMessage());
        } else if(e instanceof HttpRequestMethodNotSupportedException) {
            logger.info(sb.toString());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseDto.setMessage(e.getMessage());
        } else {
            logger.error(sb.toString());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }

}

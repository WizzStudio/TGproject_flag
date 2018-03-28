package com.ctg.flag.web.interceptor;

import com.ctg.flag.enums.UserInfoStateEnum;
import com.ctg.flag.pojo.entity.User;
import com.ctg.flag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("userId");
        if (uid == null) {
            response.sendError(401, "not log in ");
            return true;
        }
        return true;
    }
}

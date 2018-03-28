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
public class UserInfoInterceptor implements HandlerInterceptor {
    private final UserService userService;

    @Autowired
    public UserInfoInterceptor(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("userId");
        if (uid == null) {
            return true;
        }
        User user = userService.getUserById(uid);
        if (user == null) {
            response.sendError(401, "user information is wrong");
            return true;
        }
        if (user.getState().equals(UserInfoStateEnum.INCOMPLETED.getValue())) {
            response.sendError(403, "user information is not completed.");
            return true;
        }
        return true;
    }
}

package com.ctg.flag.web.interceptor;

import com.ctg.flag.enums.UserInfoStateEnum;
import com.ctg.flag.exception.NoAuthenticationException;
import com.ctg.flag.exception.NoPermissionException;
import com.ctg.flag.pojo.entity.User;
import com.ctg.flag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户登录及完善信息验证
 */
@Component
public class UserInfoInterceptor implements HandlerInterceptor {
    private final UserService userService;

    @Autowired
    public UserInfoInterceptor(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws NoPermissionException, NoAuthenticationException {
        HttpSession session = request.getSession();
        Integer uid = (Integer) session.getAttribute("userId");
        if (uid == null) {
            throw new NoAuthenticationException();
        }
        User user = userService.getUserById(uid);
        if (user == null) {
            throw new NoAuthenticationException();
        }
        if (user.getState().equals(UserInfoStateEnum.INCOMPLETED.getValue())) {
            throw new NoPermissionException();
        }
        return true;
    }
}

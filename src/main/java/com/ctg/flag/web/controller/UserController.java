package com.ctg.flag.web.controller;

import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.pojo.entity.User;
import com.ctg.flag.service.UserService;
import com.ctg.flag.util.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseDto login(@RequestParam(name = "code", defaultValue = "") String code,
                             HttpSession session) throws Exception{
        String openid = WechatUtil.getOpenId(code);

        User user = userService.login(openid);
        session.setAttribute("user", user);

        if (user.getState)

        return ResponseDto.succeed("log in successfully");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseDto updateUserInfo(User user, HttpSession session) {
        User sUser = (User) session.getAttribute("user");
        if (sUser == null) {
            return ResponseDto.failed("not log in");
        }

        user.setId(sUser.getId());
        userService.update(user);

        return ResponseDto.succeed();
    }
}

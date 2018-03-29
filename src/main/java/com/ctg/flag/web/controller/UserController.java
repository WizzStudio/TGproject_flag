package com.ctg.flag.web.controller;

import com.ctg.flag.enums.UserInfoStateEnum;
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

    private WechatUtil wechatUtil;

    @Autowired
    public UserController(UserService userService, WechatUtil wechatUtil) {
        this.userService = userService;
        this.wechatUtil = wechatUtil;
    }

    /**
     * 用户微信认证登录
     * @param code 前端给的code
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseDto login(@RequestParam(name = "code", defaultValue = "") String code,
                             HttpSession session) throws Exception{
        String openid = wechatUtil.getOpenId(code);
//        String openid = "openid";
        if (openid == null) {
            return ResponseDto.failed("log in failed, code is wrong");
        }

        User user = userService.login(openid);
        session.setAttribute("userId", user.getId());

        if (user.getState().equals(UserInfoStateEnum.INCOMPLETED.getValue())) {
            return ResponseDto.failed("not complete user info.");
        } else {
            return ResponseDto.succeed("log in successfully.");
        }
    }

    /**
     * 完善个人信息，或者修改个人信息
     * @param user 表单自动生成的user
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseDto updateUserInfo(User user, HttpSession session) {
        Integer uid = (Integer) session.getAttribute("userId");

        User sUser = userService.getUserById(uid);

        user.setId(uid);
        user.setOpenid(sUser.getOpenid());
        user.setState(UserInfoStateEnum.COMPLETED.getValue());
        userService.update(user);

        return ResponseDto.succeed();
    }

    /**
     * 用户退出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseDto logout(HttpSession session) {
        session.invalidate();
        return ResponseDto.succeed();
    }
}

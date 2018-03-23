package com.ctg.flag.web.controller;

import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.pojo.entity.Department;
import com.ctg.flag.pojo.entity.User;
import com.ctg.flag.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.List;

/**
 * @Description:
 * @Author: StormWangxhu
 * @Date: created on 2018/3/22
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseDto getDepartment(@RequestParam(name = "authCode") String authCode, HttpSession session) {
        //从session域中获取表单user对象
        User from = (User) session.getAttribute("user");
        //获取user中的部门id
        Integer did = from.getDid();
        //从数据库中查询部门
        Department department = departmentService.findByAuthCode(authCode);
        if (department == null) {//若为空，说明验证码错误
            return ResponseDto.failed("身份认证码错误！");
        }
        //若查询成功,比较部门id和前端传来id
        if (did == department.getId()) {
            return ResponseDto.succeed();//返回成功状态码1
        } else {
            return ResponseDto.failed();//返回失败状态码 0
        }
    }

}

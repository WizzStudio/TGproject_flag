package com.ctg.flag.web.controller;

import com.ctg.flag.pojo.entity.Department;
import com.ctg.flag.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
    public  DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    public  getDepartment(@RequestParam(name="authCode")String authCode, HttpSession session){

         Department department=departmentService.findByAuthCode(authCode);
         if (department==null){

             return null;
         }else {

         }
    }






}

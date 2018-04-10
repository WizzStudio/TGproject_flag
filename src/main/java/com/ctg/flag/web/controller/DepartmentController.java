package com.ctg.flag.web.controller;

import com.ctg.flag.pojo.dto.OptionDto;
import com.ctg.flag.pojo.dto.ResponseDto;
import com.ctg.flag.pojo.entity.Department;
import com.ctg.flag.pojo.entity.User;
import com.ctg.flag.service.DepartmentService;
import com.ctg.flag.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Description:
 * @Author: StormWangxhu
 * @Date: created on 2018/3/22
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;
    private UserService userService;


    @Autowired
    public DepartmentController(DepartmentService departmentService,UserService userService) {
        this.departmentService = departmentService;
        this.userService=userService;
    }

    /**
     * 验证身份认证码功能
     * @return 验证成功：0，失败：1
     */
    @RequestMapping(value = "/authCode", method = RequestMethod.GET)
    public ResponseDto getDepartment(@RequestParam(name = "authCode") String authCode, HttpSession session) {
        Integer userId=(Integer) session.getAttribute("userId");
        if (userId==null){
            return ResponseDto.failed("UserId："+userId);
        }

        User form= userService.getUserById(userId);
        //获取user中的部门id
        Integer dId = form.getDid();
        //从数据库中查询部门
        Department department = departmentService.findByAuthCode(authCode);
        if (department == null) {//若为空，说明验证码错误
            return ResponseDto.failed("身份认证码错误！");
        }
        //若查询成功,比较部门id和前端传来id

        if (dId.equals(department.getId())) {
            return ResponseDto.succeed();//返回成功状态码0
        } else {
            return ResponseDto.failed();//返回失败状态码 1
        }
    }

    /**
     * 返会所属机构列表功能
     * key:authCode,value:name
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseDto getDepartmentNameList() {
        //通过种类查询所有部门
        List<Department> list=departmentService.findAllByKind();
        //Map，存放部门id,部门名称
        List<OptionDto<String, Integer> > departmentList = new ArrayList<>();
        if (list!=null){
            for (Department department:list){
                String name = department.getName();
                Integer id = department.getId();
                departmentList.add(new OptionDto<>(name, id));
            }
            departmentList.sort(Comparator.comparing(OptionDto::getOptKey));
            return ResponseDto.succeed(null,departmentList);//返回部门列表
        }else {
            return ResponseDto.failed();//查询为空，则返回失败状态码
        }
    }
}


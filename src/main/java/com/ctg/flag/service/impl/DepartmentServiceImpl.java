package com.ctg.flag.service.impl;

import com.ctg.flag.dao.DepartmentDao;
import com.ctg.flag.enums.DepartmentKindEnum;
import com.ctg.flag.enums.PlaceKindEnum;
import com.ctg.flag.pojo.entity.Department;
import com.ctg.flag.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: StormWangxhu
 * @Date: created on 2018/3/22
 */
//声明为service
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    /**
     * 根据身份验证码查询部门
     * @param authCode
     * @return
     */
    @Override
    public Department findByAuthCode(String authCode) {
        return departmentDao.findByAuthCode(authCode);
    }

<<<<<<< HEAD

=======
>>>>>>> 2b81e649b084a37d5345166f28d6606d4e2c4a4b
    /**
     * 返回所属机构列表
     * @return
     */
    @Override
<<<<<<< HEAD
    public List<Department> findAll() {
        return departmentDao.findAll();
=======
    public List<Department> findAllByKind() {
        return departmentDao.findAllByKind(DepartmentKindEnum.ORGANIZATION.getValue());
>>>>>>> 2b81e649b084a37d5345166f28d6606d4e2c4a4b
    }
}

package com.ctg.flag.dao;

import com.ctg.flag.pojo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: StormWangxhu
 * @Date: created on 2018/3/22
 */

@Component
public interface DepartmentDao extends JpaRepository<Department,Integer> {
    /**
     * 根据部门身份验证码查询部门
     * @param authCode
     * @return
     */
    Department findByAuthCode(String authCode);
}

package com.ctg.flag.service;

import com.ctg.flag.pojo.entity.Department;

/**
 * @Description:
 * @Author: StormWangxhu
 * @Date: created on 2018/3/22
 */
public interface DepartmentService {
    /**
     * 查询身份验证码
     * @param authCode
     * @return
     */
    Department findByAuthCode(String authCode);
}

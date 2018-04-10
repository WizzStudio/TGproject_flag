package com.ctg.flag.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "council_order", schema = "flag")
public class CouncilOrder {
    // 前端提供
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teamName;  // 团队名称
    private String activityName;  // 活动名称
    private String activityForm;  // 活动形式

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startTime;  // 开始时间

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;  // 结束时间
    private Integer cid;  // 会务室场地id
    private Integer peopleSchoolIn;  // 校内人数
    private Integer peopleSchoolOut;  // 校外人数
    private String securityAdmin;  // 安全负责人
    private String phone;  // 负责人电话
    private String securityMeasure;  // 安全措施
    private String equipment;  // 设备

    // 后端处理
    private Integer uid;
    private Integer state;
    private String feedback;

    private Date createTime;
    private Date updateTime;


    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getUid() {
        return uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityForm() {
        return activityForm;
    }

    public void setActivityForm(String activityForm) {
        this.activityForm = activityForm;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPeopleSchoolIn() {
        return peopleSchoolIn;
    }

    public void setPeopleSchoolIn(Integer peopleSchoolIn) {
        this.peopleSchoolIn = peopleSchoolIn;
    }

    public Integer getPeopleSchoolOut() {
        return peopleSchoolOut;
    }

    public void setPeopleSchoolOut(Integer peopleSchoolOut) {
        this.peopleSchoolOut = peopleSchoolOut;
    }

    public String getSecurityAdmin() {
        return securityAdmin;
    }

    public void setSecurityAdmin(String securityAdmin) {
        this.securityAdmin = securityAdmin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecurityMeasure() {
        return securityMeasure;
    }

    public void setSecurityMeasure(String securityMeasure) {
        this.securityMeasure = securityMeasure;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}




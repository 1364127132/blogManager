package com.zjt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "h_project")
public class Project {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    @Column(name = "project_id")
    private Integer projectId;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 地点
     */
    @Column(name = "project_address")
    private String projectAddress;

    /**
     * 公司名称
     */
    @Column(name = "project_company")
    private String projectCompany;

    /**
     * 项目负责人
     */
    @Column(name = "project_leader")
    private String projectLeader;

    /**
     * 项目开始时间
     */
    @Column(name = "project_startTime")
    private String projectStarttime;

    /**
     * 项目结束时间
     */
    @Column(name = "project_endTime")
    private String projectEndtime;

    /**
     * 项目状态：0未完成、1进行中、2已完成
     */
    @Column(name = "project_state")
    private Integer projectState;

    /**
     * 项目添加时间
     */
    @Column(name = "project_addTime")
    private String projectAddtime;

    /**
     * 项目修改时间
     */
    @Column(name = "project_updateTime")
    private String projectUpdatetime;

    /**
     * 备注
     */
    @Column(name = "project_notes")
    private String projectNotes;

    /**
     * 客户联系人
     */
    @Column(name = "project_contactPerson")
    private String projectContactperson;

    /**
     * 联系电话
     */
    @Column(name = "project_contactTel")
    private String projectContacttel;

    /**
     * 项目类型：0帆软、
     */
    @Column(name = "project_type")
    private Integer projectType;

    /**
     * 获取id
     *
     * @return project_id - id
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 设置id
     *
     * @param projectId id
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取项目名称
     *
     * @return project_name - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }
    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 获取地点
     *
     * @return project_address - 地点
     */
    public String getProjectAddress() {
        return projectAddress;
    }

    /**
     * 设置地点
     *
     * @param projectAddress 地点
     */
    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }

    /**
     * 获取公司名称
     *
     * @return project_company - 公司名称
     */
    public String getProjectCompany() {
        return projectCompany;
    }

    /**
     * 设置公司名称
     *
     * @param projectCompany 公司名称
     */
    public void setProjectCompany(String projectCompany) {
        this.projectCompany = projectCompany == null ? null : projectCompany.trim();
    }

    /**
     * 获取项目负责人
     *
     * @return project_leader - 项目负责人
     */
    public String getProjectLeader() {
        return projectLeader;
    }

    /**
     * 设置项目负责人
     *
     * @param projectLeader 项目负责人
     */
    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader == null ? null : projectLeader.trim();
    }

    /**
     * 获取项目开始时间
     *
     * @return project_startTime - 项目开始时间
     */
//    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    public String getProjectStarttime() {
        return projectStarttime;
    }

    /**
     * 设置项目开始时间
     *
     * @param projectStarttime 项目开始时间
     */
    public void setProjectStarttime(String projectStarttime) {
        this.projectStarttime = projectStarttime;
    }

    /**
     * 获取项目结束时间
     *
     * @return project_endTime - 项目结束时间
     */
//    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    public String getProjectEndtime() {
        return projectEndtime;
    }

    /**
     * 设置项目结束时间
     *
     * @param projectEndtime 项目结束时间
     */
    public void setProjectEndtime(String projectEndtime) {
        this.projectEndtime = projectEndtime;
    }

    /**
     * 获取项目状态：0未完成、1进行中、2已完成
     *
     * @return project_state - 项目状态：0未完成、1进行中、2已完成
     */
    public Integer getProjectState() {
        return projectState;
    }

    /**
     * 设置项目状态：0未完成、1进行中、2已完成
     *
     * @param projectState 项目状态：0未完成、1进行中、2已完成
     */
    public void setProjectState(Integer projectState) {
        this.projectState = projectState;
    }

    /**
     * 获取项目添加时间
     *
     * @return project_addTime - 项目添加时间
     */
    public String getProjectAddtime() {
        return projectAddtime;
    }

    /**
     * 设置项目添加时间
     *
     * @param projectAddtime 项目添加时间
     */
    public void setProjectAddtime(String projectAddtime) {
        this.projectAddtime = projectAddtime;
    }

    /**
     * 获取项目修改时间
     *
     * @return project_updateTime - 项目修改时间
     */
    public String getProjectUpdatetime() {
        return projectUpdatetime;
    }

    /**
     * 设置项目修改时间
     *
     * @param projectUpdatetime 项目修改时间
     */
    public void setProjectUpdatetime(String projectUpdatetime) {
        this.projectUpdatetime = projectUpdatetime;
    }

    /**
     * 获取备注
     *
     * @return project_notes - 备注
     */
    public String getProjectNotes() {
        return projectNotes;
    }

    /**
     * 设置备注
     *
     * @param projectNotes 备注
     */
    public void setProjectNotes(String projectNotes) {
        this.projectNotes = projectNotes == null ? null : projectNotes.trim();
    }

    /**
     * 获取客户联系人
     *
     * @return project_contactPerson - 客户联系人
     */
    public String getProjectContactperson() {
        return projectContactperson;
    }

    /**
     * 设置客户联系人
     *
     * @param projectContactperson 客户联系人
     */
    public void setProjectContactperson(String projectContactperson) {
        this.projectContactperson = projectContactperson == null ? null : projectContactperson.trim();
    }

    /**
     * 获取联系电话
     *
     * @return project_contactTel - 联系电话
     */
    public String getProjectContacttel() {
        return projectContacttel;
    }

    /**
     * 设置联系电话
     *
     * @param projectContacttel 联系电话
     */
    public void setProjectContacttel(String projectContacttel) {
        this.projectContacttel = projectContacttel == null ? null : projectContacttel.trim();
    }

    /**
     * 获取项目类型：0帆软、
     *
     * @return project_type - 项目类型：0帆软、
     */
    public Integer getProjectType() {
        return projectType;
    }

    /**
     * 设置项目类型：0帆软、
     *
     * @param projectType 项目类型：0帆软、
     */
    public void setProjectType(Integer projectType) {
        this.projectType = projectType;
    }
}
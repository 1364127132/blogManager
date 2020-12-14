package com.zjt.entity;

import javax.persistence.*;

@Table(name = "h_project_implementers")
public class ProjectImplementers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键自增
    @Column(name = "im_id")
    private Integer imId;

    @Column(name = "im_project_id")
    private Integer imProjectId;

    @Column(name = "im_User_id")
    private Integer imUserId;

    @Column(name = "im_name")
    private String imName;

    /**
     * @return im_id
     */
    public Integer getImId() {
        return imId;
    }

    /**
     * @param imId
     */
    public void setImId(Integer imId) {
        this.imId = imId;
    }

    /**
     * @return im_project_id
     */
    public Integer getImProjectId() {
        return imProjectId;
    }

    /**
     * @param imProjectId
     */
    public void setImProjectId(Integer imProjectId) {
        this.imProjectId = imProjectId;
    }

    /**
     * @return im_name
     */
    public String getImName() {
        return imName;
    }

    /**
     * @param imName
     */
    public void setImName(String imName) {
        this.imName = imName == null ? null : imName.trim();
    }

    public Integer getImUserId() {
        return imUserId;
    }

    public void setImUserId(Integer imUserId) {
        this.imUserId = imUserId;
    }
}
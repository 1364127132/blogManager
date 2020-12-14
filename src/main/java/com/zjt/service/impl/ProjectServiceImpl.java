package com.zjt.service.impl;

import com.zjt.entity.Project;
import com.zjt.mapper.ProjectMapper;
import com.zjt.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href=""mailto:zhaojt@gtmap.cn></a>
 * @version 1.0, 2017/11/10
 * @description
 */

@Service("projectService")
public class ProjectServiceImpl extends BaseService<Project> implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> selectProjectById(Integer userid) {
        return projectMapper.selectProjectById(userid);
    }



}

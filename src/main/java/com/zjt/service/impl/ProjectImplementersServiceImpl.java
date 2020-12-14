package com.zjt.service.impl;

import com.zjt.entity.ProjectImplementers;
import com.zjt.mapper.ProjectImplementersMapper;
import com.zjt.service.ProjectImplementersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href=""mailto:zhaojt@gtmap.cn></a>
 * @version 1.0, 2017/11/10
 * @description
 */

@Service("projectImplementersService")
public class ProjectImplementersServiceImpl extends BaseService<ProjectImplementers> implements ProjectImplementersService {
    @Autowired
    private ProjectImplementersMapper projectImplementersMapper;

    @Override
    public List<ProjectImplementers> selecImplementerById(Integer projectId) {
        return projectImplementersMapper.selecImplementerById(projectId);
    }


}

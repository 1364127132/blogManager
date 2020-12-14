package com.zjt.mapper;

import com.zjt.entity.ProjectImplementers;
import com.zjt.util.MyMapper;

import java.util.List;

public interface ProjectImplementersMapper extends MyMapper<ProjectImplementers> {

    List<ProjectImplementers> selecImplementerById(Integer projectId);
}
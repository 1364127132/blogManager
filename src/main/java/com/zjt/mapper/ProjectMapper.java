package com.zjt.mapper;

import com.zjt.entity.Project;
import com.zjt.util.MyMapper;

import java.util.List;

public interface ProjectMapper extends MyMapper<Project> {
    List<Project> selectProjectById(Integer userid);
}
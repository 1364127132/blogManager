package com.zjt.service;

import com.zjt.entity.ProjectImplementers;
import com.zjt.service.IService;

import java.util.List;

public interface ProjectImplementersService extends IService<ProjectImplementers>{
    //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    List<ProjectImplementers> selecImplementerById(Integer projectId);//根据id查询所有的项目

}
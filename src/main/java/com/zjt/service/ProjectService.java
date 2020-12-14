package com.zjt.service;

import com.zjt.entity.Project;
import java.util.List;

public interface ProjectService extends IService<Project>{


    //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    List<Project> selectProjectById(Integer userid);//根据id查询所有的项目


}
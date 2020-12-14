package com.zjt.service;

import com.zjt.entity.Tuser;

import java.util.List;

public interface TuserService  extends IService<Tuser>{

    List<Tuser> selectAllImUser(Integer projectId);
}
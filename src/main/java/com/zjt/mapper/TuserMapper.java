package com.zjt.mapper;

import com.zjt.entity.Tuser;
import com.zjt.util.MyMapper;

import java.util.List;

public interface TuserMapper extends MyMapper<Tuser> {
    List<Tuser> selectAllImUser(Integer projectId);
}
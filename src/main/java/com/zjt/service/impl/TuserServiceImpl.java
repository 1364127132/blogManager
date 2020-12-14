package com.zjt.service.impl;

import com.zjt.entity.Tuser;
import com.zjt.mapper.TuserMapper;
import com.zjt.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href=""mailto:zhaojt@gtmap.cn></a>
 * @version 1.0, 2017/11/10
 * @description
 */
@Service("tuserService")
public class TuserServiceImpl extends BaseService<Tuser> implements TuserService {
    @Autowired
    private TuserMapper tuserMapper;

    @Override
    public List<Tuser> selectAllImUser(Integer projectId) {
        return tuserMapper.selectAllImUser(projectId);
    }
}

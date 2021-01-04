package com.qy25.sm.service.base.impl;

import com.github.pagehelper.PageInfo;
import com.qy25.sm.mapper.base.BaseMapper;
import com.qy25.sm.service.base.BaseService;
import com.qy25.sm.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseServiceImpl<T,ID> implements BaseService<T,ID> {
    @Autowired
    private BaseMapper<T, ID> baseMapper;

    @Override
    public PageVo<T> findPage() {
        List<T> ts = baseMapper.selectByExample(null);
        return setPageVo(ts);
    }
    @Override
    public PageVo<T> findPage(Object example) {
        List<T> ts = baseMapper.selectByExample(example);
        return setPageVo(ts);
    }

    @Override
    public T findById(ID id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateEntity(T entity) {
        return baseMapper.updateByPrimaryKey(entity);
    }

    @Override
    public int addEntity(T entity) {
        return baseMapper.insert(entity);
    }

    @Override
    public int deleteById(ID id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int batchAddEntity(List<T> entities) {
        entities.forEach(entity->{
            baseMapper.insert(entity);
        });
        return 1;
    }

    @Transactional
    @Override
    public int batchUpdateEntity(List<T> entities) {
        entities.forEach(entity->{
            baseMapper.updateByPrimaryKey(entity);
        });
        return 1;
    }

    @Transactional
    @Override
    public int batchDeleteEntity(List<ID> ids) {
        ids.forEach(id->{
            baseMapper.deleteByPrimaryKey(id);
        });
        return 1;
    }

    /**
     * 封装分页数据
     */
    private PageVo<T> setPageVo(List<T> list){
        PageInfo<T> pageInfo=new PageInfo<T>(list);
        long total = pageInfo.getTotal();
        PageVo<T> tPageVo = new PageVo<>();
        tPageVo.setList(list);
        tPageVo.setTotal(total);
        return tPageVo;
    }
}

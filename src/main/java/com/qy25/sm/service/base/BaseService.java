package com.qy25.sm.service.base;

import com.qy25.sm.vo.PageVo;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public interface BaseService<T, ID> {
    /**
     * 分页无条件
     */
    PageVo<T> findPage();

    /**
     * 分页有条件
     */
    PageVo<T> findPage(Object example);
    /**
     * 通过id查询
     */
    T findById(ID id);
    /**
     * 增加一个
     */
    int addEntity(T entity);
    /**
     * 修改一个
     */
    int updateEntity(T entity);
    /**
     * 删除一个
     */
    int deleteById(ID id);
    /**
     * 批量添加
     */
    int batchAddEntity(List<T> entities);
    /**
     * 批量修改
     */
    int batchUpdateEntity(List<T> entities);
    /**
     * 批量删除
     */
    int batchDeleteEntity(List<ID> ids);
}

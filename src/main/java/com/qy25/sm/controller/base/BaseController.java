package com.qy25.sm.controller.base;

import com.github.pagehelper.PageHelper;
import com.qy25.sm.common.http.AxiosResult;
import com.qy25.sm.service.base.BaseService;
import com.qy25.sm.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BaseController<T,ID> {
    @Autowired
    private BaseService<T,ID> baseService;

    @GetMapping
    public AxiosResult<PageVo<T>> findPage(@RequestParam(defaultValue = "1") int currentPage,
                                           @RequestParam(defaultValue = "5") int pageSize){
        PageHelper.startPage(currentPage,pageSize);
        return AxiosResult.success(baseService.findPage());
    }

    @GetMapping("{id}")
    public AxiosResult<T> findById(@PathVariable ID id){
        return AxiosResult.success(baseService.findById(id));
    }
    @PostMapping
    public AxiosResult<Void> addEntity(@RequestBody T entity){

        int i = baseService.addEntity(entity);
        return getAxios(i);
    }
    @PutMapping
    public AxiosResult<Void> updateEntity(@RequestBody T entity){
        int i = baseService.updateEntity(entity);
        return getAxios(i);
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> deleteById(@PathVariable ID id){
        int i = baseService.deleteById(id);
        return getAxios(i);
    }

    /**
     *批量添加
     */
    @PostMapping("addList")
    public AxiosResult<Void> addEntities(@RequestBody List<T> entities){
        int i = baseService.batchAddEntity(entities);
        return getAxios(i);
    }

    /**
     *批量修改
     */
    @PutMapping("updateList")
    public AxiosResult<Void> updateEntities(@RequestBody List<T> entities){
        int i = baseService.batchUpdateEntity(entities);
        return getAxios(i);
    }

    /**
     *批量删除
     */
    @DeleteMapping("deleteList")
    public AxiosResult<Void> deleteByIds(@RequestBody List<ID> ids){
        int i = baseService.batchDeleteEntity(ids);
        return getAxios(i);
    }

    /**
     *得到int返回数据分装
     */
    private AxiosResult<Void> getAxios(int row){
        if (row>0){
            return AxiosResult.success();
        }
        return AxiosResult.error();
    }
}

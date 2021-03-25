package com.sharding.demo.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface IBaseService<T> {

    /**
     * 真实删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 更新数据
     * @param record
     * @return
     */
    void update(T record);

    /**
     * 增加数据
     * @param record
     * @return
     */
    boolean add(T record);

    /**
     * 单条数据
     * @param id
     * @return
     */
    T queryById(Long id);

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param t
     * @return
     */
    Page<T> queryPage(Integer pageNo, Integer pageSize, T t);

    /**
     * 列表查询
     * @param t
     * @return
     */
    List<T> queryList(T t);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(String ids);
}

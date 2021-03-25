package com.sharding.demo.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: lgh
 * @Date: 2020/12/30 14:42
 */
public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
    /**
     * 通用分页查询
     * @param page
     * @param t
     * @return
     */
    List<T> queryPage(Page<T> page, @Param("ew") T t);

    /**
     * 通用列表查询
     * @param t
     * @return
     */
    List<T> queryList(@Param("ew") T t);
}

package com.sharding.demo.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

public abstract class BaseServiceImpl<M extends BaseMapper<T>, T> implements IBaseService<T> {

    @Autowired
    protected M baseMapper;

    @Override
    public void delete(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void update(T record) {
        //数字类型为null字段不做更新，字段为0时才允许更新
        baseMapper.updateById(record);
    }


    @Override
    public boolean add(T record) {
        int size = baseMapper.insert(record);
        if(size > 0){
            return true;
        }
        return false;
    }

    @Override
    public T queryById(Long id) {
        return baseMapper.selectById(id);
    }

    @Override
    public Page<T> queryPage(Integer pageNo, Integer pageSize, T t) {
        Page<T> page = new Page<>(pageNo, pageSize);
        List<T> list = baseMapper.queryPage(page, t);
        page.setRecords(list);
        return page;
    }

    @Override
    public List<T> queryList(T t) {
        return baseMapper.queryList(t);
    }

    @Override
    public void deleteByIds(String ids){
        String[] idList = ids.split(",");
        baseMapper.deleteBatchIds(Arrays.asList(idList));
    }
}

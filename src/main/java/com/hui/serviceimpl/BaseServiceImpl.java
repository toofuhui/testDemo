package com.hui.serviceimpl;

import com.hui.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
public class BaseServiceImpl<T> implements BaseService<T>{
    @Autowired
    private BaseMapper baseMapper;
    @Override
    public void save(T entity) {
        baseMapper.insert(entity);
    }

    @Override
    public void delete(T entity) {
        baseMapper.delete(entity);
    }

    @Override
    public void update(T entity) {
        baseMapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public T findById(Integer id) {
        return (T) baseMapper.selectByPrimaryKey(id);

    }

    @Override
    public List<T> getAll() {
        return baseMapper.selectAll();
    }
}

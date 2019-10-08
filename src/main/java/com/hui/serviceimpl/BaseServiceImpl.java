package com.hui.serviceimpl;

import com.hui.mapper.BaseMapper;
import com.hui.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T>{
    /**
     * dao层是接口层，没有实现类的。
     * service中的BaseServiceImpl是抽象的，
     * 因为我们不知道这个service要注入的dao是哪一个，
     * 因此需要一个抽象方法，让子类去实现。
     * 抽象函数， protected abstract BaseMapper<T> getMapper();
     * 这个要让子类来覆盖
     * @return
     */
    protected abstract BaseMapper<T> getMapper();
    @Override
    public void save(T entity) {
        getMapper().insertSelective(entity);
    }

    @Override
    public void delete(T entity) {
        getMapper().delete(entity);
    }

    @Override
    public void update(T entity) {
        getMapper().updateByPrimaryKeySelective(entity);
    }

    @Override
    public T findById(Integer id) {
        return (T)getMapper().selectByPrimaryKey(id);

    }

    @Override
    public List<T> getAll() {
        return getMapper().selectAll();
    }
}





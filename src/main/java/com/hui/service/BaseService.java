package com.hui.service;

import java.util.List;

public interface BaseService<T> {
    public void save(T entity);// 保存

    public void delete(T entity);// 删除

    public void update(T entity);// 更新

    public T findById(Integer id);// 根据主键查找

    public List<T> getAll();// 查看所有

}

package com.jacky.learn.shiro.service.impl;

import com.jacky.learn.shiro.dao.BaseDao;
import com.jacky.learn.shiro.entity.BaseEntity;
import com.jacky.learn.shiro.service.ICommonEntityService;

import java.util.List;

public class AbstractCommonEntityService<T extends BaseEntity> implements ICommonEntityService<T> {

    protected BaseDao<T> dao;

    public AbstractCommonEntityService(BaseDao<T> dao) {
        this.dao = dao;
    }

    @Override
    public T save(T entity) {
        // TODO set create user info
        entity.setCreUserId("admin");
        entity.setCrtUserName("admin");
        entity.setCrtTime("");
        return dao.save(entity);
    }

    @Override
    public T update(T entity) {
        // TODO set update user info
        return dao.save(entity);
    }

    @Override
    public void delete(String id) {
        dao.deleteById(id);
    }

    @Override
    public List<T> find(T entity) {
        return dao.findAll();
    }
}

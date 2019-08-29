package com.jacky.learn.shiro.service;

import com.jacky.learn.shiro.entity.BaseEntity;

import java.util.List;

public interface ICommonEntityService<T extends BaseEntity> {
    T save(T entity);
    T update(T entity);
    void delete(String id);
    List<T> find(T entity);
}

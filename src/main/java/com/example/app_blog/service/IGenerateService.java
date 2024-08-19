package com.example.app_blog.service;

import java.util.List;

public interface IGenerateService <T>{

    public T findById(Long id);

    public List<T> findAll();

    public void save(T t);

    public void remove(Long id);

}

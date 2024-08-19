package com.example.app_blog.repository;

import java.util.List;

public interface IGenerateRepository<T> {


    public T findById(Long id);

    public List<T> findAll();

    public void save(T t);

    public void remove(Long id);

}

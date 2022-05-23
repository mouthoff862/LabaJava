package com.solvd.hospital.dao;

import java.util.List;

public interface IBaseDAO<T> {
    T getById(int id);

    void insert(T t);

    void update(T t);

    void remove(int id);

    List<T> selectAll();
}

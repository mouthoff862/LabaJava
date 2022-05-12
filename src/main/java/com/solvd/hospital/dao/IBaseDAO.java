package com.solvd.hospital.dao;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> {
    T getById(int t);
    void insert(T t);
    void update(T t);
    void remove(int id);
    List<T> selectAll();
}

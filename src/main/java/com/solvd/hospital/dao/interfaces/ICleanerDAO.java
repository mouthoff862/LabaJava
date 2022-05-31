package com.solvd.hospital.dao.interfaces;

import com.solvd.hospital.entities.Cleaner;

import java.util.List;

public interface ICleanerDAO extends IBaseDAO<Cleaner> {
    List<Cleaner> showAllCleaners();
}

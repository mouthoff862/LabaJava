package com.solvd.hospital.dao.interfaces;

import com.solvd.hospital.entities.Nurse;

import java.util.List;

public interface INurseDAO extends IBaseDAO<Nurse>{
    List<Nurse> showAllNurses();
}

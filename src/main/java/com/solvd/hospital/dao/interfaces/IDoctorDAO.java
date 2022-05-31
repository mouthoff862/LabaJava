package com.solvd.hospital.dao.interfaces;

import com.solvd.hospital.entities.Doctor;

import java.util.List;

public interface IDoctorDAO extends IBaseDAO<Doctor>{
    List<Doctor> showAllDoctors();
}

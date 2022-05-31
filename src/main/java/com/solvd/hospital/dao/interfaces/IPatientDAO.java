package com.solvd.hospital.dao.interfaces;

import com.solvd.hospital.entities.Patient;

import java.util.List;

public interface IPatientDAO extends IBaseDAO<Patient> {
    List<Patient> showAllPatients();
}

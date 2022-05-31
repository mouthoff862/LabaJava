package com.solvd.hospital.dao.interfaces;

import com.solvd.hospital.entities.PatientService;

import java.util.List;

public interface IPatientServiceDAO extends IBaseDAO<PatientService> {
    List<PatientService> showAllPatientServices();
}

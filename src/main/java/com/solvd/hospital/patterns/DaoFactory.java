package com.solvd.hospital.patterns;

import com.solvd.hospital.dao.interfaces.IBaseDAO;
import com.solvd.hospital.dao.mybatisimpl.*;
import com.solvd.hospital.entities.*;

public class DaoFactory {
    public static IBaseDAO<?> getDAO(String dao) {
        dao = dao.toUpperCase();
        switch(dao) {
            case "doctorDAO":
                IBaseDAO<Doctor> doctorIBaseDAO = new DoctorDAO();
                return doctorIBaseDAO;
            case "patientDAO":
                IBaseDAO<Patient> patientIBaseDAO = new PatientDAO();
                return patientIBaseDAO;
            case "cleanerDAO":
                IBaseDAO<Cleaner> cleanerIBaseDAO = new CleanerDAO();
                return cleanerIBaseDAO;
            case "medicineDAO":
                IBaseDAO<Medicine> medicineIBaseDAO = new MedicineDAO();
                return medicineIBaseDAO;
            case "patientServiseDAO":
                IBaseDAO<PatientService> patientServiceIBaseDAO = new PatientServiceDAO();
                return patientServiceIBaseDAO;
        }
        return null;
    }
}

package com.solvd.hospital.patterns;

import com.solvd.hospital.dao.interfaces.IBaseDAO;
import com.solvd.hospital.dao.mybatisimpl.*;
import com.solvd.hospital.entities.*;

import java.util.Locale;

public class DaoFactory extends AbstractFactory {
    public static IBaseDAO<?> getDAO(String dao) {
        dao = dao.toLowerCase();
        switch(dao) {
            case "doctordao":
                IBaseDAO<Doctor> doctorIBaseDAO = new DoctorDAO();
                return doctorIBaseDAO;
            case "patientdao":
                IBaseDAO<Patient> patientIBaseDAO = new PatientDAO();
                return patientIBaseDAO;
            case "cleanerdao":
                IBaseDAO<Cleaner> cleanerIBaseDAO = new CleanerDAO();
                return cleanerIBaseDAO;
            case "medicinedao":
                IBaseDAO<Medicine> medicineIBaseDAO = new MedicineDAO();
                return medicineIBaseDAO;
            case "patientservisedao":
                IBaseDAO<PatientService> patientServiceIBaseDAO = new PatientServiceDAO();
                return patientServiceIBaseDAO;
        }
        return null;
    }
}

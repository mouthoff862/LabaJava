package com.solvd.hospital;

import com.solvd.hospital.dao.interfaces.IDoctorDAO;
import com.solvd.hospital.dao.interfaces.IPatientDAO;
import com.solvd.hospital.dao.mybatisimpl.DoctorDAO;
import com.solvd.hospital.dao.mybatisimpl.PatientDAO;
import com.solvd.hospital.entities.Doctor;
import com.solvd.hospital.entities.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisRunner {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisRunner.class);

    private static void runPatientDAO() {
        IPatientDAO ipatientDAO = new PatientDAO();
        Patient patient = new Patient("Markus Zusak", "markus@gmail.com", 30, "San Francisco");
        Patient updatePatient = new Patient(2, "Tom Rubak", "tom@gmeil.com", 45);
        ipatientDAO.createEntity(patient);
        ipatientDAO.updateEntity(updatePatient);
        ipatientDAO.showAllPatients();
    }

    private static void showAllPatients() {
        IPatientDAO iPatientDAO = new PatientDAO();
        iPatientDAO.showAllPatients();
    }

    private static void runDoctorDAO() {
        IDoctorDAO iDoctorDAO = new DoctorDAO();
        Doctor doctorCreate = new Doctor();
        doctorCreate.setName("Albus Dumbledore");
        doctorCreate.setPosition("Therapist");
        doctorCreate.setAge(60);
        iDoctorDAO.createEntity(doctorCreate);
    }

    public static void main(String[] args) {
        MyBatisRunner.runPatientDAO();
        MyBatisRunner.runDoctorDAO();
        MyBatisRunner.showAllPatients();
    }

}

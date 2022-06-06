package com.solvd.hospital.dao.service;

import com.solvd.hospital.dao.interfaces.IPatientDAO;
import com.solvd.hospital.entities.Patient;
import com.solvd.hospital.patterns.DaoFactory;
import com.solvd.hospital.patterns.MyBatisFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListService {

    private static final Logger LOGGER = LogManager.getLogger(ListService.class);
    // To choose what type of dao you want to use, uncomment one of these variables:
    // --- "patientdao" - for jdbc
    // private IPatientDAO iPatientDAO = (IPatientDAO) DaoFactory.getDAO("patientdao");
    // --- "patient" - for MyBatis
     private IPatientDAO iPatientDAO = (IPatientDAO) MyBatisFactory.getMyBatis("patient");

    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
            patients = iPatientDAO.showAllPatients();
            patients.stream().forEach(LOGGER::info);
        return patients;
    }

    public static void main(String[] args) {
        ListService listService = new ListService();
        listService.getAllPatients();
    }
}

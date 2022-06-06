package com.solvd.hospital;

import com.solvd.hospital.dao.interfaces.IPatientDAO;
import com.solvd.hospital.dao.jdbcmysqlimpl.PatientDAO;
import com.solvd.hospital.entities.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCRunner {
    private final static Logger LOGGER = LogManager.getLogger(JDBCRunner.class);

    public static void main(String[] args) {
        //List of patients
        IPatientDAO iPatientDAO = new PatientDAO();
        iPatientDAO.showAllPatients();

        //Delete patient
        IPatientDAO patientDAO = new PatientDAO();
        patientDAO.removeEntity(12);

        //Find patient by id
        patientDAO.getEntityById(10);

        //Create patient
        Patient patient = new Patient("Tom Zavadsky", "tom@gmail.com", 35, "Polotsk");
        patientDAO.createEntity(patient);
    }

}

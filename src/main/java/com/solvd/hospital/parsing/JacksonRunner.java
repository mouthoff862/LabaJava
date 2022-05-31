package com.solvd.hospital.parsing;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.*;
import com.solvd.hospital.parsing.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class JacksonRunner {
    private static final Logger LOGGER = LogManager.getLogger(JacksonRunner.class);

    public static void jsonMarshalling() {
        PatientClass patient = new PatientClass();
        patient.setId(1L);
        patient.setName("Andrew Milton");
        patient.setEmail("Andrew_Milton@gmail.com");
        patient.setAge(45);

        VisitPatient visit = new VisitPatient();
        HospitalDoctor doctor = new HospitalDoctor();
        doctor.setId(1L);
        doctor.setName("John Marston");
        doctor.setPosition("Therapist");
        visit.setDoctor(doctor);
        visit.setYear(2022);
        visit.setDateOfVisit(new Date(10/10/2021));

        PatientTherapy therapy = new PatientTherapy();
        HospitalNurse nurse = new HospitalNurse();
        HospitalMedicine medicineOne = new HospitalMedicine();
        medicineOne.setName("Panangin");
        medicineOne.setPortion(10);
        HospitalMedicine medicineSecond = new HospitalMedicine();
        medicineSecond.setName("Norvask");
        medicineSecond.setPortion(20);
        List<HospitalMedicine> medicines = new ArrayList<>();
        medicines.add(medicineOne);
        medicines.add(medicineSecond);
        nurse.setName("Abigail Marston");
        therapy.setDoctor(doctor);
        therapy.setNurse(nurse);
        therapy.setHospitalMedicine(medicines);

        DiagnosisPatient diagnosis = new DiagnosisPatient();
        diagnosis.setDiagnosis("Hypertension");

        Chart chart = new Chart();
        chart.setId(1L);
        chart.setPatient(patient);
        chart.setVisit(visit);
        chart.setTherapy(therapy);
        chart.setDiagnosis(diagnosis);

        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            List<Chart> charts = new ArrayList<>();
            charts.add(chart);
            om.writeValue(new File(System.getProperty("user.dir") + "/src/main/resources/Json_Chart.json"), charts);
        } catch (JsonParseException e) {
            LOGGER.info(e.getMessage());
        } catch (StreamWriteException e) {
            LOGGER.info(e.getMessage());
        } catch (DatabindException e) {
            LOGGER.info(e.getMessage());
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    public static void jsonUnmarshalling() {
        ObjectMapper om = new ObjectMapper();
        try {
            JavaType type = om.getTypeFactory().constructCollectionType(List.class, Chart.class);
            List<Chart> charts = om.readValue(new File(System.getProperty("user.dir") + "/src/main/resources/Json_Chart.json"), type);
            LOGGER.info(charts);
        } catch (FileNotFoundException e) {
            LOGGER.info(e.getMessage());
        } catch (StreamReadException e) {
            LOGGER.info(e.getMessage());
        } catch (DatabindException e) {
            LOGGER.info(e.getMessage());
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }
}

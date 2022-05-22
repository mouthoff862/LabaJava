package com.solvd.hospital.jaxb;

import com.solvd.hospital.entities.Patient;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JaxbToWrite {

    private static final Logger LOGGER = LogManager.getLogger(JaxbToWrite.class);

    public static void marshal() {

        PatientClass patient = new PatientClass();
        patient.setId(1L);
        patient.setName("Andrew Milton");
        patient.setEmail("Andrew_Milton@gmail.com");
        patient.setAge(45);

        VisitPatient visit = new VisitPatient();
        HospitalDoctor doctor = new HospitalDoctor();
        doctor.setName("John Marston");
        visit.setDoctor(doctor);
        visit.setYear(2022);

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

        try {
            JAXBContext context = JAXBContext.newInstance(Chart.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(chart, new File(System.getProperty("user.dir") + "/src/main/resources/Chart.xml"));
        } catch (JAXBException e) {
            LOGGER.info(e);
        }
    }

    public static Chart unmarshal() throws JAXBException, FileNotFoundException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Chart.class);
        return (Chart) jaxbContext.createUnmarshaller()
                .unmarshal(new FileReader(System.getProperty("user.dir") + "/src/main/resources/Chart.xml"));
    }

}

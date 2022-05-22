package com.solvd.hospital;

import com.solvd.hospital.entities.*;
import com.solvd.hospital.jaxb.Chart;
import com.solvd.hospital.jaxb.JaxbToWrite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {

        LOGGER.info("Hello");

    //    String file = (System.getProperty("user.dir") + "/src/main/resources/hospital.xml");
    //    List<Patient> patientList = parserForFile(file);
    //    for (Patient p : patientList) {
     //       LOGGER.info(p.toString());
     //   }

       // marshalJaxb();
    }


    private static void marshalJaxb() {
        JaxbToWrite.marshal();
        Chart chartOne = new Chart();
        try {
            chartOne= JaxbToWrite.unmarshal();
            LOGGER.info(chartOne);
        } catch (JAXBException | FileNotFoundException e) {
            LOGGER.info(e);
        }
    }

    private static List<Patient> parserForFile(String file) {
        List<Patient> patients = new ArrayList<>();
        Patient p = new Patient();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(file));
            while (reader.hasNext()) {
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("patient")) {
                        p = new Patient();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null) {
                            p.setId(Integer.parseInt(idAttr.getValue()));
                        }
                    } else if (startElement.getName().getLocalPart().equals("name")) {
                        xmlEvent = reader.nextEvent();
                        p.setName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("email")) {
                        xmlEvent = reader.nextEvent();
                        p.setEmail(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("age")) {
                        xmlEvent = reader.nextEvent();
                        p.setAge(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }
                }
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("patient")) {
                        patients.add(p);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            LOGGER.info(e.getMessage());
        }
        return patients;
    }

}



package com.solvd.hospital;

import com.solvd.hospital.connector.ConnectionPool;
import com.solvd.hospital.entities.Patient;
import com.solvd.hospital.jdbcMySqlImpl.PatientDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {

        Connection conn = ConnectionPool.getConnection();
        if (conn != null) {
           LOGGER.info("The connection is taken");
        }

        //staxXmlDocument();

    }

    private static void staxXmlDocument() {
        final String file = "D:/laba/src/main/resourses/hospital.xml";

        try{
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(file, new FileInputStream(file));

            while (xmlr.hasNext()){
                if (xmlr.isStartElement()) {
                    LOGGER.info(xmlr.getLocalName());
                } else if (xmlr.isEndElement()) {
                    LOGGER.info("/" + xmlr.getLocalName());
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    LOGGER.info("   " + xmlr.getText());
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            LOGGER.info(ex.getMessage());
        }
    }


}

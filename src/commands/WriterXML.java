package commands;

import managers.CollectionManager;
import models.Organization;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class WriterXML {
    public static void write(){
        LinkedList<Organization> orgsCollection = CollectionManager.getCollection();
        String filepath = System.getenv("MY_TEXT_FILE");
        try{
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("organizations");
            doc.appendChild(rootElement);

            for (Organization organization : orgsCollection) {
                Element orgElement = doc.createElement("organization");

                orgElement.setAttribute("id", String.valueOf(organization.getId()));
                orgElement.setAttribute("name", organization.getName());
                orgElement.setAttribute("CoordinateX", String.valueOf(organization.getCoordinates().getX()));
                orgElement.setAttribute("CoordinateY", String.valueOf(organization.getCoordinates().getY()));
                orgElement.setAttribute("creationDate", String.valueOf(organization.getCreationDate()));
                orgElement.setAttribute("annualTurnover", String.valueOf(organization.getAnnualTurnover()));
                orgElement.setAttribute("fullName", organization.getFullName());
                orgElement.setAttribute("Organizationtype", String.valueOf(organization.getType()));
                orgElement.setAttribute("zipCode", organization.getPostalAddress().getZipCode());
                if (organization.getPostalAddress().getStreet() != null) {
                    orgElement.setAttribute("street", organization.getPostalAddress().getStreet());
                }
                rootElement.appendChild(orgElement);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            //Использую OutputStreamWriter для записи в файл
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            StreamResult result = new StreamResult(outputStreamWriter);
            transformer.transform(new DOMSource(doc), result);
            outputStreamWriter.close();

            System.out.println("Файл записан!");
        } catch (TransformerException | IOException | ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}

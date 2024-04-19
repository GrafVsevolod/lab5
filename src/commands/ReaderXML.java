package commands;

import managers.CollectionManager;
import models.Address;
import models.Coordinates;
import models.Organization;
import models.OrganizationType;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.time.LocalDate;

public class ReaderXML {
    public static void read() {
        String filePath = System.getenv("MY_TEXT_FILE");
        StringBuilder xmlContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                xmlContent.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("File not found: " + filePath);
        }

        InputSource in = new InputSource(new StringReader(xmlContent.toString()));
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(in);
            NodeList orgElements = document.getDocumentElement().getElementsByTagName("organization");

            if (orgElements.getLength() == 0) {
                System.out.println("File is empty");
            } else {
                for (int i = 0; i < orgElements.getLength(); i++) {
                    Node orgNode = orgElements.item(i);
                    NamedNodeMap attributes = orgNode.getAttributes();

                    //создаем обьект Organization
                    Organization organization = new Organization(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    organization.setName(attributes.getNamedItem("name").getNodeValue());
                    organization.setCoordinates(new Coordinates(
                            Long.parseLong(attributes.getNamedItem("CoordinateX").getNodeValue()),
                            Double.parseDouble(attributes.getNamedItem("CoordinateY").getNodeValue())
                    ));
                    organization.setCreationDate(LocalDate.parse(attributes.getNamedItem("creationDate").getNodeValue()));
                    organization.setAnnualTurnover(Long.parseLong(attributes.getNamedItem("annualTurnover").getNodeValue()));
                    organization.setFullName((attributes.getNamedItem("fullName").getNodeValue()));
                    organization.setType(OrganizationType.valueOf(attributes.getNamedItem("Organizationtype").getNodeValue()));
                    organization.setPostalAddress(new Address(
                            attributes.getNamedItem("street").getNodeValue(),
                            attributes.getNamedItem("zipCode").getNodeValue()
                    ));

                    CollectionManager.add(organization);
                    System.out.println("файл успешно считан!");
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}

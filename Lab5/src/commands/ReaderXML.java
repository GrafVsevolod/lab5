package commands;

import managers.CollectionManager;
import models.Coordinates;
import models.Organization;
import models.OrganizationType;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Scanner;

public class ReaderXML {
     public static void read(){
            String filePath = System.getenv("MY_FILE");
            StringBuilder xmlContent = new StringBuilder();
            try (Scanner scanner = new Scanner(new File(filePath))) {
                while (scanner.hasNextLine()) {
                    xmlContent.append(scanner.nextLine()).append("\n");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + filePath);
                return;
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
                        Node flatNode = orgElements.item(i);
                        NamedNodeMap attributes = flatNode.getAttributes();

                        Organization organization = new Organization(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                        organization.setName(attributes.getNamedItem("name").getNodeValue());
                        organization.setCoordinates(new Coordinates(
                                Long.parseLong(attributes.getNamedItem("coordinate X").getNodeValue()),
                                Double.parseDouble(attributes.getNamedItem("coordinate Y").getNodeValue())
                        ));
                        organization.setAnnualTurnover(Long.parseLong(attributes.getNamedItem("annualTurnover").getNodeValue()));
                        organization.setFullName(attributes.getNamedItem("fullName").getNodeValue());
                        organization.setType(OrganizationType.valueOf(attributes.getNamedItem("type").getNodeValue()));
                        CollectionManager.add(organization);
                    }
                }
            } catch (Exception e) {
                System.out.println("File is empty or damaged");
                e.printStackTrace();
            }
        }
    }

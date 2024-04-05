package commands;

import managers.CollectionManager;
import models.Organization;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;

public class WritterXML {
    public static void write() {
        LinkedList<Organization> orgsCollection = CollectionManager.getCollection();
        String filePath = System.getenv("MY_TEXT_FILE");
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("organizations");
            doc.appendChild(rootElement);

            for (Organization organization: orgsCollection) {
                Element orgElement = doc.createElement("organization");

                orgElement.setAttribute("id", String.valueOf(organization.getId()));
                orgElement.setAttribute("name", organization.getName());
                orgElement.setAttribute("coordinateX", String.valueOf(organization.getCoordinates().getX()));
                orgElement.setAttribute("coordinateY", String.valueOf(organization.getCoordinates().getY()));
                orgElement.setAttribute("creationDate", String.valueOf(organization.getCreationDate()));
                orgElement.setAttribute("area", String.valueOf(organization.getAnnualTurnover()));
                orgElement.setAttribute("numberOfRooms", String.valueOf(organization.getFullName()));
                orgElement.setAttribute("kitchenArea", String.valueOf(organization.getType()));
                if (organization.getPostalAddress() != null) {
                    orgElement.setAttribute("transport", String.valueOf(organization.getPostalAddress()));
                }
                rootElement.appendChild(orgElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // Используем PrintWriter для записи в файл
            PrintWriter writer = new PrintWriter(new File(filePath));
            StreamResult result = new StreamResult(writer);
            transformer.transform(new DOMSource(doc), result);
            writer.close();

            System.out.println("Файл успешно сохранен!");

        } catch (Exception e) {
            System.out.println("Colletcion is empty :(");
            ;
        }
    }
}

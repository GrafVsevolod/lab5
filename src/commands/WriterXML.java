package commands;

import managers.CollectionManager;
import models.Organization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.*;
import java.util.LinkedList;

public class WriterXML {
    public static void write(LinkedList<Organization> collection){
        String filepath = "My_File.xml";

        try{
            File file = new File(filepath);

            OrganizationsStorage organizationsStorage = new OrganizationsStorage();
            for(Object org : collection.toArray()){
                organizationsStorage.addOrganizationsToOrgs((Organization) org);
            }

            FileOutputStream fos = new FileOutputStream(file, false);
            Writer outputStreamWriter = new BufferedWriter(new OutputStreamWriter(fos));

            JAXBContext context = JAXBContext.newInstance(Organization.class, OrganizationsStorage.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.marshal(organizationsStorage, outputStreamWriter);

            outputStreamWriter.close();
            System.out.println("Данные записаны в XML файл!");
        } catch (FileNotFoundException | JAXBException e) {
            throw new RuntimeException("Файл не найден!");
        } catch (IOException e) {
            throw new RuntimeException("Что-то пошло не так(");
        }
    }
}

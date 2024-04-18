package commands;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class ReaderXML {
    public static OrganizationsStorage read(String filepath){
        File file = new File(filepath);
        if(!file.exists()){
            System.out.println("Файл не найден");
            return new OrganizationsStorage();
        }
        StringBuilder stringBuilderOrg = new StringBuilder();
        try{
            FileReader fileReader = new FileReader(filepath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //строка для хранения считанной строки
            String line;
            while(bufferedReader.readLine() != null){
                line = bufferedReader.readLine();
                stringBuilderOrg.append(line).append("/n");
            }
            if(stringBuilderOrg.isEmpty()){
                System.out.println("у вас нету обьектов");
            }
            else{
                JAXBContext context = JAXBContext.newInstance(OrganizationsStorage.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                return (OrganizationsStorage) unmarshaller.unmarshal(new StringReader((stringBuilderOrg.toString())));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (JAXBException e){
            e.printStackTrace();
        }
        return new OrganizationsStorage();
    }
}

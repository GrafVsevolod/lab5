package commands;

import managers.CollectionManager;
import models.*;

import java.io.FileReader;
import java.time.LocalDate;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command{
    @Override
    public void execute(String[] args) throws Exception {
        String filepath = args[1];
        Scanner scanner = new Scanner(new FileReader(filepath));

        try {
            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();

                if (command.equals("add")) {
                    String name = scanner.nextLine();
                    Long coordinateX = Long.valueOf(scanner.nextLine());
                    Double coordinateY = Double.valueOf(scanner.nextLine());
                    Coordinates coordinates = new Coordinates(coordinateX, coordinateY);
                    Long annualTurnover = Long.valueOf(scanner.nextLine());
                    LocalDate creationDate = LocalDate.parse(scanner.nextLine());
                    String fullname = scanner.nextLine();
                    OrganizationType type = OrganizationType.valueOf(scanner.nextLine());
                    String street = scanner.nextLine();
                    String zipcode = scanner.nextLine();
                    Address address = new Address(street, zipcode);

                    Organization organization = new Organization(IdGenerator.generateId());
                    organization.setName(name);
                    organization.setCoordinates(coordinates);
                    organization.setAnnualTurnover(annualTurnover);
                    organization.setCreationDate(creationDate);
                    organization.setFullName(fullname);
                    organization.setType(type);
                    organization.setPostalAddress(address);

                    CollectionManager.add(organization);
                }
            }
            //P.S остальные equals делаются шаблонно, допишу перед практикой
        }
        catch (Exception e){
            System.out.println("Wrong input data");
        }
    }

    @Override
    public String getDescription(){
        return "read and execute script from our file";
    }

    @Override
    public String getName(){
        return "ExecuteScript";
    }
}
package commands;

import models.Address;
import models.Coordinates;
import models.Organization;
import models.OrganizationType;

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

                    Organization organization = new Organization();
                }
            }
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
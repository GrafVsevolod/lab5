package commands;

import exceptions.BuildOrganizationException;
import exceptions.WrongArgumentException;
import managers.CollectionManager;
import models.Organization;
import models.OrganizationInput;

import java.util.LinkedList;

public class UpdateCommand implements Command {
    @Override
    public void execute(String[] args) throws WrongArgumentException, BuildOrganizationException {
        if(args.length != 2 || CollectionManager.getCollection().isEmpty() || Long.parseLong(args[1]) < 0){
            System.out.println("wrong id");
        }
        else{
            Integer needId = Integer.parseInt(args[1]);
            Object[] arr = CollectionManager.getCollection().toArray();
            Organization or = OrganizationInput.createOrganization(needId);
            arr[needId - 1] = or;

            LinkedList<Organization> newList = new LinkedList<>();
            for(Object org: arr){
                newList.add((Organization) org);
            }

            CollectionManager.setCollection(newList);
        }
    }

    @Override
    public String getName(){
        return "Update";
    }

    public String getDescription(){
        return "update element by id";
    }
}

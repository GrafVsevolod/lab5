package commands;

import exceptions.BuildOrganizationException;
import exceptions.NoElementException;
import exceptions.WrongArgumentException;
import managers.CollectionManager;
import models.Organization;
import models.OrganizationInput;

import java.util.LinkedList;

public class UpdateCommand implements Command {
    @Override
    public void execute(String[] args) throws NoElementException, WrongArgumentException, BuildOrganizationException {
        int id = Integer.parseInt(args[1]);
        boolean flag = false;
        for(Organization org : CollectionManager.getCollection()){
            if(org.getId() == id){
                flag = true;
                Organization organization = OrganizationInput.createOrganization(id);
                int pozition = CollectionManager.getCollection().indexOf(org);
                CollectionManager.remove(org);
                CollectionManager.getCollection().add(pozition, organization);
            }
        }
        if(!flag){
            throw new NoElementException("No element in collection with this id");
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

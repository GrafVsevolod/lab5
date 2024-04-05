package commands;

import managers.CollectionManager;
import models.IdGenerator;
import models.Organization;
import models.OrganizationInput;

public class AddCommand implements Command {
    @Override
    public void execute(String[] args) throws Exception{
        Organization org = OrganizationInput.createOrganization(IdGenerator.generateId());
        CollectionManager.add(org);
    }

    @Override
    public String getName(){
        return "Add";
    }

    @Override
    public String getDescription(){
        return "add element in collection";
    }
}

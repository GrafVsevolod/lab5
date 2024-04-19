package commands;

import managers.CollectionManager;
import models.IdGenerator;
import models.Organization;
import models.OrganizationInput;

/**
 * Данная команда добавляет новый элемент в коллекцию
 *
 * @author GrafVsevolod
 * @since 1.0
 */

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

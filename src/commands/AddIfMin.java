package commands;

import comparators.OrganizationsComparator;
import exceptions.BuildOrganizationException;
import exceptions.WrongArgumentException;
import managers.CollectionManager;
import models.IdGenerator;
import models.Organization;
import models.OrganizationInput;

import java.util.List;
/**
 * Добавляет новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class AddIfMin implements Command {
    @Override
    public void execute(String[] args) throws WrongArgumentException, BuildOrganizationException {
        List<Organization> ourList = CollectionManager.getCollection().stream().toList();
        OrganizationsComparator a = new OrganizationsComparator();
        Organization minElem = ourList.stream().min(a).get();

        Organization org = OrganizationInput.createOrganization(IdGenerator.generateId());
        if(a.compare(org, minElem) < 0){
            org.setId(IdGenerator.generateId());
            CollectionManager.add(org);
        }
        else{
            System.out.println("Value of new element is bigger, than old value");
        }
    }

    @Override
    public String getName(){
        return "AddIfMin";
    }

    @Override
    public String getDescription(){
        return "add element in collection if his value less then smaller collection element";
    }
}

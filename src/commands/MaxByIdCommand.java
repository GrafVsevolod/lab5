package commands;

import managers.CollectionManager;
import models.Organization;
/**
 *  выводит любой объект из коллекции, значение поля id которого является максимальным
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class MaxByIdCommand implements Command{
    @Override
    public void execute(String[] args){
        int maxId = Integer.MIN_VALUE;
        Organization output = null;
        for(Organization organization : CollectionManager.getCollection()){
            if(organization.getId() > maxId){
                maxId = (int) organization.getId();
                output = organization;
            }
        }
        System.out.println("Element in collection with max id: " + output);
    }

    @Override
    public String getName(){
        return "MaxById";
    }

    @Override
    public String getDescription(){
        return "output element from collection with max ID";
    }
}

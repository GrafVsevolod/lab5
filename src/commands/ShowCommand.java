package commands;

import managers.CollectionManager;
import models.Organization;

import java.util.LinkedList;
/**
 *  выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class ShowCommand implements Command {
    public void execute(String[] args) throws Exception{
        LinkedList<Organization> orgs = CollectionManager.getCollection();
        if(orgs.isEmpty()){
            System.out.println("no elements");
        }
        else{
            for(Organization organization: orgs){
                System.out.println(organization);
            }
        }
    }

    @Override
    public String getName() {
        return "Show";
    }

    @Override
    public String getDescription(){
        return "Show elements of collection";
    }
}

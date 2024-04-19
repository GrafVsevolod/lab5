package commands;

import managers.CollectionManager;
import models.Organization;

import java.util.LinkedList;
/**
 *  удаляет элемент из коллекции по его id
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class RemoveCommand implements Command {
    @Override
    public void execute(String[] args){
        if(CollectionManager.getCollection().isEmpty() || args.length != 2 || Integer.parseInt(args[1]) < 0){
            System.out.println("delete failed");
        }
        else{
            Integer needId = Integer.parseInt(args[1]);
            LinkedList<Organization> newList = new LinkedList<>();
            for(Organization org: CollectionManager.getCollection()){
                if(org.getId() != needId){
                    newList.add(org);
                }
            }
            CollectionManager.setCollection(newList);
        }
    }

    @Override
    public String getName(){
        return "Remove";
    }

    @Override
    public String getDescription(){
        return "remove";
    }
}

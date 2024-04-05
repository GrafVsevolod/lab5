package commands;

import managers.CollectionManager;
import models.Organization;

import java.util.LinkedList;

public class RemoveCommand implements Command {
    @Override
    public void execute(String[] args){
        if(CollectionManager.getCollection().isEmpty() || args.length != 2 || Integer.parseInt(args[1]) < 0){
            System.out.println("delete failed");
        }
        else{
            Object[] orga = CollectionManager.getCollection().toArray();
            Integer needId = Integer.parseInt(args[1]);
            LinkedList<Organization> newList = new LinkedList<>();
            for(Object org: orga){
                Organization orgg = (Organization) org;
                if(orgg.getId() != needId){
                    newList.add(orgg);
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

package commands;

import managers.CollectionManager;
import models.Organization;

import java.util.LinkedList;
/**
 *  удаляет первый элемент из коллекции
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class RemoveFirstCommand implements Command {
    @Override
    public void execute(String[] args){
        LinkedList<Organization> dec = CollectionManager.getCollection();
        dec.removeFirst();
        CollectionManager.setCollection(dec);
    }

    @Override
    public String getName(){
        return "Remove first";
    }

    @Override
    public String getDescription(){
        return "Remove first element from collection";
    }
}

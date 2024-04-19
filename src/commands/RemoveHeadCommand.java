package commands;

import managers.CollectionManager;
import models.Organization;

import java.util.LinkedList;
/**
 *  выводит первый элемент коллекции и удалить его
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class RemoveHeadCommand implements Command {
    public void execute(String[] args){
        LinkedList<Organization> dec = CollectionManager.getCollection();
        System.out.println(dec.get(0));
        dec.removeFirst();
        CollectionManager.setCollection(dec);
    }

    public String getName(){
        return "RemoveHead";
    }

    public String getDescription(){
        return "Output first element and delete it";
    }
}

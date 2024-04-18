package managers;

import exceptions.NoElementException;
import models.IdGenerator;
import models.Organization;

import java.time.LocalDate;
import java.util.LinkedList;

public class CollectionManager {
    public static LinkedList<Organization> list = new LinkedList<>();
    public static LocalDate date;

    public CollectionManager(){
        list = new LinkedList<>();
        date = LocalDate.now();
    }

    public static LocalDate InitDate(){
        return date;
    }

    public static void add(Organization organization){
        if(list == null){
            list = new LinkedList<>();
        }
        list.add(organization);
        IdGenerator.add(organization.getId());
    }

    public static void remove(Organization organization) throws NoElementException {
        if(list == null || (!list.contains(organization))){
            throw new NoElementException("list nnot contains element");
        }
        else{
            IdGenerator.remove(organization.getId());
            list.remove(organization);
        }
    }

    public static Long getAverageTurn(){
        Long counter = 0L;
        if(list.isEmpty()){
            return 0L;
        }
        else{
            for(Organization org: CollectionManager.getCollection()){
                counter+=org.getAnnualTurnover();
            }
        }
        return counter/(CollectionManager.getCollection().size());
    }

    public static void setCollection(LinkedList<Organization> li){
        list = li;
    }

    public static void clear(){
        list.clear();
    }

    public static LinkedList<Organization> getCollection(){
        return list;
    }
}

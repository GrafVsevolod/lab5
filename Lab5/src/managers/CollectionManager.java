package managers;

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

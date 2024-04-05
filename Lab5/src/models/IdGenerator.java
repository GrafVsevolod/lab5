package models;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.Collection;

public class IdGenerator {
    private static ArrayList<Long> idList = new ArrayList<>();
    private static int max = 1000000;
    private static int min = 10000;

    public IdGenerator(){
        idList = new ArrayList<>();
    }

    public static boolean idIsUnique(Long id){
        if((idList).contains(id)){
            return false;
        }
        else{
            return true;
        }
    }

    public static int generateId(){
        int id = (int)Math.floor(Math.random()*(max - min + 1) + min);
        idList.add((long) id);
        return id;
    }
}

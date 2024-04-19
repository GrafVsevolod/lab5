package commands;

import managers.CollectionManager;
import models.Organization;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * выводит элементы, значение поля fullName которых начинается с заданной подстроки
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class FilterStartsWithCommand implements Command{
    @Override
    public void execute(String[] args){
        Scanner scanner = new Scanner(System.in);
        String ourStr = scanner.nextLine();
        ArrayList<Organization> list = new ArrayList<>();
        for(Organization org : CollectionManager.getCollection()){
            if(org.getFullName().startsWith(ourStr)){
                list.add(org);
            }
        }
        System.out.println(list);
    }

    @Override
    public String getName(){
        return "fullNameStartsWith";
    }

    @Override
    public String getDescription(){
        return "output elements which fullname fields starts with ...";
    }
}

package commands;

import managers.CollectionManager;
/**
 *  вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class InfoCommand implements Command {
    @Override
    public void execute(String[] args) throws Exception{
        System.out.println("Type - " + CollectionManager.getCollection().getClass().getName());
        System.out.println("Date - " + CollectionManager.date);
        System.out.println("Amount - " + CollectionManager.getCollection().size());
    }

    @Override
    public String getName(){
        return "info";
    }

    @Override
    public String getDescription(){
        return "information about app";
    }
}

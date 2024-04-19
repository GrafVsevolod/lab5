package commands;

import managers.CollectionManager;
/**
 * очистить коллекцию
 *
 * @author GrafVsevolod
 * @since 1.0
 */
public class ClearCommand implements Command {
    @Override
    public void execute(String[] args){
        CollectionManager.clear();
        System.out.println("GG");
    }

    @Override
    public String getName(){
        return "Clear";
    }

    @Override
    public String getDescription(){
        return "clear our Collection";
    }
}

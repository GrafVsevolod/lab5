package commands;

public class SaveCommand implements Command {
    @Override
    public void execute(String[] args){
        System.out.println();
    }

    @Override
    public String getName(){
        return "Save";
    }

    @Override
    public String getDescription(){
        return "Save collection";
    }
}

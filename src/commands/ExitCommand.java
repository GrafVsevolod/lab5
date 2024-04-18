package commands;

public class ExitCommand implements Command {
    @Override
    public void execute(String[] args){
        System.exit(1);
    }

    @Override
    public String getName(){
        return "Exit";
    }

    @Override
    public String getDescription(){
        return "finish our programm without saving";
    }
}

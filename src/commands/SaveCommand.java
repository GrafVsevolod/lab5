package commands;

public class SaveCommand implements Command {
    @Override
    public void execute(String[] args) throws Exception{
        WriterXML.write();
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

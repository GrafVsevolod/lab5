package commands;

import managers.CollectionManager;

public class SaveCommand implements Command {
    @Override
    public void execute(String[] args) throws Exception{
        WriterXML.write(CollectionManager.getCollection());
        System.out.println("Collection was saved");
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

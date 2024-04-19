package managers;

import commands.*;
import exceptions.UnknownCommandException;

import java.util.HashMap;
import java.util.LinkedList;

public class CommandManager {
    private static HashMap<String, Command> commandList;

    public CommandManager(){
        commandList = new HashMap<>();
        commandList.put("help", new HelpCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("add", new AddCommand());
        commandList.put("update", new UpdateCommand());
        commandList.put("remove", new RemoveCommand());
        commandList.put("clear", new ClearCommand());
        commandList.put("save", new SaveCommand());
        commandList.put("execute", new ExecuteScriptCommand());
        commandList.put("exit", new ExitCommand());
        commandList.put("remove first", new RemoveFirstCommand());
        commandList.put("remove head", new RemoveHeadCommand());
        commandList.put("addMin", new AddIfMin());
        commandList.put("average", new AverageTurnCommand());
        commandList.put("Max by", new MaxByIdCommand());
        commandList.put("filter starts", new FilterStartsWithCommand());
    }

    public void startExecuting(String arg)  throws Exception{
        String commandName = arg.split(" ")[0];
        if(!commandList.containsKey(commandName)){
            throw new UnknownCommandException(commandName);
        }
        else{
            Command command = commandList.get(commandName);
            command.execute(arg.split(" "));
        }
    }

    public static HashMap<String, Command> getCommandList(){
        return commandList;
    }

}

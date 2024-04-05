package managers;

import managers.CollectionManager;
import managers.CommandManager;
import models.IdGenerator;

import java.io.InputStream;
import java.util.Scanner;

public class Console {
    public void start(InputStream input){
        Scanner scanner = new Scanner(System.in);
        CollectionManager collectionManager = new CollectionManager();
        IdGenerator idGenerator = new IdGenerator();

        while(scanner.hasNextLine()){
            String command = scanner.nextLine();
            CommandManager commandManager = new CommandManager();
            try{
                commandManager.startExecuting(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

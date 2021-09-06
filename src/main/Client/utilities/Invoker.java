package utilities;

import commands.Command;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Invoker {
    private final HashMap<String, Command> commands = new HashMap<>();

    private final Deque<String> commandHistory = new ArrayDeque<>();

    public void register(String name, Command command){
        commands.put(name, command);
    }

    public void executeCommand(String[] userCommand) throws IOException {
        try {
            //System.out.println("here");
            if(userCommand[0].equals("history")){
                commandHistory.forEach(System.out::println);
            }
            else {
                Command command = commands.get(userCommand[0]);
                command.execute(userCommand);
            }
            addCommandToHistory(userCommand[0]);

        } catch(NullPointerException e){
            System.out.println("Command is not supported! Insert help to see the guideline!");
        }
    }

    public void addCommandToHistory(String onlyName){
        if(commandHistory.size() == 14) commandHistory.removeFirst();
        commandHistory.addLast(onlyName);
    }

    public HashMap<String, Command> getCommands(){
        return this.commands;
    }
}
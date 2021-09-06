package utilities;

import commands.specificCommands.*;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleManager {


    public void interactive(String host, String p) throws IOException {
        Session session = null;
        try {
            session = new Session(host, Integer.parseInt(p));
            session.startSession();
        } catch (NumberFormatException e){
            System.out.println("Client: Error! Port is invalid!");
            System.exit(0);
        }


        Sender sender = new Sender(session.getSocketAddress());
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver(invoker, sender, session);

        invoker.register("add", new Add(receiver));
        invoker.register("clear", new Clear(receiver));
        invoker.register("insert_null", new InsertNull(receiver));
        invoker.register("exit", new Exit(receiver));
        invoker.register("count_by_difficulty", new CountByDifficulty(receiver));
        invoker.register("help", new Help(receiver));
        invoker.register("info", new Info(receiver));
        invoker.register("print_field", new PrintField(receiver));
        invoker.register("remove_by_key", new RemoveByKey(receiver));
        invoker.register("replace_if_greater", new ReplaceIfGreater(receiver));
        invoker.register("replace_if_lower", new ReplaceIfLower(receiver));
        invoker.register("show", new Show(receiver));
        invoker.register("update", new Update(receiver));
        invoker.register("execute_script", new ExecuteScript(receiver));

        Scanner userInput = new Scanner(System.in);
        while(true){
            if(!userInput.hasNextLine()){
                session.endSession();
                System.exit(0);
            }
            String[] userCommand = userInput.nextLine().trim().split(" ");
            invoker.executeCommand(userCommand);
            System.out.println("----------------------------------------");
        }

    }

}
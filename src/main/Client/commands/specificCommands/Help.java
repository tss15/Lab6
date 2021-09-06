package commands.specificCommands;
import commands.Command;
import utilities.Receiver;

import java.io.IOException;
import java.io.Serializable;
public class Help extends Command implements Serializable {

    private final Receiver receiver;
    private static final long serialVersionUID = 1234567L;


    public Help(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("help:                   - display which commands can be executed.");
    }

    @Override
    public void execute(String[] args) {
        if(args.length != 1){
            System.out.println("Client: Invalid command's format! Fail to execute HelpCommand!");
        }
        else{
            receiver.help();
        }
    }
}

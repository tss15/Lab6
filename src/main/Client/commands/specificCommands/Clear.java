package commands.specificCommands;

import commands.Command;
import utilities.Receiver;

import java.io.IOException;
import java.io.Serializable;

public class Clear extends Command implements Serializable {

    private Receiver receiver;
    private static final long serialVersionUID = 1502L;

    public Clear(){

    }

    public Clear(Receiver receiver){
        this.receiver = receiver;
    }


    @Override
    public void aboutCommand() {
        System.out.println("clear                       - clear collection");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if(args.length != 1) {
            System.out.println("Client: Invalid command's format! Fail to execute ClearCommand!");
        }
        else{
            receiver.clear();
        }
    }
}
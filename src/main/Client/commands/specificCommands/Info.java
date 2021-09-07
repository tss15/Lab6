package commands.specificCommands;
import commands.Command;
import utilities.Receiver;

import java.io.IOException;
import java.io.Serializable;
public class Info extends Command implements Serializable {

    private static final long serialVersionUID = 1502L;
    private Receiver receiver;

    public Info(){

    }

    public Info(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void aboutCommand() {

    }

    @Override
    public void execute(String[] args) throws IOException {

        if(args.length != 1) {
            System.out.println("Client: Invalid command's format! Fail to execute InfoCommand!");
        }
        else{
            receiver.info();
        }
    }

}

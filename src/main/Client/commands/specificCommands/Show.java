package commands.specificCommands;
import java.io.Serializable;
import commands.Command;
import utilities.Receiver;

import java.io.IOException;
public class Show extends Command implements Serializable {

    private Receiver receiver;
    private static final long serialVersionUID = 1502L;

    public Show(){

    }

    public Show(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void aboutCommand() {
        System.out.println("show                        - display all the elements of the collection");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if(args.length != 1) {
            System.out.println("Client: Invalid command's format! Fail to execute ShowCommand!");
        }
        else{
            receiver.show();
        }
    }
}

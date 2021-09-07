package commands.specificCommands;
import java.io.Serializable;
import commands.Command;
import utilities.Receiver;

import java.io.IOException;
public class ReplaceIfGreater extends Command implements Serializable {

    private Receiver receiver;
    private static final long serialVersionUID = 1502L;

    public ReplaceIfGreater(){

    }

    public ReplaceIfGreater(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void aboutCommand() {
        System.out.println("replace_if_greater {element}    - replace all elements from the collection, which are greater than " +
                "specific element");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if(args.length != 1){
            System.out.println("Client: Invalid command's format! Fail to execute ReplaceIfGreaterCommand!");
        }
        else{
            receiver.replaceIfGreater();
        }
    }
}
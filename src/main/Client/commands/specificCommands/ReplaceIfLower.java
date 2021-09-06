package commands.specificCommands;
import java.io.Serializable;
import commands.Command;
import utilities.Receiver;

import java.io.IOException;
public class ReplaceIfLower extends Command implements Serializable {

    private Receiver receiver;
    private static final long serialVersionUID = 1234567L;

    public ReplaceIfLower(){

    }

    public ReplaceIfLower(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void aboutCommand() {
        System.out.println("replace_if_lower {element}    - replace all elements from the collection, which are lower than " +
                "specific element");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if(args.length != 1){
            System.out.println("Client: Invalid command's format! Fail to execute ReplaceIfLowerCommand!");
        }
        else{
            receiver.replaceIfLower();
        }
    }
}

package commands.specificCommands;
import java.io.Serializable;
import commands.Command;
import utilities.Receiver;

import java.io.IOException;
public class RemoveByKey extends Command implements Serializable {

    private Receiver receiver;
    private static final long serialVersionUID = 1502L;

    public RemoveByKey(){

    }

    public RemoveByKey(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void aboutCommand() {
        System.out.println("remove_by_key {key}           - remove element has corresponding key from the collection");

    }

    @Override
    public void execute(String[] args) throws IOException {
        if(args.length != 2){
            System.out.println("Client: Invalid command's format! Fail to execute RemoveByKeyCommand!");
        }
        else{
            receiver.removeByKey(args[1]);
        }
    }
}

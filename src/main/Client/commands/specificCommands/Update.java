package commands.specificCommands;
import java.io.Serializable;
import commands.Command;
import utilities.Receiver;

import java.io.IOException;
public class Update extends Command implements Serializable {

    private Receiver receiver;
    private static final long serialVersionUID = 1234567L;

    public Update(){

    }

    public Update(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void aboutCommand() {
        System.out.println("update {id}                 - update new values for element that has corresponding id");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if(args.length != 1){
            System.out.println("Client: Invalid command's format! Fail to execute UpdateCommand!");
        }
        else{
            receiver.update();
        }
    }
}
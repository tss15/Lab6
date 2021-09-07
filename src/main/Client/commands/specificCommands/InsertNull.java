package commands.specificCommands;

import java.io.Serializable;
import commands.Command;
import utilities.Receiver;

import java.io.IOException;
public class InsertNull extends Command implements Serializable {
    private Receiver receiver;
    private static final long serialVersionUID = 1502L;

    public InsertNull(){

    }
    public InsertNull(Receiver receiver){
        this.receiver = receiver;
    }

    @Override
    public void aboutCommand() {
        System.out.println("insert_null -  add new item to collection ");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if(args.length != 1){
            System.out.println("Client: Invalid command's format! Fail to execute InsertNullCommand!");
        }
        else{
            receiver.insert();
        }
    }
}

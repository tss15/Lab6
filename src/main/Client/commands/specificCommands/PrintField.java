package commands.specificCommands;

import java.io.Serializable;
import commands.Command;
import utilities.Receiver;

import java.io.IOException;

public class PrintField extends Command implements Serializable {
    private Receiver receiver;
    private static final long serialVersionUID = 1234567L;

    public PrintField() {
    }

    public PrintField(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void aboutCommand() {
        System.out.println("print_field -  print field of all elements in descending order");

    }
    @Override
    public void execute(String[] args) throws IOException {
        if (args.length != 1){
            System.out.println("Client: Invalid command's format! Fail to execute PrintFieldCommand!");
        } else {
            receiver.printField();
        }
    }
}

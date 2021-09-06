package commands.specificCommands;

import commands.Command;
import utilities.Receiver;

import java.io.IOException;
import java.io.Serializable;

public class CountByDifficulty extends Command implements Serializable {
    private Receiver receiver;
    private static final long serialVersionUID = 1234567L;

    public CountByDifficulty(){

    }

    public CountByDifficulty(Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void aboutCommand() {
        System.out.println("count_by_difficulty        - count elements with the same given difficulty");
    }

    @Override
    public void execute(String[] args) throws IOException {
        if(args.length != 1){
            System.out.println("Client: Invalid command's format! Fail to execute CountByDifficultyCommand!");
        }
        else{
            receiver.countByDifficulty();
        }
    }
}

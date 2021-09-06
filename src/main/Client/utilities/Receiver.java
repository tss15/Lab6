package utilities;

import commands.serializedCommands.SerializedArgumentCommand;
import commands.serializedCommands.SerializedCombinedCommand;
import commands.serializedCommands.SerializedObjectCommand;
import commands.serializedCommands.SerializedSimplyCommand;
import commands.specificCommands.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Receiver {

    private final Invoker invoker;
    private final Sender sender;
    private final CommandAsker commandAsker = new CommandAsker(new InputChecker());
    private final Session session;
    private DatagramChannel datagramChannel;
    private final HashMap<String, Boolean> inStack = new HashMap<>();


    public Receiver(Invoker invoker, Sender sender, Session session){
        this.invoker = invoker;
        this.sender = sender;
        this.session = session;
    }

    private void setWriteChannel() throws IOException {
        sender.setDatagramChannel(session.selectWriteChannel());
    }

    public void help(){
        invoker.getCommands().forEach((name, command) -> command.aboutCommand());
    }

    public void info() throws IOException {
        SerializedSimplyCommand serializedSimplyCommand = new SerializedSimplyCommand(new Info());
        setWriteChannel();
        sender.sendObject(serializedSimplyCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void show() throws IOException {
        SerializedSimplyCommand serializedSimplyCommand = new SerializedSimplyCommand(new Show());
        setWriteChannel();
        sender.sendObject(serializedSimplyCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        System.out.println("length: " + responseBytes.length);
        System.out.println(Arrays.toString(responseBytes));
        System.out.println("--------------------");
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void exit(){
        //System.out.println("Client: exit!");
        System.exit(0);
    }

    public void clear() throws IOException {
        //System.out.println("Client: Sent ClearCommand");
        SerializedSimplyCommand serializedSimplyCommand = new SerializedSimplyCommand(new Clear());
        setWriteChannel();
        sender.sendObject(serializedSimplyCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        //System.out.println("length: " + responseBytes.length);
        //System.out.println(Arrays.toString(responseBytes));
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void executeScript(String fileName) throws IOException {
        if(inStack.get(fileName) != null){
            if(inStack.get(fileName)){
                System.out.println("To avoid infinite recursion. File " + fileName + " can't be executed!");
                return;
            }
        }

        inStack.put(fileName, true);

        File scriptFile = new File(fileName);
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(scriptFile);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Script file doesn't exist. Please check the file path!");
            return ;
        }

        while(fileScanner.hasNextLine()){
            String[] userCommand = fileScanner.nextLine().trim().split(" ");
            invoker.executeCommand(userCommand);
            System.out.println("----------------------------------------");
        }

        inStack.put(fileName, false);
    }

    public void add() throws IOException {
        //System.out.println("Client: Sent AddCommand");
        SerializedObjectCommand serializedObjectCommand =  new SerializedObjectCommand(new Add(),
                commandAsker.createLabWork());
        setWriteChannel();
        sender.sendObject(serializedObjectCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        //System.out.println("length: " + responseBytes.length);
        //System.out.println(Arrays.toString(responseBytes));
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void countByDifficulty() throws IOException {
        //System.out.println("Client: Sent countByDifficultyCommand");
        SerializedSimplyCommand serializedSimplyCommand = new SerializedSimplyCommand(new CountByDifficulty());
        setWriteChannel();
        sender.sendObject(serializedSimplyCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        //System.out.println("length: " + responseBytes.length);
        //System.out.println(Arrays.toString(responseBytes));
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void printField() throws IOException {
        SerializedSimplyCommand serializedSimplyCommand = new SerializedSimplyCommand(new PrintField());
        setWriteChannel();
        sender.sendObject(serializedSimplyCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        //System.out.println("length: " + responseBytes.length);
        //System.out.println(Arrays.toString(responseBytes));
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void removeByKey(String arg) throws IOException {
        SerializedArgumentCommand serializedArgumentCommand = new SerializedArgumentCommand(new RemoveByKey(), arg);
        setWriteChannel();
        sender.sendObject(serializedArgumentCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        //System.out.println("length: " + responseBytes.length);
        //System.out.println(Arrays.toString(responseBytes));
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void replaceIfGreater() throws IOException {
        SerializedObjectCommand serializedObjectCommand = new SerializedObjectCommand( new ReplaceIfGreater(),
                commandAsker.createLabWork());
        setWriteChannel();
        sender.sendObject(serializedObjectCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        //System.out.println("length: " + responseBytes.length);
        //System.out.println(Arrays.toString(responseBytes));
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void replaceIfLower() throws IOException {

        SerializedObjectCommand serializedObjectCommand = new SerializedObjectCommand(new ReplaceIfLower(),
                commandAsker.createLabWork());
        setWriteChannel();
        sender.sendObject(serializedObjectCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void update() throws IOException{
        SerializedCombinedCommand serializedCombinedCommand = new SerializedCombinedCommand(new Update(),
                commandAsker.idAsker(), commandAsker.createLabWork());
        setWriteChannel();
        sender.sendObject(serializedCombinedCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }

    public void insert() throws IOException {
        SerializedCombinedCommand serializedCombinedCommand = new SerializedCombinedCommand(new InsertNull(),
                commandAsker.idAsker(), commandAsker.createLabWork());
        setWriteChannel();
        sender.sendObject(serializedCombinedCommand);
        byte[] responseBytes = new byte[4096];
        ByteBuffer responseBuffer = ByteBuffer.wrap(responseBytes);
        datagramChannel = session.selectReadChannel();
        if(datagramChannel == null) return;
        datagramChannel.receive(responseBuffer);
        String response = new String(responseBytes);
        response = response.substring(7);
        response = response.trim();
        System.out.println(response);
    }



}

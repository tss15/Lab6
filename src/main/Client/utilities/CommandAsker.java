package utilities;

import data.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.*;

public class CommandAsker {
    private final InputChecker inputChecker;
    private static final HashSet<Long> idChecker = new HashSet<>();
    public CommandAsker(InputChecker ic){
        this.inputChecker = ic;
    }


    private  static final Scanner scanner = new Scanner(System.in);


    public LabWork createLabWork() {
        LabWork newLabWork = new LabWork();
        System.out.println("Let's create new labwork");
        System.out.println("Id is automatically generated.");
        newLabWork.setId(idGenerator());

        newLabWork.setName(nameAsker());

        newLabWork.setCoordinates(coordinatesAsker());

        newLabWork.setCreationDate(dateAsker());

        newLabWork.setMinimalPoint(minimalPointAsker());

        newLabWork.setDifficulty(difficultyAsker());

        newLabWork.setEyeColor(eyeColorAsker());

        newLabWork.setHairColor(hairColorAsker());

        newLabWork.setNationality(nationalityAsker());

        newLabWork.setLocation(locationAsker());

        newLabWork.setAuthor(authorAsker());
        return newLabWork;
    }

    public Long idGenerator(){
        Long newID = new Random().nextLong();
        if(idChecker.contains(newID) || newID < 0){
            System.out.println("Input is invalid. Let's generate the new one!");
            return idGenerator();
        }
        else{
            idChecker.add(newID);
            System.out.println("ID = " + newID + " is successfully generated!");
            return newID;
        }
    }

    public String nameAsker(){
        System.out.println("Insert name: ");
        return (scanner.nextLine());
    }

    public Coordinates coordinatesAsker(){
        System.out.println("Insert coordinates: ");
        while(true){
            System.out.println("Insert x and y:");
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 2 ){
                System.out.println("please insert exactly two number!");
            }
            else{
                if(!inputChecker.integerValidCheck(inputNumber[0], -801, Integer.MAX_VALUE)) continue;
                if(!inputChecker.doubleValidCheck(inputNumber[1], Double.MIN_VALUE, 687.0)) continue;
                int x = Integer.parseInt(inputNumber[0]);
                Double y = Double.parseDouble(inputNumber[1]);
                return new Coordinates(x, y);
            }
        }
    }

    public LocalDateTime dateAsker(){
        return java.time.LocalDateTime.now();
    }



    public Long minimalPointAsker(){
        System.out.println("Insert minimalPoint: ");
        return longAsker(0,Integer.MAX_VALUE);
    }

    public Difficulty difficultyAsker(){
        while(true) {
            System.out.println("Insert difficulty: ");
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1) {
                System.out.println("Please insert exactly one difficulty!");
                continue;
            }
            try {
                return Difficulty.valueOf(inputNumber[0]);
            } catch(IllegalArgumentException e){
                System.out.println("Invalid difficulty! The difficulty is not in the list!");
                System.out.println("Please insert one of these following difficulties");
                for (Difficulty difficulty : Difficulty.values()){
                    System.out.println(difficulty);
                }
            }
        }
    }

    public Color eyeColorAsker(){
        while(true) {
            System.out.println("Insert eye color: ");
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1) {
                System.out.println("Please insert exactly one eye color!");
                continue;
            }
            try {
                return Color.valueOf(inputNumber[0]);
            } catch(IllegalArgumentException e){
                System.out.println("Invalid eye color! The eye color is not in the list!");
                System.out.println("Please insert one of these following eye colors");
                for (Color eyeColor : Color.values()){
                    System.out.println(eyeColor);
                }
            }
        }
    }

    public HairColor hairColorAsker(){
        while(true) {
            System.out.println("Insert hair color: ");
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1) {
                System.out.println("Please insert exactly one hair color!");
                continue;
            }
            try {
                return HairColor.valueOf(inputNumber[0]);
            } catch(IllegalArgumentException e){
                System.out.println("Invalid hair color! The hair color is not in the list!");
                System.out.println("Please insert one of these following hair colors");
                for (HairColor hairColor : HairColor.values()){
                    System.out.println(hairColor);
                }
            }
        }
    }

    public Country nationalityAsker(){
        while(true) {
            System.out.println("Insert nationality: ");
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1) {
                System.out.println("Please insert exactly one nationallity!");
                continue;
            }
            try {
                return Country.valueOf(inputNumber[0]);
            } catch(IllegalArgumentException e){
                System.out.println("Invalid nationality! The nationality is not in the list!");
                System.out.println("Please insert one of these following nationalities");
                for (Country nationality : Country.values()){
                    System.out.println(nationality);
                }
            }
        }
    }


    public Person authorAsker(){
        System.out.println("Insert Author: ");
        System.out.println("Insert name:");
        String name = scanner.nextLine();
        System.out.println("Insert weight:");
        Double PersonW = doubleAsker(Double.MIN_VALUE, Double.MAX_VALUE);
        return new Person(name, PersonW);
    }

    public Location locationAsker(){
        System.out.println("Insert Location: ");
        System.out.println("Insert X: ");
        Integer LocationX = intAsker(Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.println("Insert Y: ");
        long LocationY = longAsker(Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.println("Insert name: ");
        String name = scanner.nextLine();
        return new Location(LocationX, LocationY, name);
    }

    public Integer intAsker(int min, int max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one integer: ");
            }
            else{
                int x;
                try {
                    x = Integer.parseInt(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert an integer number");
                }
            }
        }
    }

    public Long longAsker(long min, long max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one Long number: ");
            }
            else{
                long x;
                try {
                    x = Long.parseLong(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert an Long number");
                }
            }
        }
    }

    public Double doubleAsker(double min, double max){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1){
                System.out.println("please enter exactly one Double number: ");
            }
            else{
                double x;
                try {
                    x = Double.parseDouble(inputNumber[0]);
                    if( x < min ) continue;
                    if( x > max) continue;
                    return x;
                } catch (NumberFormatException e){
                    System.out.println("please insert a Double number");
                }
            }
        }
    }

    public String idAsker(){
        while(true){
            String[] inputNumber = scanner.nextLine().trim().split(" ");
            if(inputNumber.length != 1 ){
                System.out.println("please enter exactly one Long number: ");
            }
            else{
                try {
                    Long.parseLong(inputNumber[0]);
                    return inputNumber[0];
                } catch (NumberFormatException e){
                    System.out.println("please insert an Long number");
                }
            }
        }
    }

}

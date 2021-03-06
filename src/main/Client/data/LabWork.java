package data;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LabWork implements Serializable {
    private static final long serialVersionUID = 1502L;
    private long id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Double minimalPoint;
    private Difficulty difficulty;
    private Person author;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public LocalDateTime getCreationDate(){
        return creationDate;
    }

    public void setMinimalPoint(double minimalPoint){
        this.minimalPoint = minimalPoint;
    }

    public long getId(){
        return id;
    }

    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setMinimalPoint(Double minimalPoint){
        this.minimalPoint = minimalPoint;
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }

    public void setAuthor(Person author){
        this.author = author;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Double getMinimalPoint() {
        return minimalPoint;
    }

    public Person getAuthor() {
        return author;
    }
    

    @Override
    public String toString(){
        String info = "New LabWork\n";
        info+= ("Name: " +name +'\n');
        info+= ("ID: " + id+ '\n');
        info+= ("Coordinates: \n");
        info+= ("    x: "+ coordinates.getX()+ '\n');
        info += ("   y: " + coordinates.getY() + '\n');
        info += ("creationDate: " + creationDate + '\n');
        info += ("minimalPoint: " + minimalPoint + '\n');
        info += ("Difficulty:  "+ difficulty + '\n');
        info += ("Person: \n");
        info +=( "      name" + author.getName()+'\n');
        info +=( "      weight" + author.getWeight()+'\n');
        info +=( "      eyeColor" + author.getEyeColor()+'\n');
        info +=( "      hairColor" + author.getHairColor()+'\n');
        info +=( "      nationality" + author.getNationality()+'\n');
        info +=( "      location" + author.getLocation()+'\n');
        return  info;
    }

    public void setNationality(Country nationalityAsker) {
    }

    public void setHairColor(HairColor hairColorAsker) {
    }

    public void setEyeColor(Color eyeColorAsker) {
    }

    public void setLocation(Location locationAsker) {
    }
}

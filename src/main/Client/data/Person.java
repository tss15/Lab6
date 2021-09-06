package data;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private Double weight;
    private Color eyeColor;
    private HairColor hairColor;
    private Country nationality;
    private Location location;

    public Person(String name, Double personW) {
    }


    public Double getWeight(){
        return weight;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public Color getEyeColor(){
        return eyeColor;
    }

    public HairColor getHairColor(){
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }

    public void setNationality(Country nationality){
        this.nationality = nationality;
    }
    public void setEyeColor(Color eyeColor){
        this.eyeColor = eyeColor;
    }

    public void setHairColor(HairColor hairColor){
        this.hairColor = hairColor;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Person) {
            Person personObj = (Person) obj;
            return name.equals(personObj.getName()) && weight.equals(personObj.getWeight()) && (eyeColor == personObj.getEyeColor()) && (hairColor == personObj.getHairColor()) && (nationality == personObj.getNationality()) && (location == personObj.getLocation());
        }
        return false;
    }

}

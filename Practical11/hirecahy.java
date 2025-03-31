/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;
/**
 *
 * @author ASUS
 */

class LivingBeing {
    private int age;
    private String name;
    private String gender;

    LivingBeing(int age, String name, String gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }
    public String toString() {
        return "Age: " + age + ", Name: " + name + ", Gender: " + gender;
    }
}

class Mammals extends LivingBeing {
    private boolean tail;
    private String habitat;

    Mammals(boolean tail, String habitat, int age, String name, String gender) {
        super(age, name, gender);
        this.tail = tail;
        this.habitat = habitat;
    }
    public String toString() {
        return super.toString() + ", Tail: " + tail + ", Habitat: " + habitat;
    }
}

class Human extends Mammals {
    private String profession;
    private String nationality;

    Human(String profession, String nationality, boolean tail, String habitat, int age, String name, String gender) {
        super(tail, habitat, age, name, gender);
        this.profession = profession;
        this.nationality = nationality;
    }
    public String toString() {
        return super.toString() + ", Profession: " + profession + ", Nationality: " + nationality;
    }
}

class Animals extends Mammals {
    private boolean isDomestic;
    private String diet;

    Animals(boolean isDomestic, String diet, boolean tail, String habitat, int age, String name, String gender) {
        super(tail, habitat, age, name, gender);
        this.isDomestic = isDomestic;
        this.diet = diet;
    }

    public String toString() {
        return super.toString() + ", Domestic: " + isDomestic + ", Diet: " + diet;
    }
}



public class JavaApplication1 {
    public static void main(String[] args) {
        
        Human human1 = new Human("Engineer", "Indian", false, "Urban", 19, "Ritesh", "Male");
        Human human2 = new Human("Doctor", "Indian", false, "Rural", 20, "Rahul", "Male");
        Human human3 = new Human("CA", "Indian", true, "Urban", 21, "Saket", "Male");

        Animals animal1 = new Animals(true, "Herbivore", true, "Jungle", 7, "Deer", "Female");
        Animals animal2 = new Animals(false, "Carnivore", true, "Savanna", 6, "Tiger", "Male");

       
        // Printing details
        System.out.println("Human Details: " + human1);
        System.out.println("Human Details: " + human2);
        System.out.println("Human Details: " + human3);
        System.out.println("Animal Details: " + animal1);
        System.out.println("Animal Details: " + animal2);
        
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Animal {
    String species;
    int age;
    String sex;
    String season;
    String color;
    double weight;
    String habitat;

    public Animal(String species, int age, String sex, String season, String color, double weight, String habitat) {
        this.species = species;
        this.age = age;
        this.sex = sex;
        this.season = season;
        this.color = color;
        this.weight = weight;
        this.habitat = habitat;
    }

    public void display() {
        System.out.println("Species: " + species + ", Age: " + age + ", Sex: " + sex +
                ", Season: " + season + ", Color: " + color +
                ", Weight: " + weight + "kg, Habitat: " + habitat);
    }
}


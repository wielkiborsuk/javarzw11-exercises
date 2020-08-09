package com.sda.javarzw11;

import java.util.Arrays;
import java.util.List;

public class Animals {
    public static void main(String[] args) {
        Animal burek = new Dog();
        Monkey pawian = new Monkey();

        Climbing climber = pawian;
        Animal monkeyAnimal = pawian;

        List<Animal> animals = Arrays.asList(burek, pawian);

        for (Animal animal : animals) {
            animal.eat(2);
            System.out.println(animal.call());
        }

        List<Climbing> climbers = Arrays.asList(pawian);

        for (Climbing climber2 : climbers) {
            climber2.climb(burek);
        }
    }
}

abstract class Animal {
    private int hunger;

    public void eat(int food) {
        hunger -= food;
    }

    abstract public String call();
}

class Dog extends Animal {
    @Override
    public String call() {
        return "bark";
    }
}

interface Climbing {
    void climb(Object object);
}

class Monkey extends Animal implements Climbing {
    @Override
    public String call() {
        return "Oook!";
    }

    public void climb(Object object) {
        System.out.println("Ouch!");
    }
}

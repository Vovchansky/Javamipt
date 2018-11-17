package com.company;

public class Main {

    public static void main(String[] args) {
        Person Volodya = new Person("Volodya", 1, 2, 3);
        Person Vovchansky = new Person("Vovchansky", 3, 2, 1);
        Person Footbaler = new Person("Footbaler", 3, 2, 1);
        Student Rexer = new Student("Rexer", 1, 2, 3, false, 4);
        Student Sasha = new Student("Sasha", 4, 3, 2, true, 1);
        Student Petya = new Student("Petya", 4, 3, 2, true, 1);
        Student Pasha = Petya;
        System.out.println(Volodya.equals(Vovchansky));
        System.out.println(Volodya.equals(Footbaler));
        System.out.println(Rexer.equals(Sasha));
        System.out.println(Rexer.equals(Petya));
        System.out.println(Petya.equals(Pasha));
    }
}

//Generics

package com.company;

public class Main {

    public static void main(String[] args) {

        //Create diploma contest
        ClassProfiledDiplomaContest<StudentClass<PhysicsStudent>> scaleOfHeat = new ClassProfiledDiplomaContest<>("Temperature Scale");
        ClassProfiledDiplomaContest<StudentClass<PhysicsStudent>> mathematicsScience = new ClassProfiledDiplomaContest<>("Mathematics theory");

        //Create class
        StudentClass<PhysicsStudent> kelvin = new StudentClass<>("Kelvin");
        System.out.println("Class " + kelvin.getName() + ":");
        kelvin.addClassMember(new PhysicsStudent("Tom", 23, 4.5));
        kelvin.addClassMember(new PhysicsStudent("Kevin", 23, 3.75));
        System.out.println();

        StudentClass<PhysicsStudent> celsius = new StudentClass<>("Celsius");
        System.out.println("Class " + celsius.getName() + ":");
        celsius.addClassMember(new PhysicsStudent("John", 24, 3.5));
        celsius.addClassMember(new PhysicsStudent("Henry", 24, 4.25));
        System.out.println();

        StudentClass<PhysicsStudent> fahrenheit = new StudentClass<>("Fahrenheit");
        System.out.println("Class " + fahrenheit.getName() + ":");
        fahrenheit.addClassMember(new PhysicsStudent("Louis", 25, 5.25));
        fahrenheit.addClassMember(new PhysicsStudent("Tim", 25, 5.5));
        System.out.println();

        StudentClass<MathsStudent> riemann = new StudentClass<>("Riemann");
        System.out.println("Class " + riemann.getName() + ":");
        riemann.addClassMember(new MathsStudent("Arthur", 22, 3.5));
        riemann.addClassMember(new MathsStudent("Dennis", 22, 3.75));
        System.out.println();

        //Add student class to diploma contest
        System.out.println("Diploma contest of " + scaleOfHeat.profileName + ":");
        scaleOfHeat.add(kelvin);
        scaleOfHeat.add(celsius);
        scaleOfHeat.add(fahrenheit);
        System.out.println();

        //Show diploma contest table
        System.out.println("Diploma contest table:");
        scaleOfHeat.showClassTable();
    }
}
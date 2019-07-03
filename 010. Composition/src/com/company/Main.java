//Composition

package com.company;

public class Main {

    public static void main(String[] args) {

        Engine kyr435 = new Engine(450, 4, 16);
        Car honda = new Car(4, 1050, 4, new Gearbox(20, 5), kyr435);

        honda.start();
        honda.carParameter();
        honda.changeSpeed(15);
        honda.carParameter();
        honda.changeSpeed(75);
        honda.carParameter();
    }
}

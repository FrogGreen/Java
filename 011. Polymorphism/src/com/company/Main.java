//Polymorphism

package com.company;

public class Main {

    public static void main(String[] args) {

        Car car = new Car(4, 4, "Xc75v");
        System.out.println(car.aboutCar());
        System.out.println(car.accelerate());
        System.out.println(car.braking());
        System.out.println();

        Opel opel = new Opel(4, 4, "XAxZF");
        System.out.println(opel.aboutCar());
        System.out.println(opel.accelerate());
        System.out.println(opel.braking());
        System.out.println();

        Ford ford = new Ford(4, 4, "XA2SF");
        System.out.println(ford.aboutCar());
        System.out.println(ford.accelerate());
        System.out.println(ford.braking());
        System.out.println();

        Honda honda = new Honda(4, 4, "XA2SF");
        System.out.println(honda.aboutCar());
        System.out.println(honda.accelerate());
        System.out.println(honda.braking());
        System.out.println();

        //Refactor - Inline
        Car bmw = new Car(4, 4, "KRSSF") {
            @Override
            public String aboutCar() {
                return "My " + getClass().getSimpleName() + " is great, it can:";
            }

            @Override
            public String accelerate() {
                return getClass().getSimpleName() + " -> Accelerate";
            }

            @Override
            public String braking() {
                return getClass().getSimpleName() + " -> Brake";
            }
        };
        System.out.println(bmw.aboutCar());
        System.out.println(bmw.accelerate());
        System.out.println(bmw.braking());
        System.out.println();

        //Refactor - Move - Inner class
        Audi audi = new Audi(4, 4, "ZX45F");
        System.out.println(audi.aboutCar());
        System.out.println(audi.accelerate());
        System.out.println(audi.braking());
        System.out.println();
    }

    public static class Audi extends Car {
        public Audi(int wheels, int doors, String engine) {
            super(wheels, doors, engine);
        }

        @Override
        public String aboutCar() {
            return "My " + getClass().getSimpleName() + " is great, it can:";
        }

        @Override
        public String accelerate() {
            return getClass().getSimpleName() + " -> Accelerate";
        }

        @Override
        public String braking() {
            return getClass().getSimpleName() + " -> Brake";
        }
    }
}

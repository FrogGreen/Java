//Enum

package com.company;

public class Main {

    public static void main(String[] args) {

        Cost Low = Cost.LOW;
        Cost Medium = Cost.MEDIUM;
        Cost High = Cost.HIGH;

        //Enum iteration
        System.out.println("Cost iteration:");
        for (Cost cost : Cost.values()) {
            System.out.println(cost);
        }

        //Return value of enum
        System.out.println("Return value of cost:");
        System.out.println(Low.getCost());
        System.out.println(Medium.getCost());
        System.out.println(High.getCost());
    }

    public enum Cost {
        LOW(5),
        MEDIUM(10),
        HIGH(15);

        @Override
        public String toString() {
            return "Operation cost is: " + super.toString();
        }

        private final int cost;

        Cost(int cost) {
            this.cost = cost;
        }

        public int getCost() {
            return this.cost;
        }
    }
}

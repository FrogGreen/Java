//Arrays, Lists, Maps, Sets, Stacks, Queues

package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //1D array
        System.out.println("1D array:");
        String[] days = new String[7];
        String[] number = {"1", "2", "3", "4", "5", "6", "7"};

        //Add some elements
        days[0] = "Monday";
        days[1] = "Tuesday";
        days[2] = "Wednesday";
        days[3] = "Thursday";
        days[4] = "Friday";
        days[5] = "Saturday";
        days[6] = "Sunday";

        //Displaying 1D Array of number with days
        int i = 0;
        for (String x : number) {
            System.out.println(x + " " + days[i]);
            i++;
        }


        //2D array
        System.out.println("\n2D array:");

        //Add some elements
        double[][] grade = {
            {3, 4.5, 5, 3.5},
            {5, 5, 5, 5, 5},
            {1, 1, 2, 3, 2, 3},
        };

        double sum = 0;
        double average = 0;
        double gradeNumber = 0;

        //Counting average of grade
        for (int j = 0; j < grade.length; j++) {
            for (int k = 0; k < grade[j].length; k++) {
                sum += grade[j][k];
                gradeNumber += 1;
            }
        }
        average = sum / gradeNumber;
        System.out.println(average);


        //Lists
        //ArrayList
        System.out.println("\nList:");
        System.out.println("ArrayList:");
        ArrayList<String> day = new ArrayList<String>();

        //Add some elements
        day.add("Monday");
        day.add("Tuesday");
        day.add("Wednesday");
        day.add("Thursday");
        day.add("Friday");
        day.add("Saturday");
        day.add("Sunday");

        //Displaying content of List
        System.out.println(day);

        //Printing whole list
        for (int j = 0; j < day.size(); j++) {
            System.out.println("#" + (j + 1) + ". day of week is: " + day.get(j));
        }

        //Removing "Friday" element
        day.remove("Friday");
        System.out.println("After removing \"Friday\" elemnt now 5th elemnt is: " + day.get(4));


        //Linkedlist
        System.out.println("\nArrayList:");
        LinkedList<String> tripPlaner = new LinkedList<String>();

        //Add some elements
        tripPlaner.add("Paris");
        tripPlaner.add("Berlin");
        tripPlaner.add("Prague");
        tripPlaner.add("Moscow");
        tripPlaner.add("Warsaw");
        tripPlaner.add("London");
        tripPlaner.add("Madrid");
        tripPlaner.add("Roma");
        tripPlaner.add("Budapest");

        //Displaying content of List
        System.out.println(tripPlaner);
        //Printing whole list
        for (int j = 0; j < tripPlaner.size(); j++) {
            System.out.println("#" + (j + 1) + ". place to visit is: " + tripPlaner.get(j));
        }
        //Or like this
        ListIterator<String> tripPlanerIterator = tripPlaner.listIterator();
        System.out.print("I want to visit: ");
        while (tripPlanerIterator.hasNext()) {
            System.out.print(tripPlanerIterator.next() + ", ");
        }

        //Get element
        System.out.println("\nGetting 5th element: " + tripPlaner.get(4));

        //Move back
        System.out.print("Move back: ");
        System.out.print(tripPlanerIterator.previous() + ", ");
        System.out.print(tripPlanerIterator.previous() + ", ");
        System.out.print(tripPlanerIterator.previous() + ", ");
        System.out.print(tripPlanerIterator.previous() + ", ");
        System.out.print(tripPlanerIterator.previous() + "\n");

        //Move forward
        System.out.print("Move forward: ");
        System.out.print(tripPlanerIterator.next() + ", ");
        System.out.print(tripPlanerIterator.next() + ", ");
        System.out.print(tripPlanerIterator.next() + "\n");


        //Maps
        System.out.println("\nMap: ");
        TreeMap cars = new TreeMap();

        // Add some elements
        cars.put("NISSAN", 35);
        cars.put("OPEL", 43);
        cars.put("BMW", 39);
        cars.put("BENTLEY", 43);
        cars.put("HONDA", 15);

        //Displaying content of Map
        for (Object key : cars.keySet())
            System.out.print(key + " - " + cars.get(key) + ", ");

        //Check empty Map
        if (cars.isEmpty()) {
            System.out.println("\nMap is empty.");
        } else {
            System.out.println("\nTotal car brand: " + cars.size());
        }

        //Searching by key "BMW"
        String searchKey = "BMW";
        if (cars.containsKey(searchKey)) {
            System.out.println("Found total " + cars.get(searchKey) + " " + searchKey + " cars!");
        }

        //Getting first key from Map
        System.out.println("First key: " + cars.firstKey());

        //Getting last key from Map
        System.out.println("Last key: " + cars.lastKey());

        //Removing all data from Map
        //Check empty Map
        cars.clear();
        if (cars.isEmpty()) {
            System.out.println("Map is empty.");
        } else {
            System.out.println("Total car brand: " + cars.size());
        }


        //Sets
        System.out.println("\nSet: ");
        TreeSet<String> carNumber = new TreeSet<String>();

        //Add some elements
        carNumber.add("KMO5567");
        carNumber.add("SDF9538");
        carNumber.add("FGV9234");
        carNumber.add("XCVG432");
        carNumber.add("XCV4321");
        carNumber.add("XCV2587");
        carNumber.add("AAA6543");

        //Displaying content of Set
        System.out.println(carNumber);
        //Or like this:
        Iterator<String> iterator = carNumber.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //Getting first data from Set
        System.out.println("First data from Set: " + carNumber.first());

        //Getting last data from Set
        System.out.println("Last data from Set: " + carNumber.last());

        //Check empty Set
        if (carNumber.isEmpty()) {
            System.out.println("Set is empty.");
        } else {
            System.out.println("Set size: " + carNumber.size());
        }

        //Removing data from Set
        String elementToRemove = "AAA6543";
        if (carNumber.remove(elementToRemove)) {
            System.out.println("Program removed data from set");
        } else {
            System.out.println("Data unrecognized!");
        }

        //Displaying new Set after removing
        System.out.print("After removing " + elementToRemove + " Set contain: ");
        iterator = carNumber.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //Removing all data from Set
        //Check empty Set
        carNumber.clear();
        if (carNumber.isEmpty()) {
            System.out.println("Set is empty.");
        } else {
            System.out.println("Set size: " + carNumber.size());
        }


        //Stacks
        //Stacks is LIFO - Last In, First Out
        System.out.println("\nStacks: ");
        Stack carOrder = new Stack();

        //Add some elements
        carOrder.push("Honda");
        carOrder.push("BMW");
        carOrder.push("Audi");
        carOrder.push("Honda");
        carOrder.push("Opel");

        //Displaying content of Stacks
        System.out.println(carOrder);

        //Search in Stacks
        System.out.println("Position of keyword \"Opel\" is :" + carOrder.search("Opel"));

        //Check empty Stacks
        if (carOrder.empty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack size: " + carOrder.size());
        }

        //Getting last data from Stack without removing
        System.out.println("First element of Stack is: " + carOrder.peek());
        //Getting the next one, one by one, with remove
        System.out.print(carOrder.pop() + " ");
        System.out.print(carOrder.pop() + " ");
        System.out.print(carOrder.pop() + " ");
        System.out.print(carOrder.pop() + " ");
        System.out.println(carOrder.pop());

        //Check empty Stacks
        if (carOrder.empty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack size: " + carOrder.size());
        }


        //Queues
        //Queue is FIFO - First In, First Out
        System.out.println("\nQueues: ");
        Queue<String> carOrderQ = new LinkedList();

        //Add some elements
        carOrderQ.add("Honda");
        carOrderQ.add("BMW");
        carOrderQ.add("Audi");
        carOrderQ.add("Honda");
        carOrderQ.add("Opel");

        //Displaying content of Queues
        System.out.println(carOrderQ);

        //Getting last data from Queues without removing
        System.out.println("First element of Queue is: " + carOrderQ.peek());
        //Getting the next one, one by one, with remove
        System.out.print(carOrderQ.poll() + " ");
        System.out.print(carOrderQ.poll() + " ");
        System.out.print(carOrderQ.poll() + " ");
        System.out.print(carOrderQ.poll() + " ");
        System.out.println(carOrderQ.poll());
    }
}

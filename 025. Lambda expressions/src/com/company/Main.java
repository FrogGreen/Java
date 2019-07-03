//Lambda expressions

package com.company;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //Lambda expression call
        //Thread
        new Thread(() -> {
            System.out.println("Hello, lambda expressions!");
            System.out.println();
        }).start();

        //Runnable
        Runnable runnable = () -> {
            System.out.println("Hello, lambda expressions!");
            System.out.println();
        };
        runnable.run();

        //Lambda with interface, like this:
        MathOper adding1 = (a, b) -> a + b;
        System.out.println("Lambda with interface:");
        System.out.println("Result is: " + adding1.sum(4, 5));
        System.out.println();

        //Or like this:
        MathOper adding2 = (a, b) -> {
            System.out.println("Lambda with interface approach 2:");
            int sum = a + b;
            return sum;
        };
        System.out.println("Result is: " + adding2.sum(4, 5));
        System.out.println();

        //Lambda with class
        System.out.println("Lambda with class:");
        MathCalc mathCalc = new MathCalc();
        System.out.println("Result is: " + mathCalc.add(4, 5));
        System.out.println();

        //Lambda list sort
        List<Aggregation> myPets = new ArrayList<>();
        myPets.add(new Aggregation("Charlie", 23));
        myPets.add(new Aggregation("Lessie", 26));
        myPets.add(new Aggregation("Monte", 47));
        myPets.add(new Aggregation("Gizmo", 16));

        //Sort by name
        System.out.println("Sort by name:");
        Collections.sort(myPets, (agregation1, agregation2) ->
            agregation1.getName().compareTo(agregation2.getName()));

        for (Aggregation aggregation : myPets) {
            System.out.println(aggregation);
        }
        System.out.println();

        //Sort by weight
        System.out.println("Sort by weight:");
        Collections.sort(myPets, (agregation1, agregation2) ->
            agregation1.getWeight() - agregation2.getWeight());

        myPets.forEach(aggregation -> {
            System.out.println(aggregation);
        });
        System.out.println();

        //Choice only pets with weight under 25
        System.out.println("Pets with weight under 25kg:");
        myPets.forEach(aggregation -> {
            if (aggregation.getWeight() < 25) {
                System.out.println(aggregation.getName());
            }
        });
        System.out.println();

        //Choice only pets with weight over 25
        //Use predicate interface
        System.out.println("Pets with weight over 25kg:");
        choiceFromAggregation(myPets, aggregation -> aggregation.getWeight() > 25);
        System.out.println();

        //Consumer interface
        System.out.println("Consumer:");
        Consumer<String> consumerFirst = (x) ->
            System.out.println(x + "Some first test message");
        Consumer<String> consumerSecond = (x) ->
            System.out.println(x + "Some second test message");
        consumerFirst.andThen(consumerSecond).accept("Consumer: ");
        System.out.println();

        //Supplier interface
        System.out.println("Supplier:");
        Supplier<Aggregation> supplierAggregation = () ->
            new Aggregation("Morti", 16);
        myPets.add(supplierAggregation.get());
        System.out.println(myPets);
        System.out.println();

        //IntPredicate interface
        System.out.println("IntPredicate:");
        IntPredicate over25 = i -> i > 25;
        IntPredicate less35 = i -> i < 35;
        System.out.println("10 is over 25: " + over25.test(10));
        System.out.println("10 is less then 35: " + less35.test(10));
        System.out.println("30 is between 25 and 35: " + over25.and(less35).test(30));
        System.out.println();

        //Function
        System.out.println("Function:");
        Function<Aggregation, String> getName = aggregation ->
            aggregation.getName();
        Function<Aggregation, Integer> getWeight = aggregation ->
            aggregation.getWeight();
        for (Aggregation aggregation : myPets) {
            System.out.println(getName.apply(aggregation) + ": " + getWeight.apply(aggregation));
        }
        System.out.println();

        //BiFunction
        System.out.println("BiFunction:");
        BiFunction<String, Integer, String> getNamePlusWeight = (String name, Integer weight) -> {
            return name + ": " + weight;
        };
        for (Aggregation aggregation : myPets) {
            System.out.println(getNamePlusWeight.apply(getName.apply(aggregation), getWeight.apply(aggregation)));
        }
        System.out.println();

        //UnaryOperator
        System.out.println("UnaryOperator:");
        UnaryOperator greetings = (name) -> "Welcome, " + name + "!";
        System.out.println(greetings.apply("GreenFrog"));
        System.out.println();


        //GuestList
        //Necessary for stream
        System.out.println("\nHere is guest list:");
        List<String> guest = Arrays.asList(
            "Simon", "George",
            "Mark", "Christoph",
            "Joseph", "David", "Hans",
            "Jacob"
        );
        System.out.println(guest);
        System.out.println();

        //Sort
        System.out.println("Guest list sorted:");
        guest.sort((String s1, String s2) -> s2.compareTo(s1));
        System.out.println(guest);
        System.out.println();

        //Get only element start with J
        System.out.println("Guest name starts with 'J':");
        guest.forEach(guestName -> {
            if (guestName.startsWith("J")) {
                System.out.println(guestName);
            }
        });
        System.out.println();


        //Streams
        System.out.println("\nStreams:");
        System.out.println("Sorted guest:");
        List<String> sortedGuests = guest
            .stream()
            .map(String::toUpperCase)
            .sorted()
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String sortedGuest : sortedGuests) {
            System.out.println(sortedGuest);
        }

        System.out.println("Guest name starts with 'J':");
        guest
            .stream()
            .filter(s -> s.startsWith("J"))
            .sorted(String::compareTo)
            .forEach(System.out::println);

        String[] anotherGuest = {
            "Oliver", "Harry", "Jack",
            "Jacob", "George"};

        String[] otherGuest = {
            "Noah", "Charlie", "Jacob",
            "Alfie", "Freddie", "Oscar"};

        Stream<String> lastGuest = Stream.of("Henry");

        Supplier<Stream<String>> guests = () -> Stream.concat(Stream.of(anotherGuest), Stream.of(otherGuest));

        //All Guest
        System.out.print("How many guest is on list? ");
        System.out.println(guests.get().count());

        //Unique Guest
        System.out.print("How many names is on list? ");
        System.out.println(guests.get().distinct().count());
        System.out.println();

        //Flat map
        System.out.println("Flatmap:");
        Collection myPetsCollection = new Collection("My Pets");
        myPetsCollection.setAggregation(myPets);

        List<Aggregation> neighborPets = new ArrayList<>();
        neighborPets.add(new Aggregation("Dingo", 4));
        neighborPets.add(new Aggregation("Milko", 23));
        neighborPets.add(new Aggregation("Angel", 16));

        Collection neighborPetsCollection = new Collection("Neighbor Pets");
        neighborPetsCollection.setAggregation(neighborPets);

        List<Collection> collections = new ArrayList<>();
        collections.add(myPetsCollection);
        collections.add(neighborPetsCollection);

        System.out.println("Sorted:");
        collections.stream()
            .flatMap(collection -> collection.getAggregation().stream())
            .sorted((collection1, collection2) -> collection1.getName().compareTo(collection2.getName()))
            .forEach(System.out::print);
        System.out.println();

        System.out.println("Grouped:");
        Map<Integer, List<Aggregation>> groupedByWeight = collections.stream()
            .flatMap(collection -> collection.getAggregation().stream())
            .collect(Collectors.groupingBy(collection -> collection.getWeight()));
        System.out.println(groupedByWeight);
        System.out.println();

        System.out.println("Lightest:");
        collections.stream()
            .flatMap(collection -> collection.getAggregation().stream())
            .reduce((collection1, collection2) -> collection1.getWeight() < collection2.getWeight() ? collection1 : collection2)
            .ifPresent(System.out::println);
        System.out.println();

        System.out.println("Heaviest:");
        collections.stream()
            .flatMap(collection -> collection.getAggregation().stream())
            .reduce((collection1, collection2) -> collection1.getWeight() > collection2.getWeight() ? collection1 : collection2)
            .ifPresent(System.out::println);
        System.out.println();
    }

    private static void choiceFromAggregation(List<Aggregation> aggregations, Predicate<Aggregation> weightPredicate) {
        for (Aggregation aggregation : aggregations) {
            if (weightPredicate.test(aggregation)) {
                System.out.println(aggregation);
            }
        }
    }
}

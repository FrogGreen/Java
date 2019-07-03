//Regular expressions

package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String greetings = "Hello, Have a 'gd', 'god', 'good', 'goood', 'gooood', very 'goooood' day GreenFrog! This is 26 java project. I want to say again: Hello GreenFrog!";
        String whiteSpaces = "Here are\tsome white\tspaces.\nBut is not a problem to delete them";

        System.out.println("Original:");
        System.out.println(greetings);
        System.out.println(whiteSpaces);
        System.out.println();

        //Replace spaces
        System.out.println("Replace spaces:");
        System.out.println(greetings.replaceAll(" ", "_"));
        System.out.println();

        //Replace any single character except newline
        System.out.println("Replace any single character except newline:");
        System.out.println(greetings.replaceAll(".", "_"));
        System.out.println();

        //Replace the beginning of the line
        System.out.println("Replace the beginning of the line:");
        System.out.println(greetings.replaceAll("^Hello", "Welcome"));
        System.out.println(greetings.replaceAll("Hello", "Welcome"));
        System.out.println();

        //Replace the end of the line
        System.out.println("Replace the end of the line:");
        System.out.println(greetings.replaceAll("GreenFrog!$", "RedFrog!"));
        System.out.println(greetings.replaceAll("GreenFrog!", "RedFrog!"));
        System.out.println();

        //Replace any single character from brackets
        System.out.println("Replace any single character from brackets:");
        System.out.println(greetings.replaceAll("[,!Glero]", "*"));
        System.out.println(greetings.replaceAll("[a-lA-L]", "*"));
        System.out.println();

        //Replace any numbers
        System.out.println("Replace any numbers:");
        System.out.println(greetings.replaceAll("\\d", "*"));
        System.out.println();

        //Ignore case sensitivity
        System.out.println("Ignore case sensitivity:");
        System.out.println(greetings.replaceAll("(?i)[a-l]", "*"));
        System.out.println();

        //Replace any single character which not exist in brackets
        System.out.println("Replace any single character which not exist in brackets:");
        System.out.println(greetings.replaceAll("[^,!Glero]", "*"));
        System.out.println();

        //Replace any single character which is not number
        System.out.println("Replace any single character which is not number:");
        System.out.println(greetings.replaceAll("\\D", "*"));
        System.out.println();

        //Replace any single character from brackets followed by characters in next bracket
        System.out.println("Replace any single character from brackets followed by characters in next bracket:");
        System.out.println(greetings.replaceAll("[,!Glero][Hrealo]", "*"));
        System.out.println(greetings.replaceAll("[Hh]ello", "hello"));
        System.out.println();

        //Replace 0 or 1 occurrence of the preceding expression
        System.out.println("Replace 0 or 1 occurrence of the preceding expression:");
        System.out.println(greetings.replaceAll("go?", "*"));
        System.out.println();

        //Replace 0 or more occurrences of the preceding expression
        System.out.println("Replace 0 or more occurrences of the preceding expression:");
        System.out.println(greetings.replaceAll("go*", "*"));
        System.out.println();

        //Replace 1 or more of the previous thing
        System.out.println("Replace 1 or more of the previous thing:");
        System.out.println(greetings.replaceAll("go+", "*"));
        System.out.println();

        //Replace exactly 3 number of occurrences of the preceding expression
        System.out.println("Replace exactly 3 number of occurrences of the preceding expression:");
        System.out.println(greetings.replaceAll("go{3}", "*"));
        System.out.println();

        //Replace 3 or more occurrences of the preceding expression
        System.out.println("Replace 3 or more occurrences of the preceding expression:");
        System.out.println(greetings.replaceAll("go{3,}", "*"));
        System.out.println();

        //Replace at least 3 and at most 4 occurrences of the preceding expression
        System.out.println("Replace at least 3 and at most 4 occurrences of the preceding expression:");
        System.out.println(greetings.replaceAll("go{3,4}", "*"));
        System.out.println();

        //Replace the word characters
        System.out.println("Replace the word characters:");
        System.out.println(whiteSpaces.replaceAll("\\w", "*"));
        System.out.println();

        //Replace non word characters
        System.out.println("Replace non word characters:");
        System.out.println(whiteSpaces.replaceAll("\\W", "*"));
        System.out.println();

        //Replace any white space
        System.out.println("Replace any white space:");
        System.out.println(whiteSpaces.replaceAll("\\s", "*"));
        System.out.println();

        //Replace any single character which is not white space
        System.out.println("Replace any single character which is not white space:");
        System.out.println(whiteSpaces.replaceAll("\\S", "*"));
        System.out.println();

        //Matcher
        System.out.println("Matcher:");
        String coreStatement = "I am ";
        String profession1 = "engineer.";
        String profession2 = "writer.";
        String profession3 = "artist.";
        String check = "I am (engineer|artist).";
        System.out.println((coreStatement + profession1).matches(check));
        System.out.println((coreStatement + profession2).matches(check));
        System.out.println((coreStatement + profession3).matches(check));
        System.out.println();

        //StringBuilder
        System.out.println("StringBuilder:");
        StringBuilder stringBuilder = new StringBuilder("<h1>Head</h1>");
        stringBuilder.append("<h2>Sub-head Uno</h2>");
        stringBuilder.append("<p>Paragraph Uno - Uno</p>");
        stringBuilder.append("<p>Paragraph Uno - Due</p>");
        stringBuilder.append("<h2>Sub-head Due</h2>");
        stringBuilder.append("<p>Paragraph Due - Uno</p>");

        String StringBuilderGroupPattern = "(<h2>)(.+?)(</h2>)";
        Pattern StringBuilderPattern = Pattern.compile(StringBuilderGroupPattern);
        Matcher stringBuilderMatcher = StringBuilderPattern.matcher(stringBuilder);

        System.out.println("Here is Sub-Head:");
        while (stringBuilderMatcher.find()) {
            System.out.println(stringBuilderMatcher.group(2));
        }
        System.out.println();
    }
}

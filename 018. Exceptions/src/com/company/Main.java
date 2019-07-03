//Exceptions

package com.company;

public class Main {

    public static void main(String[] args) {

        int x = 45;
        int y = 33;
        int z = 0;

        try {
            System.out.println(x + "/" + y + "is:");
            System.out.println(divideFirstMethod(x, y));
            System.out.println(divideSecondMethod(x, y));
            System.out.println(divideThirdMethod(x, y));
            System.out.println(divide(x, y));

            System.out.println(x + "/" + z + "is:");
            System.out.println(divideFirstMethod(x, z));
            System.out.println(divideSecondMethod(x, z));
            System.out.println(divideThirdMethod(x, z));
            System.out.println(divide(x, z));
        } catch (ArithmeticException e) {
            System.out.println(e.toString());
            System.out.println("Something went wrong, isn't it?");
        } finally {
            System.out.println("Well done! You did it! Program still work, no error crash!");
        }
    }

    //Using LBYL (Look Before You Leap)
    private static int divideFirstMethod(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    //Using EAFP (Easier to Ask Forgiveness than Permission):
    private static int divideSecondMethod(int x, int y) {
        try {
            return x / y;
        } catch (Exception e) {
            return 0;
        }
    }

    //Throw new Arithmetic Exception
    private static int divideThirdMethod(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Did you try to divide by zero?");
        }
    }

    //Not using exceptions
    private static int divide(int x, int y) {
        return x / y;
    }
}

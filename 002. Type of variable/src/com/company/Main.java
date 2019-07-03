//Type of variable

package com.company;

public class Main {

    public static void main(String[] args) {

        boolean minBool = false;
        boolean maxBool = true;

        System.out.println("Boolean MIN value = " + minBool);                   //False
        System.out.println("Boolean MAX value = " + maxBool);                   //True
        System.out.println("Byte MIN value = " + Byte.MIN_VALUE);               //-128
        System.out.println("Byte MAX value = " + Byte.MAX_VALUE);               //127
        System.out.println("Short MIN value  = " + Short.MIN_VALUE);            //-32768
        System.out.println("Short MAX value = " + Short.MAX_VALUE);             //32767
        System.out.println("Integer MIN value  = " + Integer.MIN_VALUE);        //-2147483648
        System.out.println("Integer MAX value = " + Integer.MAX_VALUE);         //2147483647
        System.out.println("Long MIN value  = " + Long.MIN_VALUE);              //-9223372036854775808
        System.out.println("Long MAX value = " + Long.MAX_VALUE);               //9223372036854775807
        System.out.println("Float MIN value  = " + Float.MIN_VALUE);            //1.4E-45
        System.out.println("Float MAX value = " + Float.MAX_VALUE);             //3.4028235E38
        System.out.println("Double MIN value  = " + Double.MIN_VALUE);          //4.9E-324
        System.out.println("Double MAX value = " + Double.MAX_VALUE);           //1.7976931348623157E308

        long longPresentation = 32147483647L;
        System.out.println("This is long presentation: " + longPresentation);

        float floatPresentation = 320.45e-2F;
        System.out.println("This is float presentation: " + floatPresentation);
    }
}

package com.pluralsight.NorthwindTraderSpringBoot.util;


import java.util.Scanner;

public class Console {
    static Scanner input = new Scanner(System.in);

    //display a message to the user before reading input.
    public static String PromptForString(String prompt){
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    //reads input without displaying any prompt.
    public static String PromptForString(){
        return input.nextLine().trim();
    }

    public static boolean PromptForYesNo(String prompt){
        System.out.print(prompt + " ( Y for Yes, N for No ) ? " );
        String userInput = input.nextLine().trim();
        return (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("YES"));
    }

    public static short PromptForShort(String prompt){
        System.out.print(prompt);
        String stringNumber = input.nextLine().trim();
        short number = Short.parseShort(stringNumber);
        return  number;
    }

    public static short PromptForShort(){
        String stringNumber = input.nextLine().trim();
        short number = Short.parseShort(stringNumber);
        return  number;
    }

    public static int PromptForInt(String prompt){
        System.out.print(prompt);
        String stringNumber = input.nextLine().trim();
        int number = Integer.parseInt(stringNumber);
        return number;
    }

    public static int PromptForInt(){
        String stringNumber = input.nextLine().trim();
        int number = Integer.parseInt(stringNumber);
        return number;
    }



    public static float PromptForFloat(String prompt){
        System.out.print(prompt);
        String stringNumber = input.nextLine().trim();
        float number = Float.parseFloat(stringNumber);
        return  number;
    }

    public static float PromptForFloat(){
        String stringNumber = input.nextLine().trim();
        float number = Float.parseFloat(stringNumber);
        return  number;
    }

    public static double PromptForDouble(String prompt){
        System.out.print(prompt);
        String stringNumber = input.nextLine().trim();
        double number = Double.parseDouble(stringNumber);
        return number;
    }

    public static double PromptForDouble(){
        String stringNumber = input.nextLine().trim();
        double number = Double.parseDouble(stringNumber);
        return number;
    }

    public static byte PromptForByte(String prompt){
        System.out.print(prompt);
        String stringNumber = input.nextLine().trim();
        byte number = Byte.parseByte(stringNumber);
        return number;
    }

    public static byte PromptForByte(){
        String stringNumber = input.nextLine().trim();
        byte number = Byte.parseByte(stringNumber);
        return number;
    }

}

package Utiles;

import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt){
        while(true){
            System.out.println(prompt);
            String input = scanner.nextLine();
            if (HelperUtils.isValidString(input)){
                return input;
            }
            System.out.println("Please Enter a Valid String");
        }
    }

    public static int getIntInput(String prompt){

    }



}

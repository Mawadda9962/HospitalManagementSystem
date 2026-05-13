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
        while(true){
            System.out.println(prompt);
            try{
                return Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Please Enter a Valid whole number");
            }
        }
    }

    public static int getIntInput(String prompt, int min, int max){
        while (true){
            int num = getIntInput(prompt);
            if (HelperUtils.isValidNumber(num, min, max)){
                return num;
            }
            System.out.println("Please ");
        }
    }


}

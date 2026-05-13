package Utiles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
            System.out.println("Please Enter a number between " + min + max);
        }
    }

    public static double getDoubleInput(String prompt){
        while(true){
            System.out.println(prompt);
            try{
                //parseDouble its converts a string into double
                return Double.parseDouble(scanner.nextLine());
                //NumberFormatException is the specific type of error
            }catch (NumberFormatException e){
                System.out.println("Please enter a valid decimal number");
            }
        }
    }

    public static LocalDate getDateInput(String prompt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    }





}

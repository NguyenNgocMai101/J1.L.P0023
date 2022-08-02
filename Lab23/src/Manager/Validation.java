
package Manager;

import java.util.Scanner;

public class Validation {
    private final static Scanner sc = new Scanner(System.in);
    
     //check user input number limit
    public static int checkInputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
    
    //check user input String
    public static String checkInputString(){
        //loop until user input correct
        while (true) {            
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Please re-enter: ");
            }
            else{
                return result;
            }
        }
    }
    
     //check user input yes/ no
    public static boolean checkInputYN() {
        System.out.print("Do you want to continue (Y/N)? ");
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
    //check user input int
    public static int checkInputInt(){
        //loop until user input correct
        while (true) {            
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result<=0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must input positive integer");
                System.out.print("Please re-enter: ");
            }
        }
    }
    
    //check user input double
    public static double checkInputDouble(){
        //loop until user input correct
        while (true) {            
            try {
                double result = Double.parseDouble(sc.nextLine());
                if (result<=0) {
                    throw  new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must input positive double");
                System.out.print("Please re-enter: ");
            }
        }
    }
    
    
}

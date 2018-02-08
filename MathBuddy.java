
package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 02-07-2018
 * @version 0.0.1
 */


import java.util.ArrayList;
import java.util.Scanner;

public class MathBuddy 
{
    public static void main(String[] args) 
    {
        Scanner console = new Scanner(System.in);
        int menu = -1;
        int choice = -1;
        ArrayList<Problem> problems = new ArrayList();
        int p = 0;
        int problemLength;
        int i;
        ArrayList<String> operations = new ArrayList();
        while(menu != 0)
        {
            menu = menuHome();
            switch(menu)
            {
                case 1: //Basic
                    System.out.println("Input the length of the problem (number of numbers), must be greater than 1");
                    problemLength = console.nextInt();
                    System.out.println();
                    while(problemLength <= 1)
                    {
                        System.out.println("Input the length of the problem (number of numbers), must be greater than 1");
                        problemLength = console.nextInt();
                        System.out.println();
                    }
                    
                    while(choice != 0)
                    {
                        choice = menuChoice();
                        switch(choice)
                        {
                            case 1: //addAdditionOp
                                operations.add("ADDITION");
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                    choice = 0;
                            break;
                        }
                    }// end of problem creation switch
                    Problem tempProblem = new Problem(new Basic(), operations);
                    problems.add(tempProblem);
                    break;
                    
                case 2: //Start session
                    double input;
                    for(p = 0; p < problems.size(); p++)
                    {
                        problems.get(p).display();
                        System.out.print(" = ");
                        input = console.nextDouble();
                        System.out.println("Correct Answer");
                        problems.get(p).displayCorrectAnswer();
                    }
                    break;
                default: ;
            }//end of menu switch
        }
                
    }
    
     /**
      * Display the home menu interface for the application.
      * @return the home menu option selected.
      */  
    private static int menuHome()
    {
        Scanner console = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("              MATHBUDDY              ");
            System.out.println("=====================================");
            System.out.println("[1] Basic");
            System.out.println("[2] Test");
            System.out.println("[0] Quit");
            System.out.println("=====================================");
            System.out.printf("Select an option: ");
            option = console.nextInt();
            if (option < 0 || option > 2)
            {
                System.out.println("Invalid option...Try again");
                System.out.println();
            }
            else
            {
                System.out.println();
                return option;
            }
        }while(true);
        
    }
    
    /**
      * Display the choice menu interface for the application.
      * @return the choice menu option selected.
      */  
    private static int menuChoice()
    {
        Scanner console = new Scanner(System.in);
        int option;
        do
        {
            System.out.println("MATHBUDDY - CREATE BASIC PROBLEM     ");
            System.out.println("=====================================");
            System.out.println("[1] Addition extend");
            //System.out.println("[0] Delete");
            System.out.println("=====================================");
            System.out.printf("Select an option: ");
            option = console.nextInt();
            if (option < 1 || option > 1)
            {
                System.out.println("Invalid option...Try again");
                System.out.println();
            }
            else
            {
                System.out.println();
                return option;
            }
        }while(true);
    }
}

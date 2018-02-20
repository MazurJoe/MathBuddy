
package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 02-08-2018
 * @version 0.0.1
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MathBuddy 
{
//    public Problem generateRanProb(ProblemType probType, int dig,int l)
//    {
//        Problem problem = new Problem(probType);
//        ArrayList<Operations> = new ArrayList();
//        
//        
//        return problem;
//    }
    
    //Purely for testing, NOT FINAL CODE
    public static void main(String[] args) 
    {
        Scanner console = new Scanner(System.in);
        int menu = -1;
        int choice = -1;
        ArrayList<Problem> problems = new ArrayList();
        int p = 0;
        int problemLength;
        int i;
        ArrayList<Character> operations = new ArrayList();
        ArrayList<Operations> pOperations = new ArrayList();
        ArrayList<ArrayList<Operations>> parentheses = new ArrayList();
        int pChoice;
        int digit;
        int parenthesesCheck = 0;
        while(menu != 0)
        {
            menu = menuHome();
            switch(menu)
            {
                case 1: //Basic
                    System.out.println("Input the length of the problem (number of numbers), must be greater than 1");
                    problemLength = 0;
                    problemLength = console.nextInt();
                    System.out.println();
                    while(problemLength <= 1)
                    {
                        System.out.println("Input the length of the problem (number of numbers), must be greater than 1");
                        problemLength = console.nextInt();
                        System.out.println();
                    }
                    
                    System.out.println("Input the number of digits of the problem (number of numbers in one), must be greater than or equal to 1");
                    digit = 0;
                    digit = console.nextInt();
                    System.out.println();
                    while(problemLength <= 1)
                    {
                        System.out.println("Input the length of the problem (number of numbers), must be greater than or equal 1");
                        digit = console.nextInt();
                        System.out.println();
                    }
                    
                    choice = -1;
                    problemLength--;
                    while(choice != 0)
                    {
                        choice = menuChoice();
                        switch(choice)
                        {
                            case 1: //addAdditionOp
                                operations.add('A');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            case 2: //addSubtractionOp
                                operations.add('S');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            case 3: //addMultiplicationOp
                                operations.add('M');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            case 4: //addDivisionOp
                                operations.add('D');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            case 5: //addPowerOp
                                operations.add('E');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            case 6: //addParentheses
                                operations.add('P');
                                //check to end problem creation
//                                p++;
//                                if(p == problemLength)
//                                {
//                                    choice = 0;
//                                    p = 0;
//                                }
                            break;
                        }
                    }// end of problem creation switch
                    
                    for(i = 0; i < operations.size(); i++)
                    {
                        if(operations.get(i) == 'P')
                            parenthesesCheck++;
                    }
                    if(parenthesesCheck % 2 != 0)
                        operations.add('P');
                    
                    Problem tempProblem = new Problem(new Basic(), operations, problemLength + 1, digit);
                    problems.add(tempProblem);
                    operations = new ArrayList();
                    break;
                    
                case 2: //Start session
                    double input;
                    for(p = 0; p < problems.size(); p++)
                    {
                        problems.get(p).displayProblem();
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
            System.out.println("[2] Subtaction extend");
            System.out.println("[3] Multiplication extend");
            System.out.println("[4] Division extend");
            System.out.println("[5] Power extend");
            System.out.println("[6] Parentheses");
            System.out.println("=====================================");
            System.out.printf("Select an option: ");
            option = console.nextInt();
            if (option < 1 || option > 6)
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

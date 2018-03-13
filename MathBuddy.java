
package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 03-13-2018
 * @version 0.0.1
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MathBuddy 
{
    static Random ran = new Random(System.currentTimeMillis());
    
    public static Problem generateRanIntProb(ProblemType probType, int dig,int l)
    {
        int choice = -1;
        int i;
        
        int p = 0;
        int problemLength = l;
        
        ArrayList<Character> operations = new ArrayList();
        ArrayList<Integer> parenthesesStart = new ArrayList();
        ArrayList<Integer> parenthesesEnd = new ArrayList();
        
        int digit = dig;
        int parenthesesCheck = 0;
        int parenthesesEnds = 0;
        int temp = -1;
        problemLength--;
        while(temp != 0)
        {
            temp = ran.nextInt(7) + 1;
                switch(temp)
                {
                    case 1: //addAdditionOp
                        operations.add('+');
                        System.out.println("add +");
                        //check to end problem creation
                        p++;
                        if(p == problemLength)
                        {
                            temp = 0;
                            p = 0;
                        }
                        break;
                            
                    case 2: //addSubtractionOp
                        operations.add('-');
                        System.out.println("add -");
                        //check to end problem creation
                        p++;
                        if(p == problemLength)
                        {
                            temp = 0;
                            p = 0;
                        }
                        break;
                            
                    case 3: //addMultiplicationOp
                        operations.add('*');
                        System.out.println("add *");
                        //check to end problem creation
                        p++;
                        if(p == problemLength)
                        {
                            temp = 0;
                            p = 0;
                        }
                        break;
                            
                    case 4: //addDivisionOp
                        operations.add('/');
                        System.out.println("add /");
                        //check to end problem creation
                        p++;
                        if(p == problemLength)
                        {
                            temp = 0;
                            p = 0;
                        }
                    break;
                            
                    case 5: //addPowerOp
                        operations.add('^');
                        System.out.println("add ^");
                        //check to end problem creation
                        p++;
                        if(p == problemLength)
                        {
                            temp = 0;
                            p = 0;
                        }
                    break;
                            
                    case 6: //addParenthesesStart
                        if(parenthesesCheck != 1 )
                        {
                            operations.add('(');
                            System.out.println("add (");
                            parenthesesStart.add(p);
                            parenthesesCheck++;
                        }
                    break;    

                    case 7: //addParenthesesEnd
                        
                        if(parenthesesEnds != 1 && operations.size() - 1 > 0 && operations.get(operations.size()-1).charValue() != '(')
                        {
                            if(parenthesesCheck > parenthesesEnds)
                            {
                            System.out.println("add )");
                            operations.add(')');
                            parenthesesEnd.add(p);
                            parenthesesEnds++;
                            }
                        }
                        break;
                }
            }// end of problem creation switch
                    
            if(parenthesesEnds < parenthesesCheck)
            {
                operations.add(')');
                parenthesesEnd.add(problemLength -1);
            }
                    
            Problem tempProblem = new Problem(new Basic(), operations, parenthesesStart, parenthesesEnd, problemLength + 1 , digit);
        
                    
                    
        return tempProblem;
    }
        
        
    


    //Purely for testing, NOT FINAL CODE
    public static void main(String[] args) 
    {
        Scanner console = new Scanner(System.in);
        int menu = -1;
        int choice = -1;
        int i;
        
        ArrayList<Problem> problems = new ArrayList();
        
        int p = 0;
        int problemLength;
        
        ArrayList<Character> operations = new ArrayList();
        ArrayList<Integer> parenthesesStart = new ArrayList();
        ArrayList<Integer> parenthesesEnd = new ArrayList();
        
        int temp;
        int digit;
        int parenthesesCheck = 0;
        int parenthesesEnds = 0;
        
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
                                operations.add('+');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            
                            case 2: //addSubtractionOp
                                operations.add('-');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            
                            case 3: //addMultiplicationOp
                                operations.add('*');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            
                            case 4: //addDivisionOp
                                operations.add('/');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            
                            case 5: //addPowerOp
                                operations.add('^');
                                //check to end problem creation
                                p++;
                                if(p == problemLength)
                                {
                                    choice = 0;
                                    p = 0;
                                }
                            break;
                            
                            case 6: //addParenthesesStart
                                operations.add('(');
                                parenthesesStart.add(p);
                                parenthesesCheck++;
                                System.out.println("parcheck:" + parenthesesCheck);
                            break;    

                            case 7: //addParenthesesEnd
                                if(parenthesesCheck < parenthesesEnds + 1)
                                    System.out.printf("Can't, no starting parentheses%n%n");
                                else
                                {
                                    operations.add(')');
                                    parenthesesEnd.add(p);
                                    parenthesesEnds++;
                                }
                            break;
                        }
                    }// end of problem creation switch
                    
                    if(parenthesesEnds < parenthesesCheck)
            {
                operations.add(')');
                parenthesesEnd.add(problemLength -1);
            }
                    
                    Problem tempProblem = new Problem(new Basic(), operations, parenthesesStart, parenthesesEnd, problemLength + 1 , digit);
                    problems.add(tempProblem);
                    operations = new ArrayList();
                    break;
                    
                case 2: //ranprob
                    problems.add(generateRanIntProb(new Basic(),2,5));
                    break;
                    
                case 3: //Start session
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
            System.out.println("[2] GenRanProb");
            System.out.println("[3] Test");
            System.out.println("[0] Quit");
            System.out.println("=====================================");
            System.out.printf("Select an option: ");
            option = console.nextInt();
            if (option < 0 || option > 3)
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
            System.out.println("[6] Parentheses Start");
            System.out.println("[7] Parentheses End");
            System.out.println("=====================================");
            System.out.printf("Select an option: ");
            option = console.nextInt();
            if (option < 1 || option > 7)
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

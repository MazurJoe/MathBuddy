
package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 03-15-2018
 * @version 0.0.1
 */

import java.util.ArrayList;

public class Basic implements ProblemType
{
    /**
     * ArrayList of numbers in form of object Double
     */
    private ArrayList<Double> nums = new ArrayList();
    
    /**
     * ArrayList of Operations, list is filled in readOps()
     */
    private ArrayList<Operations> operations = new ArrayList();
    
    /**
     * parentheses count within problem, value is computed in readOps()
     */
    private int parCount = 0;
    
    /**
     * starting positions of parentheses in problem, filled in readOps()
     */
    private ArrayList<Integer> parPosStart = new ArrayList();
    
    /**
     * ending positions of parentheses in problem, filled in readOps()
     */
    private ArrayList<Integer> parPosEnd = new ArrayList();
    
    /**
     * Object of Addition to utilize in generateCorrectAnswer() for comparison
     */
    private Addition a = new Addition();
    
    /**
     * Object of Subtraction to utilize in generateCorrectAnswer() for comparison
     */
    private Subtraction s = new Subtraction();
    
    /**
     * Object of Multiplication to utilize in generateCorrectAnswer() for comparison
     */
    private Multiplication m = new Multiplication();

    /**
     * Object of Division to utilize in generateCorrectAnswer() for comparison
     */
    private Division d = new Division();
    
    /**
     * Object of Power to utilize in generateCorrectAnswer() for comparison
     */
    private Power pow = new Power();
    
    private int i;
    private int j;
    private int temp;
    
    /**
     * Generates string representation of problem
     * @param ops ArrayList of operations in the form of Characters
     * @param nums ArrayList of numbers in form of Double
     * @return String of problem
     */
    @Override
    public String generateProblem(ArrayList<Character> ops, ArrayList<Double> nums)
    {
        readOps(ops);
        String p = "";
        int length = ops.size()+1;
        this.nums = nums;
                
//int to read amount of numbers added to string        
        j = 0;
        
        i = 0;
        
//adds first number if start of problem is not '('        
        if(ops.get(0) != '(')
        {
            p += nums.get(j);
            j++;
        }
        
        while(i < ops.size())
        {
            if(ops.get(i) == '(')
            {
                p += ops.get(i);
                if(ops.get(i +1) != '(' && ops.get(i +1) != ')')
                {
                    p += nums.get(j);
                    j++;
                }
//                System.out.println(p);
            }
            else if(ops.get(i) == ')')
            {
                p += ops.get(i);
//                System.out.println(p);
            }
            else
            {
                if(ops.get(i) == '^')
                    p += ops.get(i);
                else
                    p += " " + ops.get(i) + " ";
                
                if(j < length && i+1 < ops.size() && ops.get(i+1).charValue() != '(')
                {
                    p += nums.get(j);
                    j++;
                }
                
//                System.out.println(p);
            }
            i++;
        }
        
//adds last number if end of problem is not ')'        
        if(ops.get(ops.size() - 1) != ')')
        {
                p += nums.get(nums.size()-1).doubleValue();
        }
//        System.out.println(p);
        return p;
    }

    
    /**
     * Reads ArrayList of operations to convert Characters into 
     * corresponding Operation class.
     * @param ops an ArrayList of ops with object type Character.
     */
    @Override
    public void readOps(ArrayList<Character> ops)
    {
        int p = 0;
        for(i = 0; i < ops.size(); i++)
        {
            switch (ops.get(i)) 
            {
                case '(':
                    parCount++;
                    parPosStart.add(p);
                    break;
                case ')':
                    if(parPosStart.size() - 1 > parPosEnd.size())
                        parPosEnd.add(parPosStart.get(parPosEnd.size() + 1) - 1);
                    else
                        parPosEnd.add(p-1);
                    break;
                case '^':
                    operations.add(new Power());
                    p++;
                    break;
                case '*':
                    operations.add(new Multiplication());
                    p++;
                    break;
                case '/':
                    operations.add(new Division());
                    p++;
                    break;
                case '+':
                    operations.add(new Addition());
                    p++;
                    break;
                case '-':
                    operations.add(new Subtraction());
                    p++;
                    break;
                default:
                    break;
            }
        }
    }
    
    /**
     * Utilizes ArrayList operations and ArrayList nums to compute the
     * correct answer and converts it into a String
     * @return string of correct answer
     */
    @Override
    public String generateCorrectAnswer() 
    {
        if(parCount > 0) //parenthesesRecursionStart
        {
            i = parPosStart.remove(0);
            parCount--;
            parenthesesOp(i);
        }
        
//        System.out.println("pass Parentheses");
        
        if(operations.size() > 0) //power
        {
//            System.out.println("enter pow");
            i = operations.size() - 1;
            while(i > -1)
            {
                if(operations.size() == 1)
                {
//                    System.out.println("enter break");
                    if(operations.get(0).getClass().isInstance(pow))   
                    {
                        nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                        nums.remove(1);
                        operations.remove(0);
//                        System.out.println("PerformPowBreak");
                        break;
                    }
                    else
                        i--;
                }
                else
                {
//                    System.out.println("enter else");
                    if(operations.get(i).getClass().isInstance(pow))   
                    {
//                        System.out.println("nums i: "+nums.get(i)+" nums i+1: " + nums.get(i+1) + " = " + operations.get(i).performOperation(nums.get(i), nums.get(i + 1)) + " op " + operations.get(i).getClass());
                        nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(i);
                        i--;
//                        System.out.println("PerformPow");
                    }
                    else
                        i--;
                }
            }
        }
        if(operations.size() == 1)
        {
            if(operations.get(0).getClass().isInstance(pow))   
            {
                nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                nums.remove(1);
                operations.remove(0);
//                System.out.println("PerformlastPow");
            }
        }

//        System.out.println("Pass pow");

        if(operations.size() > 0) //multiplication and division
        {
            i = 0;
            while(i < operations.size())
            {
                if(operations.size() == 1)
                {
                    if(operations.get(0).getClass().isInstance(m))   
                    {
//                        System.out.println("nums i: "+nums.get(i)+" nums i+1: " + nums.get(i+1) + " = " + operations.get(i).performOperation(nums.get(i), nums.get(i + 1)) + " op " + operations.get(i).getClass());
                        nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                        nums.remove(1);
                        operations.remove(0);
//                        System.out.println("PerformMbreak");
                        break;
                    }
                    else if(operations.get(0).getClass().isInstance(d))   
                    {
//                        System.out.println("nums i: "+nums.get(i)+" nums i+1: " + nums.get(i+1) + " = " + operations.get(i).performOperation(nums.get(i), nums.get(i + 1)) + " op " + operations.get(i).getClass());
                        nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                        nums.remove(1);
                        operations.remove(0);
//                        System.out.println("PerformDbreak");
                        break;
                    }
                    else
                        i++;
                }
                else if(operations.get(i).getClass().isInstance(m))
                {
//                    System.out.println("nums i: "+nums.get(i)+" nums i+1: " + nums.get(i+1) + " = " + operations.get(i).performOperation(nums.get(i), nums.get(i + 1)) + " op " + operations.get(i).getClass());
//                        System.out.println("PerformM");
                        nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(i);
                        i = 0;
                }
                else if(operations.get(i).getClass().isInstance(d))   
                {
//                    System.out.println("nums i: "+nums.get(i)+" nums i+1: " + nums.get(i+1) + " = " + operations.get(i).performOperation(nums.get(i), nums.get(i + 1)) + " op " + operations.get(i).getClass());
//                    System.out.println("PerformD");
                    nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                    nums.remove(i+1);
                    operations.remove(i);
                    i = 0;
                }
                else
                    i++;
            }
        }
        if(operations.size() == 1)
        {
            if(operations.get(0).getClass().isInstance(m))   
            {
                nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                nums.remove(1);
                operations.remove(0);
//                System.out.println("PerformLastM");
            }
            else if(operations.get(0).getClass().isInstance(d))   
            {
                nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                nums.remove(1);
                operations.remove(0);
//                System.out.println("PerformLastD");
            }
        }
        
//        System.out.println("Pass M and D");
        
        if(operations.size() > 0) //addition and subtraction
        {
            i = 0;
            while(i < operations.size())
            {
                if(operations.size() == 1)
                {
                    if(operations.get(0).getClass().isInstance(a))   
                    {
//                        System.out.println("PerformAbreak");
                        nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                        nums.remove(1);
                        operations.remove(0);
                        break;
                    }
                    else if(operations.get(i).getClass().isInstance(s))   
                    {
//                        System.out.println("PerformSbreak");
                        nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                        nums.remove(1);
                        operations.remove(0);
                        break;
                    }
                    else
                        i++;
                }
                else if(operations.get(i).getClass().isInstance(a))   
                {
                        nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(i);
                        i = 0;
//                        System.out.println("PerformA");
                }
                else if(operations.get(i).getClass().isInstance(s))   
                {
                    nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                    nums.remove(i+1);
                    operations.remove(i);
                    i = 0;
//                    System.out.println("PerformS");
                }
                else
                    i++;
            }
        }
        if(operations.size() == 1)
        {
            if(operations.get(0).getClass().isInstance(a))   
            {
                nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                nums.remove(1);
                operations.remove(0);
//                System.out.println("PerformLastA");
            }
            else if(operations.get(0).getClass().isInstance(s))   
            {
                nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                nums.remove(1);
                operations.remove(0);
//                System.out.println("PerformlastS");
            }
        }
        
//        System.out.println("Pass A and S");
        
        return "" + nums.get(0);
    } 
    
    /**
     * Recursive method to compute operations within parentheses
     * @param pos starting position for computation
     */
    public void parenthesesOp(int pos)
    {
        int pEnd = parPosEnd.remove(0);
        
//        System.out.println("pos: " + pos + "  pEnd: " +pEnd);

        if(parCount > 0) //parenthesesRecursion
        {
            i = parPosStart.remove(0);
            parCount--;
            parenthesesOp(i);
        }
        
        if(pEnd > pos) //power
        {
            i = pEnd;
            while( i > pos - 1)
            {
                if(operations.size() == 1)
                {
                    if(operations.get(0).getClass().isInstance(pow))   
                    {
                        nums.set(i, operations.get(0).performOperation(nums.get(0), nums.get(1)));
                        nums.remove(1);
                        operations.remove(0);
//                        System.out.println("performPowBreak");
                        break;
                    }
                    else
                        i--;
                }
                else
                {
                    if(operations.get(i).getClass().isInstance(pow))   
                    {
                        nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(i);
                        pEnd--;
                        i = pEnd;
//                        System.out.println("performPow");
                    }
                    else
                        i--;
                }
            }
        }
        if(pos == pEnd)
        {
            if(operations.get(pos).getClass().isInstance(pow))   
            {
                nums.set(pos, operations.get(pos).performOperation(nums.get(pos), nums.get(pEnd+1)));
                nums.remove(pEnd+1);
                operations.remove(pos);
//                System.out.println("performlastPow");
                pEnd--;
            }
        }
        
        if(pEnd > pos) //multiplication and division
        {
            i = pos;
            while(i <= pEnd)
            {
                if(operations.size() == 1)
                {
                    if(operations.get(0).getClass().isInstance(m))   
                    {
                        nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(0);
//                        System.out.println("performMBreak");
                        break;
                    }
                    else if(operations.get(0).getClass().isInstance(d))   
                    {
                        nums.set(i, operations.get(0).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(0);
//                        System.out.println("performDBreak");
                        break;
                    }
                    else
                        i++;
                }
                else if(operations.get(i).getClass().isInstance(m))  
                {
//                    System.out.println("nums i: "+nums.get(i)+" nums i+1: " + nums.get(i+1) + " = " + operations.get(i).performOperation(nums.get(i), nums.get(i + 1)) + " op " + operations.get(i).getClass());
                    nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                    nums.remove(i+1);
                    operations.remove(i);
                    i = pos;
                    pEnd--;
//                    System.out.println("performM");
                }
                else if(operations.get(i).getClass().isInstance(d))   
                {
//                    System.out.println("nums i: "+nums.get(i)+" nums i+1: " + nums.get(i+1) + " = " + operations.get(i).performOperation(nums.get(i), nums.get(i + 1)) + " op " + operations.get(i).getClass());
                    nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                    nums.remove(i+1);
                    operations.remove(i);
                    i = pos;
                    pEnd--;
//                    System.out.println("performD");
                }
//                System.out.println("i: " + i);
                i++;
            }
        }
        if(pos == pEnd)
        {
            
            if(operations.get(pos).getClass().isInstance(m))   
            {
                nums.set(pos, operations.get(pos).performOperation(nums.get(pos), nums.get(pEnd+1)));
                nums.remove(pEnd+1);
                operations.remove(pos);
//                System.out.println("performLastM");
                pEnd--;
            }
            else if(operations.get(pos).getClass().isInstance(d))   
            {
                nums.set(pos, operations.get(pos).performOperation(nums.get(pos), nums.get(pEnd+1)));
                nums.remove(pEnd+1);
                operations.remove(pos);
//                System.out.println("performlastD");
                pEnd--;
            }
        }
        
//        System.out.println("pos: " + pos + "  pEnd: " +pEnd);
        
        if(pEnd > pos)
        {
            i = pos;
            while(i <= pEnd)
            {
                if(operations.size() == 1)
                {
                    if(operations.get(0).getClass().isInstance(a))   
                    {
                        nums.set(i, operations.get(0).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(0);
//                        System.out.println("performABreak");
                        break;
                    }
                    else if(operations.get(0).getClass().isInstance(s))   
                    {
                        nums.set(i, operations.get(0).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(0);
//                        System.out.println("performSBreak");
                        break;
                    }
                    else
                        i++;
                }
                else if(operations.get(i).getClass().isInstance(a)) 
                {
//                    System.out.println("nums i: "+nums.get(i)+" nums i+1: " + nums.get(i+1) + " = " + operations.get(i).performOperation(nums.get(i), nums.get(i + 1)) + " op " + operations.get(i).getClass());
                        nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(i);
                        i = pos;
                        pEnd--;
//System.out.println("performA");
                    }
                    else if(operations.get(i).getClass().isInstance(s))   
                    {
//                        System.out.println("nums i: "+nums.get(i)+" nums i+1: " + nums.get(i+1) + " = " + operations.get(i).performOperation(nums.get(i), nums.get(i + 1)) + " op " + operations.get(i).getClass());
                        nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                        nums.remove(i+1);
                        operations.remove(i);
                        i = pos;
                        pEnd--;
//System.out.println("performS");
                    }
                        i++;
                }
            }
//        System.out.println("pos: " + pos + "  pEnd: " +pEnd);
//        System.out.println(nums.get(0)+  " , " +nums.get(1));
        if(pos == pEnd)
        {
            if(operations.get(pos).getClass().isInstance(a))   
            {
                nums.set(pos, operations.get(pos).performOperation(nums.get(pos), nums.get(pEnd+1)));
                nums.remove(pEnd+1);
                operations.remove(pos);
//                System.out.println("performLastA");
                pEnd--;
            }
            else if(operations.get(pos).getClass().isInstance(s))   
            {
//                System.out.println("nums i: "+nums.get(pos)+" nums i+1: " + nums.get(pEnd) + " = " + operations.get(pos).performOperation(nums.get(pos), nums.get(pEnd)) + " op " + operations.get(pos).getClass());
                nums.set(pos, operations.get(pos).performOperation(nums.get(pos), nums.get(pEnd+1)));
                nums.remove(pEnd+1);
                operations.remove(pos);
//                System.out.println("performlastS");
                pEnd--;
            }
        }
        
    }
    
}


package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 02-14-2018
 * @version 0.0.1
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Basic implements ProblemType
{
    private Random ran = new Random(System.currentTimeMillis());
    private ArrayList<Double> nums = new ArrayList();
    private String p = "";
    private ArrayList<Operations> operations = new ArrayList();
    private ArrayList<String> operands = new ArrayList();
    private int parCount = 0;
    private ArrayList<Integer> parPos= new ArrayList();
    
    @Override
    public String generateProblem(ArrayList<Character> ops, int length, int digit)
    {
        readOps(ops);
        digit = (int) (Math.pow(10, digit) + 1);
        int i;
        double tempNum;
        for(i = 0; i < length; i++)
        {
            tempNum = ran.nextInt(digit);
            nums.add(tempNum);
        }
        
        for(i = 0; i < length; i++)
        {
            if(i < ops.size() && ops.get(i) == 'P' && parCount > 0)
            {
                p += "(";
                p += nums.get(i);
                parCount--;
            }
            else if (i < ops.size() && ops.get(i) == 'P')
            {
                p += nums.get(i);
                p += ")";
            }
            else
            {
                p += nums.get(i);
            }
            
            if(i < operands.size())
                p += operands.get(i);
        }
        if(ops.get(ops.size() - 1) == 'P')
            p += ")";
        return p;
    }

    @Override
    public void readOps(ArrayList<Character> ops)
    {
        int i;
        for(i = 0; i < ops.size(); i++)
        {
            if(ops.get(i).equals('P'))
            {
                parCount++;
                parPos.add(i);
            }
            else if(ops.get(i).equals('E'))   
            {
                operations.add(new Power());
                operands.add("^");
            }
            else if(ops.get(i).equals('M'))   
            {
                operations.add(new Multiplication());
                operands.add(" * ");
            }
            else if(ops.get(i).equals('D'))   
            {
                operations.add(new Division());
                operands.add(" / ");
            }
            else if(ops.get(i).equals('A'))   
            {
                operations.add(new Addition());
                operands.add(" + ");
            }
            else if(ops.get(i).equals('S'))   
            {
                operations.add(new Subtraction());
                operands.add(" - ");
            }
        }
        parCount = parCount / 2;
    }
    
    private Addition a = new Addition();
    private Subtraction s = new Subtraction();
    private Multiplication m = new Multiplication();
    private Division d = new Division();
    private Power pow = new Power();
    private int i;
    private double temp;
    @Override
    public String generateCorrectAnswer(int pos) 
    {
        //parenthesesRecursion
        if(parCount > 0)
        {
            parCount--;
            pos = parPos.get(0);
            parPos.remove(0);
            generateCorrectAnswer(pos);
        }
        
        //power
        for(i = pos; i < operations.size(); i++)
        {
            if(operands.get(i).equals("^"))   
            {
                nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                nums.remove(i+1);
                operations.remove(i);
                i = pos;
                System.out.println("performPower");
            } 
        }
        
        //multiplication and division
        for(i = pos; i < operations.size(); i++)
        {
            if(operations.get(i).getClass().isInstance(m))   
            {
                nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                nums.remove(i+1);
                operations.remove(i);
                i = pos;
                System.out.println("performMultiplication");
            }
            else if(operations.get(i).getClass().isInstance(d))   
            {
                nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                    nums.remove(i+1);
                    operations.remove(i);
                    i = pos;
                    System.out.println("performDivision");
            }
        }
        
        //addition and subtraction
        if(nums.size() == 2)
        {
            nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
            operations.remove(0);
        }
        else
        {
            for(i = pos; i < operations.size(); i++)
            {
                if(operations.get(i).getClass().isInstance(a))   
                {
                   
                    nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                    nums.remove(i+1);
                    operations.remove(i);
                    i = pos;
                    System.out.println("performAddition");
                }
                else if(operations.get(i).getClass().isInstance(s))   
                {
                    nums.set(i, operations.get(i).performOperation(nums.get(i), nums.get(i + 1)));
                    nums.remove(i+1);
                    operations.remove(i);
                    i = pos;
                    System.out.println("performSubtraction");
                }
            }
        }
        
        if(nums.size() == 2)
        {
            nums.set(0, operations.get(0).performOperation(nums.get(0), nums.get(1)));
            operations.remove(0);
        
        }
        
        
        return "" + nums.get(0);
    } 
}


package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 02-08-2018
 * @version 0.0.1
 */

import java.util.ArrayList;

public class Basic implements ProblemType
{
    private ArrayList<Double> nums = new ArrayList();
    private String p;
    private double answer = 1;
    
    @Override
    public String generateProblem(ArrayList<Operations> ops)
    {
        nums.add(ops.get(0).createString());
        p = "" + nums.get(0);
        int i;
        
        Addition a = new Addition();
        Subtraction s = new Subtraction();
        Multiplication m = new Multiplication();
        Division d = new Division();
        
        for(i = 1; i < ops.size(); i++)
        {
            if(ops.get(i).getClass().isInstance(m))   
            {
                nums.add(ops.get(i).extend());
                p += " * " + nums.get(i);
            }
            else if(ops.get(i).getClass().isInstance(d))   
            {
                nums.add(ops.get(i).extend());
                p += " / " + nums.get(i);
            }
            else if(ops.get(i).getClass().isInstance(a))   
            {
                nums.add(ops.get(i).extend());
                p += " + " + nums.get(i);
            }
            else if(ops.get(i).getClass().isInstance(s))   
            {
                nums.add(ops.get(i).extend());
                p += " - " + nums.get(i);
            }
        }
        double temp;

        //multiplication and division
        for(i = 1; i < ops.size(); i++)
        {
            if(ops.get(i).getClass().isInstance(m))   
            {
                nums.set(i - 1, ops.get(i).performOperation(nums.get(i -1)));
                ops.remove(i);
                nums.remove(i);
                ops.get(i-1).setNum(nums.get(i-1));
                i = 1;
            }
            else if(ops.get(i).getClass().isInstance(d))   
            {
                nums.set(i - 1, ops.get(i).performOperation(nums.get(i -1)));
                ops.remove(i);
                nums.remove(i);
                ops.get(i-1).setNum(nums.get(i-1));
                i = 1;
            }
        }
        
        //addition and subtraction
        if(ops.size() == 2)
        {
            nums.set(0, ops.get(1).performOperation(nums.get(0)));
            ops.remove(1);
        }
        else
        {
            for(i = 1; i < ops.size(); i++)
            {
                if(ops.get(i).getClass().isInstance(a))   
                {
                    nums.set(i - 1, ops.get(i).performOperation(nums.get(i -1)));
                    ops.remove(i);
                    nums.remove(i);
                    ops.get(i-1).setNum(nums.get(i-1));
                    i = 1;
                }
                else if(ops.get(i).getClass().isInstance(s))   
                {
                    nums.set(i - 1, ops.get(i).performOperation(nums.get(i -1)));
                    ops.remove(i);
                    nums.remove(i);
                    ops.get(i-1).setNum(nums.get(i-1));
                    i = 1;
                }
            }
        }
        if(ops.size() == 2)
        {
            nums.set(0, ops.get(1).performOperation(nums.get(0)));
            ops.remove(1);
        }
        
        answer = nums.get(0);
        
        return p;
    }

    @Override
    public String generateCorrectAnswer() 
    {
        return "" + answer;
    } 
}

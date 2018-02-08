
package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 02-07-2018
 * @version 0.0.1
 */

import java.util.ArrayList;

public class Basic implements ProblemType
{
    private ArrayList<Operations> operations = new ArrayList();
    private ArrayList<Double> nums = new ArrayList();
    private String p;
    public double answer;
    
    @Override
    public String generateProblem(ArrayList<Operations> ops)
    {
        nums.add(ops.get(0).createString());
        p = "" + nums.get(0);
        answer += nums.get(0);
        int i;
        for(i = 1; i < ops.size(); i++)
        {
            if(ops.get(i).getClass().isInstance(new Addition()))   
            {
                nums.add(ops.get(i).add());
                p += " + " + nums.get(i);
                answer = ops.get(i).performOperation(answer);
            }
        }
        return p;
    }

    @Override
    public String generateCorrectAnswer() 
    {
        return "" + answer;
    } 
}

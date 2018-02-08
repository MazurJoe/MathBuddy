
package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 02-07-2018
 * @version 0.0.1
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Basic implements ProblemType
{
    private ArrayList<Operations> operations = new ArrayList();
    private ArrayList<Double> nums = new ArrayList();
    private String p;
    public double answer;
    
//    public Basic()
//    {
//        
//    }
    
    @Override
    public String generateProblem(ArrayList<String> ops)
    {
        readOps(ops);
        Scanner fi;
        p = operations.get(0).createString();
        fi = new Scanner(p);
        fi.useDelimiter("[^\\p{Alnum},\\.-]");
        if (fi.hasNextInt())
            answer += fi.nextInt();
        else if (fi.hasNextDouble())
            answer += fi.nextDouble();
        String temp;
        for(int i = 1; i < operations.size(); i++)
        {
            temp = operations.get(i).add();
            fi = new Scanner(temp.substring(3));
            fi.useDelimiter("[^\\p{Alnum},\\.-]");
            if (fi.hasNextInt())
                answer += fi.nextInt();
            else if (fi.hasNextDouble())
                answer += fi.nextDouble();
            p += temp;
        }
        return p;
    }

    @Override
    public void readOps(ArrayList<String> ops)
    {
        for(int i = 0; i < ops.size() ; i++)
        {
            if(ops.get(i).equals("ADDITION"))
                operations.add(new Addition());
        }
    }

    @Override
    public String generateCorrectAnswer() 
    {
        return "" + answer;
    } 
}


package mathbuddy;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Joe
 */
public class DoubleSubtraction 
{
    private ArrayList<Double> coeffs;
    private int y,z;
    public String[] listOfProblems = new String[10];
    public double[] listOfAnswers = new double[10];
    public DoubleSubtraction(int low, int high, int numOfDecimals)
    {
        y=low;
        z=high;
        if (y>z)
        {
           int temp = y;
           y = z;
           z = temp;
        }
        Random generator = new Random(System.currentTimeMillis());
        for(int k=0; k<10; k++)
        {    
            ArrayList<Double> temp = new ArrayList<>();
            this.coeffs = temp;
            int j = 2;
            for(int i = 0; i < j; i++)
            {
                coeffs.add(NumberGenerator.doubleNumGen(y,z,numOfDecimals));     
            }
            ArrayList<Character> ops = new ArrayList();
            for(int i= 0; i < coeffs.size() -1; i++)
            {
                ops.add('-');
            }
            Problem p = new Problem(new Basic(), ops, coeffs);
            listOfProblems[k] = p.getProblem();
            listOfAnswers[k] = p.getCorrectAnswer();
        }    
    }    
}

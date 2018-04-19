
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
    private int x,y,z;
    public String[] listOfProblems = new String[10];
    
    public DoubleSubtraction(int low, int high, int numOfDecimals)
    {
        Random generator = new Random(System.currentTimeMillis());
        for(int k=0; k<10; k++)
        {    
            ArrayList<Double> temp = new ArrayList<>();
            this.coeffs = temp;
            int j = generator.nextInt(1)+2;
            for(int i = 0; i < j; i++)
            {
                coeffs.add(NumberGenerator.doubleNumGen(low,high,numOfDecimals));     
            }
            ArrayList<Character> ops = new ArrayList();
            for(int i= 0; i < coeffs.size() -1; i++)
            {
                ops.add('-');
            }
            Problem p = new Problem(new Basic(), ops, coeffs);
            listOfProblems[k] = p.getProblem();
        }    
    }    
}


package mathbuddy;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Joe
 */
public class IntegerDivision 
{
    private ArrayList<Double> coeffs;
    public int y,z;
    public String[] listOfProblems = new String[10];
    public double[] listOfAnswers = new double[10];
    public IntegerDivision(int low, int high)
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
        //Random generator = new Random(System.currentTimeMillis());
        int j = 2;
        for(int i = 0; i < j; i++)
        {
            coeffs.add(NumberGenerator.intNumGen(y,z));
            
        }
        ArrayList<Character> ops = new ArrayList();
        for(int i= 0; i < coeffs.size() -1; i++)
        {
            ops.add('/');
        }    
        Problem p = new Problem(new BasicInteger(), ops, coeffs);
        listOfProblems[k] = p.getProblem();  
        listOfAnswers[k] = p.getCorrectAnswer();
    }
    }

}

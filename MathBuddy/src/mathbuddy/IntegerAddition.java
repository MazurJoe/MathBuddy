
package mathbuddy;

import java.util.Random;
/**
 * This class creates arrays filled with random numbers from various ranges makes them into an equation in the form of a String and evaluate the summation of the numbers.
 * @author Joe Mazur
 */

import java.util.ArrayList;
public class IntegerAddition 
{
    private ArrayList<Double> coeffs;
    public int y,z;
    public String[] listOfProblems = new String[10];
    public double[] listOfAnswers = new double[10];
    public IntegerAddition(int low, int high)
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
                coeffs.add(NumberGenerator.intNumGen(y,z));    
            }
            ArrayList<Character> ops = new ArrayList();
            for(int i= 0; i < coeffs.size() -1; i++)
            {    
                ops.add('+');
            }
            Problem p = new Problem(new BasicInteger(), ops, coeffs);
            listOfProblems[k] = p.getProblem();
            listOfAnswers[k] = p.getCorrectAnswer(); 
        }  
    }    
}

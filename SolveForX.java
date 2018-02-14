
package mathbuddy;

import java.util.ArrayList;
import java.util.Random;
public class SolveForX 
{
    private ArrayList<Integer> coeffs = new ArrayList<>();
    
    /**
     * fills the private ArrayList with 3 integers from the range -20->20
     */
   public void equationCoeffs()
   {
       Random generator = new Random(System.currentTimeMillis());
       coeffs.add(0,generator.nextInt(41)-20);

       while(coeffs.get(0) == 0)
       {
           coeffs.set(0,generator.nextInt(41)-20);
       }
       
       for(int i=1; i<3; i++)
       {
           coeffs.add(generator.nextInt(41)-20);
       }
   }
    
   /**
    * creates an equation from the numbers in coeffs and prints the equation 
    */
   public void solveForXEquation()
   {
       System.out.print(coeffs.get(0)+"x + " + coeffs.get(1) + " = " + coeffs.get(2));
   }
   
   public void xValue()
   {
       double x = (1.0*coeffs.get(2) - coeffs.get(1))/coeffs.get(0);
       System.out.printf("x = %.3f",x);
   }
    
    public SolveForX()
    {
        ArrayList<Integer> temp = new ArrayList<>();
        this.coeffs = temp;
    }
}

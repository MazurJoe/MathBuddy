
package mathbuddy;

import java.util.Random;
/**
 * This class creates arrays filled with random numbers from various ranges makes them into an equation in the form of a String and evaluate the summation of the numbers.
 * @author Joe Mazur
 */

import java.util.ArrayList;
public class IntegerSumation 
{
   private ArrayList<Integer> coeffs;
    
     
    
    /**
     * fills the private ArrayList coeffs with either 2 or 3 integers from the range 1->10
     */
    public void beginerIntAdd()
    {
        Random generator = new Random(System.currentTimeMillis());
        for(int i = 0; i < generator.nextInt(2)+2; i++)
        {
            coeffs.add(generator.nextInt(10) + 1);
        }  
    }
    
    /**
     * fills the private ArrayList with either 2 or 3 integers from the range 10->100
     */
    public void simpleIntAdd()
    {
        Random generator = new Random(System.currentTimeMillis());
        for(int i = 0; i < generator.nextInt(2)+2; i++)
        {
            coeffs.add(generator.nextInt(91) + 10);
        }
    }
     
    /**
     * fills the private ArrayList with either 2 or 3 integers from the range 100->1000
     */
    public void complexIntAdd()
    {
        Random generator = new Random(System.currentTimeMillis());
        for(int i = 0; i < generator.nextInt(2)+2; i++)
        {
            coeffs.add(generator.nextInt(901) + 100);
        }
    }
    
    /**
     * uses the numbers from the private arrayList coeffs and forms an addition equation
     * @return equation
     */
    public String intAddEquation()
    {
        String equation = "" + coeffs.get(0);
        if(coeffs.size() > 2)
        {   
            for(int i = 1; i < coeffs.size(); i++)
            equation+= " + " + coeffs.get(i);
        } 
        else
            equation+= " + " + coeffs.get(1);
        return equation + " = ?";
    }        
     
     /**
      * takes the numbers from the private ArrayList coeffs and calculates them added together 
      * @return sum
      */
    public double addCalculator()
    {
        double sum = 0;
        for(int i = 0; i < coeffs.size(); i++ )
        {
            sum+= coeffs.get(i)*1.0;
        }
        return sum;
    }
    
    /**
     * fills the private ArrayList with 2 integers from the range 1->10 in descending order
     */
    public void beginerIntSubtract()
    {
       Random generator = new Random(System.currentTimeMillis());
       int num1 = generator.nextInt(10) + 1;
       int num2 = generator.nextInt(10) + 1;
       if(num1 > num2)
       {    
           coeffs.add(num1);
           coeffs.add(num2);
       }            
        else
       {    
           coeffs.add(num2);
           coeffs.add(num1);
       }
    }
    
     /**
      * fills the private ArrayList with 2 integers from the range 10->100 in descending
      */
    public void simpleIntSubtract()
    {
        Random generator = new Random(System.currentTimeMillis());
        int num1 = generator.nextInt(91) + 10;
        int num2 = generator.nextInt(91) + 10;
        if(num1 > num2)
        {    
            coeffs.add(num1);
            coeffs.add(num2);
        }            
        else
        {    
            coeffs.add(num2);
            coeffs.add(num1);
        }
       
    }
    
    /**
     * fills the private ArrayList with 2 integers from the range 10->100
     */
    public void complexIntSubtract()
    {
       Random generator = new Random(System.currentTimeMillis());
       coeffs.add(generator.nextInt(91) + 10);
       coeffs.add(generator.nextInt(91) + 10);     
    }
     
    /**
     * uses the numbers from the private ArrayList coeffs and forms a subtraction equation
     * @return equation
     */
    public String intSubtractEquation()
    {
        String equation = "" + coeffs.get(0) + " - " + coeffs.get(1);
        return equation + " = ?";
    }    
    
    
     /**
      * takes the numbers from the private ArrayList and subtracts the second number from the first
      * @return the difference 
      */
    public double subtractCalculator()
    {
        return coeffs.get(0)*1.0 - coeffs.get(1)*1.0;      
    }

     /**
      * creates an empty ArrayList and set the private ArrayList coeffs equal to it
      */
    public IntegerSumation()
    {
        ArrayList<Integer> temp = new ArrayList<>();
        this.coeffs = temp;
    }
    
}

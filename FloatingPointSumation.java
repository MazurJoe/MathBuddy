
package mathbuddy;

import java.util.Random;
import java.util.ArrayList;

public class FloatingPointSumation 
{
    private ArrayList<Float> coeffs;
    
     
    
    /**
     * fills the private ArrayList coeffs with either 2 or 3 floating-point from the range 0->10
     */
    public void beginerFPAdd()
    {
        Random generator = new Random(System.currentTimeMillis());
        for(int i = 0; i < generator.nextInt(2)+2; i++)
        {
            coeffs.add(10*generator.nextFloat());
        }  
    }
    
    /**
     * fills the private ArrayList with either 2 or 3 integers from the range 10->100
     */
    public void simpleFPAdd()
    {
        Random generator = new Random(System.currentTimeMillis());
        for(int i = 0; i < generator.nextInt(2)+2; i++)
        {
            coeffs.add(100*generator.nextFloat());
        }    
    }
     
    /**
     * fills the private ArrayList with either 2 or 3 integers from the range 100->1000
     */
    public void complexFPAdd()
    {
        Random generator = new Random(System.currentTimeMillis());
        for(int i = 0; i < generator.nextInt(2)+2; i++)
        {
            coeffs.add(1000*generator.nextFloat());
        }
    }
    
    /**
     * uses the numbers from the private arrayList coeffs and forms an addition equation
     * @return equation
     */
    public void fPAddEquation()
    {
        if(coeffs.size() == 3)
        {
            System.out.printf("%.4f + %.4f + %.4f = ?", coeffs.get(0), coeffs.get(1), coeffs.get(2));
        }
        else
        {
            System.out.printf("%.4f + %.4f = ?", coeffs.get(0), coeffs.get(1));
        }
    }        
     
     /**
      * takes the numbers from the private ArrayList coeffs and calculates them added together 
      * @return sum
      */
    public void addCalculator()
    {
        float sum = 0;
        for(int i = 0; i < coeffs.size(); i++ )
        {
            sum+= coeffs.get(i)*1.0;
        }
        System.out.printf("%.3f", sum);
    }
    
    /**
     * fills the private ArrayList with 2 integers from the range 1->10 in descending order
     */
    public void beginerFPSubtract()
    {
       Random generator = new Random(System.currentTimeMillis());
       float num1 = 10*generator.nextFloat();
       float num2 = 10*generator.nextFloat();
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
    public void simpleFPSubtract()
    {
        Random generator = new Random(System.currentTimeMillis());
        float num1 = 100*generator.nextFloat();
        float num2 = 100*generator.nextFloat();
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
    public void complexFPSubtract()
    {
       Random generator = new Random(System.currentTimeMillis());
       coeffs.add(100*generator.nextFloat());
       coeffs.add(100*generator.nextFloat());     
    }
     
    /**
     * uses the numbers from the private ArrayList coeffs and forms a subtraction equation
     * @return equation
     */
    public void fPSubtractEquation()
    {
        System.out.printf("%.3f - %.3f = ?", coeffs.get(0), coeffs.get(1));  
    }    
    
    
     /**
      * takes the numbers from the private ArrayList and subtracts the second number from the first
      * @return the difference 
      */
    public void subtractCalculator()
    {
        float sum = coeffs.get(0) - coeffs.get(1);  
        System.out.printf("%.3f", sum);
    }

     /**
      * creates an empty ArrayList and set the private ArrayList coeffs equal to it
      */
    public FloatingPointSumation()
    {
        ArrayList<Float> temp = new ArrayList<>();
        this.coeffs = temp;
    }
}

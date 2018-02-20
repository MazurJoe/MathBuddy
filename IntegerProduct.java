
package mathbuddy;


import java.util.ArrayList;
import java.util.Random;
public class IntegerProduct
/**
 * this class creates an ArrayList, fills the ArrayList, creates a multiplication or division equation, then calculates the value of the equation
 */        
        
{
    private ArrayList<Integer> coeffs;
    
    /**
     * fills the private ArrayList coeffs with 2 integers from the range 1->10
     */
    public void beginerIntMult()
    {
        Random generator = new Random(System.currentTimeMillis());
        coeffs.add(generator.nextInt(10)+1);
        coeffs.add(generator.nextInt(10)+1);
    }
    
    
    /**
     * fills the private ArrayList coeffs with 3 integers from the range 1->10
     */
    public void simpleIntMult()
    {
        Random generator = new Random(System.currentTimeMillis());
        for(int i = 0; i < 3; i++)
        {
            coeffs.add(generator.nextInt(10)+1);
        }
    }
    
    /**
     * fills the private ArrayList coeffs with 2 integers from the range 10->100
     */
    public void complexIntMult()
    {
        Random generator = new Random(System.currentTimeMillis());
        coeffs.add(generator.nextInt(91)+10);
        coeffs.add(generator.nextInt(91)+10);
    }
    
    /**
     * uses the numbers from the private ArrayList coeffs and forms a multiplication equation
     * @return equation
     */
    public String intMultEquation()
    {
        String equation = "";
        for(int i = 0; i < coeffs.size()-1; i++)
        {
            equation += coeffs.get(i) + " X ";
        }
        return equation += coeffs.get(coeffs.size()-1) + " = ?";
    }
    
    /**
     * takes the numbers from the private ArrayList coeffs and multiples them together
     * @return prod
     */
    public int intMultCalculator()
    {
        int prod = 1;
        for(int i = 0; i < coeffs.size(); i++)
        {
            prod *= coeffs.get(i); 
        }
        return prod;
    }
    
    /**
     * fills the private ArrayList with 2 integers from the range 1->10 such that,
     * the second number goes into the first number a whole number of times
     */
    public void beginerIntDivide()
    {
        Random generator = new Random(System.currentTimeMillis());
        coeffs.add(generator.nextInt(10) + 1);
        coeffs.add(generator.nextInt(10) + 1);
        while((coeffs.get(0)%coeffs.get(1)) != 0)
        {    
            coeffs.set(1, generator.nextInt(10) + 1);
        }  
    }
    
    /**
     * fills the first and second spots of private ArrayList with integers from the range 10->100 and 1->100 respectively, such that,
     * the second number goes into the first number a whole number of times
     */
    public void simpleIntDivide()
    {
        Random generator = new Random(System.currentTimeMillis());
        coeffs.add(generator.nextInt(91) + 10);
        coeffs.add(generator.nextInt(100) + 1);
        while((coeffs.get(0)%coeffs.get(1)) != 0)
        {    
            coeffs.set(1, generator.nextInt(100) + 1);
        }    
    }
    
    /**
     * fills the private ArrayList coeffs with 2 integers from the range 10->1000
     */
    public void complexIntDivide()
    {
        Random generator = new Random(System.currentTimeMillis());
        coeffs.add(generator.nextInt(991) + 10);
        coeffs.add(generator.nextInt(991) + 10);
    }
    
    /**
     * uses the numbers from the private ArrayList coeffs and form a division equation
     * @return equation
     */
    public String intDivideEquation()
    {
        return coeffs.get(0) + "/" + coeffs.get(1) + " = ?";
    }
            
    /**
     * takes the first number from the private ArrayList coeffs and divides it by the second number
     * @return first number divided by second
     */
    public double intDivideCalculator()
    {
        return (coeffs.get(0)/coeffs.get(1));   
    }
     
    /**
     * creates an empty ArrayList and sets the private ArrayList coeffs equal to it
     */
    public IntegerProduct()
    {
        ArrayList<Integer> temp = new ArrayList<>();
        this.coeffs = temp;
    }
}


package mathbuddy;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Joe
 */
public class FloatingPointProduct 
{
    private ArrayList<Float> coeffs;
    
    /**
     * fills the private ArrayList coeffs with 2 floating-point from the range 0->1
     */
    public void beginerFPMult()
    {
        Random generator = new Random(System.currentTimeMillis());
        coeffs.add(generator.nextFloat());
        coeffs.add(generator.nextFloat());       
    }
    
    
    /**
     * fills the private ArrayList coeffs with 2 floating points from the range 0->10
     */
    public void simpleFPMult()
    {
        Random generator = new Random(System.currentTimeMillis());
        coeffs.add(10*generator.nextFloat());
        coeffs.add(10*generator.nextFloat());
    }
    
    /**
     * fills the private ArrayList coeffs with 2 floating points from the range 0->100
     */
    public void complexFPMult()
    {
        Random generator = new Random(System.currentTimeMillis());
        coeffs.add(100*generator.nextFloat());
        coeffs.add(100*generator.nextFloat());
    }
    
    /**
     * uses the numbers from the private ArrayList coeffs and forms a multiplication equation
     */
    public void fPMultEquation()
    {
        System.out.printf("%.3f X %.3f = ?", coeffs.get(0), coeffs.get(1));
    }
    
    /**
     * takes the numbers from the private ArrayList coeffs and multiples them together then prints the results up to 3 decimal places 
     */
    public void fPMultCalculator()
    {
        float prod = coeffs.get(0)*coeffs.get(1);
        System.out.printf("%.3f", prod);
    }
    
    /**
     * uses the numbers from the private ArrayList coeffs and form a division equation and prints the equation
     */
    public void fPDivideEquation()
    {
        System.out.printf("%.3f/%.3f = ?", coeffs.get(0), coeffs.get(1));
    }
            
    /**
     * takes the first number from the private ArrayList coeffs and divides it by the second number then prints the results 
     */
    public void fPDivideCalculator()
    {
        float prod = coeffs.get(0)/coeffs.get(1);
        System.out.printf("%.3f", prod);
    }
     
    /**
     * creates an empty ArrayList and sets the private ArrayList coeffs equal to it
     */
    public FloatingPointProduct()
    {
        ArrayList<Float> temp = new ArrayList<>();
        this.coeffs = temp;
    }    
}

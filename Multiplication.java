
package mathbuddy;

import java.util.Random;

/**
 * @author Paul John Nguyen
 * @since 02-12-2018
 * @version 0.0.1
 */

public class Multiplication implements Operations
{
    public Random ran = new Random(System.currentTimeMillis());
    public double t;
    public String s;
    public double temp = 1;
    
    public Multiplication()
    {
        t = ran.nextInt(101);
    }
    
    @Override
    public double createString()
    {
        s = "";
        s += t;
        temp *= t;
        return t;
    }
    
    @Override
    public double extend()
    {   
        temp *= t;
        s += " * " + t;
        return t;
    }
    
    @Override
    public double performOperation(double in)
    {
        t = in * t;
        return t;
    }
    
    @Override
    public double getAnswer()
    {
        return temp;
    }
    
    public void setNum(double num)
    {
        t = num;
    }
    
    public double getNum()
    {
        return t;
    }
    
    @Override
    public String toString()
    {
        return s;
    }
}

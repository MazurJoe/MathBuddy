
package mathbuddy;


/**
 * @author Paul John Nguyen
 * @since 02-07-2018
 * @version 0.0.1
 */

public class Addition implements Operations
{
    public double t;
    public String s;
    public double temp = 0;
    
    public Addition()
    {
        t = RAN.nextInt(101);
    }
    
    @Override
    public Double createString()
    {
        s = "";
        s += t;
        temp += t;
        return t;
    }
    
    @Override
    public Double add()
    {   
        temp += t;
        s += " + " + t;
        return t;
    }
    
    @Override
    public double performOperation(double in)
    {
        return in + t;
    }
    
    @Override
    public double getAnswer()
    {
        return temp;
    }
    
    @Override
    public String toString()
    {
        return s;
    }
}

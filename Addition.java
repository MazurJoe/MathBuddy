
package mathbuddy;


/**
 * @author Paul John Nguyen
 * @since 02-07-2018
 * @version 0.0.1
 */

public class Addition implements Operations
{
    
    public String s;
    public double temp = 0;
    
//    public Addition()
//    {
//        
//    }
    
    @Override
    public String createString()
    {
        s = "";
        temp = RAN.nextInt(101);
        s += temp;
        return s;
    }
    
    @Override
    public String add()
    {
        double t = RAN.nextInt(101);
        temp += t;
        s += " + " + t;
        return " + " + t;
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

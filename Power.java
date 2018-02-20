
package mathbuddy;

import java.util.Random;

/**
 * @author Paul John Nguyen
 * @since 02-14-2018
 * @version 0.0.1
 */
public class Power implements Operations
{
    @Override
    public double performOperation(double in1, double in2)
    {
        if (in2 == 0)
            return 1;
        if (in2 % 2 == 0) 
        {
            double m;
            m = performOperation(in1, in2 / 2);
            return m * m;
        }   
        else
        {
            return in1 * performOperation(in1, in2 - 1);
        }
    }
}

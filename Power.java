
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
        return Math.pow(in1, in2);
    }
}


package mathbuddy;

import java.util.Random;

/**
 * @author Paul John Nguyen
 * @since 02-14-2018
 * @version 0.0.1
 */
public class Division implements Operations
{
    @Override
    public double performOperation(double in1, double in2)
    {
        return in1 / in2;
    }
}

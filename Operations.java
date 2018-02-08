
package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 02-07-2018
 * @version 0.0.1
 */

import java.util.Random;
public interface Operations 
{
    public Random RAN = new Random(System.currentTimeMillis());
    public String createString();
    public double getAnswer();
    public String add();
}

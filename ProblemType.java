
package mathbuddy;

import java.util.ArrayList;

/**
 * @author Paul John Nguyen
 * @since 02-07-2018
 * @version 0.0.1
 */
public interface ProblemType 
{
    public String generateProblem(ArrayList<Operations> ops);
    public String generateCorrectAnswer();
}

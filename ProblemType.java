
package mathbuddy;

import java.util.ArrayList;

/**
 * @author Paul John Nguyen
 * @since 02-08-2018
 * @version 0.0.1
 */
public interface ProblemType 
{
    /**
     * Generates a string of the problem given the operations for it.
     * @param ops
     * @return
     */
    public String generateProblem(ArrayList<Operations> ops);
    
    /**
     * Generates a string of the correct answer to the created problem.
     * @return 
     */
    public String generateCorrectAnswer();
}

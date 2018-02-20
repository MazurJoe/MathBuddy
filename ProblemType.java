
package mathbuddy;

import java.util.ArrayList;

/**
 * @author Paul John Nguyen
 * @since 02-14-2018
 * @version 0.0.1
 */
public interface ProblemType 
{
    /**
     * Generates a string of the problem given the operations for it.
     * @param ops
     * @return
     */
    public String generateProblem(ArrayList<Character> ops, int length, int digit);
    
    /**
     * 
     */
    public void readOps(ArrayList<Character> ops);
    
    /**
     * Generates a string of the correct answer to the created problem.
     * @param ops
     * @return 
     */
    public String generateCorrectAnswer(int pos);
}

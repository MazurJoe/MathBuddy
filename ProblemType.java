
package mathbuddy;

import java.util.ArrayList;

/**
 * @author Paul John Nguyen
 * @since 03-15-2018
 * @version 0.0.1
 */
public interface ProblemType 
{
    /**
     * Generates a string of the problem given the operations, 
     * length, digit, parentheses starting positions, and parentheses
     * ending positions
     * @param ops ArrayList of operations in form of Character
     * @param nums ArrayList of numbers in form of Double
     * @return String representation of problem
     */
    public String generateProblem(ArrayList<Character> ops, ArrayList<Double> nums);
    
    /**
     * reads ArrayList ops to convert to Operation objects
     * @param ops ArrayList of Operations in type Character
     */
    public void readOps(ArrayList<Character> ops);
    
    /**
     * Generates a Double of the correct answer to the created problem.
     * @return String of the correct answer
     */
    public Double generateCorrectAnswer();
}

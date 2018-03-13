
package mathbuddy;

import java.util.ArrayList;

/**
 * @author Paul John Nguyen
 * @since 03-13-2018
 * @version 0.0.1
 */
public interface ProblemType 
{
    /**
     * Generates a string of the problem given the operations, 
     * length, digit, parentheses starting positions, and parentheses
     * ending positions
     * @param ops ArrayList of operations in form of Character
     * @param parStart ArrayList of starting parentheses positions
     * @param parEnd ArrayList of ending parentheses positions
     * @param length number of numbers/variables to be in problem
     * @param digit number of digits in numbers
     * @return String representation of problem
     */
    public String generateProblem(ArrayList<Character> ops,ArrayList<Integer> parStart, ArrayList<Integer> parEnd, int length, int digit);
    
    /**
     * reads ArrayList ops to convert to Operation objects
     * @param ops ArrayList of Operations in type Character
     */
    public void readOps(ArrayList<Character> ops);
    
    /**
     * Generates a string of the correct answer to the created problem.
     * @return String of the correct answer
     */
    public String generateCorrectAnswer();
}

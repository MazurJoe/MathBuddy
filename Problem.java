
package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 02-14-2018
 * @version 0.0.1
 */

import java.util.ArrayList;

public class Problem 
{
    /**
     * The type of mathematical problem.
     */
    private ProblemType problemType;
    
    /**
     * String representation of the problem.
     */
    private String problem;
    
    /**
     * The correct answer to the problem.
     */
    private String correctAnswer;
    
    /**
     * Constructor for problem.
     * @param ops
     */
    public Problem(ProblemType p, ArrayList<Character> ops, int length, int digit)
    {
        problemType = p;
        problem = problemType.generateProblem(ops, length, digit);
        correctAnswer = problemType.generateCorrectAnswer(0);
    }
    
    /**
     * Prints the correct answer.
     */
    public void displayCorrectAnswer()
    {
        System.out.println(correctAnswer);
    }
    
    /**
     * Prints the problem.
     */
    public void displayProblem()
    {
        System.out.print(problem);
    }
}


package mathbuddy;

/**
 * @author Paul John Nguyen
 * @since 02-08-2018
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
     * @param p
     * @param ops 
     */
    public Problem(ProblemType p, ArrayList<Operations> ops)
    {
        problemType = p;
        problem = problemType.generateProblem(ops);
        correctAnswer = problemType.generateCorrectAnswer();
    }
    
    /**
     * Prints correct answer.
     */
    public void displayCorrectAnswer()
    {
        System.out.println(correctAnswer);
    }
    
    /**
     * Prints the problem.
     */
    public void display()
    {
        System.out.print(problem);
    }
}

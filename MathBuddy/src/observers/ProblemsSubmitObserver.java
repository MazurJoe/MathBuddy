/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import frontEndUI.ProblemScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mathbuddy.Comparator;
import mathbuddy.MathBuddy;

/**
 *
 * @author John Rosser
 */
public class ProblemsSubmitObserver implements ActionListener {
    
    private ProblemScreen menu;
    private MathBuddy mb;
    private Comparator comp;
    private int positionCounter;
    
    public ProblemsSubmitObserver(ProblemScreen menu, MathBuddy mb) {
        this.menu = menu;
        this.mb = mb;
        this.comp = new Comparator();
        this.positionCounter = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(positionCounter<9){
            double answer = menu.getAnswer();
            if(comp.numComparator(answer, menu.getCurrAnswers(positionCounter))){
              menu.setNumCorrect();
            }
            positionCounter++;
            menu.updateProblem(positionCounter);            
        }
        else if(positionCounter==9){
            double answer = menu.getAnswer();
            if(comp.numComparator(answer, menu.getCurrAnswers(positionCounter))){
                menu.setNumCorrect();
            }
            positionCounter++;
            menu.noMoreProblems();
        }
        else{}
        //CHECK ANSWER
    }
    
}

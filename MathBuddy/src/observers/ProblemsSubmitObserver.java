/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import frontEndUI.ProblemScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mathbuddy.MathBuddy;

/**
 *
 * @author John Rosser
 */
public class ProblemsSubmitObserver implements ActionListener {
    
    private ProblemScreen menu;
    private MathBuddy mb;
    
    public ProblemsSubmitObserver(ProblemScreen menu, MathBuddy mb) {
        this.menu = menu;
        this.mb = mb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double answer = menu.getAnswer();
        //CHECK ANSWER
    }
    
}

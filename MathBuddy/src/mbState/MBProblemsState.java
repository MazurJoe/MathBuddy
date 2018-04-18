/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbState;

import frontEndUI.ProblemScreen;
import mathbuddy.MathBuddy;


/**
 *
 * @author John Rosser
 */
public class MBProblemsState implements MBState{
    
    MathBuddy mb;
    
    public MBProblemsState(MathBuddy mb){
        this.mb = mb;
    }

    @Override
    public void update() {
        ProblemScreen ps = new ProblemScreen(mb);
        ps.setVisible(true);
        
    }
    
}

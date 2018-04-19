/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbState;

import frontEndUI.ProblemScreen;
import humans.OptionsBundle;
import mathbuddy.MathBuddy;


/**
 *
 * @author John Rosser
 */
public class MBProblemsState implements MBState{
    
    MathBuddy mb;
    OptionsBundle ob;
    
    public MBProblemsState(MathBuddy mb, OptionsBundle ob){
        this.mb = mb;
        this.ob = ob;
    }

    @Override
    public void update() {
        ProblemScreen ps = new ProblemScreen(mb);
        ps.setObAndMakeProblems(ob);
        ps.setVisible(true);
        
    }
    
}

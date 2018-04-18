/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbState;

import frontEndUI.MBSplash;
import mathbuddy.MathBuddy;

/**
 *
 * @author John Rosser
 */
public class MBMainMenuState implements MBState {
      
    MathBuddy mb;
    
    public MBMainMenuState(MathBuddy mb) {
        this.mb = mb;
    }
    
    
    @Override
    public void update() {
        MBSplash mbs = new MBSplash(mb);
        mbs.setVisible(true);
        
        //Find the studentID of the given ID
        //getStudent(id);
        
        
        
    }
    
}

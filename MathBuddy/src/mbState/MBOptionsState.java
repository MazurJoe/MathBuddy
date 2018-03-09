/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbState;

import frontEndUI.MBOptionsMenu;
import mathbuddy.MathBuddy;

/**
 *
 * @author John Rosser
 */
public class MBOptionsState implements MBState{
    
    MathBuddy mb;
    
    public MBOptionsState(MathBuddy mb) {
        this.mb = mb;
    }

    @Override
    public void update() {
        MBOptionsMenu mbo = new MBOptionsMenu(mb);
        mbo.setVisible(true);
    }
    
}

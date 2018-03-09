/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathbuddy;

import mbState.MBMainMenuState;
import mbState.MBState;

/**
 *
 * @author John Rosser
 */
public class MathBuddy {

    public MBState state;   
    
    public void setState(MBState state) {
        this.state = state;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MathBuddy mb = new MathBuddy();
        
        mb.setState(new MBMainMenuState(mb));
        mb.state.update();
        
    }
    
}

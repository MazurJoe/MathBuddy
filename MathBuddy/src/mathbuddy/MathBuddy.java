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

    MBState state;   
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MBState state = new MBMainMenuState();
        while(true) {
            state.update();
        }
        
        
    }
    
}

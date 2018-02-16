/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbtimer;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author John Rosser
 */
public class MBNoTimer implements TimeableStrategy {
    
    
    public MBNoTimer(){
    }
    
    

    @Override
    public void timerOut() {
    }

    @Override
    public double timerStop() {
        return 0.0;
    }

    @Override
    public void timerStart() {
    }

    @Override
    public void setJTextField(JTextField jtf) {      
    }

}

package mbtimer;

import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author John Rosser
 */
public interface TimeableStrategy {
    
    public void timerOut();
    public double timerStop();
    public void timerStart();
    public void setJTextField(JTextField jtf);
    
}

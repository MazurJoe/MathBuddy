/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbtimer;

import javax.swing.JTextField;


/**
 *
 * @author John Rosser
 */
public class MBCountDown implements TimeableStrategy {
    
    private JTextField jtf;
    private double allowedTime;
    private double startTime;
    private int timeRemaining;
    private boolean running;
    
    
    public MBCountDown(double allowedTime){
        this.allowedTime = allowedTime;
        this.timeRemaining = (int) allowedTime;
        this.running = false;
    }
    

    @Override
    public void timerOut() {
        jtf.setText("" + timeRemaining);
    }

    @Override
    public double timerStop() {
        this.running = false;
        return System.currentTimeMillis() - startTime;
    }

    @Override
    public void timerStart() {
        this.startTime = System.currentTimeMillis();
        timerOut();
        while(System.currentTimeMillis()-startTime < allowedTime && this.running == true) {
                timeRemaining = (int) (allowedTime - (System.currentTimeMillis() - startTime)/1000);
                timerOut();
        }
        timerStop();
    }

    @Override
    public void setJTextField(JTextField jtf) {
        this.jtf = jtf;
    }
    
    
}

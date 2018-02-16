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
public class MBStopWatch implements TimeableStrategy{
    
    private int totalTime;
    private boolean running;
    private JTextField jtf;
    private double startTime;
    
    public MBStopWatch(){
        this.running = false;
        this.startTime = 0;
        this.totalTime = 0;
    }
    
    @Override
    public void setJTextField(JTextField jtf){
        this.jtf = jtf;
    }

    @Override
    public void timerOut() {
        jtf.setText(""+totalTime);
    }

    @Override
    public double timerStop() {
        this.running = false;
        return System.currentTimeMillis() - this.startTime;
    }

    @Override
    public void timerStart() {
        this.running = true;
        this.startTime = System.currentTimeMillis();
        double localTime = startTime;
        timerOut();        
        while(running){
            if((System.currentTimeMillis() - localTime)/1000 > 1){
                totalTime++;
                timerOut();
                localTime = System.currentTimeMillis();
            }
        }
    } 
}

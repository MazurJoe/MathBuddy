/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbtimer;


/**
 *
 * @author John Rosser
 */
public class MBTimer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MBTimerFrame frame = new MBTimerFrame(new MBNoTimer());
        frame.setVisible(true);
        frame.frameStart();
        frame.frameStop();

        MBTimerFrame frame2 = new MBTimerFrame(new MBStopWatch());
        frame2.setVisible(true);
        frame2.frameStart();
        
        //frame2.frameStop();
    }
    
}

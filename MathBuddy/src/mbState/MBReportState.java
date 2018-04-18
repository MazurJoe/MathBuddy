/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mbState;

import frontEndUI.ReportScreen;
import mathbuddy.MathBuddy;

/**
 *
 * @author John Rosser
 */
public class MBReportState implements MBState{
    
    MathBuddy mb;
    int numCorrect;

    public MBReportState(MathBuddy mb, int numCorrect) {
        this.mb = mb;
        this.numCorrect = numCorrect;
    }
    
    

    @Override
    public void update() {
        ReportScreen rs = new ReportScreen(numCorrect);
        rs.setVisible(true);
    }
    
}

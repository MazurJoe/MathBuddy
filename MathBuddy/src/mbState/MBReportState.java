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

    public MBReportState(MathBuddy mb) {
        this.mb = mb;
    }
    
    

    @Override
    public void update() {
        ReportScreen rs = new ReportScreen();
        rs.setVisible(true);
    }
    
}

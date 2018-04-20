/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import frontEndUI.ReportScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mathbuddy.MathBuddy;
import mbState.MBOptionsState;

/**
 *
 * @author John Rosser
 */
public class ReportResetObserver implements ActionListener {
    
    MathBuddy mb;
    ReportScreen rs;

    public ReportResetObserver(MathBuddy mb, ReportScreen rs) {
        this.mb = mb;
        this.rs = rs;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        rs.dispose();
        mb.setState(new MBOptionsState(mb));
        mb.state.update();
    }
    
}

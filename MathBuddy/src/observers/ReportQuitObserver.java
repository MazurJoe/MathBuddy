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

/**
 *
 * @author John Rosser
 */
public class ReportQuitObserver implements ActionListener {
    
    ReportScreen rs;
    MathBuddy mb;
    
    public ReportQuitObserver(ReportScreen rs, MathBuddy mb) {
        this.mb = mb;
        this.rs = rs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.rs.dispose();
        System.exit(0);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import frontEndUI.MBOptionsMenu;
import humans.OptionsBundle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mathbuddy.MathBuddy;
import mbState.MBProblemsState;

/**
 *
 * @author John Rosser
 */
public class OKObserver implements ActionListener {
    
    private MBOptionsMenu menu;
    private MathBuddy mb;
    
    public OKObserver(MBOptionsMenu menu, MathBuddy mb) {
        this.menu = menu;
        this.mb = mb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        OptionsBundle ob = menu.buildOptions();
        menu.setVisible(false);
        mb.setState(new MBProblemsState(mb));
        mb.state.update();
    }
    
}

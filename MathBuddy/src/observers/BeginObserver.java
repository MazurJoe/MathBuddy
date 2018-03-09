/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import mathbuddy.MathBuddy;
import mbState.MBOptionsState;

/**
 *
 * @author John Rosser
 */
public class BeginObserver implements ActionListener {
    
    private JFrame menu;
    private JTextField IDField;
    private MathBuddy mb;
    
    public BeginObserver(JFrame menu, JTextField field, MathBuddy mb){
        this.IDField = field;
        this.menu = menu;
        this.mb = mb;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Find the student = IDField.getText();
        //Do stuff
        //Advance the State
        menu.setVisible(false);
        mb.setState(new MBOptionsState(mb));
        mb.state.update();
    }
    
}
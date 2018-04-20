/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import frontEndUI.WelcomePopup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JTextField;
import mathbuddy.MathBuddy;
import mbState.MBOptionsState;
import saverAndReader.Reader;
import saverAndReader.SGLSaver;
import saverAndReader.Saver;

/**
 *
 * @author John Rosser
 */
public class BeginObserver implements ActionListener {
    
    private JFrame menu;
    private JTextField IDField;
    private MathBuddy mb;
    private Reader reader;
    private Saver saver;
    
    public BeginObserver(JFrame menu, JTextField field, MathBuddy mb){
        this.IDField = field;
        this.menu = menu;
        this.mb = mb;
        this.reader = new Reader();
        this.saver = new Saver("C:\\mathbuddy");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Find the student = IDField.getText();
        //Do stuff
        //Advance the State
        String name = this.IDField.getText();
        
        try{
            saver.newUser("SGL", name);
            SGLSaver currSGL = new SGLSaver(name,"C:\\mathbuddy");
            currSGL.login();
            WelcomePopup wp = new WelcomePopup(menu, true, currSGL.getStudentUserName(), currSGL.getLoginCount());
            menu.dispose();
            wp.setVisible(true);
        } catch (Exception ex) {System.out.println("Something happened trying to make a new user");}
        
        mb.setState(new MBOptionsState(mb));
        mb.state.update();
    }
    
}

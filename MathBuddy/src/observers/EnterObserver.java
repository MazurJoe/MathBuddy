/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;

/**
 *
 * @author John Rosser
 */
public class EnterObserver implements KeyListener{
    
    JButton butt;
    
    public EnterObserver(JButton butt){
        this.butt = butt;
    }
    

    @Override
    public void keyTyped(KeyEvent e) {    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            butt.doClick();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {    }
    
}

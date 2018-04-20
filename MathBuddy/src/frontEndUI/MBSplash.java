/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEndUI;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import mathbuddy.MathBuddy;
import observers.BeginObserver;
import observers.EnterObserver;

/**
 *
 * @author John Rosser
 */
public class MBSplash extends javax.swing.JFrame {

    ActionListener al;
    KeyListener kl;
    MathBuddy mb;
    
    
    /**
     * Creates new form MBSplash
     */
    public MBSplash(MathBuddy mb) {
        initComponents();
        this.mb = mb;
        this.al = new BeginObserver(this, IDField, mb);
        this.kl = new EnterObserver(beginButton);
        this.beginButton.addActionListener(al);
        this.IDField.addKeyListener(kl);
    }
    
    public String getName(){
        return this.IDField.getText();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        beginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MathBuddy!");
        setName("MBSplash"); // NOI18N
        setResizable(false);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Name:");
        jLabel1.setFocusable(false);

        beginButton.setText("Begin!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(beginButton)
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beginButton))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDField;
    private javax.swing.JButton beginButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

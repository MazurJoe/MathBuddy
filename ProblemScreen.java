/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontEndUI;

import humans.OptionsBundle;
import java.awt.event.ActionListener;
import mathbuddy.DoubleAddition;
import mathbuddy.DoubleDivision;
import mathbuddy.DoubleMultiplication;
import mathbuddy.DoubleSubtraction;
import mathbuddy.IntegerAddition;
import mathbuddy.IntegerDivision;
import mathbuddy.IntegerMultiplication;
import mathbuddy.IntegerSubtraction;
import mathbuddy.MathBuddy;
import mbtimer.MBStopWatch;
import observers.ProblemsQuitObserver;
import observers.ProblemsSubmitObserver;

/**
 *
 * @author John Rosser
 */
public class ProblemScreen extends javax.swing.JFrame {
    
    int numCorrect;
    ActionListener quit,submit;
    MathBuddy mb;
    MBStopWatch sw;
    OptionsBundle ob;
    String[] problems;
    double[] answers;

    /**
     * Creates new form ProblemScreen
     */
    public ProblemScreen(MathBuddy mb) {
        initComponents();
        this.mb = mb;
        this.quit = new ProblemsQuitObserver(this,mb);
        this.submit = new ProblemsSubmitObserver(this,mb);
        this.submitButton.addActionListener(submit);
        this.quitButton.addActionListener(quit);
        this.problems = new String[10];
        this.answers = new double[10];
        numCorrect = 0;
    }

    public void setObAndMakeProblems(OptionsBundle ob) {
        this.ob = ob;
        if(ob.isIntegersOnly()) {
            if(ob.getOperation().equals("Addition")){
                IntegerAddition obj = new IntegerAddition(ob.getMin(), ob.getMax());
                problems = obj.listOfProblems;
                for(int i = 0; i < obj.listOfAnswers.length; i++){
                    answers[i] = obj.listOfAnswers[i];
                }
                //answers = obj.listOfAnswers;
                this.jTextField2.setText(problems[0]);
                return;
            }
            if(ob.getOperation().equals("Subtraction")){
                IntegerSubtraction obj = new IntegerSubtraction(ob.getMin(), ob.getMax());
                problems = obj.listOfProblems;
                for(int i = 0; i < obj.listOfAnswers.length; i++){
                    answers[i] = obj.listOfAnswers[i];
                }
                this.jTextField2.setText(problems[0]);
                return;
            }
            if(ob.getOperation().equals("Multiplication")){
                IntegerMultiplication obj = new IntegerMultiplication(ob.getMin(), ob.getMax());
                problems = obj.listOfProblems;
                for(int i = 0; i < obj.listOfAnswers.length; i++){
                    answers[i] = obj.listOfAnswers[i];
                }
                this.jTextField2.setText(problems[0]);
                return;
            }
            if(ob.getOperation().equals("Division")){
                IntegerDivision obj = new IntegerDivision(ob.getMin(), ob.getMax());
                problems = obj.listOfProblems;
                for(int i = 0; i < obj.listOfAnswers.length; i++){
                    answers[i] = obj.listOfAnswers[i];
                }
                this.jTextField2.setText(problems[0]);
                return;
            }                        
        }
        else {
            if(ob.getOperation().equals("Addition")){                
                DoubleAddition obj = new DoubleAddition(ob.getMin(), ob.getMax(),2);
                problems = obj.listOfProblems;
                for(int i = 0; i < obj.listOfAnswers.length; i++){
                    answers[i] = obj.listOfAnswers[i];
                }
                this.jTextField2.setText(problems[0]);
                return;
            }
            if(ob.getOperation().equals("Subtraction")){
                DoubleSubtraction obj = new DoubleSubtraction(ob.getMin(), ob.getMax(),2);
                problems = obj.listOfProblems;
                for(int i = 0; i < obj.listOfAnswers.length; i++){
                    answers[i] = obj.listOfAnswers[i];
                }
                this.jTextField2.setText(problems[0]);
                return;
            }
            if(ob.getOperation().equals("Multiplication")){
                DoubleMultiplication obj = new DoubleMultiplication(ob.getMin(), ob.getMax(), 2);
                problems = obj.listOfProblems;
                for(int i = 0; i < obj.listOfAnswers.length; i++){
                    answers[i] = obj.listOfAnswers[i];
                }
                this.jTextField2.setText(problems[0]);
                return;
            }
            if(ob.getOperation().equals("Division")){
                DoubleDivision obj = new DoubleDivision(ob.getMin(), ob.getMax(), 2);
                problems = obj.listOfProblems;
                for(int i = 0; i < obj.listOfAnswers.length; i++){
                    answers[i] = obj.listOfAnswers[i];
                }
                this.jTextField2.setText(problems[0]);
                return;
            }  
        }
    }
    
    public void updateProblem(int k){
        this.jTextField2.setText(problems[k]);
    }
    
    public void noMoreProblems(){
        this.jTextField2.setText("All done");
    }

    public String[] getProblems() {
        return problems;
    }

    public double getCurrAnswers(int counter) {
        return answers[counter];
    }
    
    public void clearAnswer(){
        this.answer.setText("");
    }
    
    public void resetFocus(){
        this.answer.requestFocus();
    }

    public int getNumCorrect() {
        return numCorrect;
    }

    public void setNumCorrect() {
        this.numCorrect++;
    }
    
    public double getAnswer(){
        return Double.parseDouble(this.answer.getText());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayArea = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        answer = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Math Buddy!");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(800, 580));
        setResizable(false);
        getContentPane().setLayout(null);

        displayArea.setOpaque(false);

        javax.swing.GroupLayout displayAreaLayout = new javax.swing.GroupLayout(displayArea);
        displayArea.setLayout(displayAreaLayout);
        displayAreaLayout.setHorizontalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayAreaLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        displayAreaLayout.setVerticalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayAreaLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        getContentPane().add(displayArea);
        displayArea.setBounds(180, 70, 440, 130);
        getContentPane().add(answer);
        answer.setBounds(600, 380, 133, 22);

        submitButton.setText("Submit");
        getContentPane().add(submitButton);
        submitButton.setBounds(493, 380, 90, 25);

        quitButton.setText("Quit");
        getContentPane().add(quitButton);
        quitButton.setBounds(663, 490, 100, 25);

        jTextField1.setFocusable(false);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(50, 380, 109, 22);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontEndUI/Mathbuddy Problem Background.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private javax.swing.JPanel displayArea;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}

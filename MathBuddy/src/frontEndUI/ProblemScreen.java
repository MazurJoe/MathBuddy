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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Math Buddy!");
        setAlwaysOnTop(true);
        setResizable(false);

        displayArea.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

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
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        submitButton.setText("Submit");

        quitButton.setText("Quit");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Answer:");

        jTextField1.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(displayArea, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 295, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(quitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(submitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(quitButton)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField answer;
    private javax.swing.JPanel displayArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}

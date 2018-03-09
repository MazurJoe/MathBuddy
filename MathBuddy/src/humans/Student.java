/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humans;

/**
 *
 * @author John Rosser
 */
public class Student extends Human{
    
    private boolean teacher;
    private int studentID;
    
    public Student() {
        teacher = false;
        //do some stuff to get a uniqueID
        //this.studentID = ID;
    }

    public int getStudentID() {
        return studentID;
    }
    
    
    
    
    
}

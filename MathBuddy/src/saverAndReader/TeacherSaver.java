/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saverAndReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Reese
 */
public class TeacherSaver {
    /**
     * The class that this saver is for
     */
    private String className;
    
    /**
     * The Path to directory
     */
    protected String dir;
    
    /**
     * the userName of the teacher
     */
    protected String teacherUserName;
    
    
    /**
     * the string of the username of a student that teacher selected to change the data of
     */
    private String studentUserName;
    
    
    public TeacherSaver(String userName, String dir) {
        teacherUserName = userName;
        this.dir = dir;
        className =  studentUserName = null;
        
    }
    
    public void selectClass(String className) {
        this.className = className;
    }
    
    public void selectStudent(String studentUserName) {
        this.studentUserName = studentUserName;
    }
    
    public void createClass(String className, String subjectName) 
    {
        Saver save = new Saver(dir);
        save.createClassroom(className, subjectName, teacherUserName, "teacher");
    }
    
    
    /*
    ----------------------------------------------------------------------------
    The following are account and class management fot the teacher user
    ---------------------------------------------------------------------------
    */
    
    
    /**
     * deletes the class that was selected
     * a class must be selected in order for this to do anything
     */
    public void deleteClass() 
    {
        if(className != null) {
            Saver save = new Saver(dir);
            save.deleteClass(className, "teacher", teacherUserName);  
        }
    }
    
    /**
     * puts selected student in class
     */
    public void putStudentInClass()
    {
        if(studentUserName !=null) {
            Saver save = new Saver(dir);
            save.addtoClass(studentUserName, className, teacherUserName);
        }
    }
    
    /**
     * puts selected student out of the class all class related data of student will be lost
     */
    public void takeStudentOutOfClass() 
    {
        if(studentUserName != null) {
            Saver save = new Saver(dir);
            save.takeOutOfClass(studentUserName, className);
        }
    }
    
    /**
     * deletes the user who's saver is pointed to
     */
    public void deleteAccount() {
        Saver save = new Saver(dir);
        save.deleteUser("teacher", teacherUserName);
    }
    
    
/*
----------------------------------------------------------------------------
    The following are methods relating to class functions of the user 
*/
    //need to make new doc in teacher and student class folder
   
   
    /**
     * returns an array list of String arrayLists. the first element of each string array list is the class name
     * the second is the subject
     * can add more to it if needed
     * @return
     * @throws FileNotFoundException 
     */
    public ArrayList<ArrayList<String>> getClassList() throws FileNotFoundException
    {
        ArrayList<ArrayList<String>> out = new ArrayList();
        
        File file = new File(dir + "\\teacher\\" + teacherUserName + "\\" + teacherUserName + ".txt");
        Scanner scan = new Scanner(file);
        scan.next();
        scan.next();
        while(scan.hasNext())
        {
            ArrayList<String> temp = new ArrayList();
            temp.add(scan.next());
            scan.next();
            temp.add(scan.next());
            out.add(temp);
        }
        return out;
    }
    
    /**
     * returns a String arrayList where each element is  the UserName of a student in the class
     * @return 
     * @throws FileNotFoundException 
     */
    public ArrayList<String> getStudentList() throws FileNotFoundException
    {
        if(className == null)
        {
            return new ArrayList(); //will give an empty array List
        }
        ArrayList<String> out = new ArrayList();
        File file = new File(dir + "\\teacher\\" + teacherUserName + "\\" + className + "\\" + className + ".txt"); 
        Scanner scan = new Scanner(file);
        scan.next();
        scan.next();
        scan.next();
        scan.next();
        while(scan.hasNext())
            out.add(scan.next());
        scan.close();
        return out;
    }
    
    
}

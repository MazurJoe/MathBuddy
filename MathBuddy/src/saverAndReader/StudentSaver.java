/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saverAndReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Reese
 */
public class StudentSaver {
    //It is assumed that the student is a valid username and all the directories exist
    protected String studentUserName;
    //will add class if progect progresses to that.
    private String className;
    protected String dir;
    
    
    
    public StudentSaver(String userName, String dir){
        
        studentUserName = userName;
        this.className = null;
        this.dir = dir;
    }
    
    /**
     * changes the className variable to the given string
     * @param className 
     */
    public void selectClass(String className) {
        this.className = className;
    }
    
 /*
    ---------------------------------------------------------------------------
    the following are basic account fucntions to make, crate, add ect that the 
    user can use.
 */
    
    /**
     * adds student to the class specified
     */
    public void joinClass() {
        Saver save = new Saver(dir);
        save.addtoClass(studentUserName, className, Reader.getTeacherAndSub(className, dir)[0]);
    }
    
    
    /**
     * takes the student out of the selected class
     */
    public void leaveClass() {
        Saver save = new Saver(dir);
        save.takeOutOfClass(studentUserName, className);
    }
    
    public void deleteAccount() {
        Saver save = new Saver(dir);
        save.deleteUser("student", studentUserName);
    }
    
/*
----------------------------------------------------------------------------
the following are actions that can be performed when user has selected a class
    that is not null
*/
    
    
    /**
     * saves the info for the problem generator to call up the same problem later if asked to by the user
     * see the student reader to see how the inputed info is made
     * will assume that typeofarray is double or int for now
     * @param problemType this is the type of problem like solve for x, addition, ect. 
     * @param nums The important numbers that are needed to created that type of problem
     */
    public void saveProblem(String problem) throws FileNotFoundException
    {
        File file = new File(dir + "\\student\\" + studentUserName + "\\" + className + "\\" + "savedProbs.txt");
        Scanner read = new Scanner(file);
        String holder = "";
        int problemsInFile = read.nextInt();
        for(int i = 0; i < problemsInFile; i++)
        {
            holder += read.next() + " ";
        }
        read.close();
        holder = (problemsInFile+1) + " " + holder;
         File userData = new File(dir + "\\student\\" + studentUserName + "\\" +className + "\\savedProbs.txt");
        PrintWriter userFile = new PrintWriter(userData);
        userFile.print(holder + " " + problem);
        userFile.close();
    }
    
    public ArrayList<String> getSavedProblems() throws FileNotFoundException {
        File file = new File(dir + "\\student\\" + studentUserName + "\\" + className + "\\" + "savedProbs.txt");
        Scanner read = new Scanner(file);
        ArrayList<String> out = new ArrayList();
        int numOfProblems = read.nextInt();
        for(int i = 0; i < numOfProblems; i++) {
            out.add(read.next());
        }
        read.close();
        return out;
    }
    
    
    //----------------------------------------

   
    
  
  /**
     * returns an array list of String arrayLists. the first element of each string array list is the class name
     * the second is the teacher name
     * the third is the subject
     * can add more to it if needed
     * @return
     * @throws FileNotFoundException 
     */
   public ArrayList<ArrayList<String>> getClassList() throws FileNotFoundException
    {
        ArrayList<ArrayList<String>> out = new ArrayList();
        File file = new File(dir + "\\student\\" + studentUserName + "\\" + studentUserName + ".txt");
        Scanner scan = new Scanner(file);
        scan.next();
        scan.next();
        while(scan.hasNext())
        {
            ArrayList<String> temp = new ArrayList();
            temp.add(scan.next());
            temp.add(scan.next());
            temp.add(scan.next());
            out.add(temp);
        }
        return out;
    }
   
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
}

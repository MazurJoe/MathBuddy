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
public class SGLSaver {
    protected String studentUserName;
    //will add class if progect progresses to that.
    private String className;
    protected String dir;
    
    
    public SGLSaver(String userName, String dir){
        
        studentUserName = userName;
        this.className = null;
        this.dir = dir;
    }
    
    public void selectClass(String className) {
        this.className = className;
    }
    
    public void login() throws FileNotFoundException{
        File file = new File(dir + "\\SGL\\" + studentUserName + "\\loginCount.txt");
        Scanner s = new Scanner(file);
        int login = s.nextInt();
        login++;
        s.close();
        PrintWriter loginCount = new PrintWriter(file);
                    loginCount.print(login);
                    loginCount.close();
    }

    public String getStudentUserName() {
        return studentUserName;
    }
    
    public int getLoginCount() throws FileNotFoundException{
        File file = new File(dir + "\\SGL\\" + studentUserName + "\\loginCount.txt");
        Scanner s = new Scanner(file);
        int login = s.nextInt();
        s.close();
        return login;
    }
    
    public void createClass(String className, String subjectName) 
    {
        Saver save = new Saver(dir);
        save.createClassroom(className, subjectName, studentUserName, "SGL");
    }
    
    public void deleteClass() 
    {
        if(className != null) {
            Saver save = new Saver(dir);
            save.deleteClass(className, "SGL", studentUserName);  
        }
    }
    
    public void deleteAccount() {
        Saver save = new Saver(dir);
        save.deleteUser("SGL", studentUserName);
    }
    
    public void saveProblem(String problem) throws FileNotFoundException {
         File file = new File(dir + "\\SGL\\" + studentUserName + "\\" + className + "\\" + "savedProbs.txt");
        Scanner read = new Scanner(file);
        String holder = "";
        int problemsInFile = read.nextInt();
        for(int i = 0; i < problemsInFile; i++)
        {
            holder += read.next() + " ";
        }
        read.close();
        holder = (problemsInFile+1) + " " + holder;
         File userData = new File(dir + "\\SGL\\" + studentUserName + "\\" +className + "\\savedProbs.txt");
        PrintWriter userFile = new PrintWriter(userData);
        userFile.print(holder + " " + problem);
        userFile.close();
    }
    
    public ArrayList<String> getSavedProblems() throws FileNotFoundException {
        File file = new File(dir + "\\SGL\\" + studentUserName + "\\" + className + "\\" + "savedProbs.txt");
        Scanner read = new Scanner(file);
        ArrayList<String> out = new ArrayList();
        int numOfProblems = read.nextInt();
        for(int i = 0; i < numOfProblems; i++) {
            out.add(read.next());
        }
        read.close();
        return out;
    }
    
   
    public ArrayList<ArrayList<String>> getClassList() throws FileNotFoundException
    {
        ArrayList<ArrayList<String>> out = new ArrayList();
        File file = new File(dir + "\\SGL\\" + studentUserName + "\\" + studentUserName + ".txt");
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

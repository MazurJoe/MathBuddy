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
 * The saver class will make, and edit text files that is the user's data
 * the saver will rely on the reader class to pull information from the files to make decisions concerning saving data and to hold data so new data can be written.
 * @author Reese
 */
public class Saver
{
    /**
     * this is a variable that is the full path to the directory folder.
     * should be set as a constant/final once path to director is chosen
     * directory should have the following 4 folder titles:
     * SGL
     * student
     * teacher
     * misc
     */
    private String PathToDir;
    
    
    public  void newUser(String userType,String userName)
    {
        
        if(!Reader.doesUserExistAlready(userType, userName, PathToDir))
        {
            File newfolder = new File(PathToDir + "\\" + userType + "\\" + userName);
            newfolder.mkdir();
            PrintWriter userFile = new PrintWriter(PathToDir + "\\" + userType + "\\" + userName + "\\" + userName + ".txt");
            userFile.println(userName + " " + userType);
            userFile.close();
            File nameList = new File(PathToDir + "\\" + userType + "\\userNames.txt");
            String names = Reader.getFile(nameList);
            names += userName;
            PrintWriter newList = new PrintWriter(nameList);
            newList.print(names);
            newList.close();
        }
    }
    
    
    /**
     * creates a new valid class for student and SGL's to be able to join. 
     * Only teachers and SGL should be able to call this method
     * if user is a teacher the classname and data will be added to a txt doc in misc folder
     * if user is just a SGL misc will not be edited the class will just be in their own personal file
     * @param className the name of the class to be created
     * @param subject the subject the class will be
     * @param createdBy the name of person who created it will be SGL or teacher
     */
    public void createClassroom(String className, String subject, String createdBy, String createdByType)
    {
        if(Reader.doesUserExistAlready(createdByType, createdBy, PathToDir) && !(Reader.doesClassAlreadyExist(className, createdByType, createdBy, PathToDir)))
        {
            if(createdByType.equals("teacher"))
            { 
                    File classRoster = new File(PathToDir + "\\misc\\classes.txt");
                    String list = Reader.getFile(classRoster);
                    list += className + " " + subject + " " + createdBy;
                    PrintWriter w = new PrintWriter(classRoster);
                    w.print(list);
                    w.close();
            }
            File newFilePath = new File(PathToDir + "\\" + createdByType + "\\" + createdBy + "\\" + className);
            newFilePath.mkdir();
            PrintWriter k = new PrintWriter(PathToDir + "\\teacher\\" + createdBy + "\\" + className + "\\" + className + ".txt");
            k.println(createdBy + " " + createdByType + " " + className + " " + subject);
            k.close();
            File userData = new File(PathToDir + "\\" + createdByType + "\\" + createdBy + "\\"  + createdBy + ".txt" );
            String s = Reader.getFile(userData);
            s += className + " " + createdBy + " " + subject;
            PrintWriter t = new PrintWriter(userData);
            t.print(s);
            t.close();
        }
    }
    
            
            
public void addtoClass(String userName, String className, String teacherName)
{
    if((Reader.doesUserExistAlready("student", userName, PathToDir)) && Reader.doesClassAlreadyExist(className, "teacher", userName, PathToDir))
    {
        //here is where you would do a "is class open or does there need to be a teacher check code
        if(!Reader.isStudentInClass(userName, className, PathToDir))
        {
            File classFolder = new File(PathToDir + "\\student\\" + userName + "\\" + className );
            classFolder.mkdir();
            String[] teacherSub = Reader.getTeacherAndSub(className);
            PrintWriter classFile = new PrintWriter(PathToDir + "\\student\\" + userName + "\\" + className + "\\" + className + "txt");
            classFile.print(userName + " student " + className + " " + teacherSub[0] + " " + teacherSub[1]);
            //where to add additonal keys for saving student data
            classFile.close();
            File userData = new File(PathToDir + "\\student\\" + userName + "\\" + userName + ".txt"); 
            String data = Reader.getFile(userData);
            data+= " " + className + " " + teacherSub[0] + " " + teacherSub[1];
            PrintWriter userFile = new PrintWriter(userData);
            userFile.print(data);
            userFile.close();
            File teacherClassFile = new File(PathToDir + "\\teacher\\" + teacherSub[0] + "\\" + className + "\\" + className + ".txt");
            String classdata = Reader.getFile(teacherClassFile);
            classdata += " " + userName;
            PrintWriter teacherFile = new PrintWriter(teacherClassFile);
            teacherFile.print(classdata);
            teacherFile.close();
        }
    }
}

public void takeOutOfClass(String userName,String className)
{
    if(Reader.doesUserExistAlready("student", userName, PathToDir) && Reader.doesClassAlreadyExist(className, "teacher", userName, PathToDir))
    {
        if(Reader.isStudentInClass(userName, className, PathToDir))
        {
            File userFile = new File(PathToDir + "\\student\\" + userName + "\\" + userName + ".txt");
            String editedData = Reader.removeItem(userFile, true, 2, className);
            PrintWriter newUserFile = new PrintWriter(userFile);
            newUserFile.print(editedData);
            newUserFile.close();
            File studentClassData = new File(PathToDir + "\\student\\" + userName + "\\" + className + "\\" + className + ".txt");
            //may need to add more files to be deleted
            File studentClassFolder = new File(PathToDir + "\\student\\" + userName + "\\" + className);
            studentClassData.delete();
            studentClassFolder.delete();
            String[] teachsub = Reader.getTeacherAndSub(className);
            File teacherClassFile = new File(PathToDir + "\\teacher\\" + userName + "\\" + className + "\\" + className + ".txt");
            String editedTeachData = Reader.removeItem(teacherClassFile, true, 0, userName);
            PrintWriter newTeachFile = new PrintWriter(teacherClassFile);
            newTeachFile.print(editedTeachData);
            newTeachFile.close();     
        }
    }
}

public void deleteClass(String className, String classType, String creatorName)
{
    if(Reader.doesClassAlreadyExist(className, classType, creatorName, PathToDir))
    {
        //written before creatorName was a var
       if(classType.equals("teacher"))
       {
            String[] teachSub = Reader.getTeacherAndSub(className);
            File classRoster = new File(PathToDir + "\\misc\\classes.txt");
            String editedRoster = Reader.removeItem(classRoster, false, 2, className);
            PrintWriter classes = new PrintWriter(classRoster);
            classes.print(editedRoster);
            classes.close();
            File classFile = new File(PathToDir + "\\teacher\\" + teachSub[0] + "\\" + className +  "\\" + className + ".txt");
            ArrayList<String> students = Reader.getStudentsInClass(teacherSub[0], className, classFile);
            while(0 < students.size())
            {
                takeOutOfClass(students.remove(0), className);
            }
            //here to add more if files for class folder is added
            File classFolder = new File(PathToDir + "\\teacher\\" + teachSub[0] + "\\" + className);
            classFile.delete();
            classFolder.delete();
            File teacherFile = new File(PathToDir + "\\teacher\\" + teachSub[0] + "\\" + teachSub[0] + ".txt");
            String editedTFile = Reader.removeItem(teacherFile, true, 2, className);
            PrintWriter newTFile = new PrintWriter(teacherFile);
            newTFile.print(editedTFile);
            newTFile.close();
       }
       else if(classType.equals("SGL"))
       {
           File userFile = new File(PathToDir + "\\SGL\\" + creatorName + "\\" + creatorName + ".txt");
           String editedUserFile = Reader.removeItem(userFile, true, 2, className);
           PrintWriter newUserFile = new PrintWriter(userFile);
           newUserFile.print(editedUserFile);
           File classFolder = new File(PathToDir + "\\SGL\\" + creatorName + "\\" + className);
           File classUserFile = new File(PathToDir + "\\SGL\\" + creatorName + "\\" + className + "\\" + className + ".txt");
           //add to here if more datafiles are added
           classUserFile.delete();
           classFolder.delete();
       }
    } 
}

public void deleteUser(String userName, String userType)
{
    if(Reader.doesUserExistAlready(userType, userName, PathToDir))
    {
        File userData = new File(PathToDir + "\\" + userType + "\\" + userName + "\\" + userName + ".txt");
        ArrayList<String> classList = Reader.getStudentClassList(userName, userType, userData);
        if(userType.equals("student"))
        {
            while(0< classList.size())
                takeOutOfClass(userName, classList.remove(0));
        }
        else if(userType.equals("SGL"))
        { 
            while(0<classList.size())
                deleteClass(classList.remove(0), "SGL", userName);
        }
        else
        {
            while(0<classList.size())
                deleteClass(classList.remove(0), "teacher", userName);
        }
        File userFolder = new File(PathToDir + "\\" + userType + "\\" + userName);
        userData.delete();
        userFolder.delete();
        File userNameList = new File(PathToDir + "\\" + userType + "\\" + "userNames.txt");
        String editedUserNameList = Reader.removeItem(userNameList, false, 0, userName);
        PrintWriter newUserNameList = new PrintWriter(userNameList);
        newUserNameList.print(editedUserNameList);
        newUserNameList.close();
    }
}
    
    
    
    
}

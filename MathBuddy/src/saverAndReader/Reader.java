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



public class Reader
{
    /**
     * checks the list of already created users in dir\\userType\\userNames 
     * Every type of user needs to have a unique userName
     * @param userType the type of user you are checking to see if exits 
     * @param userName the userName to see if valid
     * @param pathToDir the file path to head of directory
     * @return 
     */
    public static boolean doesUserExistAlready(String userType, String userName, String pathToDir) throws FileNotFoundException
    {
        try
        {
            File file = new File(pathToDir + "\\" + userType + "\\userNames.txt");
            Scanner userNameFile = new Scanner(file);
            
            while(userNameFile.hasNext())
            {
                String c = userNameFile.next();
                if(c.equals(userName))
                {
                    userNameFile.close();
                    return true;
                }
            }
            userNameFile.close();
            return false;
        }
         catch(Exception e)
        {
            System.out.print(e);   
           return false;
        }
    }
    
    /**
     * checks to see if Class already exists to make sure duplicate classes are not made
     * @param className must be unique for teacher and SGL type classes
     * @param userType type of class it is. teacher class allows students to join. SGL is just one student
     * @param userName the user that is creating the class
     * @param dir folder path to directory
     * @return 
     */
    public static boolean doesClassAlreadyExist(String className, String userType, String userName, String dir)
    {
        try
        {
            if(userType.equals("teacher"))
            {
                File classList = new File(dir + "\\misc\\classes.txt");
                Scanner scan = new Scanner(classList);
                while (scan.hasNext())
                    if(className.equals(scan.next()))
                    {
                            scan.close();
                            return true;
                    }
                    else
                    {
                        scan.next();
                        scan.next();
                    }
                scan.close();
                return false;
            }
            if(userType.equals("SGL"))
            {
                File classList = new File(dir + "\\SGL\\" + userName + "\\" + userName + ".txt");
                Scanner scan = new Scanner(classList);
                scan.next();
                scan.next();
                while(scan.hasNext())
                {
                    if(className.equals(scan.next()))
                    {
                        scan.close();
                        return true;
                    }
                    else
                    {
                        scan.next();
                        scan.next();
                    }
                }
                scan.close();
                return false;
            }
            return false;
        }
         catch(Exception e)
        {
            System.out.print(e);   
            return false;
        }
    }
    
    /**
     * checks to see if student users are in a teacher classroom by looking at the userfile in the user's folder
     * @param userName 
     * @param className
     * @param PathToDir
     * @return 
     */
    public static boolean isStudentInClass(String userName, String className, String PathToDir)
    {
        try
        {
            File userData = new File(PathToDir + "\\student\\" + userName + "\\" + userName + ".txt");
            Scanner scan = new Scanner(userData);
            scan.next();
            scan.next();
            while(scan.hasNext())
                if(scan.next().equals(className))
                {
                    scan.close();
                    return true;
                }
                else
                {
                    scan.next();
                    scan.next();
                }
            scan.close();
            return false;
        }
         catch(Exception e)
        {
            System.out.print(e); 
            return false;
        }
    }
    
    
    /**
     * 
     * @param className name of class you want the teacher and subject of
     * @param dir the directory head
     * @return a size two string with the 0 position having the name of the teacher and the 2nd the name of the subject
     */
    public static String[] getTeacherAndSub(String className, String dir)
    {
        try
        {
            File classList = new File(dir + "\\misc\\classes.txt");
            Scanner scan = new Scanner(classList);
            while (scan.hasNext())
                    if(className.equals(scan.next()))
                    {
                        String[] out = new String[2];
                        out[1] = scan.next();
                        out[0] = scan.next();
                        scan.close();
                        return out;
                    }
                    else
                    {
                        scan.next();
                        scan.next();
                    }
                scan.close();
                String[] out = {"techer not Found", "subject not Found"};
                return out;
        }
         catch(Exception e)
        {
            System.out.print(e); 
            return new String[5];
        }
        
    }
    
    /**
     * returns a string that is all of the text of the incoming file
     * @param file
     * @return 
     */
    public static String getFile(File file)
    {
        try
        {
            Scanner scan = new Scanner(file);
            String out = "";
            while (scan.hasNext())
                out+= scan.next() + " ";
            scan.close();
            return out;
        }
         catch(Exception e)
        {
            System.out.print(e); 
            return "fileNotFond";
        }
    }
    
    /**
     * 
     * @param file the file to be scanned and removed from
     * @param headerSkips the number of items that are ahead of start of data we are interested in
     * also the number of next() methods needed to get to the first start of data
     * @param skipsNeeded the number of data items that are for the same item and grouped like className, Teacher's name of the class, subject, ect
     * @param toBeRemoved the String that will be looked for and it and the data related to it will be removed from the out string
     * @return a string that does not have the toBeRemoved data and the data that is related to it
     */
    public static String removeItem(File file,int headerSkips, int skipsNeeded, String toBeRemoved)
    {
        try
        {
            Scanner scan = new Scanner(file);
            String editedData ="";
            for(int i = 0; i < headerSkips; i++)
                editedData += scan.next() + " ";
            String beingCompared = "";
            while(scan.hasNext())
            {
                beingCompared = scan.next();
                if(toBeRemoved.equals(beingCompared))
                    for(int i = 0; i < skipsNeeded; i++)
                    scan.next();
                else
                {
                    editedData += beingCompared + " ";
                    for(int i = 0; i < skipsNeeded; i++)
                        editedData += scan.next() + " ";
                }
            }
            while(scan.hasNext())
                for(int i = 0; i < skipsNeeded + 1; i++)
                        editedData += scan.next() + " ";
            scan.close();
            return editedData;
        }
         catch(Exception e)
        {
            System.out.print(e); 
            return "nosuchFile";
        }
    }
    
    
   /**
    * Returns a String ArrayList where each element is a name of a student in the specified class
    * @param TeacherName name of teacher of class
    * @param className name of class
    * @param classFile the class file that has a list of the students in it
    * @return An array list that contains all of the students in the class
    */
    public static ArrayList<String> getStudentsInClass(String TeacherName, String className, File classFile)
    {
        try
        {
            Scanner scan = new Scanner(classFile);
            scan.next();
            scan.next();
            scan.next();
            scan.next();
            ArrayList<String> out = new ArrayList<String>();
            while(scan.hasNext())
                out.add(scan.next());
            scan.close();
            return out;
        }
         catch(Exception e)
        {
            System.out.print(e); 
            return new ArrayList(0);
        }
    }
    /**
     * Returns all of the classes that a SGL or student is in
     * @param userName the username of the user
     * @param userType the type of user
     * @param classList the file that points to the class list of the user the dir\\usertype\\username\\username.txt doc
     * @return a string ArrayList where every element is the classname of a class that the user is in
     */
    public static ArrayList<String> getStudentClassList(String userName, String userType, File classList)
    {
        try
        {
            Scanner scan = new Scanner(classList);
            scan.next();
            scan.next();
            ArrayList<String> out = new ArrayList<String>();
            while(scan.hasNext())
            {
               out.add(scan.next());
               scan.next();
               scan.next();
            }
            scan.close();
            return out;
        }
         catch(Exception e)
        {
            System.out.print(e); 
            return new ArrayList(0);
        }
            
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

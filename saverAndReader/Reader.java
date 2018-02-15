/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathbuddysaverandreader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class Reader
{
    private String pathToDir;
 
    
    Reader(String dir)
    {
        pathToDir = dir;
    }
    
    public static boolean doesUserExistAlready(String userType, String userName, String pathToDir)
    {
        Scanner userNameFile = new Scanner(pathToDir + "\\" + userType + "\\userNames.txt");
        userNameFile.useDelimiter(" ");
        while(userNameFile.hasNext())
            if(userNameFile.next().equals(userName))
            {
                userNameFile.close();
                return true;
            }
        userNameFile.close();
        return false;
    }
    
    public static boolean doesClassAlreadyExist(String className, String userType, String userName, String dir)
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
            scan.nextLine();
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
    
    
    public static boolean isStudentInClass(String userName, String className, String PathToDir)
    {
        File userData = new File(PathToDir + "\\student\\" + userName + "\\" + userName + ".txt");
        Scanner scan = new Scanner(userData);
        scan.nextLine();
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
    
    public static String[] getTeacherAndSub(String className)
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
    public static String getFile(File file)
    {
        Scanner scan = new Scanner(file);
        String out = "";
        while (scan.hasNext())
            out+= scan.next() + " ";
        scan.close();
        return out;
    }
    
    public static String removeItem(File file, boolean header, int skipsNeeded, String toBeRemoved)
    {
        Scanner scan = new Scanner(file);
        String editedData ="";
        if(header)
        editedData += scan.nextLine() + "\n";
        String beingCompared ="";
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
    
    
    //combine the next two methods please
    public static ArrayList<String> getStudentsInClass(String TeacherName, String className, File classFile)
    {
        Scanner scan = new Scanner(classFile);
        scan.nextLine();
        ArrayList<String> out = new ArrayList<String>();
        while(scan.hasNext())
            out.add(scan.next());
        return out;
    }
    
    public static ArrayList<String> getStudentClassList(String userName, String userType, File classList)
    {
        Scanner scan = new Scanner(classList);
        scan.nextLine();
        ArrayList<String> out = new ArrayList<String>();
        while(scan.hasNext())
        {
           out.add(scan.next());
           scan.next();
           scan.next();
        }
        return out;
            
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

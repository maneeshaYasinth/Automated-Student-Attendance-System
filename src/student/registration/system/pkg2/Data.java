/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.registration.system.pkg2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Data {
    //Encapsulation
    private static int studentCount,lecturerCount,userCount;
    private static Student[] studentArray = new Student[50];
    private static Lecturer[] lecturerArray = new Lecturer[10];
    private static User[] userLoginArray = new User[5];	
    
    //Getters
    public static User[] getUserArray(){
        return userLoginArray;
    }
    
    //Setters
    public static void addUserAccount(String userName,String password){
        for (int i = 0; i < userLoginArray.length; i++) {
            if(userLoginArray[i] == null){
                userLoginArray[i] = new User(userName,password);
            } 
        }
        addUserData(new User(userName,password));
    }
    public static void addStudent(Student student){
        if (isArrayFull(studentArray )) studentArray[studentCount++] = student;        
        if( ! addStudentData(student) ) JOptionPane.showMessageDialog(null, "File Writing Error", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void addLecturer(Lecturer lecturer){
        if (isArrayFull(lecturerArray )) lecturerArray[lecturerCount++] = lecturer;        
        if( ! addLecturerData(lecturer) ) JOptionPane.showMessageDialog(null, "File Writing Error", "Error", JOptionPane.ERROR_MESSAGE);
    }
    public static void removeStudent(Student student){
        
    }
    //Overload Methods
    public static void resetArray(Person[] personArray){        
        int count=0;
        for(Person person : personArray){
            if( person != null) count++;
        }
        Person[] tempPersonArray = new Person[count];
        for (Person person : personArray) {
            if ( person != null) {
                tempPersonArray[count++] = person;
            }
        }
        
        /*
        Person[] tempPersonArray = null;
        int count=0;
        for(Person person : personArray){
            if ( person != null) tempPersonArray[count++] = person;
        }
        */
    }
    public static void resetArray(User[] userArray){
        int count=0;
        for(User user : userArray){
            if( user != null) count++;
        }
        User[] tempUserArray = new User[count];
        for (User user : userArray) {
            if ( user != null) {
                tempUserArray[count++] = user;
            }
        }
    }
    //Overload Methods
    public static void extendArray(Student[] array){
        Student[] tempArray=new Student[array.length+(int)(array.length*0.5)];
        for (int i = 0; i < array.length; i++)
        {
                if(array[i] != null ) tempArray[i] = array[i];
                else continue;
        }	
        studentArray = tempArray;
    }
    public static void extendArray(Lecturer[] array){
        Lecturer[] tempArray=new Lecturer[array.length+(int)(array.length*0.5)];
        for (int i = 0; i < array.length; i++)
        {
                if(array[i] != null ) tempArray[i] = array[i];
                else continue;
        }	
        lecturerArray = tempArray;
    }
    public static void extendArray(User[] array){
        User[] tempArray=new User[array.length+(int)(array.length*0.5)];
        for (int i = 0; i < array.length; i++)
        {
                if(array[i] != null ) tempArray[i] = array[i];
                else continue;
        }	
        userLoginArray  = tempArray;
    }
    
    //Checkers
    public static boolean isArrayFull(Student[] array){
        if(array[array.length-1] != null) extendArray(array);
        return array[array.length-1] != null;
            
    }
    public static boolean isArrayFull(Lecturer[] array){
        if(array[array.length-1] != null)extendArray(array);
        return array[array.length-1] != null;
            
    }
    public static boolean isArrayFull(User[] array){
        if(array[array.length-1] != null)extendArray(array);
        return array[array.length-1] != null;
    }
    
    public static boolean validatePerson(String universityId){
        //200216400676
        //123456789v
        //return (nic.length()== 12 && nic.matches("d++")) || (nic.length() == 10 && nic.substring(0,9).matches("d++"))? true : false;
        return true;
    }
    
    //File Handling
    public static boolean addStudentData(Student student){
        File studentFile = new File("Students.txt");
        try{
            if( !studentFile.exists() ) studentFile.createNewFile();
        }catch(IOException e){
            return false;
        }
        try{
            FileWriter studentWriter = new FileWriter("Students.txt",true); 
            PrintWriter printWriter = new PrintWriter(studentWriter);
            
            printWriter.println(student.fullName + "," + student.universityId);
            printWriter.close();
            studentWriter.close();            
        }catch(IOException e){
          return false;
        }
        return true;  
    }
    public static boolean addLecturerData(Lecturer lecturer){
        File lecturerFile = new File("Lecturers.txt");
        try{
            if( !lecturerFile.exists() ) lecturerFile.createNewFile();
        }catch(IOException e){
            return false;
        }
        try{
            FileWriter lecturerWriter = new FileWriter("Lecturers.txt",true);
            PrintWriter printWriter = new PrintWriter(lecturerWriter);
            printWriter.println(lecturer.fullName + "," + lecturer.universityId);
            printWriter.close();
            lecturerWriter.close();            
        }catch(IOException e){
          return false;
        }
        return true;  
    }
    public static boolean addUserData(User user){
        File userFile = new File("Users.txt");
        
        try {
            if( !userFile.exists() ) userFile.createNewFile();
            FileWriter userWriter = new FileWriter("Users.txt",true);
            PrintWriter printWriter = new PrintWriter(userWriter);
            printWriter.println(user.getUsername()+","+user.getPassword());
            printWriter.close();
            userWriter.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
    public static boolean loadData(){
        
        
        try{
            File userFile = new File("Students.txt");
            
            Scanner scanner = new Scanner(userFile);
            int count = 0;
            /*
            while (scanner.hasNextLine()) {
                count++;
            } */
            while( studentArray.length < count){
                extendArray(studentArray);
            }
            for (int i = 0;i < count;i++){
                String dataLine = scanner.nextLine();
                String dataParts[] = dataLine.split(",");
                studentArray[i] = new Student(dataParts[0],dataParts[1]);
            }  
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "File Writing Error", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        
        return true;
    }
    public static boolean deleteData(String fileName){
        File file = new File(fileName);
        if (file.exists()) file.delete();
        else return false;
        return true;
        
    }
    
}

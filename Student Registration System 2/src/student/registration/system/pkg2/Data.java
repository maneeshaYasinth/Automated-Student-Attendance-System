/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.registration.system.pkg2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Data {
    //Encapsulation
    private static int studentCount,lecturerCount,userCount;
    private static Student[] studentArray = new Student[100];
    private static Lecturer[] lecturerArray = new Lecturer[10];
    private static User[] userLoginArray = new User[5];	
    
    //Getters
    public static User[] getUserArray(){
        //resetArray(userLoginArray);
        return Arrays.copyOf(userLoginArray, userLoginArray.length);
        //return userLoginArray;
    }
    public static Lecturer[] getLecturerArray(){
        //resetArray(lecturerArray);
        return Arrays.copyOf(lecturerArray,lecturerArray.length);
        //return lecturerArray;
    }
    public static Student[] getStudentArray(){
        //resetArray(studentArray);
        return Arrays.copyOf(studentArray,studentArray.length);
    }
    /*
    public static Student getStudent(String universityId){
        for (int i = 0; i < studentArray.length; i++) {
            if (studentArray[i] == null ) return null;
            if (studentArray[i] != null && studentArray[i].universityId == universityId) {
                studentArray[i].attendance.status = true;
                return studentArray[i];
            }
            
        }
        return null;
    }*/
    
    
    public static void addUserAccount(String userName,String password){
        for (int i = 0; i < userLoginArray.length; i++) {
            if(userLoginArray[i] == null){
                userLoginArray[i] = new User(userName,password);
            } 
        }
        writeUserData(new User(userName,password));
    }
    public static void addStudent(Student student) throws IOException{
        studentCount = getFilecount("Students.txt") - 1;
        if (isArrayFull(studentArray )) {}
        studentArray[studentCount++] = student; 
        writeStudentData(student);
        //if( ! writeStudentData(student) ) JOptionPane.showMessageDialog(null, "File Writing Error", "Error", JOptionPane.ERROR_MESSAGE);
        //System.out.println("Last  Student : "+studentArray[studentCount-1].fullName);
    }
    public static void addLecturer(Lecturer lecturer) throws IOException{
        lecturerCount = getFilecount("Lecturers.txt");
        System.out.println("Lecturer count "+lecturerCount);
        if (isArrayFull(lecturerArray )) {}
        lecturerArray[lecturerCount++] = lecturer;        
        //if( ! writeLecturerData(lecturer) ) JOptionPane.showMessageDialog(null, "File Writing Error", "Error", JOptionPane.ERROR_MESSAGE);
        writeLecturerData(lecturer);
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
    public void setArray(User[] user,int count){
        user = new User[count];        
    }
    public void setArray(Student[] user,int count){
        user = new Student[count];        
    }
    public void setArray(Lecturer[] user,int count){
        user = new Lecturer[count];        
    }
    
    //Checkers
    public static boolean isArrayFull(Student[] array){
        if(array[array.length-1] != null) extendArray(array);
        return false;
            
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
    public static boolean writeStudentData(Student student){
        File studentFile = new File("Students.txt");
        try{
            if( !studentFile.exists() ) studentFile.createNewFile();
        }catch(IOException e){
            return false;
        }
        try{
            FileWriter studentWriter = new FileWriter("Students.txt",true); 
            PrintWriter printWriter = new PrintWriter(studentWriter);
            
            printWriter.print(student.fullName + "," + student.universityId+"\n");
            printWriter.close();
            studentWriter.close();            
        }catch(IOException e){
          return false;
        }
        return true;  
    }
    public static boolean writeLecturerData(Lecturer lecturer){
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
    public static boolean writeUserData(User user){
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
    public static boolean writeReport(ArrayList<Object> arrayList,String choiceBoxValue,String courseModule,String lectureHall){
        try {
            // Create a PrintWriter object with the specified file path
            PrintWriter writer = new PrintWriter("Attendance Report.txt");
            
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);
            
            LocalTime currentTime = LocalTime.now();
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = currentTime.format(formatter2);
            

            // Using printf to write formatted content to the file
            writer.write("           Attendance Report                \n");
            writer.write("--------------------------------------------\n");
            writer.printf("%-15s %15s %-15s %n"," Date",":",formattedDate);
            writer.printf("%-15s %15s %-15s %n"," Date",":",formattedTime);
            writer.printf("%-15s %15s %-15s %n"," Course module",":",courseModule);
            writer.printf("%-15s %15s %-15s %n"," Lecturer Name",":",choiceBoxValue);
            writer.printf("%-15s %15s %-15s %n"," Lecture Hall",":",lectureHall);
            writer.write("--------------------------------------------\n");
            for (int i = 0; i < studentArray.length; i++) {
                if (studentArray[i] != null ) writer.printf("%-15s %-15s %-15s %n",studentArray[i].fullName,studentArray[i].universityId,arrayList.get(i));
            }
            // Close the writer
            writer.close();

            System.out.println("Content has been written to the file successfully.");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return true;
    }
    public static void getFilecount() throws IOException{
        String fileLine;
    
        try(BufferedReader scanner1 = new BufferedReader(new FileReader("Students.txt"))){
             int count1 = 0;
             while ((fileLine = scanner1.readLine()) != null) {
                 count1++;
        
            }
            //System.out.println(count1);
        }
    }
    public static int getFilecount(String FileName) throws IOException{
        String fileLine;
        int count1 = 0;
        try(BufferedReader scanner1 = new BufferedReader(new FileReader(FileName))){
             
             while ((fileLine = scanner1.readLine()) != null) {
                 count1++;
        
            }
            //System.out.println("Hi : "+count1);
             
        }
        return count1;
    }
    public static boolean loadData() throws FileNotFoundException, IOException{
        int num = getFilecount("Students.txt");
        String dataLine;
        if (num != 0 ){
            try(BufferedReader scanner = new BufferedReader(new FileReader("Students.txt"))){
            int count = 0;
            while ((dataLine = scanner.readLine()) != null) {
                String[] dataParts = dataLine.split(",");
                    studentArray[count++] = new Student(dataParts[0],dataParts[1]);
            }
            /*
            for(int i = 0;i<num;i++){
                System.out.println(studentArray[i].fullName+" "+studentArray[i].universityId);
            }*/
            //System.out.println(studentArray.length);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Student File Loading Error", "Error", JOptionPane.ERROR_MESSAGE);
                e.getMessage();
                return false;
            }

            num = getFilecount("Users.txt");
            if(num != 0){
                try(BufferedReader scanner = new BufferedReader(new FileReader("Users.txt"))){
            int count = 0;
            while ((dataLine = scanner.readLine()) != null) {
                String[] dataParts = dataLine.split(",");
                    userLoginArray[count++] = new User(dataParts[0],dataParts[1]);
                }
            /*
            for(int i = 0;i<num;i++){
                System.out.println(userLoginArray[i].getName()+" "+userLoginArray[i].getPassword());
            }*/
            System.out.println(userLoginArray.length);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "User File Loading Error", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            }
            
        }
        
        num = getFilecount("Lecturers.txt");
        if(num != 0){
            try(BufferedReader scanner = new BufferedReader(new FileReader("Lecturers.txt"))){
            int count = 0;
            while ((dataLine = scanner.readLine()) != null) {
                String[] dataParts = dataLine.split(",");
                    lecturerArray[count++] = new Lecturer(dataParts[0],dataParts[1]);
                }
            /*
            for(int i = 0;i<num;i++){
                System.out.println(lecturerArray[i].fullName+" "+lecturerArray[i].universityId);
            }*/
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Lecturer File Loading Error", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }  
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student.registration.system.pkg2;

import java.io.IOException;

/**
 *
 * @author HP
 */
public class StudentRegistrationSystem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Data.loadData();
        new LoginMenu().setVisible(true);
    }
    
}

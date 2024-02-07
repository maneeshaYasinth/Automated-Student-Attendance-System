import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Course Registration
        //System.out.println("Course Registration:");
        CourseRegistration registration = new CourseRegistration();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter lecturer name: ");
        String lectureName = scanner.nextLine();

        registration.registerCourse(courseName, lectureName);

        // Attendance
        //System.out.println("\nAttendance Tracking:");
        Attendance attendance = new Attendance();

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        attendance.markAttendance(studentId);

        System.out.println("Attendance count for student ID " + studentId + ": " + attendance.getAttendanceCount(studentId));

        scanner.close();
    }
}
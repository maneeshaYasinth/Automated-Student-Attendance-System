import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseRegistration registration = new CourseRegistration();

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter lecturer name: ");
        String lectureName = scanner.nextLine();

        registration.registerCourse(courseName, lectureName);

        scanner.close();
    }
}
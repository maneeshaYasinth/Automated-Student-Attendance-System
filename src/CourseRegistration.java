import java.io.FileWriter;
import java.io.IOException;


public class CourseRegistration {
    private String courseName;
    private String lectureName;
    private static final String FILE_PATH = "course_registration.txt";

    public void registerCourse(String courseName, String lectureName) {
        this.courseName = courseName;
        this.lectureName = lectureName;
        System.out.println("Registration successful for course: " + courseName + " with lecturer: " + lectureName);
        saveToFile();
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write("Course                 Lecturer Name");
            writer.write( courseName + ": " + lectureName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
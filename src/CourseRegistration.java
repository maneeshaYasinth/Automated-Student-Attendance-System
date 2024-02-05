import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CourseRegistration {
    private String courseName;
    private String lectureName;
    private static final String FILE_PATH = "course_registration.txt";


    // to see the entered course already registered
    public boolean isCourseAlreadyRegistered(String courseName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Course: " + courseName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // if the Course is not registered
        return false;
    }

    public void registerCourse(String courseName, String lectureName) {
        if (isCourseAlreadyRegistered(courseName)) {
            System.out.println("Course " + courseName + " is already registered.");
        } else {
            this.courseName = courseName;
            this.lectureName = lectureName;
            System.out.println("Registration successful for course: " + courseName + " with lecturer: " + lectureName);
            saveToFile();
        }
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write("Course: " + courseName + ", Lecturer: " + lectureName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
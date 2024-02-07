import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;


//Course registration class is to save the course number and the lecturer name in a file
class CourseRegistration {
    private String courseName;
    private String lectureName;

    //creating a file to save the course
    private static final String FILE_PATH = "course_registration.txt";


    //to check if the course is already registered
    public boolean isCourseAlreadyRegistered() {
        try {
            Path path = Paths.get(FILE_PATH);
            if (Files.exists(path)) {
                String content = Files.lines(path).collect(Collectors.joining("\n"));
                return content.contains("Course: " + courseName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    //course registeration
    public void registerCourse(String courseName, String lectureName) {
        if (isCourseAlreadyRegistered()) {
            System.out.println("Course " + courseName + " is already registered.");
        } else {
            this.courseName = courseName;
            this.lectureName = lectureName;
            System.out.println("Registration successful for course: " + courseName + " with lecturer: " + lectureName);
            saveToFile();
        }
    }

    //saving the courese in the file
    private void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write("Course: " + courseName + ", Lecturer: " + lectureName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

class CourseRegistration {
    private String courseName;
    private String lectureName;
    private static final String FILE_PATH = "course_registration.txt";

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

    private void saveToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write("Course: " + courseName + ", Lecturer: " + lectureName + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

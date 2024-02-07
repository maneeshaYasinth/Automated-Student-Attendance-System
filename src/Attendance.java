import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Attendance extends CourseRegistration {
    private static final String ATTENDANCE_FILE_PATH = "attendance.txt";
    private final List<String> attendanceRecords;

    public Attendance() {
        attendanceRecords = new ArrayList<>();
    }

    public void markAttendance(String studentId) {
        if (isCourseAlreadyRegistered()) {
            attendanceRecords.add(studentId);
            System.out.println("Attendance marked for student ID: " + studentId);
            saveAttendanceToFile();
        } else {
            System.out.println("Please register the course first.");
        }
    }

    public int getAttendanceCount(String studentId) {
        int count = 0;
        for (String record : attendanceRecords) {
            if (record.equals(studentId)) {
                count++;
            }
        }
        return count;
    }

    private void saveAttendanceToFile() {
        try (FileWriter writer = new FileWriter(ATTENDANCE_FILE_PATH, true)) {
            for (String record : attendanceRecords) {
                writer.write("Student ID: " + record + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error saving attendance to file: " + e.getMessage());
        }
    }
}

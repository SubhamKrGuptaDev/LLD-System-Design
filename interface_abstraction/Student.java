package interface_abstraction;

public class Student extends User{
    private Integer studentId;
    private String course;

    public Student(String username, String email, Integer studentId, String course) {
        super(username, email);
        this.studentId = studentId;
        this.course = course;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("studentId: " + studentId);
        System.out.println("course: " + course);
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public String getCourse() {
        return this.course;
    }

    public static void main(String[] args) {
        Student student = new Student("jane_doe", "jane.doe@example.com", 101, "Computer Science");
        System.out.println("Username: " + student.getUsername());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Course: " + student.getCourse());
        student.displayInfo();
    }
}

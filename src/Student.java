public class Student {
    private String studentID;
    private String name;
    private String className;
    private String major;
    private int attendance; // Attendance count

    public Student(String studentID, String name, String className, String major, int attendance) {
        this.studentID = studentID;
        this.name = name;
        this.className = className;
        this.major = major;
        this.attendance = attendance;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", major='" + major + '\'' +
                ", attendance=" + attendance +
                '}';
    }
}
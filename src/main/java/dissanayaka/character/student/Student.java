package dissanayaka.character.student;

import dissanayaka.character.Character;

public class Student implements Character {

    private int studentId;
    private String studentFirstName;
    private String studentLastName;
    private int studentGrade;
    private String studentBirthDay;

    public Student(int studentId, String studentFirstName, String studentLastName, int studentGrade, String studentBirthDay) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentGrade = studentGrade;
        this.studentBirthDay = studentBirthDay;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentBirthDay() {
        return studentBirthDay;
    }

    public void setStudentBirthDay(String studentBirthDay) {
        this.studentBirthDay = studentBirthDay;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", studentGrade=" + studentGrade +
                ", studentBirthDay=" + studentBirthDay +
                '}';
    }
}

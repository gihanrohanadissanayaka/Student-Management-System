package dissanayaka.classes;

import dissanayaka.character.student.Student;
import dissanayaka.character.teacher.Teacher;

import java.util.List;

public class ClassRoom {

    private int classRoomId;
    private int classRoomGrade;
    private String classRoomSubject;
    private Teacher classRoomTeacher;
    private List<Student> classRoomStudent;

    public ClassRoom(int classRoomId, int classRoomGrade, String classRoomSubject, Teacher classRoomTeacher, List<Student> classRoomStudent) {
        this.classRoomId = classRoomId;
        this.classRoomGrade = classRoomGrade;
        this.classRoomSubject = classRoomSubject;
        this.classRoomTeacher = classRoomTeacher;
        this.classRoomStudent = classRoomStudent;
    }

    public int getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(int classRoomId) {
        this.classRoomId = classRoomId;
    }

    public int getClassRoomGrade() {
        return classRoomGrade;
    }

    public void setClassRoomGrade(int classRoomGrade) {
        this.classRoomGrade = classRoomGrade;
    }

    public String getClassRoomSubject() {
        return classRoomSubject;
    }

    public void setClassRoomSubject(String classRoomSubject) {
        this.classRoomSubject = classRoomSubject;
    }

    public Teacher getClassRoomTeacher() {
        return classRoomTeacher;
    }

    public void setClassRoomTeacher(Teacher classRoomTeacher) {
        this.classRoomTeacher = classRoomTeacher;
    }

    public List<Student> getClassRoomStudent() {
        return classRoomStudent;
    }

    public void setClassRoomStudent(List<Student> classRoomStudent) {
        this.classRoomStudent = classRoomStudent;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "classRoomId=" + classRoomId +
                ", classRoomGrade=" + classRoomGrade +
                ", classRoomSubject='" + classRoomSubject + '\'' +
                ", classRoomTeacher=" + classRoomTeacher.getTeacherFirstName() +" " +classRoomTeacher.getTeacherLastName()+
                '}';
    }
}

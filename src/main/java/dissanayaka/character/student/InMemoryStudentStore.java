package dissanayaka.character.student;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentStore implements StudentStore {
    // create static list for save student
    private static List<Student> studentList = new ArrayList<>();

    public InMemoryStudentStore() {
    }

    @Override
    public boolean saveStudent(Student student) {
        for( Student student1: studentList){
            if( student1.getStudentId() == student.getStudentId() ){
                return false;
            }
        }
        studentList.add(student);
        return true;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        for( Student student: studentList ){
            if( student.getStudentId() == studentId ){
                studentList.remove(student);
                return true;
            }
        }
        return false;
    }

    @Override
    public Student getStudent(int studentId) {
        for( Student student: studentList ){
            if( student.getStudentId() == studentId ){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> getAllSameGradeStudent(int classRoomGrade) {
        List<Student> sameGradeStudent = new ArrayList<>();
        for( Student student: studentList){
            if( student.getStudentGrade() == classRoomGrade ){
                sameGradeStudent.add(student);
            }
        }
        if(sameGradeStudent.size() == 0){
            System.out.println("No any student for this class");
            return null;
        } else {
            return sameGradeStudent;
        }
    }

    @Override
    public List<Student> getAllStudent() {
        return studentList;
    }
}

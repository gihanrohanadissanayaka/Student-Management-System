package dissanayaka.character.student;

import java.util.List;

public interface StudentStore {
    boolean saveStudent(Student student);
    boolean deleteStudent(int studentId );
    Student getStudent(int studentId);
    List<Student> getAllSameGradeStudent(int studentGrade);
    List<Student> getAllStudent();
}

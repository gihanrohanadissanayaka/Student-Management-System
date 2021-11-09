package dissanayaka.character.teacher;

import java.util.List;

public interface TeacherStore {

    boolean saveTeacher(Teacher teacher);
    boolean deleteTeacher(int teacherId );
    Teacher getTeacher(int teacherId);
    List<Teacher> getAllTeacher();
}

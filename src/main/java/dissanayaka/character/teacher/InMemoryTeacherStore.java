package dissanayaka.character.teacher;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTeacherStore implements TeacherStore {

    private static List<Teacher> teacherList = new ArrayList<>();

    @Override
    public boolean saveTeacher(Teacher teacher) {
        for( Teacher teacher1: teacherList){
            if( teacher1.getTeacherId() == teacher.getTeacherId() ){
                return false;
            }
        }
        teacherList.add(teacher);
        return true;
    }

    @Override
    public boolean deleteTeacher(int teacherId) {
        for( Teacher teacher: teacherList ){
            if( teacher.getTeacherId() == teacherId ){
                teacherList.remove(teacher);
                return true;
            }
        }
        return false;
    }

    @Override
    public Teacher getTeacher(int teacherId) {
        for( Teacher teacher: teacherList ){
            if( teacher.getTeacherId() == teacherId ){
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherList;
    }
}

package dissanayaka.classes;

import dissanayaka.character.student.Student;

import java.util.List;

public interface ClassRoomStore {

    boolean saveClassRoom(ClassRoom classRoom);
    boolean deleteClassRoom(int classRoomId );
    ClassRoom getClassRoom(int classRoomId);
    List<ClassRoom> getAllClassRoom();
}

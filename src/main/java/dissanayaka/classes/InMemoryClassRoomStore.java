package dissanayaka.classes;

import java.util.ArrayList;
import java.util.List;

public class InMemoryClassRoomStore implements ClassRoomStore {

    private static List<ClassRoom> classRoomList = new ArrayList<>();

    @Override
    public boolean saveClassRoom(ClassRoom classRoom) {
        for( ClassRoom classRoom1: classRoomList){
            if( classRoom1.getClassRoomId() == classRoom.getClassRoomId() ){
                return false;
            }
        }
        classRoomList.add(classRoom);
        return true;
    }

    @Override
    public boolean deleteClassRoom(int classRoomId) {
        for( ClassRoom classRoom: classRoomList ){
            if( classRoom.getClassRoomId() == classRoomId ){
                classRoomList.remove(classRoom);
                return true;
            }
        }
        return false;
    }

    @Override
    public ClassRoom getClassRoom(int classRoomId) {
        for( ClassRoom classRoom: classRoomList ){
            if( classRoom.getClassRoomId() == classRoomId ){
                return classRoom;
            }
        }
        return null;     }

    @Override
    public List<ClassRoom> getAllClassRoom() {
        return classRoomList;
    }
}

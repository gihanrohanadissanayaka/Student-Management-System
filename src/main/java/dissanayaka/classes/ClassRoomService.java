package dissanayaka.classes;

import dissanayaka.App;
import dissanayaka.character.student.InMemoryStudentStore;
import dissanayaka.character.student.Student;
import dissanayaka.character.student.StudentStore;
import dissanayaka.character.teacher.InMemoryTeacherStore;
import dissanayaka.character.teacher.Teacher;
import dissanayaka.character.teacher.TeacherStore;

import java.util.List;
import java.util.Scanner;

public class ClassRoomService {

    Scanner scanner = new Scanner(System.in);
    ClassRoomStore classRoomStore = new InMemoryClassRoomStore();

    public void classRoomAction(){

        while (true){
            System.out.println("Enter your action:");
            System.out.println(" *)create\n *)delete\n *)show\n *)exit\n");
            String userInput = scanner.nextLine();

            switch (userInput){

                case "create":
                    createClassRoom();
                    break;

                case "exit":
                    App app = new App();
                    app.mainMenu();
                    break;

                case "delete":
                    deleteClassRoom();
                    break;

                case "show":
                    showAllClassRoom();
                    break;

                default:
                    System.out.println("no match");
            }
        }
    }

    public void createClassRoom(){

        System.out.println("Enter classRoom details\n");
        System.out.println("--> <ClassRoom ID> <ClassRoom Grade> <ClassRoom Subject> <ClassRoom Teacher ID>\n");
        String classRoomDetails = scanner.nextLine();
        String[] data = classRoomDetails.split(" ");

        TeacherStore teacherStore = new InMemoryTeacherStore();
        Teacher teacher = teacherStore.getTeacher(Integer.parseInt(data[3]));
        if (teacher == null){
            System.out.println("No teacher with this ID no. "+data[3]);
            return;
        }

        StudentStore studentStore = new InMemoryStudentStore();
        List<Student> studentList = studentStore.getAllSameGradeStudent(Integer.parseInt(data[1]));

        ClassRoom classRoom = new ClassRoom(Integer.parseInt(data[0]), Integer.parseInt(data[1]), data[2], teacher, studentList);
        boolean res = classRoomStore.saveClassRoom(classRoom);

        if(res){
            System.out.println("classRoom create successfully => "+ classRoom.toString() + "\n");
            System.out.println("Student in class : "+studentList.size());
        } else {
            System.out.println("Can't create new classRoom with existing ID.Try again");
        }
    }

    public void showAllClassRoom(){

        List<ClassRoom> classRoomList = classRoomStore.getAllClassRoom();
        if( classRoomList.size() == 0 ){
            System.out.println("No class room ");
            return;
        }
        System.out.println("***** All classRooms *****");
        for(ClassRoom classRoom: classRoomList){
            System.out.println(classRoom.toString());
        }
        System.out.println("*****  *****");
    }

    public void deleteClassRoom(){

        System.out.println("Enter ClassRoom ID\n");
        String classRoomId = scanner.nextLine();
        boolean res = classRoomStore.deleteClassRoom(Integer.parseInt(classRoomId));
        if(res){
            System.out.println("classRoom delete successfully");
        } else {
            System.out.println("ClassRoom delete unsuccessfully.No ClassRoom with ID: "+classRoomId);
        }
    }
}

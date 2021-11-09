package dissanayaka.character.teacher;

import dissanayaka.App;

import java.util.List;
import java.util.Scanner;

public class TeacherService {

    Scanner scanner = new Scanner(System.in);
    TeacherStore teacherStore = new InMemoryTeacherStore();


    public void teacherAction(){

        while (true){
            System.out.println("Enter your action:");
            System.out.println(" *)create\n *)delete\n *)show\n *)exit\n");
            String userInput = scanner.nextLine();

            switch (userInput){

                case "create":
                    createTeacher();
                    break;

                case "exit":
                    App app = new App();
                    app.mainMenu();
                    break;

                case "delete":
                    deleteTeacher();
                    break;

                case "show":
                    showAllTeacher();
                    break;

                default:
                    System.out.println("no match");
            }
        }
    }

    public void createTeacher(){

        System.out.println("Enter teacher details\n");
        System.out.println("--> <Teacher ID> <Teacher firstName> <Teacher lastName>\n");
        String teacherDetails = scanner.nextLine();
        String[] data = teacherDetails.split(" ");
        Teacher teacher = new Teacher(Integer.parseInt(data[0]), data[1], data[2] );
        boolean res = teacherStore.saveTeacher(teacher);

        if(res){
            System.out.println("Teacher create successfully => "+ teacher.toString() + "\n");
        } else {
            System.out.println("Can't create new teacher with existing ID.Try again");
        }

    }

    public void showAllTeacher(){

        List<Teacher> teacherList = teacherStore.getAllTeacher();
        if( teacherList.size() == 0 ){
            System.out.println("No teachers");
            return;
        }
        System.out.println("***** All teachers *****");
        for(Teacher teacher: teacherList){
            System.out.println(teacher.toString());
        }
        System.out.println("*****  *****");
    }

    public void deleteTeacher(){

        System.out.println("Enter Teacher ID\n");
        String teacherId = scanner.nextLine();
        boolean res = teacherStore.deleteTeacher(Integer.parseInt(teacherId));
        if(res){
            System.out.println("Teacher delete successfully");
        } else {
            System.out.println("Teacher delete unsuccessfully.No teacher with ID: "+teacherId);
        }
    }
}

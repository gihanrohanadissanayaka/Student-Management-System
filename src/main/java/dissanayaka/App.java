package dissanayaka;

import dissanayaka.character.student.StudentService;
import dissanayaka.character.teacher.TeacherService;
import dissanayaka.classes.ClassRoomService;
import dissanayaka.session.SessionService;

import java.util.Scanner;

public class App 
{

    public static void main( String[] args)
    {
        System.out.println("=======================================================");
        System.out.println("               Student Management System");
        System.out.println("=======================================================");
        App app = new App();
        app.mainMenu();
    }

    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println( "Welcome to main menu" );

        System.out.println("Enter command:\n");
        while (true){
            System.out.println(" *)student\n *)teacher\n *)class\n *)session\n");
            String userInput = scanner.nextLine();

            switch (userInput){
                case "student":
                    StudentService studentService = new StudentService();
                    studentService.studentAction();
                    break;

                case "teacher":
                    TeacherService teacherService = new TeacherService();
                    teacherService.teacherAction();
                    break;

                case "class":
                    ClassRoomService classRoomService = new ClassRoomService();
                    classRoomService.classRoomAction();
                    break;

                case "session":
                    SessionService sessionService = new SessionService();
                    sessionService.sessionAction();
                    break;

                default:
                    System.out.println("Wrong command. Try Again \n");
            }


        }
    }
}
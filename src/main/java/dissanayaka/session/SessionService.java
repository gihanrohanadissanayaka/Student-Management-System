package dissanayaka.session;

import dissanayaka.App;
import dissanayaka.character.student.Student;
import dissanayaka.classes.ClassRoom;
import dissanayaka.classes.ClassRoomStore;
import dissanayaka.classes.InMemoryClassRoomStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SessionService {

    Scanner scanner = new Scanner(System.in);
    SessionStore sessionStore = new InMemorySessionStore();

    public void sessionAction(){

        while (true){
            System.out.println("Enter your action:");
            System.out.println(" *)create\n *)delete\n *)all\n *)show\n *)exit\n");
            String userInput = scanner.nextLine();

            switch (userInput){

                case "create":
                    createSession();
                    break;

                case "exit":
                    App app = new App();
                    app.mainMenu();
                    break;

                case "delete":
                    deleteSession();
                    break;

                case "all":
                    showAllSession();
                    break;

                case "show":
                    showSessionById();
                    break;

                default:
                    System.out.println("no match");
            }
        }
    }

    public void createSession(){

        System.out.println("Enter session details\n");
        System.out.println("--> <Session ID> <Session Date> <Session Start Time> <Session End Time> <Class Room ID>\n");
        String sessionDetails = scanner.nextLine();
        String[] data = sessionDetails.split(" ");

        ClassRoomStore classRoomStore = new InMemoryClassRoomStore();
        ClassRoom classRoom = classRoomStore.getClassRoom(Integer.parseInt(data[4]));
        if (classRoom == null){
            System.out.println("No class room with this ID no. "+data[4]);
            return;
        }

        List<Student> studentList = classRoom.getClassRoomStudent();
        List<Student> studentList1 = new ArrayList<>();
        System.out.println("Mark attendance for class students");
        for (Student student: studentList){
            System.out.println(student.toString());
            System.out.println("Mark attendance -> present- 1 , absent- 0");
            String isPresent = scanner.nextLine();
            if (isPresent.equals("1")){
                studentList1.add(student);
                System.out.println("student added successfully");
            } else if (isPresent.equals("0")){
                System.out.println("no student added to session");
            } else {
                System.out.println("invalid input");
            }
        }

        Session session = new Session(Integer.parseInt(data[0]), data[1], data[2], data[3], classRoom, studentList1 );
        boolean res = sessionStore.saveSession(session);

        if(res){
            System.out.println("session create successfully => "+ session.toString() + "\n");
        } else {
            System.out.println("Can't create new session with existing ID.Try again");
        }
    }

    public void showAllSession(){

        List<Session> sessionList = sessionStore.getAllSession();
        if( sessionList.size() == 0 ){
            System.out.println("No session ");
            return;
        }
        System.out.println("***** All sessions *****");
        for(Session session: sessionList){
            System.out.println(session.toString());
        }
        System.out.println("*****  *****");
    }

    public void deleteSession(){

        System.out.println("Enter Session ID\n");
        String sessionId = scanner.nextLine();
        boolean res = sessionStore.deleteSession(Integer.parseInt(sessionId));
        if(res){
            System.out.println("Session delete successfully");
        } else {
            System.out.println("Session delete unsuccessfully.No session with ID: "+sessionId);
        }
    }

    public void showSessionById(){
        System.out.println("Enter Session ID\n");
        String sessionId = scanner.nextLine();
        Session session = sessionStore.getSession(Integer.parseInt(sessionId));
        if(session.getSessionStudent().size() == 0 ){
            System.out.println("No student for this session");
        } else {
            List<Student> studentList = session.getSessionStudent();
            System.out.println("All student for session -> "+session.toString());
            for (Student student: studentList){
                System.out.println("-> "+student.toString());
            }
        }
    }
}

package dissanayaka.character.student;

import dissanayaka.App;

import java.util.List;
import java.util.Scanner;

public class StudentService {

    Scanner scanner = new Scanner(System.in);
    StudentStore studentStore = new InMemoryStudentStore();


    public void studentAction(){


        while (true){
            System.out.println("Enter your action:");
            System.out.println(" *)create\n *)delete\n *)show\n *)exit\n");
            String userInput = scanner.nextLine();

            switch (userInput){

                case "create":
                    createStudent();
                    break;

                case "exit":
                    App app = new App();
                    app.mainMenu();
                    break;

                case "delete":
                    deleteStudent();
                    break;

                case "show":
                    showAllStudent();
                    break;

                default:
                    System.out.println("no match");
            }
        }
    }
    public void createStudent(){

        System.out.println("Enter student details\n");
        System.out.println("--> <Student ID> <Student firstName> <Student lastName> <Student Grade> <Student Birthday>\n");
        String studentDetails = scanner.nextLine();
        String[] data = studentDetails.split(" ");
        Student student = new Student(Integer.parseInt(data[0]), data[1], data[2], Integer.parseInt(data[3]), data[4] );
        boolean res = studentStore.saveStudent(student);

        if(res){
            System.out.println("Student create successfully => "+ student.toString() + "\n");
        } else {
            System.out.println("Can't create new student with existing ID.Try again");
        }

    }

    public void showAllStudent(){

        List<Student> studentList = studentStore.getAllStudent();
        if( studentList.size() == 0 ){
            System.out.println("No students");
            return;
        }
        System.out.println("***** All students *****");
        for(Student student: studentList){
            System.out.println(student.toString());
        }
        System.out.println("*****  *****");
    }

    public void deleteStudent(){

        System.out.println("Enter student ID\n");
        String studentId = scanner.nextLine();
        boolean res = studentStore.deleteStudent(Integer.parseInt(studentId));
        if(res){
            System.out.println("Student delete successfully");
        } else {
            System.out.println("Student delete unsuccessfully.No student with ID: "+studentId);
        }
    }
}

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    
    Scanner Sc = new Scanner(System.in);
    
    Studentmanager manager = new Studentmanager();

        int choice = 0;
        boolean running = true;

        while (running) {
            System.out.println("===student management system===");
            System.out.println("1. Add student");
            System.out.println("2. viewall students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. exit");
            System.out.print("Enter your choice: ");


            choice = Integer.parseInt(Sc.nextLine());

            switch (choice) {
                case 1:
                    manager.addStudent(Sc);
                    break;

                case 2:
                    manager.viewallStudents();
                    break;

                case 3:
                    manager.searchStudent(Sc);
                    break;

                case 4:
                    manager.updateStudent(Sc);
                        break;
                case 5:
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
        Sc.close();
    }
}
import java.util.Scanner;
import java.util.ArrayList;

public class Studentmanager {
    ArrayList<Student> students = new ArrayList<Student>();
    
    int nextId = 1;
    
    public void addStudent(Scanner sc){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());
        
        System.out.print("Enter marks: ");
        double marks = Double.parseDouble(sc.nextLine());

        Student student = new Student(nextId, name, age, marks);
        students.add(student);
        nextId++;

        System.out.println("student added successfully.");
    }

    public void viewallStudents(){
        if(students.isEmpty()){
            System.out.println("No students found.");
            return;
        }

        System.out.println("===All Students===");
        
        int i=0;
        while(i<students.size()){
            students.get(i).display();
            i++;
        }
    }
    
        public void searchStudent(Scanner sc) {
        System.out.print("Enter Student ID to search: ");
        int searchId = Integer.parseInt(sc.nextLine());
        int i = 0;
        while (i < students.size()) {
            Student s = students.get(i);
            if (s.id == searchId) {
                System.out.println("Student Found!");
                s.display();
                System.out.println();
                return;
            }
            i++;
        }
        System.out.println("Student Not Found!");
    }

    public void updateStudent(Scanner sc) {
        System.out.print("Enter Student ID to update: ");
        int updateId = Integer.parseInt(sc.nextLine());

        int i = 0;
        while (i < students.size()) {
            Student s = students.get(i);
            if (s.id == updateId) {
                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter New Age: ");
                int newAge = Integer.parseInt(sc.nextLine());

                System.out.print("Enter New Marks: ");
                double newMarks = Double.parseDouble(sc.nextLine());

                s.name = newName;
                s.age = newAge;
                s.marks = newMarks;

                System.out.println("Student Updated Successfully!");
                return;
            }
            i++;
        }
        System.out.println("Student Not Found!");
    }
}


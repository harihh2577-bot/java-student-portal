import java.util.Scanner;
import java.util.ArrayList;

public class Studentmanager {
    ArrayList<Student> students = new ArrayList<Student>();
    
    int nextId = 1;

    private boolean isIdExists(int id) {
        int i = 0;
        while (i < students.size()) {
            if (students.get(i).id == id) {
                return true;
            }
            i++;
        }
        return false;
    }
    
    public void addStudent(Scanner sc) {
        System.out.println("\n--- Add Student ---");

        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter Student Name: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Try again.");
            }
        }

        int age = 0;
        while (age <= 0) {
            try {
                System.out.print("Enter Age: ");
                age = Integer.parseInt(sc.nextLine().trim());
                if (age <= 0) {
                    System.out.println("Age must be greater than 0. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid age! Please enter a number.");
            }
        }

        String department = "";
        while (department.isEmpty()) {
            System.out.print("Enter Department: ");
            department = sc.nextLine().trim();
            if (department.isEmpty()) {
                System.out.println("Department cannot be empty. Try again.");
            }
        }

        double marks = -1;
        while (marks < 0) {
            try {
                System.out.print("Enter Marks: ");
                marks = Double.parseDouble(sc.nextLine().trim());
                if (marks < 0) {
                    System.out.println("Marks cannot be negative. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid marks! Please enter a number.");
            }
        }

        Student newStudent = new Student(nextId, name, age, marks, department);
        students.add(newStudent);
        nextId++;
        System.out.println("Student added successfully!\n");
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
    public void deleteStudent(Scanner sc) {
        System.out.println("\n--- Delete Student ---");
        try {
            System.out.print("Enter Student ID to delete: ");
            int deleteId = Integer.parseInt(sc.nextLine().trim());
            int i = 0;
            while (i < students.size()) {
                Student s = students.get(i);
                if (s.id == deleteId) {
                    students.remove(i);
                    System.out.println("Student deleted successfully!\n");
                    return;
                }
                i++;
            }
            System.out.println("Student ID not found. Delete failed.\n");
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID! Please enter a number.\n");
        }
    }

    public void updateStudent(Scanner sc) {
        System.out.print("Enter Student ID to update: ");
        int updateId = Integer.parseInt(sc.nextLine());
        int i = 0;
        while (i < students.size()) {
            Student s = students.get(i);
            if (s.id == updateId) {
                System.out.print("Enter New Name: ");
                String newName = sc.nextLine().trim();

                int newAge = -1;
                while (newAge <= 0) {
                    try {
                        System.out.print("Enter New Age: ");
                        newAge = Integer.parseInt(sc.nextLine().trim());
                        if (newAge <= 0) System.out.println("Age must be greater than 0. Try again.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age! Please enter a number.");
                    }
                }

                double newMarks = -1;
                while (newMarks < 0) {
                    try {
                        System.out.print("Enter New Marks: ");
                        newMarks = Double.parseDouble(sc.nextLine().trim());
                        if (newMarks < 0) System.out.println("Marks cannot be negative. Try again.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid marks! Please enter a number.");
                    }
                }

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


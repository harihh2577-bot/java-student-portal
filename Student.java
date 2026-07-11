public class Student {
    int id;
    String name;
    int age;
    double marks;
    String department;

    public Student(int id, String name, int age, double marks, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.department = department;
    }
    public void display() {
        System.out.print("id:"+id+", name:"+name+", age:"+age+", marks:"+marks+", department:"+department);
    }
    
}
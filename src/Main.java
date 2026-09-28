import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String course;
    private String department;
    private double marks;
    private double percentage;

    Student(int id, String name, int age, String gender,
            String email, String phone, String course,
            String department, double marks, double percentage) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.department = department;
        this.marks = marks;
        this.percentage = percentage;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCourse() {
        return course;
    }

    public String getDepartment() {
        return department;
    }

    public double getMarks() {
        return marks;
    }

    public double getPercentage() {
        return percentage;
    }
    public String toString() {
        return id + " " + name + " " + age + " " + gender + " " + email + " " + phone + " " + course + " " + department + " " + marks + " " + percentage;
    }
}

class Main {
    public static void main(String[] args) {

        List<Student> c = new ArrayList<Student>();
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        int ch;
        do {
            System.out.println("1.ADD");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("Enter your choice: ");

            ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = s.nextInt();
                    System.out.print("Enter student name: ");
                    String name = s1.nextLine();
                    System.out.print("Enter student age: ");
                    int age = s.nextInt();
                    System.out.print("Enter student gender: ");
                    String gender = s1.nextLine();
                    System.out.print("Enter student email: ");
                    String email = s1.nextLine();
                    System.out.print("Enter student phone: ");
                    String phone = s1.nextLine();
                    System.out.print("Enter student course: ");
                    String course = s1.nextLine();
                    System.out.print("Enter student department: ");
                    String department = s1.nextLine();
                    System.out.print("Enter student marks: ");
                    double marks = s.nextDouble();
                    System.out.print("Enter student percentage: ");
                    double percentage = s.nextDouble();

                    c.add(new Student(id, name, age, gender, email, phone, course, department, marks, percentage));
                    break;
                case 2:
                    System.out.println("------------------------------");
                    Iterator<Student> i = c.iterator();
                    while(i.hasNext()) {
                        Student e = i.next();
                        System.out.println(e);
                    }
                    System.out.println("-----------------------------");
                    break;

                //SEARCH
                case 3:
                    boolean found = false;
                    System.out.println("Enter Student ID to search: ");
                    id = s.nextInt();
                    System.out.println("------------------------------");
                    i = c.iterator();
                    while(i.hasNext()) {
                        Student e = i.next();
                        if (e.getId() == id) {
                            System.out.println(e);
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("Record not found");
                    }
                    System.out.println("-----------------------------");

                    //DELETE
                case 4:
                    found = false;
                    System.out.println("Enter Student ID to delete : ");
                    id = s.nextInt();
                    System.out.println("------------------------------");
                    i = c.iterator();
                    while(i.hasNext()) {
                        Student e = i.next();
                        if (e.getId() == id) {
                            i.remove();
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("Record not found");
                    }else {
                        System.out.println("Record deleted successfully...!");
                    }
                    System.out.println("-----------------------------");
                    break;

                // UPDATE
                case 5:
                    found = false;
                    System.out.println("Enter Student ID to Update : ");
                    id = s.nextInt();
                    System.out.println("------------------------------");
                    ListIterator<Student>li = c.listIterator();
                    while(li.hasNext()) {
                        Student e = li.next();
                        if (e.getId() == id) {
                            System.out.print("Enter new name: ");
                            name = s1.nextLine();

                            System.out.print("Enter new age: ");
                            age = s.nextInt();

                            System.out.print("Enter new gender: ");
                            gender = s1.nextLine();

                            System.out.print("Enter new email: ");
                            email = s1.nextLine();

                            System.out.print("Enter new phone: ");
                            phone = s1.nextLine();

                            System.out.print("Enter new course: ");
                            course = s1.nextLine();

                            System.out.print("Enter new department: ");
                            department = s1.nextLine();

                            System.out.print("Enter new marks: ");
                            marks = s.nextDouble();

                            System.out.print("Enter new percentage: ");
                            percentage = s.nextDouble();

                            li.set(new Student(id, name, age, gender, email, phone, course, department, marks, percentage));
                            found = true;
                        }
                    }
                    if(!found) {
                        System.out.println("Record not found");
                    }else {
                        System.out.println("Record is Updated successfully...!");
                    }
                    System.out.println("-----------------------------");
                    break;
            }
        }while (ch!=0);
    }
}

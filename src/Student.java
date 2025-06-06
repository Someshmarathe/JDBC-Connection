public class Student {
    private int id;
    private String name;
    private int age;
    private String password;

    public Student(int id , String name, String password , int age) {
        this.age = age;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Student(String name, String password , int age) {
        this.age = age;
        this.id = (int) (Math.random() * 10);
        this.name = name;
        this.password = password;
    }

    public Student(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

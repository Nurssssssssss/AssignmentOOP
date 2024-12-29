package Classes;

public abstract class Person
{
    private static int id = 1;
    private int id_gen;
    private String name;
    private String surname;
    private int age;
    private boolean gender;


    public Person()
    {
        id_gen = id++;
    }

    public Person(String name , String surname , int age , boolean gender)
    {
        this();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Person.id = id;
    }

    public void setId_gen(int id_gen) {
        this.id_gen = id_gen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ("Hi, i am " + name + " " + surname+", a " + age + "-year-old " + (gender?"Male":"Female")+".");
    }

    public int getId_gen() {
        return id_gen;
    }
}

import Classes.Person;
import Classes.School;
import Classes.Student;
import Classes.Teacher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers  = new ArrayList<>();
        School school = new School();

        File studentsFile = new File("Materials/students.txt");
        File teachersFile = new File("Materials/teachers.txt");

        Scanner scanner = new Scanner(studentsFile);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int barcode = Integer.parseInt(parts[0]);
            String name = parts[1];
            String surname = parts[2];
            int age = Integer.parseInt(parts[3]);

            boolean gender = parts[4].equalsIgnoreCase("Male");

            ArrayList<Integer> grades = new ArrayList<>();
            for (int i = 5; i < parts.length; i++) {
                grades.add(Integer.parseInt(parts[i]));
            }

            Student student = new Student(barcode, name,surname,age,gender);
            for(int grade : grades) {student.addGrade(grade);}

            students.add(student);
            school.addMember(student);
        }

        scanner = new Scanner(teachersFile);
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            String name = parts[0];
            String surname = parts[1];
            int age = Integer.parseInt(parts[2]);
            boolean gender = true;
            switch (parts[3]){
                case "Male":
                    gender = true;
                    break;
                case "Female":
                    gender = false;
                    break;
            }

            String subject = parts[4];
            int yearsOfExpirience = Integer.parseInt(parts[5]);
            int salary = Integer.parseInt(parts[6]);
            Teacher teacher = new Teacher(name,surname,age,gender , subject , yearsOfExpirience , salary);

            teachers.add(teacher);
            school.addMember(teacher);
        }

        System.out.println(school.toString());

        for(Student student : students){
            System.out.println(student.getName() +"'s  GPA : " + student.calculateGPA());
        }


        for(Teacher teacher : teachers) {
            System.out.print(teacher.getName()+"  :  " + teacher.getSalary() + " + "+(teacher.getYearsOfExpirience()+"%") + " = ");
            teacher.giveRaise(teacher.getYearsOfExpirience() *1.5f);
            System.out.println(teacher.getSalary());
        }
    }
}
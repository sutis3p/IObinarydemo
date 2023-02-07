import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeFile(String fileName, List<Student>students){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Student student = new Student();
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"suti",19));
        students.add(new Student(2,"thư",20));
        students.add(new Student(3,"chi",25));
        students.add(new Student(4,"mai",23));
        students.add(new Student(5,"trang",21));
        writeFile("student.dat",students);
        List<Student>studentList= readFile("student.dat");
        for (Student student1 : studentList){
            System.out.println(student1);
        }
    }
    public static List<Student> readFile(String fileName){
        List<Student>students=new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            students = (List<Student>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}

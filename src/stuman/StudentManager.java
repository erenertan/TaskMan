package stuman;

import java.io.*;
import java.util.ArrayList;

/**
 * Project: TaskMan
 * <p>
 * Date: 12 Jun 2016
 * Author: incetarik
 */
public class StudentManager {
    public static final String FILE_NAME_STUDENTS = "students.d";
    public static final String FILE_NAME_SCHOOLS = "schools.d";

    private ArrayList<Student> students;
    private ArrayList<School> schools;

    public StudentManager() {
        students = new ArrayList<>();
        schools = new ArrayList<>();

        loadData();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<School> getSchools() {
        return schools;
    }

    public Student getStudentById(int id) {
        for (Student stu : students) {
            if (stu.getId() == id) {
                return stu;
            }
        }

        return null;
    }

    public Student getStudentByFullName(String name, String surname) {
        for (Student stu : students) {
            if (stu.getName().equals(name) && stu.getSurname().equals(surname)) {
                return stu;
            }
        }

        return null;
    }

    public Student getStudentByEmail(String email) {
        for (Student stu : students) {
            if (stu.getEmail().equals(email)) {
                return stu;
            }
        }

        return null;
    }

    public Student getStudentByPhone(String phoneNumber) {
        for (Student stu : students) {
            if (stu.getPhone().equals(phoneNumber)) {
                return stu;
            }
        }

        return null;
    }

    public ArrayList<Student> getStudentsByMission(StudentMission mis) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student stu : students) {
            if (stu.getMission().equals(mis)) {
                list.add(stu);
            }
        }

        return list;
    }

    public void saveToFile(Object o, String path) {
        if (o == null) {
            return;
        }

        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveToFile() {
        saveToFile(schools, FILE_NAME_SCHOOLS);
        saveToFile(students, FILE_NAME_STUDENTS);
    }

    public Object loadFromFile(String path) {
        File file = new File(path);
        Object retVal = null;
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                retVal = ois.readObject();
                ois.close();
                fis.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return retVal;
    }

    public void loadData() {
        loadSchools();
        loadStudents();
    }

    public void loadStudents() {
        Object o = loadFromFile(FILE_NAME_STUDENTS);
        if (o == null) {
            return;
        }

        students = (ArrayList<Student>) o;
    }

    public void loadSchools() {
        Object o = loadFromFile(FILE_NAME_SCHOOLS);
        if (o == null) {
            return;
        }

        schools = (ArrayList<School>) o;
    }
}
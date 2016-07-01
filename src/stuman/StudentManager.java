package stuman;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Project: TaskMan
 * <p>
 * Date: 12 Jun 2016
 * Author: incetarik
 */
public class StudentManager {
    public static final String FILE_NAME_STUDENTS = "students.d";
    public static final String FILE_NAME_SCHOOLS = "schools.d";

    private static ArrayList<Student> students;
    private static ArrayList<School> schools;

    public static void initialize() {
        students = new ArrayList<>();
        schools = new ArrayList<>();
        loadData();
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static ArrayList<School> getSchools() {
        return schools;
    }

    public static Student getStudentById(int id) {
        for (Student stu : students) {
            if (stu.getId() == id) {
                return stu;
            }
        }

        return null;
    }

    public static Student getStudentByFullName(String name, String surname) {
        for (Student stu : students) {
            if (stu.getName().equals(name) && stu.getSurname().equals(surname)) {
                return stu;
            }
        }

        return null;
    }

    public static Student getStudentByEmail(String email) {
        for (Student stu : students) {
            if (stu.getEmail().equals(email)) {
                return stu;
            }
        }

        return null;
    }

    public static Student getStudentByPhone(String phoneNumber) {
        for (Student stu : students) {
            if (stu.getPhone().equals(phoneNumber)) {
                return stu;
            }
        }

        return null;
    }

    public static ArrayList<Student> getStudentsByMission(StudentMission mis) {
        ArrayList<Student> list = new ArrayList<>();
        for (Student stu : students) {
            if (stu.getMission().equals(mis)) {
                list.add(stu);
            }
        }

        return list;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Reads a file bytes from filePath and sets image byte array into student.
     * If file is not exists, returns.
     * Note: File size cannot be bigger than {@link Integer#MAX_VALUE}.
     *
     * @param student  Student to install image from filePath
     * @param filePath Path of the file to read
     */
    public static void installImage(Student student, String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            return;
        }

        try {
            if (file.length() > Integer.MAX_VALUE) {
                throw new IOException("File is too big");
            }

            int currentByte, index = 0;
            byte[] bytes = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            while ((currentByte = fis.read()) != -1) {
                bytes[index++] = (byte) currentByte;
            }
            student.setImageArray(bytes);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Filters students by regular expressions / patterns
     * Example:
     * students: Tarık İnce, Halil Ertan, Ali Metin
     * pattern: \w{3}\s\w{5} will return Ali Metin
     * pattern: ^[TH] will return Tarık İnce, Halil Ertan
     *
     * @param regex Pattern to filter students
     * @return Array of students
     */
    public static ArrayList<Student> getStudentByFullNameRegex(String regex) {
        Pattern pattern = Pattern.compile(regex);
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : students) {
            if (pattern.matcher(student.getFullName()).matches()) {
                students.add(student);
            }
        }

        return students;
    }

    public static void saveToFile(Object o, String path) {
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

    public static void saveToFile() {
        saveToFile(schools, FILE_NAME_SCHOOLS);
        saveToFile(students, FILE_NAME_STUDENTS);
    }

    public static Object loadFromFile(String path) {
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

    public static void loadData() {
        loadSchools();
        loadStudents();
    }

    public static void loadStudents() {
        Object o = loadFromFile(FILE_NAME_STUDENTS);
        if (o == null) {
            return;
        }

        students = (ArrayList<Student>) o;
    }

    public static void loadSchools() {
        Object o = loadFromFile(FILE_NAME_SCHOOLS);
        if (o == null) {
            return;
        }

        schools = (ArrayList<School>) o;
    }
}
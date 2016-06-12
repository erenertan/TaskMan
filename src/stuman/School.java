package stuman;

import java.util.ArrayList;

/**
 * Project: TaskMan
 * <p>
 * Date: 16:04 12 Jun 2016
 * Author: incetarik
 */
public class School implements Comparable<School> {
    private ArrayList<Student> students;
    private String name, place;

    public School() {
    }

    public School(String name, String place) {
        this.name = name;
        this.place = place;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public int compareTo(School o) {
        return name.compareTo(o.name);
    }
}

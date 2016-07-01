package stuman;

import java.util.Date;

/**
 * Project: TaskMan
 * <p>
 * Date: 16:03 12 Jun 2016
 * Author: incetarik
 */
public class Student implements Comparable<Student> {
    private String name, surname, phone, email, note;
    private int id;
    private School school;
    private StudentMission mission;
    private Date birthDate;
    private byte[] imageArray;

    public Student() {
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Student(String name, String surname, int id) {
        this(name, surname);
        this.id = id;
    }

    public Student(String name, String surname, int id, School school) {
        this(name, surname, id);
        this.school = school;
    }

    public byte[] getImageArray() {
        return imageArray;
    }

    public void setImageArray(byte[] imageArray) {
        this.imageArray = imageArray;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public StudentMission getMission() {
        return mission;
    }

    public void setMission(StudentMission mission) {
        this.mission = mission;
    }

    public String getName() {
        return name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
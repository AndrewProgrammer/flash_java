package com.hillel.lesson6.entities;

import javax.persistence.*;
import java.util.Set;


@NamedNativeQueries({
        @NamedNativeQuery(
                name = "students",
                query = "select * from students",
                resultClass = Student.class
        )
})
@NamedQueries({
        @NamedQuery(
                name = "studentByName",
                query = "from Student s where s.firstname = :firstname"
        )
})
@Entity //Класс с базой данных
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT PRIMARY KEY;
    private long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private int age;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private Set<Exam> exams;
    //Добавляет к студенту новые поля - как Abstract Class
    @Embedded
    private StudentAddress studentAddress; //Агрегация - добавляет поля другого класса реализованы в другом классе


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}

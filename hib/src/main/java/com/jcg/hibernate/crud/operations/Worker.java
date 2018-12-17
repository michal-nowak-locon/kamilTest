package com.jcg.hibernate.crud.operations;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "worker")

public class Worker  implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "salary")
    private float salary;

    public void setId(int id) {
        this.id = id;
    }
    public int getPhoneNumber(){return phoneNumber;}
    public void setPhoneNumber(int phoneNumber){this.phoneNumber = phoneNumber;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress(){ return address; }
    public void setAddress(String address){this.address = address; }
    public float getSalary() {return salary; }
    public void setSalary(float salary){this.salary = salary;}

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id= " + id +
                ", Phone number = " + phoneNumber +
                ", Name = '" + name + '\'' +
                ", Last name = '" + lastName + '\'' +
                ", Age = " + age +
                ", Address= '" + address + '\'' +
                ", Salary= " + salary +
                '}';
    }
}

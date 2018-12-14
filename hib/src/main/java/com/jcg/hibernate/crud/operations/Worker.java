package com.jcg.hibernate.crud.operations;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "worker")

public class Worker  implements Serializable {

    @Id
    @Column(name = "worker_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "worker_phone_number")
    private int phone_number;

    @Column(name = "worker_name")
    private String name;

    @Column(name = "worker_lastname")
    private String lastname;

    @Column(name = "worker_age")
    private int age;

    @Column(name = "worker_adress")
    private String adres;

    @Column(name = "worker_salary")
    private float salary;

    public void setId(int id) {
        this.id = id;
    }
    public int getPhone_number(){return phone_number;}
    public void setPhone_number(int phone_number){this.phone_number = phone_number;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public String getAdres(){ return adres; }
    public void setAdres(String adres){this.adres = adres; }
    public float getSalary() {return salary; }
    public void setSalary(float salary){this.salary = salary;}

    @Override
    public String toString() {
        return "ID:  " + this.id + "Phone number: " + this.phone_number + "Name: " + this.name + "Last name: " + this.lastname + "Age: " + this.age + "Adress: " + this.adres + "Salary: " + this.salary;
    }


}

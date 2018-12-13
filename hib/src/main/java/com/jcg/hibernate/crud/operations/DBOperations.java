package com.jcg.hibernate.crud.operations;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class DBOperations {

    private static Session sessionObj;
    private static SessionFactory sessionFactoryObj;

    public final static Logger logger = Logger.getLogger(DBOperations.class);

    private static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("/hibernate.cfg.xml");
        configObj.addAnnotatedClass(Student.class);
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);

        return sessionFactoryObj;
    }

    public static void createRecord() {
        int count = 0;
        Student studentoObj = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            for (int j = 101; j <= 105; j++) {
                count = count + 1;
                studentoObj = new Student();
                studentoObj.setRollNumber(j);
                studentoObj.setStudentName("Editor =" + j);
                studentoObj.setCourse("Bachelor of Technology");
                sessionObj.save(studentoObj);
            }
            sessionObj.getTransaction().commit();
            logger.info("Succesfully created " + count + "Records in Database");
        } catch (Exception sqlExcteption) {
            if (null != sessionObj.getTransaction()) {
                logger.info("Transation  is being rolled back...");
                sessionObj.getTransaction().rollback();
            }
            sqlExcteption.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Student> displayRecords() {
        List studentList = new ArrayList<>();
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            studentList = sessionObj.createQuery("SELECT s FROM Student s").list();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("Transaction is being  Rolled Back...");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null)
                sessionObj.close();
        }
        return studentList;
    }

    public static void updateRecord(int student_id) {

        try {

            sessionObj = buildSessionFactory().openSession();

            sessionObj.beginTransaction();


            Student stuObj = (Student) sessionObj.get(Student.class, student_id);
            stuObj.setStudentName("Java Code Geek");
            stuObj.setCourse("Masters Of Technology");

            sessionObj.getTransaction().commit();
            logger.info("\nStudent With Id?= " + student_id + " Is Successfully Updated In The Database!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("Transaction Is Being Rolled Back");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }

    }

    public static void deleteRecord(Integer student_id) {
        try {

            sessionObj = buildSessionFactory().openSession();

            sessionObj.beginTransaction();

            Student studObj = findRecordById(student_id);
            sessionObj.delete(studObj);

            sessionObj.getTransaction().commit();
            logger.info("\nStudent With Id?= " + student_id + " Is Successfully Deleted From The Database!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    public static Student findRecordById(Integer find_student_id) {
        Student findStudentObj = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            findStudentObj = (Student) sessionObj.load(Student.class, find_student_id);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findStudentObj;
    }

    public static void deleteAllRecords() {
        try {
            sessionObj = buildSessionFactory().openSession();

            sessionObj.beginTransaction();
            Query queryObj = sessionObj.createQuery("DELETE FROM Student");

            queryObj.executeUpdate();

            sessionObj.getTransaction().commit();
            logger.info("\nSuccessfully Deleted All Records From The Database Table!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                logger.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}

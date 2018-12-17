package com.jcg.hibernate.crud.operations;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Worker_servis {
    public final static Logger log = Logger.getLogger(String.valueOf(Worker_servis.class));

    private static Session sessionObj;
    private static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        Configuration configObj = new Configuration();
        configObj.configure("/hibernate.cfg.xml");
        configObj.addAnnotatedClass(Worker.class);
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);

        return sessionFactoryObj;
    }

    public static void Create() {
        int count = 0;
        Worker workerObj = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            for (int j = 101; j <= 105; j++) {
                count = count + 1;
                workerObj = new Worker();
                workerObj.setPhoneNumber(j);
                workerObj.setName("Person: " + j);
                workerObj.setLastName("LastName" + j);
                workerObj.setAge( j );
                workerObj.setSalary( 3242 );
                sessionObj.save(workerObj);
            }
            sessionObj.getTransaction().commit();
            log.info("Succesfully created " + count + "Records in Database");
        } catch (Exception sqlExcteption) {
            if (null != sessionObj.getTransaction()) {
                log.info("Transation  is being rolled back...");
                sessionObj.getTransaction().rollback();
            }
            sqlExcteption.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    public static void update(int worker_id) {

        try {

            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            Worker worObj = (Worker) sessionObj.get(Worker.class, worker_id);
            worObj.setName("fff");
            worObj.setLastName("Master");
            worObj.setAddress("PL");

            sessionObj.getTransaction().commit();
            log.info("\nWorker With Id?= " + worker_id + " Is Successfully Updated In The Database!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                log.info("Transaction Is Being Rolled Back");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }
    @SuppressWarnings("unchecked")
    public static List<Worker> display() {
        List workerList = new ArrayList<>();
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            workerList = sessionObj.createQuery("SELECT s FROM Worker s").list();
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                log.info("Transaction is being  Rolled Back...");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null)
                sessionObj.close();
        }
        return workerList;
    }

    public static void delete(Integer worker_id) {
        try {

            sessionObj = buildSessionFactory().openSession();

            sessionObj.beginTransaction();

            Worker workObj = findById(worker_id);
            sessionObj.delete(workObj);

            sessionObj.getTransaction().commit();
            log.info("\nWorker With Id?= " + worker_id + " Is Successfully Deleted From The Database!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                log.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if (sessionObj != null) {
                sessionObj.close();
            }
        }
    }

    public static Worker findById(Integer find_worker_id) {
        Worker findWorkerObj = null;
        try {
            sessionObj = buildSessionFactory().openSession();
            sessionObj.beginTransaction();

            findWorkerObj = (Worker) sessionObj.load(Worker.class, find_worker_id);
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                log.info("\n.......Transaction Is Being Rolled Back.......\n");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        }
        return findWorkerObj;
    }

    public static void deleteAll() {
        try {
            sessionObj = buildSessionFactory().openSession();

            sessionObj.beginTransaction();
            Query queryObj = sessionObj.createQuery("DELETE FROM Worker");

            queryObj.executeUpdate();

            sessionObj.getTransaction().commit();
            log.info("\nSuccessfully Deleted All Records From The Database Table!\n");
        } catch (Exception sqlException) {
            if (null != sessionObj.getTransaction()) {
                log.info("\n.......Transaction Is Being Rolled Back.......\n");
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



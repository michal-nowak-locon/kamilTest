package com.jcg.hibernate.crud.operations;

import java.util.List;
import java.util.logging.Logger;

public class AppMain {

    public static void main(String[] args) {

        final Logger log2 = Logger.getLogger(String.valueOf(AppMain.class));

        log2.info(".......Hibernate Crud Operations Example.......\n");

        log2.info("\n=======CREATE RECORDS=======\n");

        DBOperations.createRecord();

        log2.info("\n=======READ RECORDS=======\n");
        List<Student> viewStudents = DBOperations.displayRecords();
        if(viewStudents != null && viewStudents.size() > 0) {
            for(Student studentObj : viewStudents) {
                log2.info(studentObj.toString());
            }
        }

        log2.info("\n=======UPDATE RECORDS=======\n");
        int updateId = viewStudents.get(0).getId();
        DBOperations.updateRecord(updateId);
        log2.info("\n=======READ RECORDS AFTER UPDATION=======\n");
        List updateStudent = DBOperations.displayRecords();
        if(updateStudent != null && updateStudent.size() > 0) {
            for(Object studentObj : updateStudent) {
                log2.info(studentObj.toString());
            }
        }

        log2.info("\n=======DELETE RECORD=======\n");
        int deleteId = viewStudents.get(0).getId();
        DBOperations.deleteRecord(deleteId);
        log2.info("\n=======READ RECORDS AFTER DELETION=======\n");
        List deleteStudentRecord = DBOperations.displayRecords();
        for(Object studentObj : deleteStudentRecord) {
            log2.info(studentObj.toString());
        }

        log2.info("\n=======DELETE ALL RECORDS=======\n");
        DBOperations.deleteAllRecords();
        log2.info("\n=======READ RECORDS AFTER ALL RECORDS DELETION=======");
        List deleteAll = DBOperations.displayRecords();
        if(deleteAll.size() == 0) {
            log2.info("\nNo Records Are Present In The Database Table!\n");
        }

        log2.info(".......Hibernate Crud Operations Example.......\n");

        log2.info("\n=======CREATE RECORDS=======\n");
        Worker_servis.Create();

        log2.info("\n=======READ RECORDS=======\n");
        List<Worker> viewWorkers = Worker_servis.display();
        if(viewWorkers != null && viewWorkers.size() > 0) {
            for(Worker workerObj : viewWorkers) {
                log2.info(workerObj.toString());
            }
        }

        log2.info("\n=======UPDATE RECORDS=======\n");
        int updateid = viewWorkers.get(0).getId();
        Worker_servis.update(updateid);
        log2.info("\n=======READ RECORDS AFTER UPDATION=======\n");
        List updateWorker = Worker_servis.display();
        if(updateWorker != null && updateWorker.size() > 0) {
            for(Object workerObj : updateWorker) {
                log2.info(updateWorker.toString());
            }
        }

        log2.info("=======DELETE RECORD=======");
        int deleteid = viewWorkers.get(0).getId();
        Worker_servis.delete(deleteid);
        log2.info("=======READ RECORDS AFTER DELETION=======");
        List deleteWorkerRecord = Worker_servis.display();
        for(Object workerObj : deleteWorkerRecord) {
            log2.info(workerObj.toString());
        }

        log2.info("=======DELETE ALL RECORDS=======");
        Worker_servis.deleteAll();

        log2.info("=======READ RECORDS AFTER ALL RECORDS DELETION=======");
        deleteAll = Worker_servis.display();
        if(deleteAll.size() == 0) {
            log2.info("No Records Are Present In The Database Table!");
        }
        System.exit(0);
    }
}
package com.jcg.hibernate.crud.operations;

import java.util.List;
import java.util.logging.Logger;

import static com.jcg.hibernate.crud.operations.DBOperations.logger;


public class AppMain {


    public static void main(String[] args) {

        logger.info(".......Hibernate Crud Operations Example.......\n");

        logger.info("\n=======CREATE RECORDS=======\n");
        DBOperations.createRecord();

        logger.info("\n=======READ RECORDS=======\n");
        List<Student> viewStudents = DBOperations.displayRecords();
        if(viewStudents != null && viewStudents.size() > 0) {
            for(Student studentObj : viewStudents) {
                logger.info(studentObj.toString());
            }
        }

        logger.info("\n=======UPDATE RECORDS=======\n");
        int updateId = 1;
        DBOperations.updateRecord(updateId);
        logger.info("\n=======READ RECORDS AFTER UPDATION=======\n");
        List updateStudent = DBOperations.displayRecords();
        if(updateStudent != null && updateStudent.size() > 0) {
            for(Object studentObj : updateStudent) {
                logger.info(studentObj.toString());
            }
        }

        logger.info("\n=======DELETE RECORD=======\n");
        int deleteId = 5;
        DBOperations.deleteRecord(deleteId);
        logger.info("\n=======READ RECORDS AFTER DELETION=======\n");
        List deleteStudentRecord = DBOperations.displayRecords();
        for(Object studentObj : deleteStudentRecord) {
            logger.info(studentObj.toString());
        }

        logger.info("\n=======DELETE ALL RECORDS=======\n");
        DBOperations.deleteAllRecords();
        logger.info("\n=======READ RECORDS AFTER ALL RECORDS DELETION=======");
        List deleteAll = DBOperations.displayRecords();
        if(deleteAll.size() == 0) {
            logger.info("\nNo Records Are Present In The Database Table!\n");
        }


        logger.info(".......Hibernate Crud Operations Example.......\n");

        logger.info("\n=======CREATE RECORDS=======\n");
        Worker_servis.Create();

        logger.info("\n=======READ RECORDS=======\n");
        List<Worker> viewWorkers = Worker_servis.display();
        if(viewWorkers != null && viewWorkers.size() > 0) {
            for(Worker workerObj : viewWorkers) {
                logger.info(workerObj.toString());
            }
        }

        logger.info("\n=======UPDATE RECORDS=======\n");
        int updateid = 1;
        Worker_servis.update(updateid);
        logger.info("\n=======READ RECORDS AFTER UPDATION=======\n");
        List updateWorker = Worker_servis.display();
        if(updateWorker != null && updateWorker.size() > 0) {
            for(Object workerObj : updateWorker) {
                logger.info(updateWorker.toString());
            }
        }

        logger.info("=======DELETE RECORD=======");
        int deleteid = 5;
        Worker_servis.delete(deleteid);
        logger.info("=======READ RECORDS AFTER DELETION=======");
        List deleteWorkerRecord = Worker_servis.display();
        for(Object workerObj : deleteWorkerRecord) {
            logger.info(workerObj.toString());
        }

        logger.info("=======DELETE ALL RECORDS=======");
        Worker_servis.deleteAll();

        logger.info("=======READ RECORDS AFTER ALL RECORDS DELETION=======");
        deleteAll = Worker_servis.display();
        if(deleteAll.size() == 0) {
            logger.info("No Records Are Present In The Database Table!");
        }
        System.exit(0);
    }

}

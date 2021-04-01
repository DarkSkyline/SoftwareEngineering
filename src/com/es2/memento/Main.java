package com.es2.memento;

public class Main {

    public static void main(String[] args) throws ExistingStudentException, NotExistingSnapshotException {
        Server server = new Server();
        BackupService backup = new BackupService(server);
        backup.takeSnapshot();
        server.addStudent("Maria José");
        backup.takeSnapshot();
        server.addStudent("Manuel António");
        System.out.println(server.getStudentNames().size());

        backup.restoreSnapshot(1);
        System.out.println(server.getStudentNames().size());
    }
}


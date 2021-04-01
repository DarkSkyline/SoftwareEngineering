package com.es2.memento;

import java.util.ArrayList;

public class Server extends Object {
    public ArrayList<String> studendList = new ArrayList<>();

    public Server() { }

    /*
    * Adds a new student name
    */
    public void addStudent(String studentName) throws ExistingStudentException {
        this.studendList.add(studentName);
    }

    /* Backups the server state to a Memento object */
    public Memento backup() {
       Memento backupMemento =  new Memento(this.studendList);
       return backupMemento;
    }

    /* Return the student names */
    public ArrayList<String> getStudentNames(){
        return this.studendList;
    }

    /* Restores a previous server state */
    public void restore(Memento state) {
       ArrayList<String> backupList = state.getState();
       studendList = backupList;
       System.out.println("List has been restored");
    }
}

package com.es2.memento;

import java.util.ArrayList;

public class Server extends Object {
    public ArrayList<String> studentList = new ArrayList<>();

    public Server() { }

    /*
    * Adds a new student name
    */
    public void addStudent(String studentName) throws ExistingStudentException {
        if(this.studentList.contains(studentName))
            throw new ExistingStudentException();
        this.studentList.add(studentName);
    }

    /* Backups the server state to a Memento object */
    public Memento backup() {
       return new Memento(this.studentList);
    }

    /* Return the student names */
    public ArrayList<String> getStudentNames(){
        return this.studentList;
    }

    /* Restores a previous server state */
    public void restore(Memento state) {
       this.studentList = state.getState();
       System.out.println("List has been restored");
    }
}

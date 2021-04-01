package com.es2.memento;

import java.util.ArrayList;

public class Memento extends Object{
    public ArrayList<String> studentNamesList;

    public Memento(ArrayList<String> studentNames){
        this.studentNamesList = new ArrayList<>(studentNames);
    }

    public ArrayList<String> getState() {
        return this.studentNamesList;
    }
}

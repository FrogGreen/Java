package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class ClassProfiledDiplomaContest<S extends StudentClass> {

    String profileName;
    private ArrayList<S> classProfile = new ArrayList<>();

    public ClassProfiledDiplomaContest(String profileName) {
        this.profileName = profileName;
    }

    public void add(S studentClass) {
        if (classProfile.contains(studentClass)) {
            System.out.println("This student class is already in this part of class profiled diploma contest");
        } else {
            classProfile.add(studentClass);
            System.out.println("Class " + studentClass.getName() + " added to " + this.profileName);
        }
    }

    public void showClassTable() {
        Collections.sort(classProfile);
        for (S s : classProfile) {
            System.out.println(s.getName() + ": " + s.averageGrade());
        }
    }
}

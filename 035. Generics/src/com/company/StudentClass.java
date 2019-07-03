package com.company;

import java.util.ArrayList;

public class StudentClass<S extends Student> implements Comparable<StudentClass<S>> {

    private String name;
    private ArrayList<S> members = new ArrayList<>();

    public StudentClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int numberOfClassMembers() {
        return this.members.size();
    }

    public boolean addClassMember(S student) {
        if (members.contains(student)) {
            System.out.println(student.getName() + " is already in this class");
            return false;
        } else {
            members.add(student);
            System.out.println(student.getName() + " added to the " + this.name + " class.");
            return true;
        }
    }

    public double averageGrade() {
        double average = 0;
        if (members.size() != 0) {
            for (Student members : members) {
                average += members.getGradeAverage();
            }
            average = average / members.size();
        }
        return average;
    }

    @Override
    public int compareTo(StudentClass<S> studentClass) {
        if (this.averageGrade() > studentClass.averageGrade()) {
            return -1;
        } else if (this.averageGrade() == studentClass.averageGrade()) {
            return 0;
        } else {
            return 1;
        }
    }
}
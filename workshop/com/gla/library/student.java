package com.gla.library;

public class student extends person {
    private int rollNumber;
    private int year;
    private branch branch;

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public branch getBranch() {
        return branch;
    }

    public void setBranch(branch branch) {
        this.branch = branch;
    }
}

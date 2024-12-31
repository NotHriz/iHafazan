import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
// TODO: Review the code and identify the changes that need to be made to the Surah class
// TODO: Implement this to main class
// TODO: Review unused variables and methods
// TODO: Review what class contructor needs and add to relevant class(es)
// TODO: Review the methods and variables that need to be public and private
// TODO: MAYBE seperate Surah and SurahManagement class for better understanding

// Class representing a Surah (chapter of the Quran)
class Surah {
    private int id; // Surah ID
    private String name; // Surah name
    private int numberOfAyahs; // Current number of ayahs assigned for memorization
    private int totayahs; // Total number of ayahs in the Surah
    private int assignedStudentId; // ID of the student assigned to the Surah (-1 if unassigned)
    private String dateCreated; // Date when the Surah was created

    // Constructor to initialize a Surah object
    public Surah(int id, String name, int numberOfAyahs, int totayahs, int assignedStudentId, String dateCreated) {
        this.id = id;
        this.name = name;
        this.numberOfAyahs = numberOfAyahs;
        this.totayahs = totayahs;
        this.assignedStudentId = assignedStudentId;
        this.dateCreated = dateCreated;
    }

    // Getter and setter methods for accessing and modifying private fields
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfAyahs() {
        return numberOfAyahs;
    }

    public int getTotayahs() {
        return totayahs;
    }

    public int getAssignedStudentId() {
        return assignedStudentId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setAssignedStudentId(int assignedStudentId) {
        this.assignedStudentId = assignedStudentId;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    // Overriding the toString method to provide a string representation of a Surah
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Total Ayahs: " + totayahs + ", Current Ayahs: " + numberOfAyahs
                + ", Assigned to Student ID: " + assignedStudentId + ", Created on: " + dateCreated;
    }
}

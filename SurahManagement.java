import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SurahManagement {
    private ArrayList<Surah> surahList = new ArrayList<>(); // List of Surahs
    private Scanner scanner = new Scanner(System.in); // Scanner for user input
    private static final String SURAH_FILE = "surah_data.txt"; // File to store Surah data
    private static final String STUDENT_FILE = "student_data.txt"; // File to store student data

    // Constructor to load existing Surah data from the file
    private SurahManagement() {
        loadSurahsFromFile();
    }

    // Load Surah data from a file
    private void loadSurahsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(SURAH_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int numberOfAyahs = Integer.parseInt(data[2]);
                int totayahs = Integer.parseInt(data[3]);
                int assignedStudentId = Integer.parseInt(data[4]);
                String dateCreated = data[5];
                Surah surah = new Surah(id, name, numberOfAyahs, totayahs, assignedStudentId, dateCreated);
                surahList.add(surah);
            }
        } catch (IOException e) {
            System.out.println("Error loading surah data.");
        }
    }

    // Save Surah data to a file
    private void saveSurahsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SURAH_FILE))) {
            for (Surah surah : surahList) {
                bw.write(surah.getId() + "," + surah.getName() + "," + surah.getNumberOfAyahs() + "," +
                         surah.getTotayahs() + "," + surah.getAssignedStudentId() + "," + surah.getDateCreated() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving surah data.");
        }
    }

    // Retrieve the name of a student by their ID from the student file
    private String getStudentNameById(int studentId) {
        try (BufferedReader br = new BufferedReader(new FileReader(STUDENT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                if (id == studentId) {
                    return name;
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading student data.");
        }
        return null;
    }

    // Assign a Surah to a student by their ID
    public void assignSurahToStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String studentName = getStudentNameById(studentId);
            if (studentName == null) {
                System.out.println("Error: Student not found!");
                return;
            }

            System.out.print("Enter Surah ID to assign: ");
            int surahId = scanner.nextInt();

            for (Surah surah : surahList) {
                if (surah.getId() == surahId) {
                    surah.setAssignedStudentId(studentId);
                    saveSurahsToFile(); // Save changes to file
                    System.out.println("Surah " + surah.getName() + " assigned to " + studentName + " successfully!");
                    return;
                }
            }
            System.out.println("Error: Surah with ID " + surahId + " not found!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    // Create a new Surah and add it to the list
    public void createSurah() {
        try {
            System.out.print("Enter Surah ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter Surah Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Total Ayahs: ");
            int totayahs = scanner.nextInt();
            System.out.print("Enter Current Ayahs: ");
            int ayahs = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Date Created (YYYY-MM-DD): ");
            String dateCreated = scanner.nextLine(); // Take date as input

            Surah surah = new Surah(id, name, ayahs, totayahs, -1, dateCreated); // Create a new Surah
            surahList.add(surah);
            saveSurahsToFile(); // Save changes to file
            System.out.println("Surah added successfully on " + dateCreated + "!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    // Update the details of an existing Surah
    public void updateSurah() {
        try {
            System.out.print("Enter Student ID to verify: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Surah ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (Surah surah : surahList) {
                if (surah.getId() == id && surah.getAssignedStudentId() == studentId) {
                    System.out.print("Enter new Surah Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new current Number of Ayahs: ");
                    int ayahs = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter updated Date Created (YYYY-MM-DD): ");
                    String dateCreated = scanner.nextLine(); // Take date as input

                    surah.setAssignedStudentId(studentId);
                    surah.setDateCreated(dateCreated); // Update creation date

                    saveSurahsToFile(); // Save changes to file
                    System.out.println("Surah updated successfully on " + dateCreated + "!");
                    return;
                }
            }
            System.out.println("Error: Surah with ID " + id + " not found or incorrect Student ID!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    // Delete a Surah from the list
    public void deleteSurah() {
        try {
            System.out.print("Enter Student ID to verify: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Surah ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (Surah surah : surahList) {
                if (surah.getId() == id && surah.getAssignedStudentId() == studentId) {
                    surahList.remove(surah);
                    saveSurahsToFile(); // Save changes to file
                    System.out.println("Surah deleted successfully!");
                    return;
                }
            }
            System.out.println("Error: Surah with ID " + id + " not found or incorrect Student ID!");
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    // Display the list of all Surahs
    public void readSurahs() {
        if (surahList.isEmpty()) {
            System.out.println("No Surahs available.");
        } else {
            System.out.println("List of Surahs:");
            for (Surah surah : surahList) {
                String studentName = getStudentNameById(surah.getAssignedStudentId());
                System.out.println(surah + (studentName != null ? ", Assigned to: " + studentName : ", Not Assigned"));
            }
        }
    }

    // Menu for managing Surahs
    public void manageSurahs() {
        int choice = 0;
        do {
            try {
                System.out.println("\n--- Surah Management ---");
                System.out.println("1. Assign Surah to Student");
                System.out.println("2. Create Surah");
                System.out.println("3. Read Surahs");
                System.out.println("4. Update Surah");
                System.out.println("5. Delete Surah");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        assignSurahToStudent();
                        break;
                    case 2:
                        createSurah();
                        break;
                    case 3:
                        readSurahs();
                        break;
                    case 4:
                        updateSurah();
                        break;
                    case 5:
                        deleteSurah();
                        break;
                    case 6:
                        System.out.println("Exiting Surah Management...");
                        break;
                    default:
                        System.out.println("Error: Invalid choice. Please select a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input! Please try again.");
                scanner.nextLine(); // Clear invalid input
            }
        } while (choice != 6);
    }
}
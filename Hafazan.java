import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Surah {
    private int id;
    private String name;
    private int totalAyahs;
    private ArrayList<Integer> assignedStudentIds;

    // Constructor without originalDate
    public Surah(int id, String name, int totalAyahs, ArrayList<Integer> assignedStudentIds) {
        this.id = id;
        this.name = name;
        this.totalAyahs = totalAyahs;
        this.assignedStudentIds = assignedStudentIds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotalAyahs() {
        return totalAyahs;
    }

    public ArrayList<Integer> getAssignedStudentIds() {
        return assignedStudentIds;
    }

    public void addStudentId(int studentId) {
        if (!assignedStudentIds.contains(studentId)) {
            assignedStudentIds.add(studentId);
        }
    }

    @Override
    public String toString() {
        // Removed originalDate from the string representation
        return id + "," + name + "," + totalAyahs + "," + assignedStudentIds.toString().replaceAll("[\\[\\] ]", "");
    }
}

public class Hafazan {
    private ArrayList<Surah> surahList = new ArrayList<>();
    private static final String SURAH_FILE = "surah_data.txt";
    private Scanner scanner = new Scanner(System.in); // Reuse the same scanner object

    public Hafazan() {
        loadSurahs();
    }

    public void addSurah() {
        try {
            System.out.print("Enter Surah ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Surah Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Total Ayahs: ");
            int totalAyahs = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Assigned Student IDs: ");
            String[] studentIds = scanner.nextLine().split(" ");
            ArrayList<Integer> assignedStudentIds = new ArrayList<>();
            for (String idStr : studentIds) {
                assignedStudentIds.add(Integer.parseInt(idStr.trim()));
            }

            // Removed the prompt for the original date
            Surah surah = new Surah(id, name, totalAyahs, assignedStudentIds);
            surahList.add(surah);
            saveSurahs();

            System.out.println("Surah added successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void updateSurah() {
        try {
<<<<<<< HEAD
            System.out.print("Enter Surah ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (Surah surah : surahList) {
                if (surah.getId() == id) {
                    System.out.println("Assigned Student IDs: " + surah.getAssignedStudentIds());

                    System.out.print("Enter Additional Student IDs to Assign: ");
                    String[] studentIds = scanner.nextLine().split(" ");
                    for (String idStr : studentIds) {
                        if (!idStr.trim().isEmpty()) {
                            surah.addStudentId(Integer.parseInt(idStr.trim()));
                        }
                    }

                    System.out.print("Enter New Total Ayahs: ");
                    int totalAyahs = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter New Name: ");
                    String name = scanner.nextLine();

                    // Update surah details
                    surahList.remove(surah);
                    surahList.add(new Surah(id, name, totalAyahs, surah.getAssignedStudentIds()));

                    saveSurahs();

                    System.out.println("Surah updated successfully!");
                    return;
                }
            }
            System.out.println("Surah not found.");
=======
            System.out.println("Choose an option:\n1. Update Surah Details\n2. Update Surah Assigned to Students");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            if (choice == 1) {
                System.out.print("Enter Surah ID to update: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                for (Surah surah : surahList) {
                    if (surah.getId() == id) {
                        System.out.print("Enter New Total Ayahs: ");
                        int totalAyahs = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
    
                        System.out.print("Enter New Name: ");
                        String name = scanner.nextLine();
    
                        // Update surah details
                        surahList.remove(surah);
                        surahList.add(new Surah(id, name, totalAyahs, surah.getAssignedStudentIds()));
    
                        saveSurahs();
    
                        System.out.println("Surah details updated successfully!");
                        return;
                    }
                }
                System.out.println("Surah not found.");
            } else if (choice == 2) {
                System.out.print("Enter Surah ID to update assigned students: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
    
                for (Surah surah : surahList) {
                    if (surah.getId() == id) {
                        System.out.println("Current Assigned Student IDs: " + surah.getAssignedStudentIds());
    
                        System.out.print("Enter Additional Student IDs to Assign: ");
                        String[] studentIds = scanner.nextLine().split(" ");
                        for (String idStr : studentIds) {
                            if (!idStr.trim().isEmpty()) {
                                surah.addStudentId(Integer.parseInt(idStr.trim()));
                            }
                        }
    
                        saveSurahs();
    
                        System.out.println("Assigned students updated successfully!");
                        return;
                    }
                }
                System.out.println("Surah not found.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
>>>>>>> aa0f913d2e5573cff99e65da12cf5bef9aa038e8
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please try again.");
            scanner.nextLine(); // Clear invalid input
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void listSurahs() {
        try {
            System.out.print("Choose an option:\n1. List all Surahs\n2. List Surahs by ID\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n--- List of All Surahs ---");
                    for (Surah surah : surahList) {
                        System.out.println("ID: " + surah.getId());
                        System.out.println("Name: " + surah.getName());
                        System.out.println("Total Ayahs: " + surah.getTotalAyahs());
                        System.out.println("Assigned Student IDs: " + surah.getAssignedStudentIds());
                        System.out.println("-------------------------");
                    }
                    break;
                case 2:
                    System.out.print("Enter Surah ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("\n--- Surahs with ID: " + id + " ---");
                    boolean found = false;
                    for (Surah surah : surahList) {
                        if (surah.getId() == id) {
                            System.out.println("ID: " + surah.getId());
                            System.out.println("Name: " + surah.getName());
                            System.out.println("Total Ayahs: " + surah.getTotalAyahs());
                            System.out.println("Assigned Student IDs: " + surah.getAssignedStudentIds());
                            System.out.println("-------------------------");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("No Surahs found with the given ID.");
                    }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public void deleteSurah() {
        try {
<<<<<<< HEAD
            System.out.print("Enter Surah ID to delete: ");
            int surahId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Student ID to delete the Surah: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (Surah surah : surahList) {
                if (surah.getId() == surahId && surah.getAssignedStudentIds().contains(studentId)) {
                    surahList.remove(surah);
                    saveSurahs();
                    System.out.println("Surah with ID " + surahId + " and Student ID " + studentId + " deleted successfully!");
                    return;
                }
            }

            System.out.println("Surah with ID " + surahId + " and Student ID " + studentId + " not found.");
=======
            System.out.print("Enter Surah ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            System.out.print("Choose an option:\n1. Delete Surah and all Student IDs\n2. Delete Student ID only\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            for (Surah surah : surahList) {
                if (surah.getId() == id) {
                    switch (choice) {
                        case 1:
                            // Delete Surah and all its student IDs
                            surahList.remove(surah);
                            saveSurahs();
                            System.out.println("Surah and all assigned student IDs deleted successfully!");
                            return;
    
                        case 2:
                            // Delete only the student ID
                            System.out.print("Enter Student ID to remove: ");
                            int studentId = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
    
                            if (surah.getAssignedStudentIds().contains(studentId)) {
                                surah.getAssignedStudentIds().remove((Integer) studentId);
                                saveSurahs();
                                System.out.println("Student ID removed successfully!");
                            } else {
                                System.out.println("Student ID not found in this Surah.");
                            }
                            return;
    
                        default:
                            System.out.println("Invalid option. Please try again.");
                            return;
                    }
                }
            }
    
            System.out.println("Surah not found.");
>>>>>>> aa0f913d2e5573cff99e65da12cf5bef9aa038e8
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }
<<<<<<< HEAD
=======
    
>>>>>>> aa0f913d2e5573cff99e65da12cf5bef9aa038e8
    private void saveSurahs() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SURAH_FILE))) {
            for (Surah surah : surahList) {
                writer.write(surah.toString());  // No need to write the date anymore
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving surahs: " + e.getMessage());
        }
    }

    private void loadSurahs() {
        File file = new File(SURAH_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(SURAH_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int totalAyahs = Integer.parseInt(parts[2]);
                ArrayList<Integer> assignedStudentIds = new ArrayList<>();
                for (String idStr : parts[3].split(" ")) {
                    assignedStudentIds.add(Integer.parseInt(idStr));
                }

                // Removed the date handling
                Surah surah = new Surah(id, name, totalAyahs, assignedStudentIds);
                surahList.add(surah);
            }
        } catch (IOException e) {
            System.out.println("Error loading surahs: " + e.getMessage());
        }
        }
<<<<<<< HEAD
    }
=======
     }
>>>>>>> aa0f913d2e5573cff99e65da12cf5bef9aa038e8

    

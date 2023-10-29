import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class JournalMain {
    public static void main(String[] args) {
        System.out.println("Welcome to MINIMO");

        try {
            JournalEntryManager entryManager = new JournalEntryManager();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("A Minimal Journal Management System");
                System.out.println("1. Add Entry");
                System.out.println("2. List Entries");
                System.out.println("3. View Entry by Title");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                boolean f = false;

                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    switch (choice) {
                        case 1:
                            System.out.print("Enter title: ");
                            String title = scanner.nextLine();
                            System.out.print("Enter content: ");
                            String content = scanner.nextLine();
                            JournalEntry entry = new JournalEntry(new Date(), title, content);
                            entryManager.addEntry(entry);
                            EntryToDB.InsertToDB(entry);
                            System.out.println("Entry added successfully.");
                            break;

                        case 2:
                            System.out.println("Listing Entries:");
                            List<JournalEntry> entries = entryManager.getAllEntries();
                            if (entries.isEmpty()) {
                                System.out.println("No entries found.");
                            } else {
                                for (JournalEntry e : entries) {
                                    System.out.println("Title: " + e.getTitle());
                                    System.out.println("Content: " + e.getContent());
                                    System.out.println();
                                }
                            }
                            break;

                        case 3:
                            System.out.print("Enter the title to search for: ");
                            String searchTitle = scanner.nextLine();
                            JournalEntry foundEntry = entryManager.getEntryByTitle(searchTitle);
                            if (foundEntry != null) {
                                System.out.println("Title: " + foundEntry.getTitle());
                                System.out.println("Content: " + foundEntry.getContent());
                            } else {
                                System.out.println("No entry found for the specified title.");
                            }
                            break;

                        case 4:
                            scanner.close();
                            System.out.println("Goodbye!");
                            System.exit(0);

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                
                
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thank you for using the application.");
        System.out.println("See you soon.....");
        System.out.println("BYE BYE !!");
    }
}
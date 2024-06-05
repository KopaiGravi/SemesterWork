package org.example;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DocumentManagementSystem dms = new DocumentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Load documents from file at startup
        try {
            dms.loadDocumentsFromFile("documents.dat");
            System.out.println("Documents loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing documents found. Starting fresh.");
        }

        do {
            System.out.println("Electronic Document Management System");
            System.out.println("1. Add Document");
            System.out.println("2. Get Document by ID");
            System.out.println("3. Update Document");
            System.out.println("4. Delete Document");
            System.out.println("5. List All Documents");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter document ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter document title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter document content: ");
                    String content = scanner.nextLine();
                    Document doc = new Document(id, title, content);
                    dms.addDocument(doc);
                    System.out.println("Document added successfully.");
                    break;
                case 2:
                    System.out.print("Enter document ID: ");
                    id = scanner.nextInt();
                    Document retrievedDoc = dms.getDocumentById(id);
                    if (retrievedDoc != null) {
                        System.out.println("Document found: " + retrievedDoc);
                    } else {
                        System.out.println("Document not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter document ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new content: ");
                    String newContent = scanner.nextLine();
                    dms.updateDocument(id, newContent);
                    System.out.println("Document updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter document ID: ");
                    id = scanner.nextInt();
                    dms.deleteDocument(id);
                    System.out.println("Document deleted successfully.");
                    break;
                case 5:
                    System.out.println("List of all documents:");
                    for (Document d : dms.listAllDocuments()) {
                        System.out.println(d);
                    }
                    break;
                case 6:
                    System.out.println("Saving documents and exiting the system.");
                    try {
                        dms.saveDocumentsToFile("documents.dat");
                    } catch (IOException e) {
                        System.out.println("Error saving documents: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
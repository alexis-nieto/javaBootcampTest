package com.jbt.sysout.menus.members;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.jbt.db.drivers.Books;
import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.printers.menus.PrinterMenuBooks;

public class MenuMembersSearch {

    public static Scanner scanner = new Scanner(System.in);

    public static void searchBook() {

        PrinterMenuBooks.printBookSearch();
        Books books = new Books();
        
        boolean validChoice = false;
        while (!validChoice) {
            try {
                String choice = scanner.nextLine();
                
                switch (choice) {
                    case "1":
                        // Perform search by ISBN
                        String isbn = "";
                        while (isbn.isEmpty()) {
                            System.out.println("Enter ISBN:");
                            isbn = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        books.getBooks("isbn", isbn);
                        break;
                    case "2":
                        // Perform search by Title
                        String title = "";
                        while (title.isEmpty()) {
                            System.out.println("Enter Title:");
                            title = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        books.getBooks("title", title);
                        break;
                    case "3":
                        // Perform search by Author
                        String author = "";
                        while (author.isEmpty()) {
                            System.out.println("Enter Author:");
                            author = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        books.getBooks("author", author);
                        break;
                    case "4":
                        // Perform search by Publisher
                        String publisher = "";
                        while (publisher.isEmpty()) {
                            System.out.println("Enter Publisher:");
                            publisher = scanner.nextLine().trim();
                        }
                        validChoice = true;
                        books.getBooks("publisher", publisher);
                        break;
                    case "5":
                        // Perform search by Publication Year
                        int publicationYear = 0;
                        while (publicationYear <= 0) {
                            try {
                                System.out.println("Enter Publication Year:");
                                publicationYear = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid publication year.");
                                scanner.nextLine(); // Consume the invalid input
                            }
                        }
                        validChoice = true;
                        books.getBooks("publication_year", String.valueOf(publicationYear));                        break;
                    case "6":
                        // Perform search by Genre
                        String genre = "";
                        while (genre.isEmpty()) {
                            System.out.println("Enter Genre:");
                            genre = scanner.nextLine().trim();
                        }
                        books.getBooks("genre", genre);
                        validChoice = true;
                        break;
                    case "7":
                        // Perform search by Language
                        String language = "";
                        while (language.isEmpty()) {
                            System.out.println("Enter Language:");
                            language = scanner.nextLine().trim();
                        }
                        
                        validChoice = true;
                        books.getBooks("language_db", language);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                PrinterCommon.clearScreen();
                System.out.println("Invalid option, please try again.\n");
            }
        }
    }        
}

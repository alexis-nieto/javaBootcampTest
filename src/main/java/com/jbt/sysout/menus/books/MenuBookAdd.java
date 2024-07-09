package com.jbt.sysout.menus.books;

import java.util.Scanner;

import com.jbt.db.containers.Book;
import com.jbt.db.drivers.Books;
import com.jbt.sysout.PrinterCommon;

public class MenuBookAdd {

    private static Scanner scanner = new Scanner(System.in);

    public static void addNewBook() {

        PrinterCommon.clearScreen();

        System.out.println(">>> Adding new Book");

        Books books = new Books();
        Book book = new Book();
        
        // Prompt user for book details

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        while (isbn.isEmpty()) {
            System.out.print("ISBN cannot be empty. Please enter a valid title: ");
            isbn = scanner.nextLine();
        }
        book.setIsbn(isbn);
        
        if ( books.checkIfExists(book) ) {

            PrinterCommon.clearScreen();
            System.out.println("\nBook already exists in the database.\n");

        } else {

            System.out.print("Title: ");
            String title = scanner.nextLine();
            while (title.isEmpty()) {
                System.out.print("Title cannot be empty. Please enter a valid title: ");
                title = scanner.nextLine();
            }
            book.setTitle(title);

            System.out.print("Author: ");
            String author = scanner.nextLine();
            while (author.isEmpty()) {
                System.out.print("Author cannot be empty. Please enter a valid author: ");
                author = scanner.nextLine();
            }
            book.setAuthor(author);

            System.out.print("Publisher: ");
            String publisher = scanner.nextLine();
            while (publisher.isEmpty()) {
                System.out.print("Publisher cannot be empty. Please enter a valid publisher: ");
                publisher = scanner.nextLine();
            }
            book.setPublisher(publisher);

            int publicationYear;
            while (true) {
                System.out.print("Publication Year: ");
                try {
                    publicationYear = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid publication year.");
                }
            }
            book.setPublicationYear(publicationYear);

            int pageCount;
            while (true) {
                System.out.print("Page Count: ");
                try {
                    pageCount = Integer.parseInt(scanner.nextLine());
                    if (pageCount <= 0) {
                        throw new IllegalArgumentException("Page count must be greater than 0.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid page count.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            book.setPageCount(pageCount);

            int stockQuantity;
            while (true) {
                System.out.print("Stock Quantity: ");
                try {
                    stockQuantity = Integer.parseInt(scanner.nextLine());
                    if (stockQuantity < 0) {
                        throw new IllegalArgumentException("Stock quantity cannot be negative.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid stock quantity.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            book.setStockQuantity(stockQuantity);

            System.out.print("Genre: ");
            String genre = scanner.nextLine();
            book.setGenre(genre);

            System.out.print("Language: ");
            String language = scanner.nextLine();
            book.setLanguage(language);
            PrinterCommon.clearScreen();
    
            books.addBook(book);

        }

    }
}



package com.jbt.db.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.jbt.db.Config;
import com.jbt.db.containers.Book;
import com.jbt.sysout.CommonPrinter;
import com.jbt.sysout.printers.BookPrinter;

public class Members {

    private final String DB_URL = Config.getConfig("database_url") + Config.getConfig("database_name");
    private final String DB_USER = Config.getConfig("username");
    private final String DB_PASS = Config.getConfig("password");

    /**
         * Adds a book to the database.
         * 
         * @param book The book to add to the database.
         * @throws SQLIntegrityConstraintViolationException if a book with the same ISBN already exists in the database.
         * @throws SQLException if there is an error adding the book to the database.
         */
    public void addBook(Book book) {

        String SQL = "INSERT INTO books (isbn, title, author, publisher, publication_year, page_count, stock_quantity, genre, language_db) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        /*
            1) isbn
            2) title
            3) author
            4) publisher
            5) publication_year
            6) page_count
            7) stock_quantity
            8) genre
            9) language
        */

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {

        ps.setString(1, book.getIsbn());
        ps.setString(2, book.getTitle());
        ps.setString(3, book.getAuthor());
        ps.setString(4, book.getPublisher());
        ps.setInt(5, book.getPublicationYear());
        ps.setInt(6, book.getPageCount());
        ps.setInt(7, book.getStockQuantity());
        ps.setString(8, book.getGenre());
        ps.setString(9, book.getLanguage());

        ps.executeUpdate();

        BookPrinter.printSuccess("ISBN", book.getIsbn() , "added");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Task Failed:\nA book with the same ISBN already exists in the database.\n");
            //e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an unknown error adding the book to the database.\n");
            //e.printStackTrace();
        }
    }

    
    /**
         * Deletes a book from the database based on its ISBN.
         * 
         * @param book The book object to be deleted from the database.
         * @throws SQLException if there is an error deleting the book from the database.
         */
    public void deleteBook(Book book) {
        String SQL = "DELETE FROM books WHERE isbn = ?;";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {

        ps.setString(1, book.getIsbn());

        ps.executeUpdate();

        BookPrinter.printSuccess("ISBN", book.getIsbn() , "deleted");
  
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error deleting the book from the database.\n");
            //e.printStackTrace();
        }
    }

    public void updateBook(Book book) {

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE books SET");
        sb.append("title = ?, ");
        sb.append("author = ?, ");
        sb.append("publisher = ?, ");
        sb.append("publication_year = ?, ");
        sb.append("page_count = ?, ");
        sb.append("stock_quantity = ?, ");
        sb.append("genre = ?, ");
        sb.append("language_db = ? ");
        sb.append("WHERE isbn = ?;");
        //System.out.println(sb.toString());
        
        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(sb.toString());
        ) {

        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setString(3, book.getPublisher());
        ps.setInt(4, book.getPublicationYear());
        ps.setInt(5, book.getPageCount());
        ps.setInt(6, book.getStockQuantity());
        ps.setString(7, book.getGenre());
        ps.setString(8, book.getLanguage());
        ps.setString(9, book.getIsbn());

        ps.executeUpdate();

        BookPrinter.printSuccess("ISBN", book.getIsbn() , "updated");

        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error adding the book to the database.\n");
            //e.printStackTrace();
        }
    }

    /**
         * Retrieves books from the database based on the specified attribute and field.
         *
         * @param attribute The attribute to search for (e.g., "title", "author", "all").
         * @param field The value of the attribute to search for.
         */
    public void getBooks(String attribute, String field) {

        StringBuilder sql = new StringBuilder();

        if (attribute.equalsIgnoreCase("all") && field.equalsIgnoreCase("all")) {

            sql.append("SELECT * FROM books;");

        } else {

            sql.append("SELECT * FROM books WHERE ");
            sql.append(attribute);
            sql.append(" LIKE LOWER(\"%");
            sql.append(field);
            sql.append("%\");");
        }

        //System.out.println(sql.toString());

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(sql.toString());
        ) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Book book = new Book();

                book.setIsbn(rs.getString("isbn"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPublicationYear(rs.getInt("publication_year"));
                book.setPageCount(rs.getInt("page_count"));
                book.setStockQuantity(rs.getInt("stock_quantity"));
                book.setGenre(rs.getString("genre"));
                book.setLanguage(rs.getString("language_db"));

                CommonPrinter.printSeparator();
                BookPrinter.printBookDetails(book);

            }

            CommonPrinter.printSeparator();

        } catch (Exception e) {
            System.out.println("Task Failed:\nAn error occurred while retrieving the books from the database.\n");
            //e.printStackTrace();
        }
        //System.out.println("END");
    }

    /**
         * Get all books by passing no arguments.
         */
    public void getBooks() {
        getBooks("all", "all");
    }
}

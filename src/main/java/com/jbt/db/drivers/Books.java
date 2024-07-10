package com.jbt.db.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.jbt.db.Config;
import com.jbt.db.containers.Book;

import com.jbt.sysout.PrinterCommon;
import com.jbt.sysout.printers.drivers.PrinterDriverBook;

/**
 * The Books class provides methods for interacting with the books table in the database.
 * It allows adding, deleting, updating, and retrieving books from the database.
 * The class uses JDBC to connect to the database and execute SQL statements.
 * It also includes methods for checking if a book exists, retrieving and updating the stock quantity of a book.
 */
public class Books {

    private final String DB_URL = Config.getConfig("database_url") + Config.getConfig("database_name");
    private final String DB_USER = Config.getConfig("username");
    private final String DB_PASS = Config.getConfig("password");

    /**
         * Adds a book to the database.
         * 
         * @param book The book to add to the database.
         * @throws SQLIntegrityConstraintViolationException If a book with the same ISBN already exists in the database.
         * @throws SQLException If there is an unknown error adding the book to the database.
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

        PrinterDriverBook.printSuccess("ISBN", book.getIsbn() , "added");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Task Failed:\nA book with the same ISBN already exists in the database.\n");
            //e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an unknown error adding the book to the database.\n");
            //e.printStackTrace();
        }
    }

    /**
         * Deletes a book from the database based on the provided Book object.
         * 
         * @param book The Book object containing the ISBN of the book to be deleted.
         * 
         * This method uses a prepared statement to execute a DELETE query on the books table,
         * using the ISBN from the provided Book object as the condition. If the deletion is
         * successful, a success message is printed. If an SQLException occurs during the process,
         * an error message is printed.
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

        PrinterDriverBook.printSuccess("ISBN", book.getIsbn() , "deleted");
  
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error deleting the book from the database.\n");
            //e.printStackTrace();
        }
    }

    /**
         * Updates a book in the database based on the provided Book object.
         * 
         * @param book The Book object containing the updated information for the book.
         * 
         * This method uses a prepared statement to execute an UPDATE query on the books table,
         * using the ISBN from the provided Book object to identify the book to be updated. The
         * title, author, publisher, publication year, page count, stock quantity, genre, and
         * language are updated with the values from the Book object. If the update is successful,
         * a success message is printed. If an SQLException occurs during the process, an error
         * message is printed.
         */
    public void updateBook(Book book) {

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE books SET ");
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

        PrinterDriverBook.printSuccess("ISBN", book.getIsbn() , "updated");

        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error updating the book on the database.\n");
            //e.printStackTrace();
        }
    }


    /**
         * Retrieves books from the database based on the specified attribute and field.
         * If both attribute and field are "all", retrieves all books.
         * Otherwise, retrieves books where the specified attribute matches the specified field (case-insensitive).
         * Prints the details of each retrieved book.
         *
         * @param attribute The attribute to search for (e.g., "title", "author"). Use "all" to retrieve all books.
         * @param field The value of the attribute to search for. Use "all" to retrieve all books.
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

                PrinterCommon.printSeparator();
                PrinterDriverBook.printBookDetails(book);

            }

            PrinterCommon.printSeparator();

        } catch (Exception e) {
            System.out.println("Task Failed:\nAn error occurred while retrieving the books from the database.\n");
            //e.printStackTrace();
        }
        //System.out.println("END");
    }


    /**
         * Retrieves all books from the database.
         */
    public void getBooks() {
        getBooks("all", "all");
    }

    /**
         * Checks if a book exists in the database.
         *
         * @param book The book to check for existence.
         * @return true if the book exists in the database, false otherwise.
         */
    public boolean checkIfExists(Book book) {
        String SQL = "SELECT COUNT(*) FROM books WHERE isbn = ?;";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {
            ps.setString(1, book.getIsbn());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            return count > 0;
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error checking if the book exists in the database.");
            return false;
        }
    }

    /**
         * Retrieves the stock quantity of a book from the database.
         *
         * @param book The book to retrieve the stock quantity for.
         * @return The stock quantity of the book, or 0 if the book is not found or an error occurs.
         */
    public int getStockQuantity(Book book){
        String SQL = "SELECT stock_quantity FROM books WHERE isbn = ?;";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {
            ps.setString(1, book.getIsbn());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return rs.getInt("stock_quantity");
            }

            return 0;
            
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error retrieving the stock quantity for the book from the database.");
            return 0;
        }
    }

    /**
         * Decreases the stock quantity of a book in the database by 1.
         * 
         * @param book The book object containing the ISBN of the book to decrease the stock quantity for.
         * @return true if the stock quantity was successfully decreased, false otherwise.
         */
    public boolean decreaseStockQuantity(Book book) {
        String SQL = "UPDATE books SET stock_quantity = stock_quantity - 1 WHERE isbn = ? AND stock_quantity > 0;";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {
            ps.setString(1, book.getIsbn());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error decreasing the stock quantity for the book in the database.");
            return false;
        }
    }

    /**
         * Increases the stock quantity of a book in the database by 1.
         *
         * @param book The book to increase the stock quantity for.
         * @return true if the stock quantity was successfully increased, false otherwise.
         */
    public boolean increaseStockQuantity(Book book) {
        String SQL = "UPDATE books SET stock_quantity = stock_quantity + 1 WHERE isbn = ?;";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {
            ps.setString(1, book.getIsbn());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error increasing the stock quantity for the book in the database.");
            return false;
        }
    }

}

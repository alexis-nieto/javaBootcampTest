package com.jbt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.jbt.db.containers.Book;

public class BookDB {

    private final String DB_URL = Config.getConfig("database_url") + Config.getConfig("database_name");
    private final String DB_USER = Config.getConfig("username");
    private final String DB_PASS = Config.getConfig("password");

    /* Constructor
    public BookDB() {
    	
        books = new ArrayList<>();
        
        //String sql = "SELECT * FROM books";


    }
    */

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

        StringBuilder sb = new StringBuilder();
        sb.append("Book with ISBN: '");
        sb.append(book.getIsbn());
        sb.append("' added successfully.");
        System.out.println(sb.toString());
  
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("A book with the same ISBN already exists in the database.");
            //e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("There was an error addig the book to the database.");
            e.printStackTrace();
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

        StringBuilder sb = new StringBuilder();
        sb.append("Book with ISBN: '");
        sb.append(book.getIsbn());
        sb.append("' deleted successfully or already absent.");
        System.out.println(sb.toString());
  
        } catch (SQLException e) {
            System.out.println("There was an error deleting the book from the database.");
            e.printStackTrace();
        }
    }

/*

    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(book.getIsbn())) {
                books.set(i, book);
                break;
            }
        }
    }



    public Book getBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

*/

    public void getBookByISBN(String isbn) {

        String SQL = "SELECT * FROM books WHERE isbn = ?";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {

            ps.setString(1, isbn);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                StringBuilder sb = new StringBuilder();
                sb.append("\n<<>><<>><<>><<>><<>><<>><<>><<>>\n\n");
                sb.append("ISBN: ").append(rs.getString("isbn")).append("\n");
                sb.append("Title: ").append(rs.getString("title")).append("\n");
                sb.append("Author: ").append(rs.getString("author")).append("\n");
                sb.append("Publisher: ").append(rs.getString("publisher")).append("\n");
                sb.append("Publication Year: ").append(rs.getString("publication_year")).append("\n");
                sb.append("Page Count: ").append(rs.getString("page_count")).append("\n");
                sb.append("Stock Quantity: ").append(rs.getString("stock_quantity")).append("\n");
                sb.append("Genre: ").append(rs.getString("genre")).append("\n");
                sb.append("Language: ").append(rs.getString("language_db"));
                
                System.out.println(sb.toString());
            }


        } catch (Exception e) {
            System.out.println("An error occurred while retrieving the books from the database.");
            e.printStackTrace();
        }
    }



    public void getAllBooks() {

        String SQL = "SELECT * FROM books";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {

                StringBuilder sb = new StringBuilder();
                sb.append("\n<<>><<>><<>><<>><<>><<>><<>><<>>\n\n");
                sb.append("ISBN: ").append(rs.getString("isbn")).append("\n");
                sb.append("Title: ").append(rs.getString("title")).append("\n");
                sb.append("Author: ").append(rs.getString("author")).append("\n");
                sb.append("Publisher: ").append(rs.getString("publisher")).append("\n");
                sb.append("Publication Year: ").append(rs.getString("publication_year")).append("\n");
                sb.append("Page Count: ").append(rs.getString("page_count")).append("\n");
                sb.append("Stock Quantity: ").append(rs.getString("stock_quantity")).append("\n");
                sb.append("Genre: ").append(rs.getString("genre")).append("\n");
                sb.append("Language: ").append(rs.getString("language_db"));
                
                System.out.println(sb.toString());
            }


        } catch (Exception e) {
            System.out.println("An error occurred while retrieving the books from the database.");
            e.printStackTrace();
        }
    }
}

package com.jbt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jbt.db.containers.Book;

public class BookDB {

    private final String DB_URL = Config.getConfig("database_url") + Config.getConfig("database_name");
    private final String DB_USER = Config.getConfig("username");
    private final String DB_PASS = Config.getConfig("password");

    private List<Book> books;

    // Constructor
    public BookDB() {
    	
    	System.out.println(DB_URL);

        books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                
                Book book = new Book();
                
                book.setIsbn( rs.getString("isbn") );
                book.setTitle( rs.getString("title") );
                book.setAuthor( rs.getString("author") );
                book.setPublicationYear( rs.getInt("publication_year") );
                book.setPageCount( rs.getInt("page_count") );
                book.setStockQuantity( rs.getInt("stock_quantity") );
                book.setPublisher( rs.getString("publisher") );
                book.setGenre( rs.getString("genre") );
                book.setLanguage( rs.getString("language") );

                books.add(book);
                System.out.println(book.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Book> getBooks() {
        return books;
    }

    

}

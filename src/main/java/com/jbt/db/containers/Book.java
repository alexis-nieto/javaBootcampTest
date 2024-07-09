package com.jbt.db.containers;


/**
 * Represents a book with various attributes such as ISBN, title, author, publisher, publication year,
 * page count, stock quantity, genre, and language.
 * Provides getters and setters for accessing and modifying the book's attributes.
 * Implements validation checks for the setter methods to ensure data integrity.
 * Overrides the toString() method to provide a JSON-like string representation of the book object.
 */
public class Book {
    private String isbn = "DEFAULT ISBN";
    private String title = "DEFAULT Title";
    private String author = "DEFAULT Author";
    private String publisher = "DEFAULT Publisher";
    private int publicationYear = 0;
    private int pageCount = 0;
    private int stockQuantity = 0;
    private String genre = "DEFAULT Genre";
    private String language = "DEFAULT Language";

    
    /**
         * Returns a JSON-like string representation of the Book object.
         * The string includes all the book's attributes in a formatted manner.
         * @return A string representation of the Book object.
         */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\t\"isbn\":\"").append(isbn).append("\",\n");
        sb.append("\t\"title\":\"").append(title).append("\",\n");
        sb.append("\t\"author\":\"").append(author).append("\",\n");
        sb.append("\t\"publisher\":\"").append(publisher).append("\",\n");
        sb.append("\t\"publicationYear\":").append(publicationYear).append(",\n");
        sb.append("\t\"pageCount\":").append(pageCount).append(",\n");
        sb.append("\t\"stockQuantity\":").append(stockQuantity).append(",\n");
        sb.append("\t\"genre\":\"").append(genre).append("\",\n");
        sb.append("\t\"language\":\"").append(language).append("\"\n");
        sb.append("}");
        return sb.toString();
    }

    // Getters and Setters
    /**
             * Gets the ISBN of the book.
             *
             * @return The ISBN of the book.
             */
    public String getIsbn() {
        return isbn;
    }

    /**
         * Sets the ISBN of the book.
         *
         * @param isbn The ISBN of the book. Must be non-null and have a maximum length of 13 characters.
         * @throws IllegalArgumentException If the ISBN is null or exceeds 13 characters.
         */
    public void setIsbn(String isbn) {
        if (isbn != null && isbn.length() <= 13) {
            this.isbn = isbn;
        } else {
            throw new IllegalArgumentException(
                "ISBN must be non-null and have a maximum length of 13 characters."
            );
        }
    }

    /**
         * Gets the title of the book.
         *
         * @return The title of the book.
         */
    public String getTitle() {
        return title;
    }

    /**
         * Sets the title of the book.
         *
         * @param title The title of the book. Must be non-null, non-empty, and have a maximum length of 255 characters.
         * @throws IllegalArgumentException If the title is null, empty, or exceeds 255 characters.
         */
    public void setTitle(String title) {
        if (title != null && !title.isEmpty() && title.length() <= 255) {
            this.title = title;
        } else {
            throw new IllegalArgumentException(
                "Title must be non-null, non-empty, and have a maximum length of 255 characters."
            );
        }
    }

    /**
         * Gets the author of the book.
         *
         * @return The author of the book.
         */
    public String getAuthor() {
        return author;
    }

    /**
         * Sets the author of the book.
         *
         * @param author The author of the book. Must be non-null, non-empty, and have a maximum length of 255 characters.
         * @throws IllegalArgumentException If the author is null, empty, or exceeds 255 characters.
         */
    public void setAuthor(String author) {
        if (author != null && !author.isEmpty() && author.length() <= 255) {
            this.author = author;
        } else {
            throw new IllegalArgumentException(
                "Author must be non-null, non-empty, and have a maximum length of 255 characters."
            );
        }
    }

    /**
         * Gets the publisher of the book.
         *
         * @return The publisher of the book.
         */
    public String getPublisher() {
        return publisher;
    }

    /**
         * Sets the publisher of the book.
         *
         * @param publisher The publisher of the book. Must be non-null, non-empty, and have a maximum length of 255 characters.
         * @throws IllegalArgumentException If the publisher is null, empty, or exceeds 255 characters.
         */
    public void setPublisher(String publisher) {
        if (publisher != null && !publisher.isEmpty() && publisher.length() <= 255) {
            this.publisher = publisher;
        } else {
            throw new IllegalArgumentException(
                "Publisher must be non-null, non-empty, and have a maximum length of 255 characters."
            );
        }
    }

    /**
         * Gets the publication year of the book.
         *
         * @return The publication year of the book.
         */
    public int getPublicationYear() {
        return publicationYear;
    }

    /**
         * Sets the publication year of the book.
         *
         * @param publicationYear The publication year of the book.
         */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
         * Gets the page count of the book.
         *
         * @return The page count of the book.
         */
    public int getPageCount() {
        return pageCount;
    }

    /**
             * Sets the page count of the book.
             *
             * @param pageCount The page count of the book. Must be a non-negative integer.
             * @throws IllegalArgumentException If the page count is a negative integer.
             */
    public void setPageCount(int pageCount) {
        if (pageCount >= 0) {
            this.pageCount = pageCount;
        } else {
            throw new IllegalArgumentException(
                "Page count must be a non-negative integer."
            );
        }
    }

    /**
         * Gets the stock quantity of the book.
         *
         * @return The stock quantity of the book.
         */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
             * Sets the stock quantity of the book.
             *
             * @param stockQuantity The stock quantity of the book. Must be a non-negative integer.
             * @throws IllegalArgumentException If the stock quantity is a negative integer.
             */
    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity >= 0) {
            this.stockQuantity = stockQuantity;
        } else {
            throw new IllegalArgumentException(
                "Stock quantity must be a non-negative integer."
            );
        }
    }

    /**
         * Gets the genre of the book.
         *
         * @return The genre of the book.
         */
    public String getGenre() {
        return genre;
    }

    /**
         * Sets the genre of the book.
         *
         * @param genre The genre of the book. Must be null or have a maximum length of 100 characters.
         * @throws IllegalArgumentException If the genre is not null and exceeds the maximum length of 100 characters.
         */
    public void setGenre(String genre) {
        if (genre == null || genre.length() <= 100) {
            this.genre = genre;
        } else {
            throw new IllegalArgumentException(
                "Genre must be null or have a maximum length of 100 characters."
            );
        }
    }

    /**
         * Gets the language of the book.
         *
         * @return The language of the book.
         */
    public String getLanguage() {
        return language;
    }

    /**
         * Sets the language of the book.
         *
         * @param language The language of the book. Must be null or have a maximum length of 50 characters.
         * @throws IllegalArgumentException If the language is not null and exceeds the maximum length of 50 characters.
         */
    public void setLanguage(String language) {
        if (language == null || language.length() <= 50) {
            this.language = language;
        } else {
            throw new IllegalArgumentException(
                "Language must be null or have a maximum length of 50 characters."
            );
        }
    }
}

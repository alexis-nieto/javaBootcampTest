package com.jbt.sysout.printers;

public class BookPrinter {


/*
    protected void printBookDetails(Book book) {
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Publisher: " + book.getPublisher());
        System.out.println("Publication Year: " + book.getPublicationYear());
        System.out.println("Page Count: " + book.getPageCount());
        System.out.println("Stock Quantity: " + book.getStockQuantity());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Language: " + book.getLanguage());
    }*/

    
    public static void printSuccess(String attribute, String field, String event){

        StringBuilder sb = new StringBuilder();
        sb.append("Book with ");
        sb.append(attribute);
        sb.append(": '");
        sb.append(field);
        sb.append("' was ");
        sb.append(event);
        sb.append(" successfully.");
        System.out.println(sb.toString());
    }

}

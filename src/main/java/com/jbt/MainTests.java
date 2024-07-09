package com.jbt;

import com.jbt.db.containers.Book;
import com.jbt.db.containers.Member;
import com.jbt.db.drivers.Books;
import com.jbt.db.drivers.Loans;
import com.jbt.db.drivers.Members;

public class MainTests {

    public static void test_addBook(){

    	Books bookDB = new Books();
		Book book = new Book();

		book.setIsbn("9780061124654");
		book.setTitle("Economic Problems of Socialism in the USSR ");
		book.setAuthor("Joseph Stalin");
		book.setPublisher("USSR Ministry of Culture");
		book.setPublicationYear(1952);
		book.setPageCount(132);
		book.setStockQuantity(7);
		book.setGenre("Politics");
		book.setLanguage("Russian");

		bookDB.addBook(book);

    }

    public static void test_deleteBook() {

        Books bookDB = new Books();
		Book book = new Book();
		book.setIsbn("9780061124654");
		bookDB.deleteBook(book);

    }

    public static void test_getBooks() {

        Books bookDB = new Books();
		bookDB.getBooks("author","scott");
		//bookDB.getBooks();

    }

    public static void test_updateBook() {
        Books bookDB = new Books();
        Book book = new Book();
        book.setIsbn("9780061124654");
        book.setTitle("Updated Book Title");
        book.setAuthor("Updated Author Name");
        book.setPublisher("Updated Publisher Name");
        book.setPublicationYear(2023);
        book.setPageCount(200);
        book.setStockQuantity(100);
        book.setGenre("Updated Genre");
        book.setLanguage("Updated Language");

        bookDB.updateBook(book);
    }
    
    public static void test_getMembers() {

        Members members = new Members();
		members.getMembers("all","all");
		//bookDB.getBooks();

    }

    public static void test_deleteMember() {

        Members members = new Members();
		Member member = new Member();
		member.setMemberId(5);
		members.deleteMember(member);

    }

    public static void test_addMember(){

    	Members memberDB = new Members();
		Member member = new Member();

		member.setFirstName("Arturo");
		member.setLastName("Nieto");
		member.setPhoneNumber("639-130-5516");
		member.setEmail("arturo@nieto.onl");
		member.setAddress("Avenida 1ra Nte 1509");
		member.setCity("Delicias");
		member.setState("CUU");
		member.setZipCode("33000");
		member.setMembershipStartDate(new java.util.Date());

		memberDB.addMember(member);

    }

    public static void test_updateMember() {
        Members memberDB = new Members();
        Member member = new Member();
        member.setMemberId(4);
        member.setFirstName("Updated First Name");
        member.setLastName("Updated Last Name");
        member.setEmail("updated3@example.com");
        member.setPhoneNumber("1234567890");
        member.setAddress("Updated Address");
        member.setCity("Updated City");
        member.setState("Updated State");
        member.setZipCode("12345");

        memberDB.updateMember(member);
    }

    public static void test_getLoans() {

        Loans loans = new Loans();
        //loans.getLoans("all","all");
        loans.getLoans();

    }
}

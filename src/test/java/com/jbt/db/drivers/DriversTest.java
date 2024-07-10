package com.jbt.db.drivers;
import org.junit.jupiter.api.Test;

import com.jbt.db.containers.Book;
import com.jbt.db.containers.Loan;
import com.jbt.db.containers.Member;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * This class contains JUnit tests for the Books, Loans, and Members classes.
 * It tests the functionality of adding and deleting books, loans, and members,
 * as well as checking if they exist in their respective collections after being
 * added or deleted.
 */
public class DriversTest {
    
    /**
         * Test adding a book to the Books collection.
         * Verifies the book's properties are set correctly and that it exists in the collection after being added.
         */
    @Test
    public void testBookAdd() {

    	Books books = new Books();
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

		books.addBook(book);
        assertEquals("Economic Problems of Socialism in the USSR ", book.getTitle());
        assertEquals("Joseph Stalin", book.getAuthor());
        assertEquals(1952, book.getPublicationYear());
        assertEquals("9780061124654", book.getIsbn());
        assertEquals(true, books.checkIfExists(book));

    }

    /**
         * Test method for deleting a book from the Books collection.
         * It creates a new Books instance, a new Book instance with a specific ISBN, 
         * deletes the book from the Books collection, and asserts that the book no longer exists in the collection.
         */
    @Test
    public void testBookDelete() {

        Books books = new Books();
		Book book = new Book();

		book.setIsbn("9780061124654");

		books.deleteBook(book);

        assertEquals(false, books.checkIfExists(book));

    }

	/**
      * Test adding a loan to the Loans collection.
      * Verifies the loan's properties are set correctly and that it exists in the collection after being added.
      */
 @Test
    public void testLoanAdd() {

    	Loans loans = new Loans();
		Loan loan = new Loan();

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        loan.setIsbn("1234567890");
		loan.setMemberId(777);
		loan.setLoanDate(new java.util.Date());

        try {

            loan.setReturnDueDate( df.parse("2024-12-15") );

        } catch (Exception e) {
            e.printStackTrace();
        }

		loans.addLoan(loan);

        assertEquals("1234567890", loan.getIsbn());
        assertEquals(777, loan.getMemberId());
        assertEquals(true, loan.getStatus().equals("active"));

    }

    /**
         * Test method for deleting a loan from the Loans collection.
         * It creates a new Loans instance, a new Loan instance with a specific loan ID,
         * deletes the loan from the Loans collection, and asserts that the loan no longer exists in the collection.
         */
    @Test
    public void testLoanDelete() {

        Loans loans = new Loans();
        Loan loan = new Loan();
        loan.setLoanId(1);
        loans.deleteLoan(loan);

        assertEquals(false, loans.checkIfExists(loan));

    }

    /**
      * Test adding a member to the Members collection.
      * Verifies the member's properties are set correctly after being added.
      */
    @Test
    public void testMemberAdd(){

    	Members members = new Members();
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

		members.addMember(member);

		assertEquals("Arturo", member.getFirstName());
		assertEquals("Nieto", member.getLastName());
		assertEquals("639-130-5516", member.getPhoneNumber());
		assertEquals("arturo@nieto.onl", member.getEmail());
		assertEquals("Avenida 1ra Nte 1509", member.getAddress());
		assertEquals("Delicias", member.getCity());
		assertEquals("CUU", member.getState());
		assertEquals("33000", member.getZipCode());

    }

    
    //assertEquals(true, members.checkIfExists(member));

    /**
         * Test for deleting a member from the Members collection.
         * Creates a new Members collection and a new Member object, sets the member ID to 5,
         * deletes the member from the collection, and asserts that the member no longer exists
         * in the collection.
         */
    @Test
    public void testMemberDelete() {

        Members members = new Members();
		Member member = new Member();
		member.setMemberId(5);
		members.deleteMember(member);

        assertEquals(false, members.checkIfExists(member));

    }

}
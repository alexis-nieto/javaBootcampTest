package com.jbt.db.drivers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.jbt.db.Config;
import com.jbt.db.containers.Member;
import com.jbt.sysout.CommonPrinter;
import com.jbt.sysout.printers.MemberPrinter;

public class Loans {

    private final String DB_URL = Config.getConfig("database_url") + Config.getConfig("database_name");
    private final String DB_USER = Config.getConfig("username");
    private final String DB_PASS = Config.getConfig("password");

    /**
         * Adds a member to the database.
         * 
         * @param member The member to add to the database.
         * @throws SQLIntegrityConstraintViolationException if a member with the same email already exists in the database.
         * @throws SQLException if there is an error adding the member to the database.
         */
    public void addMember(Member member) {

        String SQL = "INSERT INTO members (first_name, last_name, phone_number, email, address_db, city, state_db, zip_code, membership_start_date) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        /*
            1) first_name
            2) last_name
            3) phone_number
            4) email
            5) address_db
            6) city
            7) state_db
            8) zip_code
            9) membership_start_date
        */

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {

        ps.setString(1, member.getFirstName());
        ps.setString(2, member.getLastName());
        ps.setString(3, member.getPhoneNumber());
        ps.setString(4, member.getEmail());
        ps.setString(5, member.getAddress());
        ps.setString(6, member.getCity());
        ps.setString(7, member.getState());
        ps.setString(8, member.getZipCode());
        ps.setDate(9, new java.sql.Date(member.getMembershipStartDate().getTime()));

        ps.executeUpdate();

        MemberPrinter.printSuccess("Email", member.getEmail() , "added");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Task Failed:\nA member with the same email already exists in the database.\n");
            //e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an unknown error adding the member to the database.\n");
            e.printStackTrace();
        }
    }

    /**
         * Deletes a member from the database based on their member ID.
         * 
         * @param member The member object to be deleted from the database.
         * @throws SQLException if there is an error deleting the member from the database.
         */
    public void deleteMember(Member member) {
        String SQL = "DELETE FROM members WHERE member_id = ?;";

        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(SQL);
        ) {

        ps.setInt(1, member.getMemberId());

        ps.executeUpdate();

        MemberPrinter.printSuccess("Member ID", String.valueOf(member.getMemberId()) , "deleted");
  
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error deleting the member from the database.\n");
            //e.printStackTrace();
        }
    }

    public void updateMember(Member member) {

        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE members SET ");
        sb.append("first_name = ?, ");
        sb.append("last_name = ?, ");
        sb.append("phone_number = ?, ");
        sb.append("email = ?, ");
        sb.append("address_db = ?, ");
        sb.append("city = ?, ");
        sb.append("state_db = ?, ");
        sb.append("zip_code = ? ");
        sb.append("WHERE member_id = ?;");
        
        //System.out.println(sb.toString());
        
        try (
            Connection conn = DriverManager.getConnection(
                this.DB_URL,
                this.DB_USER,
                this.DB_PASS
            );
            PreparedStatement ps = conn.prepareStatement(sb.toString());
        ) {

        ps.setString(1, member.getFirstName());
        ps.setString(2, member.getLastName());
        ps.setString(3, member.getPhoneNumber());
        ps.setString(4, member.getEmail());
        ps.setString(5, member.getAddress());
        ps.setString(6, member.getCity());
        ps.setString(7, member.getState());
        ps.setString(8, member.getZipCode());
        ps.setInt(9, member.getMemberId());

        ps.executeUpdate();

        MemberPrinter.printSuccess("Member ID", String.valueOf(member.getMemberId()) , "updated");

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Task Failed:\nThe email already exists in the database, please try with a different one.\n");
            //e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Task Failed:\nThere was an error updating the member in the database.\n");
            e.printStackTrace();
        }
    }

    /**
         * Retrieves members from the database based on the specified attribute and field.
         *
         * @param attribute The attribute to search for (e.g., "first_name", "last_name", "all").
         * @param field The value of the attribute to search for.
         */
    public void getMembers(String attribute, String field) {

        StringBuilder sql = new StringBuilder();

        if (attribute.equalsIgnoreCase("all") && field.equalsIgnoreCase("all")) {

            sql.append("SELECT * FROM members;");

        } else {

            sql.append("SELECT * FROM members WHERE ");
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

                Member member = new Member();

                member.setMemberId(rs.getInt("member_id"));
                member.setFirstName(rs.getString("first_name"));
                member.setLastName(rs.getString("last_name"));
                member.setPhoneNumber(rs.getString("phone_number"));
                member.setEmail(rs.getString("email"));
                member.setAddress(rs.getString("address_db"));
                member.setCity(rs.getString("city"));
                member.setState(rs.getString("state_db"));
                member.setZipCode(rs.getString("zip_code"));
                member.setMembershipStartDate(rs.getDate("membership_start_date"));

                CommonPrinter.printSeparator();
                MemberPrinter.printMemberDetails(member);

            }

            CommonPrinter.printSeparator();

        } catch (Exception e) {
            System.out.println("Task Failed:\nAn error occurred while retrieving the books from the database.\n");
            e.printStackTrace();
        }
        //System.out.println("END");
    }

    /**
         * Get all books by passing no arguments.
         */
    public void getMembers() {
        getMembers("all", "all");
    }
}

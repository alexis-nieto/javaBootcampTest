package com.jbt.db.containers;

/**
 * Represents a member with various attributes such as member ID, first name, last name, phone number,
 * email, address, city, state, zip code, membership start date, and membership end date.
 * Provides getters and setters for accessing and modifying the member's attributes.
 * Implements validation checks for the setter methods to ensure data integrity.
 * Overrides the toString() method to provide a JSON-like string representation of the member object.
 */
public class Member {
    private int memberId = 0;
    private String firstName = "DEFAULT First Name";
    private String lastName = "DEFAULT Last Name";
    private String phoneNumber = "DEFAULT Phone Number";
    private String email = "DEFAULT Email";
    private String address = "DEFAULT Address";
    private String city = "DEFAULT City";
    private String state = "DEFAULT State";
    private String zipCode = "DEFAULT Zip Code";
    private String membershipStartDate = "DEFAULT Membership Start Date";
    private String membershipEndDate = "DEFAULT Membership End Date";

    // Getters and Setters
    /**
     * Gets the member ID.
     *
     * @return The member ID.
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * Sets the member ID.
     *
     * @param memberId The member ID. Must be a non-negative integer.
     * @throws IllegalArgumentException If the member ID is a negative integer.
     */
    public void setMemberId(int memberId) {
        if (memberId >= 0) {
            this.memberId = memberId;
        } else {
            throw new IllegalArgumentException(
                "Member ID must be a non-negative integer."
            );
        }
    }

    /**
     * Gets the first name of the member.
     *
     * @return The first name of the member.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the member.
     *
     * @param firstName The first name of the member. Must be non-null, non-empty, and have a maximum length of 50 characters.
     * @throws IllegalArgumentException If the first name is null, empty, or exceeds 50 characters.
     */
    public void setFirstName(String firstName) {
        if (firstName != null && !firstName.isEmpty() && firstName.length() <= 50) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException(
                "First name must be non-null, non-empty, and have a maximum length of 50 characters."
            );
        }
    }

    /**
     * Gets the last name of the member.
     *
     * @return The last name of the member.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the member.
     *
     * @param lastName The last name of the member. Must be non-null, non-empty, and have a maximum length of 50 characters.
     * @throws IllegalArgumentException If the last name is null, empty, or exceeds 50 characters.
     */
    public void setLastName(String lastName) {
        if (lastName != null && !lastName.isEmpty() && lastName.length() <= 50) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException(
                "Last name must be non-null, non-empty, and have a maximum length of 50 characters."
            );
        }
    }

    /**
     * Gets the phone number of the member.
     *
     * @return The phone number of the member.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the member.
     *
     * @param phoneNumber The phone number of the member. Must be null or have a maximum length of 20 characters.
     * @throws IllegalArgumentException If the phone number is not null and exceeds the maximum length of 20 characters.
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() <= 20) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException(
                "Phone number must be null or have a maximum length of 20 characters."
            );
        }
    }

    /**
     * Gets the email of the member.
     *
     * @return The email of the member.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the member.
     *
     * @param email The email of the member. Must be non-null, non-empty, and have a maximum length of 255 characters.
     * @throws IllegalArgumentException If the email is null, empty, or exceeds 255 characters.
     */
    public void setEmail(String email) {
        if (email != null && !email.isEmpty() && email.length() <= 255) {
            this.email = email;
        } else {
            throw new IllegalArgumentException(
                "Email must be non-null, non-empty, and have a maximum length of 255 characters."
            );
        }
    }

    /**
     * Gets the address of the member.
     *
     * @return The address of the member.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the member.
     *
     * @param address The address of the member. Must be null or have a maximum length of 255 characters.
     * @throws IllegalArgumentException If the address is not null and exceeds the maximum length of 255 characters.
     */
    public void setAddress(String address) {
        if (address == null || address.length() <= 255) {
            this.address = address;
        } else {
            throw new IllegalArgumentException(
                "Address must be null or have a maximum length of 255 characters."
            );
        }
    }

    /**
     * Gets the city of the member.
     *
     * @return The city of the member.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the member.
     *
     * @param city The city of the member. Must be null or have a maximum length of 100 characters.
     * @throws IllegalArgumentException If the city is not null and exceeds the maximum length of 100 characters.
     */
    public void setCity(String city) {
        if (city == null || city.length() <= 100) {
            this.city = city;
        } else {
            throw new IllegalArgumentException(
                "City must be null or have a maximum length of 100 characters."
            );
        }
    }

    /**
     * Gets the state of the member.
     *
     * @return The state of the member.
     */
    public String getState() {
        return state;
    }
      /**
     * Sets the state of the member.
     *
     * @param state The state of the member. Must be null or have a maximum length of 50 characters.
     * @throws IllegalArgumentException If the state is not null and exceeds the maximum length of 50 characters.
     */
      public void setState(String state) {
          if (state == null || state.length() <= 50) {
              this.state = state;
          } else {
              throw new IllegalArgumentException(
                  "State must be null or have a maximum length of 50 characters."
              );
          }
      }

      /**
     * Gets the zip code of the member.
     *
     * @return The zip code of the member.
     */
      public String getZipCode() {
          return zipCode;
      }

      /**
     * Sets the zip code of the member.
     *
     * @param zipCode The zip code of the member. Must be null or have a maximum length of 20 characters.
     * @throws IllegalArgumentException If the zip code is not null and exceeds the maximum length of 20 characters.
     */
      public void setZipCode(String zipCode) {
          if (zipCode == null || zipCode.length() <= 20) {
              this.zipCode = zipCode;
          } else {
              throw new IllegalArgumentException(
                  "Zip code must be null or have a maximum length of 20 characters."
              );
          }
      }

      /**
     * Gets the membership start date of the member.
     *
     * @return The membership start date of the member.
     */
      public Date getMembershipStartDate() {
          return membershipStartDate;
      }

      /**
     * Sets the membership start date of the member.
     *
     * @param membershipStartDate The membership start date of the member. Must not be null.
     * @throws IllegalArgumentException If the membership start date is null.
     */
      public void setMembershipStartDate(Date membershipStartDate) {
          if (membershipStartDate != null) {
              this.membershipStartDate = membershipStartDate;
          } else {
              throw new IllegalArgumentException("Membership start date must not be null.");
          }
      }

      /**
     * Gets the membership end date of the member.
     *
     * @return The membership end date of the member.
     */
      public Date getMembershipEndDate() {
          return membershipEndDate;
      }

      /**
     * Sets the membership end date of the member.
     *
     * @param membershipEndDate The membership end date of the member.
     */
      public void setMembershipEndDate(Date membershipEndDate) {
          this.membershipEndDate = membershipEndDate;
      }
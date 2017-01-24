package edu.matc.entity;

// TODO Add instance variable for the date of birth --> complete
// TODO Add a calculation for the user's age. Age should not be stored, it should be calculated only. --> complete

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private Date dateOfBirth;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     * @param dateOfBirth the date of birth
     */
    public User(String firstName, String lastName, String userid, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the date of birth
     *
     * @return the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Gets the user's age
     *
     * @return the user's age
     */
    public int getUserAge() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
        );

        Period period = Period.between(birthday, today);
        return period.getYears();
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", age='" + this.getUserAge() + '\'' +
                '}';
    }


}
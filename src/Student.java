import java.time.LocalDate;
import java.time.Period;

public class Student {

    private String firstName;
    private String lastName;
    private String activities;
    private LocalDate birthday;
    private int studentNumber;
    private javafx.scene.image.Image picture;


    /**
     * This constructor accepts a students first name, last name and student number
     * to be printed on the student card. it also initializes the Student
     * object with valid values for each variable.
     *
     * @param firstName
     * @param lastName
     * @param studentNumber
     * @param activities
     */
    public Student(String firstName, String lastName, int studentNumber, String activities, LocalDate birthday, javafx.scene.image.Image picture) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        setActivities(activities);
        setBirthday(birthday);
        setPicture(picture);
    }

    /**
     * getter for first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter for first name and validates if there is any text and if first letter is upper case.
     */
    public void setFirstName(String firstName) {
        if (firstName.length() > 1 && Character.isUpperCase(firstName.codePointAt(0)))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("name length must be longer than one letter and first letter must be upper case");
    }

    /**
     * getter for last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter for last name validates if there is any text and if first letter is upper case.
     */
    public void setLastName(String lastName) {

        if (lastName.length() > 1 && Character.isUpperCase(lastName.codePointAt(0)))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("last name length must be longer than one letter and first letter must be upper case");
    }

    /**
     * getter for student number
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * sets the Student Number value and validates if the number in the range
     */
    public void setStudentNumber(int studentNumber) {
        if (studentNumber >= 1000000 && studentNumber <= 9999999)
            this.studentNumber = studentNumber;
        else
            throw new IllegalArgumentException("must be in range of 9999999-10000000");
    }

    /**
     * birthday getter
     */
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * birthday setter
     */
    public void setBirthday(LocalDate birthday) {
        if (birthday != null)
            this.birthday = birthday;
        else
            throw new IllegalArgumentException("Birthday field cannot be empty");
    }

    /**
     * method to calculate the years between current date an a given date
     */
    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * image getter
     */
    public javafx.scene.image.Image getPicture() {
        return picture;
    }

    /**
     * image setter
     */
    public void setPicture(javafx.scene.image.Image picture) {
        this.picture = picture;
    }

    /**
     * getter for activities
     */
    public String getActivities() {
        return activities;
    }

    /**
     * setter for activities
     */
    public void setActivities(String activities) {
        this.activities = activities;
    }

    /**
     * converts firstName lastName and studentNumber to strings
     */
    public String toString() {
        return String.format("%s %s student, #: %d", firstName, lastName, studentNumber);
    }

}


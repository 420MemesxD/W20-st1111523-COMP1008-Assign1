public class Student {
    
    private String firstName;
    private String lastName;
    private int studentNumber;


    /**
     * This constructor accepts a students first name, last name and student number
     * to be printed on the student card. it also initializes the Student
     * object with valid values for each variable.
     * @param firstName
     * @param lastName
     * @param studentNumber
     */
    public Student(String firstName, String lastName, int studentNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);

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
     * converts firstName lastName and studentNumber to strings
     */
    public String toString()
    {
        return String.format("%s %s student #: %d", firstName, lastName, studentNumber);
    }

}


import javax.smartcardio.Card;
import java.util.ArrayList;

public class Student {
    
    private String firstName;
    private String lastName;
    private int studentNumber;
    private String activity;
    ArrayList<String> favoriteActivities;



    public Student(String firstName, String lastName, int studentNumber, String activity) {
        setFirstName(firstName);
        setLastName(lastName);
        setStudentNumber(studentNumber);
        setActivity(activity);
        favoriteActivities = new ArrayList<>();
    }




    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
            this.activity = activity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 1 && Character.isUpperCase(firstName.codePointAt(0)))
        this.firstName = firstName;
        else
            throw new IllegalArgumentException("name length must be longer than one letter and first letter must be upper case");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        if (lastName.length() > 1 && Character.isUpperCase(lastName.codePointAt(0)))
        this.lastName = lastName;
        else
            throw new IllegalArgumentException("last name length must be longer than one letter and first letter must be upper case");
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        if (studentNumber >= 1000000 && studentNumber <= 9999999)
        this.studentNumber = studentNumber;
        else
            throw new IllegalArgumentException("must be in range of 9999999-10000000");
    }

    public ArrayList<String> getFavoriteActivities() {
        return favoriteActivities;
    }

    public void setFavoriteActivities(ArrayList<String> favoriteActivities) {
        this.favoriteActivities = favoriteActivities;
    }

    public String toString()
    {
        return String.format("%s %s student #: %d", firstName, lastName, studentNumber);
    }

}


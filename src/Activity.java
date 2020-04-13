import java.util.ArrayList;

public class Activity {

    private String activity;


    /**
     * This constructor accepts a activity to be printed on the student card.
     * It also initializes the Activity object with valid values for each variable.
     *
     * @param activity
     */
    public Activity(String activity) {
        setActivity(activity);
    }

    /**
     * Getter for activity
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Setter for Activity
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * Converts activity to a string
     */
    public String toString() {
        return String.format("%s", activity);
    }
}






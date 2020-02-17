import java.util.ArrayList;


public class ActivitiesList {

    private String activity;
    private ArrayList<Activity> hobbies;

    /**
     * This constructor accepts a activity list to be printed on the student card.
     * It also initializes the ActivityList object with valid values for each variable.
     * @param activityList
     */
    public ActivitiesList(String activityList) {
        setActivity(activityList);
        hobbies = new ArrayList<>();
    }

    /**
     * Getter for Activity
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
     * getter for Hobbies
     */
    public ArrayList<Activity> getHobbies() {
        return hobbies;
    }

    /**
     * setter for Hobbies
     */
    public void setHobbies(ArrayList<Activity> hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * method for adding an Activity to the array list and validating that there is anything there
     */
    public void addActivity(Activity activity) {
        if(activity.toString().length() > 1){
            hobbies.add(activity);
        }
        else{
            throw new IllegalArgumentException("Activity must have at least one character");
        }
    }

    /**
     * converts hobbies to a string
     */
    public String toString(){
        return String.format("%s", hobbies);
    }


}

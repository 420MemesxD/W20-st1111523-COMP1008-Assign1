import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;


public class NewStudentViewController implements Initializable {
    @FXML private TextField firstNameText;
    @FXML private TextField lastNameText;
    @FXML private TextField studentNumText;
    @FXML private CheckBox gamingCheckBox;
    @FXML private CheckBox paintBallingCheckBox;
    @FXML private CheckBox hikingCheckBox;
    @FXML private CheckBox readingCheckBox;
    @FXML private CheckBox pickingFlowersCheckBox;
    @FXML private CheckBox PrintingCheckBox;
    @FXML private CheckBox woodCarvingCheckBox;
    @FXML private CheckBox tableTennisCheckBox;
    @FXML private Label warningLabel;
    private Student newCard;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    /**
     * The submit info method gets the values from the text fields validates to make sure there is text in there and if
     * the student number isn't in the set range if will return an error to the user. It also gets all the values from the
     * selected check boxes a displays all the new information in the console when the submit button is click or this method
     * is called.
     */
    public void submitInfo()
    {
        String studentInfo = "Favourite Activities";
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();


        try {
            int studentNumber = Integer.parseInt(studentNumText.getText());
            newCard = new Student(firstName, lastName, studentNumber);

            System.out.print("New Student: " + newCard);


        } catch (IllegalArgumentException e){
            warningLabel.setText(e.getMessage());
        }

            if (gamingCheckBox.isSelected()) {
                studentInfo += "\nGaming";
            }

            if (paintBallingCheckBox.isSelected()) {
                studentInfo += "\nPaint Balling";
            }

            if (hikingCheckBox.isSelected()) {
                studentInfo += "\nHiking";
            }

            if (readingCheckBox.isSelected()) {
                studentInfo += "\nReading";
            }

            if (pickingFlowersCheckBox.isSelected()) {
                studentInfo += "\nPicking flowers";
            }

            if (PrintingCheckBox.isSelected()) {
                studentInfo += "\n3D printing";
            }

            if (woodCarvingCheckBox.isSelected()) {
                studentInfo += "\nWood carving";
            }

            if (tableTennisCheckBox.isSelected()) {
                studentInfo += "\nTable Tennis";
            }

            if (!firstName.isEmpty() && !lastName.isEmpty() && !studentNumText.getText().isEmpty()) {
                warningLabel.setText("");
                System.out.print(studentInfo);
            }



        if (firstName.isEmpty()) {
            warningLabel.setText("first name field is empty");
        }

        if (lastName.isEmpty()) {
            warningLabel.setText("last name field is empty");
        }

        if (studentNumText.getText().isEmpty()) {
            warningLabel.setText("student number field is empty");
        }

        if (firstName.isEmpty() && lastName.isEmpty()) {
            warningLabel.setText("first name and last name fields are empty");
        }

        if (firstName.isEmpty() && studentNumText.getText().isEmpty()) {
            warningLabel.setText("first name and student number are empty");
        }

        if (lastName.isEmpty() && studentNumText.getText().isEmpty()) {
            warningLabel.setText("last name and student number fields are empty");
        }

        if (firstNameText.getText().isEmpty() && lastName.isEmpty() && studentNumText.getText().isEmpty()) {
            warningLabel.setText("all fields are empty");
        }

    }

}

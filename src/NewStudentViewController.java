import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class NewStudentViewController implements Initializable {
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;
    @FXML
    private TextField studentNumText;
    @FXML
    private CheckBox gamingCheckBox;
    @FXML
    private CheckBox paintBallingCheckBox;
    @FXML
    private CheckBox hikingCheckBox;
    @FXML
    private CheckBox readingCheckBox;
    @FXML
    private CheckBox pickingFlowersCheckBox;
    @FXML
    private CheckBox PrintingCheckBox;
    @FXML
    private CheckBox woodCarvingCheckBox;
    @FXML
    private CheckBox tableTennisCheckBox;
    @FXML
    private Label warningLabel;
    @FXML
    private ImageView imageView;
    @FXML
    private DatePicker date;
    private Student newCard;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView.setImage(new Image("placeholderimage.png"));

    }

    /**
     * This method will open the file explorer so that the user can choose and image that they would like to use on their student card
     *
     * @param event
     */
    public void selectImage(ActionEvent event) {
        //get the stage to open a new window
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");

        //filters the file chooser to look for only .jpn and .png files
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fileChooser.getExtensionFilters().add(imageFilter);

        //set the starting directory of file chooser
        String userDirectoryString = System.getProperty("user.home") + "\\pictures";
        File userDirectory = new File(userDirectoryString);

        //confirm that the system can get to the directory
        if (!userDirectory.canRead()) {
            userDirectory = new File(System.getProperty("user.home"));
        }

        //set the FileChooser to start at the userDirectory
        fileChooser.setInitialDirectory(userDirectory);

        //makes the file chooser visible to user
        File imageFile = fileChooser.showOpenDialog(stage);

        if (imageFile != null && imageFile.isFile()) {
            imageView.setImage(new Image(imageFile.toURI().toString()));
        }
    }

    /**
     * The submit info method gets the values from the text fields validates to make sure there is text in there and if
     * the student number isn't in the set range if will return an error to the user. It also gets all the values from the
     * selected check boxes a displays all the new information in the console when the submit button is click or this method
     * is called.
     */


    /**
     * When this method is called, it will go to my other scene
     */
    public void changeScreen(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //get the stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * When this method is called, it will pass the info over
     */
    public void passInformation(ActionEvent event) throws IOException {

        String activities = "Favourite Activities:";
        String firstName = firstNameText.getText();
        String lastName = lastNameText.getText();
        LocalDate birthday = date.getValue();


        if (gamingCheckBox.isSelected()) {
            activities += "\nGaming";
        }

        if (paintBallingCheckBox.isSelected()) {
            activities += "\nPaint Balling";
        }

        if (hikingCheckBox.isSelected()) {
            activities += "\nHiking";
        }

        if (readingCheckBox.isSelected()) {
            activities += "\nReading";
        }

        if (pickingFlowersCheckBox.isSelected()) {
            activities += "\nPicking flowers";
        }

        if (PrintingCheckBox.isSelected()) {
            activities += "\n3D printing";
        }

        if (woodCarvingCheckBox.isSelected()) {
            activities += "\nWood carving";
        }

        if (tableTennisCheckBox.isSelected()) {
            activities += "\nTable Tennis";
        }

        try {
            int studentNumber = Integer.parseInt(studentNumText.getText());
            newCard = new Student(firstName, lastName, studentNumber, activities, birthday, imageView.getImage());

            Main.getStudents().add(newCard);

            System.out.print("New Student: " + newCard + "\n");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("StudentView.fxml"));
            Parent tableViewParent = loader.load();
            Scene tableViewScene = new Scene(tableViewParent);

            //access the controller and call a method
            StudentViewController controller = loader.getController();
            controller.initData(newCard);


            //get the stage info
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(tableViewScene);
            window.show();


        } catch (IllegalArgumentException e) {
            warningLabel.setText(e.getMessage());
        }

        if (firstName.isEmpty()) {
            warningLabel.setText("first name field is empty");
        }

        if (date.getValue() == null) {
            warningLabel.setText("Birthday field is empty");
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

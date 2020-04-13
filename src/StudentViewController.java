import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StudentViewController implements Initializable {
    @FXML
    private Label fName;
    @FXML
    private Label lName;
    @FXML
    private Label sNumber;
    @FXML
    private Label birthday;
    @FXML
    private TextArea textArea;
    @FXML
    private ImageView myImage;
    @FXML
    private ImageView myImage2;
    @FXML
    private ListView<Student> listView;


    private Student card;

    /**
     * The constructor will insert all the values for first name, last name, student number and my hobbies and display them.
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * gets the selected item from list view and calls initData
     */
    public void listViewSelected(){
        card = listView.getSelectionModel().getSelectedItem();
        initData();
    }

    /**
     * This method will change the scene to NewStudentView
     */
    public void changeScreen(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("NewStudentView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //get the stage info
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Update the info for first name, last name, student number, activities, age and image.
     */
    public void initData() {

        fName.setText("First Name: " + card.getFirstName());
        lName.setText("Last Name: " + card.getLastName());
        sNumber.setText("Student Number: " + (card.getStudentNumber()));
        birthday.setText("Age: " + (Integer.toString(card.getAge())));
        textArea.setText(card.getActivities());
        myImage.setImage(card.getPicture());
    }

    /**
     * gets the passed over values from the other scene and sets card equal to student and adds it to the list view then runs initData
     */
    public void selectedStudent(Student student){
        card = student;
        listView.getItems().addAll(Main.getStudents());
        initData();
    }
}

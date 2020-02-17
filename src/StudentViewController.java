import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class StudentViewController implements Initializable {
    @FXML private Label fName;
    @FXML private Label lName;
    @FXML private Label sNumber;
    @FXML private ImageView myImage;
    private Student card;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        card = new Student("William", "Van Wieringen", 1111523);
        myImage.setImage(new Image("./images/image0.jpg"));
        updateInfo();


    }

    @FXML
    private void updateInfo()
    {
        fName.setText("First Name: " + card.getFirstName());
        lName.setText("Last Name: " + card.getLastName());
        sNumber.setText("Student Number: " + card.getStudentNumber());

    }
}

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;


public class StudentViewController implements Initializable {
    @FXML private Label fName;
    @FXML private Label lName;
    @FXML private Label sNumber;
    @FXML private TextArea textArea;
    @FXML private ImageView myImage;
    @FXML private ImageView myImage2;
    private Student card;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        card = new Student("William", "Van Wieringen", 1111523, "Gaming");
        Activity gaming = new Activity("Gaming");
        Activity paintball = new Activity("Paintball");
        Activity eating = new Activity("Eating");
        ActivitiesList hobbies = new ActivitiesList("Activities");
        hobbies.addActivity(gaming);
        hobbies.addActivity(paintball);
        hobbies.addActivity(eating);
        textArea.setText(hobbies.toString().replace("[", "").replace("]",""));
        myImage.setImage(new Image("./images/image0.jpg"));
        myImage2.setImage(new Image("./images/LakeheadGeorgian.jpg"));
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

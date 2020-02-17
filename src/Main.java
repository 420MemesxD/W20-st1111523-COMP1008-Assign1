import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        //start the Application (GUI)
        launch(args);
        Student Will = new Student("William", "Van Wieringen", 1111523);
        System.out.println(Will.toString());
    }

    //creates the window for the GUI using the StudentView.fxml file
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StudentView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Student Card");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

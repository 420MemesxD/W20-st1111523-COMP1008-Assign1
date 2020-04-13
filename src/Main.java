import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    private static ArrayList<Student> student;

    public static ArrayList<Student> getStudents() {

        return student;
    }

    public static void main(String[] args) {
        student = new ArrayList<>();
        //start the Application (GUI)
        launch(args);
    }

    //creates the window for the GUI using the StudentView.fxml file
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("NewStudentView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Student Card");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

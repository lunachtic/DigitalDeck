import Grade.jSON;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        jSON j = new jSON();
        
        j.verificarJSON();
        
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentTCC.fxml"));

            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

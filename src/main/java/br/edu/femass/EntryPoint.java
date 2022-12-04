package br.edu.femass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneMain.fxml"));
        
        Scene scenemain = new Scene(root);
        scenemain.getStylesheets().add("/styles/Styles.css");
        scenemain.getRoot().setStyle("-fx-font-family: 'serif'");

        stage.setTitle("Menu Biblioteca");
        stage.setScene(scenemain);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}

package br.edu.femass;

import javafx.application.Application;
//import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneLivro.fxml"));
        
        Scene scenelivro = new Scene(root);
        scenelivro.getStylesheets().add("/styles/Styles.css");
        scenelivro.getRoot().setStyle("-fx-font-family: 'serif'");

        stage.setTitle("Cadastro de Livro");
        stage.setScene(scenelivro);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

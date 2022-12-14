package br.edu.femass.gui;
import java.net.URL;
import java.util.ResourceBundle;
//import br.edu.femass.model.Aluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class BibliotecarioController implements Initializable {
    
    @FXML
    private Button buttonLivros;

    @FXML
    private Button buttonAutores;

    @FXML
    private Button buttonExemplares;

    @FXML
    private void LivrosClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneLivro.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Livro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 

    @FXML
    private void AutoresClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneAutor.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Autor");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void ExemplaresClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneExemplar.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Exemplar");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }

}

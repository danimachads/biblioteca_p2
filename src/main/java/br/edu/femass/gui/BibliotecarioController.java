package br.edu.femass.gui;
import java.net.URL;
import java.util.ResourceBundle;
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
    private Button buttonListaLeitoresAtraso;

    @FXML
    private void LivrosClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneLivro.fxml"));
            Scene scenelivro = new Scene(root);
            scenelivro.getStylesheets().add("/styles/Styles.css");
            scenelivro.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Livro");
            stage.setScene(scenelivro);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 

    @FXML
    private void AutoresClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneAutor.fxml"));
            Scene sceneautor = new Scene(root);
            sceneautor.getStylesheets().add("/styles/Styles.css");
            sceneautor.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Autor");
            stage.setScene(sceneautor);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void ListaLeitoresAtrasoClick(ActionEvent event) {
        
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }

}

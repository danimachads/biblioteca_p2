package br.edu.femass.gui;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController implements Initializable {
    
    @FXML
    private Button buttonAtendente;

    @FXML
    private Button buttonBibliotecario;

    @FXML
    private Button buttonSair;

    @FXML
    private void AtendenteClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneAtendente.fxml"));
            Scene sceneatendente = new Scene(root);
            sceneatendente.getStylesheets().add("/styles/Styles.css");
            sceneatendente.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Menu Atendente");
            stage.setScene(sceneatendente);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 

    @FXML
    private void BibliotecarioClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneBibliotecario.fxml"));
            Scene scenebibliotecario = new Scene(root);
            scenebibliotecario.getStylesheets().add("/styles/Styles.css");
            scenebibliotecario.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Menu Bibliotecário");
            stage.setScene(scenebibliotecario);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    } 

    @FXML
    private void SairClick(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
}

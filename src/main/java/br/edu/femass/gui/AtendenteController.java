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

public class AtendenteController implements Initializable {
    
    @FXML
    private Button buttonCadAluno;

    @FXML
    private Button buttonCadProfessor;

    @FXML
    private Button buttonEmprestimo;

    @FXML
    private void CadAlunoClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneAluno.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Aluno");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    } 

    @FXML
    private void CadProfessorClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneProfessor.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Professor");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void EmprestimoClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneEmprestimo.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Emprestimo");
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

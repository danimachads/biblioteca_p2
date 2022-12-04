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
    private Button buttonDevolucao;

    @FXML
    private void CadAlunoClick(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/SceneAluno.fxml"));
            Scene scenealuno = new Scene(root);
            scenealuno.getStylesheets().add("/styles/Styles.css");
            scenealuno.getRoot().setStyle("-fx-font-family: 'serif'");
            Stage stage = new Stage();
            stage.setTitle("Cadastro de Aluno");
            stage.setScene(scenealuno);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } 

    @FXML
    private void CadProfessorClick(ActionEvent event) {
        
    }

    @FXML
    private void EmprestimoClick(ActionEvent event) {
        
    }

    @FXML
    private void DevolucaoClick(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
}

package br.edu.femass.gui;
import java.net.URL;
import java.util.ResourceBundle;
//import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ProfessorController implements Initializable {
    
    @FXML
    private Button txtCodigoProfessor;

    @FXML
    private Button txtNomeProfessor;

    @FXML
    private Button txtEnderecoProfessor;

    @FXML
    private Button txtTelefoneProfessor;

    @FXML
    private Button txtMatriculaProfessor;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonCancelar;

    @FXML
    private Button buttonIncluir;

    @FXML
    private Button buttonAlterar;
     
    @FXML
    private Button buttonExcluir;

    @FXML
    private ListView<Professor> lstProfessor;

    //private DaoProfessor dao = new DaoProfessor();

    //private Professor professor;

    //private Boolean incluindo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
}

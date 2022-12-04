package br.edu.femass.gui;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    private Button txtDisciplinaProfessor;

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

    private DaoProfessor daoProfessor = new DaoProfessor();

    private Professor professor;

    private Boolean incluindo;

    @FXML
    private void SalvarClick(ActionEvent event) {
      professor.setNome(txtNomeProfessor.getText());
      professor.setEndereco(txtEnderecoProfessor.getText());
      professor.setTelefone(txtTelefoneProfessor.getText());
      professor.setDisciplina(txtDisciplinaProfessor.getText());
      if(incluindo) {
        daoProfessor.inserir(professor);
      }
      else {
        daoProfessor.alterar(professor);
      }
      preencherLista();
      editar(false);
    }

    @FXML
    private void IncluirClick(ActionEvent event) {
      editar(true);
      incluindo = true;
      professor = new Professor();
      txtNomeProfessor.setText("");
      txtEnderecoProfessor.setText("");
      txtTelefoneProfessor.setText("");
      txtDisciplinaProfessor.setText("");
      txtNomeProfessor.requestFocus();
    }

    @FXML
    private void AlterarClick(ActionEvent event) {
      editar(true);
      incluindo = false;
    }

    @FXML
    private void ExcluirClick(ActionEvent event) {
      daoProfessor.apagar(professor);
      preencherLista();
      editar(false);
    }

    @FXML
    private void CancelarClick(ActionEvent event) {
      System.exit(0);
    }

    @FXML
    private void lstProfessores_KeyPressed(KeyEvent event) {
      exibirDados();
    }

    @FXML
    private void lstProfessores_MouseClicked(MouseEvent event) {
      exibirDados();
    }

    private void editar(boolean habilitar) {
        lstProfessor.setDisable(habilitar);
        txtNomeProfessor.setDisable(!habilitar);
        txtEnderecoProfessor.setDisable(!habilitar);
        txtTelefoneProfessor.setDisable(!habilitar);
        txtDisciplinaProfessor.setDisable(!habilitar);
        buttonSalvar.setDisable(!habilitar);
        buttonAlterar.setDisable(habilitar);
        buttonIncluir.setDisable(habilitar);
        buttonExcluir.setDisable(habilitar);
    }

    private void exibirDados() {
        this.professor = lstProfessor.getSelectionModel().getSelectedItem();
  
        if (professor == null) {
          return;
        }
  
        txtNomeProfessor.setText(professor.getNome());
        txtEnderecoProfessor.setText(professor.getEndereco());
        txtTelefoneProfessor.setText(professor.getTelefone());
        txtDisciplinaProfessor.setText(professor.getDisciplina());
    }

    private void preencherLista() {
        List<Professor> professores = daoProfessor.buscar();
        ObservableList<Professor> data = FXCollections.observableArrayList(professores);
        lstProfessor.setItems(data);
      }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       preencherLista();
    }
}

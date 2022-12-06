package br.edu.femass.gui;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class AlunoController implements Initializable {
    
    @FXML
    private TextField txtNomeAluno;

    @FXML
    private TextField txtEnderecoAluno;

    @FXML
    private TextField txtTelefoneAluno;

    @FXML
    private TextField txtMatriculaAluno;

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
    private ListView<Aluno> lstAluno;

    private DaoAluno dao = new DaoAluno();

    private Aluno aluno;

    private Boolean incluindo;

    @FXML
    private void SalvarClick(ActionEvent event) {
      aluno.setNome(txtNomeAluno.getText());
      aluno.setEndereco(txtEnderecoAluno.getText());
      aluno.setTelefone(txtTelefoneAluno.getText());
      aluno.setMatricula(txtMatriculaAluno.getText());
      if(incluindo) {
        dao.inserir(aluno);
      }
      else {
        dao.alterar(aluno);
      }
      preencherLista();
      editar(false);
    }

    @FXML
    private void IncluirClick(ActionEvent event) {
      editar(true);
      incluindo = true;
      aluno = new Aluno();
      txtNomeAluno.setText("");
      txtEnderecoAluno.setText("");
      txtTelefoneAluno.setText("");
      txtMatriculaAluno.setText("");
      txtNomeAluno.requestFocus();
    }

    @FXML
    private void AlterarClick(ActionEvent event) {
      editar(true);
      incluindo = false;
    }

    @FXML
    private void ExcluirClick(ActionEvent event) {
      dao.apagar(aluno);
      preencherLista();
      editar(false);
    }

    @FXML
    private void CancelarClick(ActionEvent event) {
      System.exit(0);
    }

    @FXML
    private void lstAlunos_KeyPressed(KeyEvent event) {
      exibirDados();
    }

    @FXML
    private void lstAlunos_MouseClicked(MouseEvent event) {
      exibirDados();
    }

    private void editar(boolean habilitar) {
        lstAluno.setDisable(habilitar);
        txtNomeAluno.setDisable(!habilitar);
        txtEnderecoAluno.setDisable(!habilitar);
        txtTelefoneAluno.setDisable(!habilitar);
        txtMatriculaAluno.setDisable(!habilitar);
        buttonSalvar.setDisable(!habilitar);
        buttonAlterar.setDisable(habilitar);
        buttonIncluir.setDisable(habilitar);
        buttonExcluir.setDisable(habilitar);
    }

    private void exibirDados() {
        this.aluno = lstAluno.getSelectionModel().getSelectedItem();
  
        if (aluno == null) {
          return;
        }
  
        txtNomeAluno.setText(aluno.getNome());
        txtEnderecoAluno.setText(aluno.getEndereco());
        txtTelefoneAluno.setText(aluno.getTelefone());
        txtMatriculaAluno.setText(aluno.getMatricula());
    }

    private void preencherLista() {
        List<Aluno> alunos = dao.buscar();
        ObservableList<Aluno> data1 = FXCollections.observableArrayList(alunos);
        lstAluno.setItems(data1);
      }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       preencherLista();
      }
}


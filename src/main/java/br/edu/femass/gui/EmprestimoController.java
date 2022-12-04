package br.edu.femass.gui;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;


public class EmprestimoController implements Initializable {
  
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
    private ListView<Livro> lstLivro;

    @FXML
    private ListView<Exemplar> lstExemplar;
    
    private DaoLivro daoLivro = new DaoLivro();

    private DaoExemplar daoExemplar = new DaoExemplar();

    private Livro livro;

    private Exemplar exemplar;

    private Boolean incluindo;

    @FXML
    private void SalvarClick(ActionEvent event) {
  
      if(incluindo) {
        daoExemplar.inserir(exemplar);
      }
      else {
        daoExemplar.alterar(exemplar);
      }
      preencherLista();
      editar(false);
    }

    @FXML
    private void IncluirClick(ActionEvent event) {
      editar(true);
      incluindo = true;
      exemplar = new Exemplar();
      livro = new Livro();
    }

    @FXML
    private void AlterarClick(ActionEvent event) {
      editar(true);
      incluindo = false;
    }

    @FXML
    private void ExcluirClick(ActionEvent event) {
      daoExemplar.apagar(exemplar);
      editar(false);
    }

    @FXML
    private void CancelarClick(ActionEvent event) {
      System.exit(0);
    }

    /*@FXML
    private void lstExemplares_KeyPressed(KeyEvent event) {
      exibirDados();
    }

    @FXML
    private void lstExemplares_MouseClicked(MouseEvent event) {
      exibirDados();
    }*/

    private void editar(boolean habilitar) {
      buttonSalvar.setDisable(!habilitar);
      buttonAlterar.setDisable(habilitar);
      buttonIncluir.setDisable(habilitar);
      buttonExcluir.setDisable(habilitar);
    }

    /*private void exibirDados() {
      this.exemplar = lstExemplar.getSelectionModel().getSelectedItem();

      if (exemplar== null) {
        return;
      }
    }*/

    private void preencherLista() {
      List<Exemplar> exemplares = daoExemplar.buscar();
      ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
      lstExemplar.setItems(data);
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      preencherLista();
    }    
}

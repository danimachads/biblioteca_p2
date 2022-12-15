package br.edu.femass.gui;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LivroController implements Initializable {
    
    @FXML
    private TextField txtTituloLivro; 

    //@FXML
    //private TextField txtCodigoLivro;

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
    private ComboBox<Autor> comboAutor;

    @FXML
    private ListView<Livro> lstLivro;

    @FXML
    private ListView<Autor> lstAutor;
    
    private DaoLivro daoLivro = new DaoLivro();

    private DaoAutor daoAutor = new DaoAutor();

    private Livro livro;

    private Boolean incluindo;

    @FXML
    private void SalvarClick(ActionEvent event) {
      livro.setTitulo(txtTituloLivro.getText());
      livro.setAutor(comboAutor.getSelectionModel().getSelectedItem());
      if(incluindo) {
        daoLivro.inserir(livro);
      }
      else {
        daoLivro.alterar(livro);
      }
      preencherLista();
      preencherCombo();
      editar(false);
    }

    @FXML
    private void IncluirClick(ActionEvent event) {
      editar(true);
      preencherCombo();
      incluindo = true;
      livro = new Livro();
      txtTituloLivro.setText("");
      txtTituloLivro.requestFocus();
    }

    @FXML
    private void AlterarClick(ActionEvent event) {
      editar(true);
      incluindo = false;
      preencherCombo();
    }

    @FXML
    private void ExcluirClick(ActionEvent event) {
      daoLivro.apagar(livro);
      preencherLista();
      editar(false);
    }

    @FXML
    private void CancelarClick(ActionEvent event) {
      System.exit(0);
    }

    @FXML
    private void lstLivros_KeyPressed(KeyEvent event) {
      exibirDados();
    }

    @FXML
    private void lstLivros_MouseClicked(MouseEvent event) {
      exibirDados();
    }

    private void editar(boolean habilitar) {
      lstLivro.setDisable(habilitar);
      txtTituloLivro.setDisable(!habilitar);
      comboAutor.setDisable(!habilitar);
      buttonSalvar.setDisable(!habilitar);
      buttonAlterar.setDisable(habilitar);
      buttonIncluir.setDisable(habilitar);
      buttonExcluir.setDisable(habilitar);
    }

    private void exibirDados() {
      this.livro = lstLivro.getSelectionModel().getSelectedItem();

      if (livro == null) {
        return;
      }

      txtTituloLivro.setText(livro.getTitulo());
      comboAutor.setValue(livro.getAutor());
    }

    private void preencherLista() {
      List<Livro> livros = daoLivro.buscar();
      ObservableList<Livro> data = FXCollections.observableArrayList(livros);
      lstLivro.setItems(data);
    }

    private void preencherCombo() {
      List<Autor> autores = daoAutor.buscar();
      ObservableList<Autor> data = FXCollections.observableArrayList(autores);
      comboAutor.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      preencherLista();
      preencherCombo();
    }    
}

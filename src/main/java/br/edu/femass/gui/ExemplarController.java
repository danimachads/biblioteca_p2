package br.edu.femass.gui;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ExemplarController implements Initializable {
  
    @FXML
    private TextField txtNumeroExemplar;

    @FXML
    private DatePicker dateAquisicao;

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
    private ComboBox<Livro> comboLivro;

    @FXML
    private ListView<Exemplar> lstExemplar;
    
    private DaoLivro daoLivro = new DaoLivro();

    private DaoExemplar daoExemplar = new DaoExemplar();

    private Exemplar exemplar;

    private Boolean incluindo;

      @FXML
      private void SalvarClick(ActionEvent event) {
      exemplar.setLivro(comboLivro.getSelectionModel().getSelectedItem());
      exemplar.setNumero(txtNumeroExemplar.getText().toString());
      
      LocalDate dataAquisicao = dateAquisicao.getValue();
      java.sql.Date sqlDate = java.sql.Date.valueOf(dataAquisicao);
      exemplar.setDataAquisicao(sqlDate);
      
      if(incluindo) {
        daoExemplar.inserir(exemplar);
      }
      else {
        daoExemplar.alterar(exemplar);
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
      exemplar = new Exemplar();
      comboLivro.requestFocus();
    }

    @FXML
    private void AlterarClick(ActionEvent event) {
      editar(true);
      incluindo = false;
      preencherCombo();
    }

    @FXML
    private void ExcluirClick(ActionEvent event) {
      daoExemplar.apagar(exemplar);
      preencherLista();
      editar(false);
    }

    @FXML
    private void CancelarClick(ActionEvent event) {
      System.exit(0);
    }

    @FXML
    private void lstExemplares_KeyPressed(KeyEvent event) {
      exibirDados();
    }

    @FXML
    private void lstExemplares_MouseClicked(MouseEvent event) {
      exibirDados();
    }

    private void editar(boolean habilitar) {
      lstExemplar.setDisable(habilitar);
      comboLivro.setDisable(!habilitar);
      dateAquisicao.setDisable(!habilitar);
      txtNumeroExemplar.setDisable(!habilitar);
      buttonSalvar.setDisable(!habilitar);
      buttonAlterar.setDisable(habilitar);
      buttonIncluir.setDisable(habilitar);
      buttonExcluir.setDisable(habilitar);
    }

    private void exibirDados() {
      this.exemplar = lstExemplar.getSelectionModel().getSelectedItem();
      if (exemplar== null) {
        return;
      }
      txtNumeroExemplar.setText(exemplar.getNumero());
      comboLivro.setValue(exemplar.getLivro());
    }

    private void preencherLista() {
      List<Exemplar> exemplares = daoExemplar.buscar();
      ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
      lstExemplar.setItems(data);
    }

    private void preencherCombo() {
      List<Livro> livros = daoLivro.buscar();
      ObservableList<Livro> data = FXCollections.observableArrayList(livros);
      comboLivro.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      preencherLista();
      preencherCombo();
      dateAquisicao.setValue(LocalDate.now());
    }    
}

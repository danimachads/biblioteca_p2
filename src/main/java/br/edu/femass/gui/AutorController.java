package br.edu.femass.gui;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
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

public class AutorController implements Initializable {
    @FXML
    private TextField txtNomeAutor; 

    @FXML
    private TextField txtSobreNomeAutor;

    @FXML
    private TextField txtNacionalidadeAutor;

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
    private ListView<Autor> lstAutor;

    private DaoAutor dao = new DaoAutor();

    private Autor autor;

    private Boolean incluindo;

    @FXML
    private void SalvarClick(ActionEvent event) {
      autor.setNome(txtNomeAutor.getText());
      autor.setSobrenome(txtSobreNomeAutor.getText());
      autor.setNacionalidade(txtNacionalidadeAutor.getText());
      if(incluindo) {
        dao.inserir(autor);
      }
      else {
        dao.alterar(autor);
      }
      preencherLista();
      editar(false);
    }

    @FXML
    private void IncluirClick(ActionEvent event) {
      editar(true);
      incluindo = true;
      autor = new Autor();
      txtNomeAutor.setText("");
      txtSobreNomeAutor.setText("");
      txtNacionalidadeAutor.setText("");
      txtNomeAutor.requestFocus();
      preencherLista();
    }

    @FXML
    private void AlterarClick(ActionEvent event) {
      editar(true);
      incluindo = false;
    }

    @FXML
    private void ExcluirClick(ActionEvent event) {
      dao.apagar(autor);
      preencherLista();
      editar(false);
    }

    @FXML
    private void CancelarClick(ActionEvent event) {
      System.exit(0);
    }

    @FXML
    private void lstAutor_KeyPressed(KeyEvent event) {
      exibirDados();
    }

    @FXML
    private void lstAutor_MouseClicked(MouseEvent event) {
      exibirDados();
    }

    private void editar(boolean habilitar) {
        lstAutor.setDisable(habilitar);
        txtNomeAutor.setDisable(!habilitar);
        txtSobreNomeAutor.setDisable(!habilitar);
        txtNacionalidadeAutor.setDisable(!habilitar);
        buttonSalvar.setDisable(!habilitar);
        buttonAlterar.setDisable(habilitar);
        buttonIncluir.setDisable(habilitar);
        buttonExcluir.setDisable(habilitar);
    }

    private void exibirDados() {
        this.autor = lstAutor.getSelectionModel().getSelectedItem();
  
        if (autor == null) {
          return;
        }
  
        txtNomeAutor.setText(autor.getNome());
        txtSobreNomeAutor.setText(autor.getSobrenome());
        txtNacionalidadeAutor.setText(autor.getNacionalidade());
    }

    private void preencherLista() {
        List<Autor> autores = dao.buscar();
        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        lstAutor.setItems(data);
      }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherLista();
    }
}

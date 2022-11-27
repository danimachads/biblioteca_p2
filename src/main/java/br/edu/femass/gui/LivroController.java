package br.edu.femass.gui;
import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.Dao;
import br.edu.femass.model.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class LivroController implements Initializable {
    
    @FXML
    private TextField txtTituloLivro; 

    //@FXML
    // TextField txtCodigoLivro;

    @FXML
    private Button buttonSalvar;

    @FXML
    private Button buttonCancelar;

    @FXML
    private ListView<Livro> lstLivro;
    
    @FXML
    private void SalvarClick(ActionEvent event) {
      Livro livro = new Livro(txtTituloLivro.getText());
      
      Dao<Livro> dao = new Dao<>();
      dao.inserir(livro);
      System.out.println(livro.getId());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
}

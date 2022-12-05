package br.edu.femass.gui;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import br.edu.femass.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class EmprestimoController implements Initializable {
  
    @FXML
    private Button buttonSalvarA;

    @FXML
    private Button buttonCancelarA;

    @FXML
    private Button buttonSalvarP;

    @FXML
    private Button buttonCancelarP;

    @FXML
    private Button buttonIncluir;

    @FXML
    private Button buttonAlterar;
   
    @FXML
    private Button buttonExcluir;

    @FXML
    private ListView<Emprestimo> lstEmprestimo;

    @FXML
    private ComboBox<Aluno> comboAluno;

    @FXML
    private ComboBox<Exemplar> comboExemplarA;

    @FXML
    private ComboBox<Professor> comboProfessor;

    @FXML
    private ComboBox<Exemplar> comboExemplarP;

    private DaoEmprestimo daoEmprestimo = new DaoEmprestimo();

    private DaoAluno daoAluno = new DaoAluno();

    private DaoProfessor daoProfessor = new DaoProfessor();

    private DaoExemplar daoExemplar = new DaoExemplar();

    private Emprestimo emprestimo;

    private Exemplar exemplar;

    private Aluno aluno;

    private Professor professor;

    private Boolean incluindo;
  

    /*@FXML
    private void SalvarAClick(ActionEvent event) {
      emprestimo.setLeitor(comboAluno.getSelectionModel().getSelectedItem());
      emprestimo.setExemplar(comboAluno.getSelectionModel().getSelectedItem());
      if(incluindo) {
        daoEmprestimo.inserir(emprestimo);
      }
      else {
        daoEmprestimo.alterar(emprestimo);
      }
      preencherLista();
      preencherComboA();
      editar(false);
    }*/

    @FXML
    private void SalvarClick(ActionEvent event) {
      emprestimo.setLeitor(comboAluno.getSelectionModel().getSelectedItem());
      emprestimo.setExemplar(comboAluno.getSelectionModel().getSelectedItem());
      
      emprestimo.setLeitor(comboProfessor.getSelectionModel().getSelectedItem());
      emprestimo.setExemplar(comboProfessor.getSelectionModel().getSelectedItem());
      if(incluindo) {
        daoEmprestimo.inserir(emprestimo);
      }
      else {
        daoEmprestimo.alterar(emprestimo);
      }
      preencherLista();
      preencherComboP();
      preencherComboA();
      editar(false);
    }

    @FXML
    private void IncluirClick(ActionEvent event) {
      editar(true);
      preencherComboA();
      preencherComboP();
      incluindo = true;
      emprestimo = new Emprestimo();
      comboAluno.setValue(null);
      comboExemplarA.setValue(null);
      comboProfessor.setValue(null);
      comboExemplarP.setValue(null);
    }

    @FXML
    private void AlterarClick(ActionEvent event) {
      editar(true);
      incluindo = false;
      preencherComboA();
      preencherComboP();
    }

    @FXML
    private void ExcluirClick(ActionEvent event) {
      daoEmprestimo.apagar(emprestimo);
      preencherLista();
      editar(false);
    }

    @FXML
    private void CancelarClick(ActionEvent event) {
      System.exit(0);
    }

    private void editar(boolean habilitar) {
      lstEmprestimo.setDisable(habilitar);
      comboAluno.setDisable(!habilitar);
      comboExemplarA.setDisable(!habilitar);
      comboProfessor.setDisable(!habilitar);
      comboExemplarP.setDisable(!habilitar);
      buttonSalvarA.setDisable(!habilitar);
      buttonSalvarP.setDisable(!habilitar);
      buttonAlterar.setDisable(habilitar);
      buttonIncluir.setDisable(habilitar);
      buttonExcluir.setDisable(habilitar);
    }

    private void preencherLista() {
      List<Emprestimo> emprestimos = daoEmprestimo.buscar();
      ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimos);
      lstEmprestimo.setItems(data);
    }

    private void preencherComboA() {
      List<Aluno> alunos = daoAluno.buscar();
      ObservableList<Aluno> data = FXCollections.observableArrayList(alunos);
      comboAluno.setItems(data);
    }

    private void preencherComboP() {
      List<Professor> professores = daoProfessor.buscar();
      ObservableList<Professor> data = FXCollections.observableArrayList(professores);
      comboProfessor.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
}

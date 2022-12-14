package br.edu.femass.gui;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
//import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;
import br.edu.femass.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class EmprestimoController implements Initializable {

    @FXML
    private Button buttonSair;

    @FXML
    private Button buttonDevolver;

    @FXML
    private ComboBox<Aluno> comboAluno;

    @FXML
    private ComboBox<Exemplar> comboExemplarAluno;

    @FXML
    private Button buttonSalvarAluno;

    @FXML
    private ComboBox<Professor> comboProfessor;

    @FXML
    private ComboBox<Exemplar> comboExemplarProfessor;

    @FXML
    private Button buttonSalvarProfessor;

    @FXML
    private TableView<Emprestimo> tableEmprestimo; //= new TableView<>();

    @FXML
    private TableColumn<Exemplar, String> colunaExemplar;

    @FXML
    private TableColumn<Leitor, String> colunaLeitor;
    
    @FXML
    private TableColumn<Emprestimo, LocalDate> colunaDataEmprestimo; 

    @FXML
    private TableColumn<Emprestimo, LocalDate> colunaPrevisaoDevolucao;

    private DaoEmprestimo daoEmprestimo = new DaoEmprestimo();
    private Emprestimo emprestimo;
    
    private DaoAluno daoAluno = new DaoAluno();
    private Aluno aluno;

    private DaoProfessor daoProfessor = new DaoProfessor();
    private Professor professor;

    //private DaoExemplar daoExemplar = new DaoExemplar();
    private Exemplar exemplar;

    @FXML
    private void SalvarEmprestimoAlunoClick(ActionEvent event) {
      aluno = comboAluno.getSelectionModel().getSelectedItem();
      exemplar = comboExemplarAluno.getSelectionModel().getSelectedItem();
      emprestimo = new Emprestimo(exemplar, aluno);
      daoEmprestimo.inserir(emprestimo);
      preencherTabela();
      preencherComboBox();
    }

    @FXML
    private void SalvarEmprestimoProfessorClick(ActionEvent event) {
      professor = comboProfessor.getSelectionModel().getSelectedItem();
      exemplar = comboExemplarProfessor.getSelectionModel().getSelectedItem();
      emprestimo = new Emprestimo(exemplar, professor);
      daoEmprestimo.inserir(emprestimo);
      preencherTabela();
      preencherComboBox();
    }

    @FXML
    private void DevolverEmprestimoClick(ActionEvent event) {
      emprestimo = tableEmprestimo.getSelectionModel().getSelectedItem();
      emprestimo.setDataDevolucao(LocalDate.now());
      daoEmprestimo.alterar(emprestimo);
      preencherTabela();
  }

    @FXML
    private void preencherComboBox() {
      List<Aluno> alunos = daoAluno.buscar();
      ObservableList<Aluno> dataAluno = FXCollections.observableArrayList(alunos);
      comboAluno.setItems(dataAluno);
      List<Professor> professores = daoProfessor.buscar();
      ObservableList<Professor> dataProfessor = FXCollections.observableArrayList(professores);
      comboProfessor.setItems(dataProfessor);
    }

    private void preencherTabela() {
      List<Emprestimo> emprestimos = daoEmprestimo.buscar();
      ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimos);
      tableEmprestimo.setItems(data);
    }

    @FXML
    private void SairClick(ActionEvent event) {
      System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      preencherTabela();
      preencherComboBox();
      
      colunaExemplar.setCellValueFactory(new PropertyValueFactory<Exemplar, String>("exemplar"));
      colunaLeitor.setCellValueFactory(new PropertyValueFactory<Leitor, String>("leitor"));
      colunaDataEmprestimo.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataEmprestimo"));
      colunaPrevisaoDevolucao.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataPrevistaDevolucao"));
      
    }  
} 

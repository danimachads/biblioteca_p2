package br.edu.femass.gui;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
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
    private TableView<Emprestimo> tableEmprestimo; 

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
    //private Aluno aluno;

    private DaoProfessor daoProfessor = new DaoProfessor();
    //private Professor professor;

    private DaoExemplar daoExemplar = new DaoExemplar();
    private Exemplar exemplar;

    //private Leitor leitor;

    @FXML
    private void SalvarEmprestimoAlunoClick(ActionEvent event) {
      emprestimo = new Emprestimo();
      emprestimo.setExemplar(comboExemplarAluno.getSelectionModel().getSelectedItem());
      emprestimo.setLeitor(comboAluno.getSelectionModel().getSelectedItem());
      emprestimo.setDataEmprestimo(LocalDate.now());
      emprestimo.setDataPrevistaDevolucao(LocalDate.now().plusDays(15));
      daoEmprestimo.inserir(emprestimo);


      /*aluno = comboAluno.getSelectionModel().getSelectedItem();
      exemplar = comboExemplarAluno.getSelectionModel().getSelectedItem();
      emprestimo = new Emprestimo(exemplar, aluno);
      daoEmprestimo.inserir(emprestimo);*/


      /*emprestimo.setExemplar(exemplar);
      emprestimo.setLeitor(leitor);
      daoEmprestimo.inserir(emprestimo);*/
      /*leitor = comboAluno.getSelectionModel().getSelectedItem();
      exemplar = comboExemplarAluno.getSelectionModel().getSelectedItem();
      emprestimo = new Emprestimo(exemplar, leitor);
      daoEmprestimo.inserir(emprestimo);*/
      preencherComboBox();
      preencherTabela();
    }

    @FXML
    private void SalvarEmprestimoProfessorClick(ActionEvent event) {
      emprestimo = new Emprestimo();
      emprestimo.setExemplar(comboExemplarProfessor.getSelectionModel().getSelectedItem());
      emprestimo.setLeitor(comboProfessor.getSelectionModel().getSelectedItem());
      emprestimo.setDataEmprestimo(LocalDate.now());
      emprestimo.setDataPrevistaDevolucao(LocalDate.now().plusDays(30));
      //exemplar.setDisponibilidade(false);
      daoEmprestimo.inserir(emprestimo);
      preencherTabela();
      preencherComboBox();
    }

    @FXML
    private void DevolverEmprestimoClick(ActionEvent event) {
      emprestimo = tableEmprestimo.getSelectionModel().getSelectedItem();
      emprestimo.setDataDevolucao(LocalDate.now());
      daoEmprestimo.apagar(emprestimo);
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
      List<Exemplar> exemplares = daoExemplar.buscar();
      ObservableList<Exemplar> dataExemplar = FXCollections.observableArrayList(exemplares);
      comboExemplarAluno.setItems(dataExemplar);
      List<Exemplar> exemplares2 = daoExemplar.buscar();
      ObservableList<Exemplar> dataExemplar2 = FXCollections.observableArrayList(exemplares2);
      comboExemplarProfessor.setItems(dataExemplar2);
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
      emprestimo = new Emprestimo();
      preencherTabela();
      preencherComboBox();
      colunaExemplar.setCellValueFactory(new PropertyValueFactory<Exemplar, String>("exemplar"));
      colunaLeitor.setCellValueFactory(new PropertyValueFactory<Leitor, String>("leitor"));
      colunaDataEmprestimo.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataEmprestimo"));
      colunaPrevisaoDevolucao.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataPrevistaDevolucao"));
    }  
} 

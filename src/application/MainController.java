package application;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import noten.NoteModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import noten.Noten;
import prozent.Prozent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController {
    @FXML
    private Stage stage;
    @FXML
    private TableView<NoteModel> tableview;
    @FXML
    private TableColumn<NoteModel, String> modulname;
    @FXML
    private TableColumn<NoteModel, String> mt;
    @FXML
    private TableColumn<NoteModel, String> atl;
    @FXML
    private TableColumn<NoteModel, String> praesenz;
    @FXML
    private TableColumn<NoteModel, String> prozent;

    @FXML
    private Label lbl_warning;

    @FXML
    private TextField input_Modulname;
    @FXML
    private TextField input_MT;
    @FXML
    private TextField input_ATL;
    @FXML
    private TextField input_Praesenz;
    @FXML
    private TextField input_ErreichbarLLP;

    private Noten noten = new Noten();

    public MainController() {
    }

    @FXML
    private void onAdd(ActionEvent event) {
        NoteModel noteModel = new NoteModel();
        Prozent prozent = new Prozent();
        if (!this.input_Modulname.getText().isEmpty() && !this.input_ErreichbarLLP.getText().isEmpty()) {
            this.lbl_warning.setText("");
        } else {
            this.lbl_warning.setText("Bitte alle Pflichtfelder ausfüllen!");
        }

        noteModel.setModulname(this.input_Modulname.getText());
        if (this.input_MT.getText().isEmpty()) {
            noteModel.setMt("0");
        } else {
            noteModel.setMt(this.input_MT.getText());
        }

        if (this.input_ATL.getText().isEmpty()) {
            noteModel.setAtl("0");
        } else {
            noteModel.setAtl(this.input_ATL.getText());
        }

        if (this.input_Praesenz.getText().isEmpty()) {
            noteModel.setPraesenz("0");
        } else {
            noteModel.setPraesenz(this.input_Praesenz.getText());
        }

        noteModel.setProzentObj(prozent);
        noteModel.getProzentObj().setVonLLP(Integer.parseInt(this.input_ErreichbarLLP.getText()));
        this.calcProzent(noteModel);
        this.tableview.getItems().add(noteModel);
        this.input_Modulname.clear();
        this.input_MT.clear();
        this.input_ATL.clear();
        this.input_Praesenz.clear();
        this.input_ErreichbarLLP.clear();
    }

    private void calcProzent(NoteModel notenEntry) {
        int int_totalMT = Integer.parseInt(Parser.parse(notenEntry.getMt()));
        int int_totalATL = Integer.parseInt(Parser.parse(notenEntry.getAtl()));
        int int_totalPraesenz = Integer.parseInt(Parser.parse(notenEntry.getPraesenz()));
        notenEntry.getProzentObj().setErreichtLLP(int_totalMT + int_totalATL + int_totalPraesenz);
        int erreichtProzent = notenEntry.getProzentObj().getErreichtLLP() * 100 / notenEntry.getProzentObj().getVonLLP();
        System.out.println(erreichtProzent);

        notenEntry.setProzent(notenEntry.getProzentObj().getErreichtLLP() * 100 / notenEntry.getProzentObj().getVonLLP() + "%");
        this.noten.addEntry(notenEntry);
        this.tableview.refresh();
    }

    @FXML
    private void onDelete(ActionEvent event) {
    }

    public void initialize(URL url, ResourceBundle rb) {
        this.initiateCols();
        this.tableview.setEditable(true);
        this.modulname.setCellFactory(TextFieldTableCell.forTableColumn());
        this.mt.setCellFactory(TextFieldTableCell.forTableColumn());
        this.atl.setCellFactory(TextFieldTableCell.forTableColumn());
        this.praesenz.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void initiateCols() {
        this.modulname.setCellValueFactory(new PropertyValueFactory("modulname"));
        this.mt.setCellValueFactory(new PropertyValueFactory("mt"));
        this.atl.setCellValueFactory(new PropertyValueFactory("atl"));
        this.praesenz.setCellValueFactory(new PropertyValueFactory("praesenz"));
        this.prozent.setCellValueFactory(new PropertyValueFactory("prozent"));
    }

}

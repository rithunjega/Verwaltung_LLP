package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import noten.NoteModel;
import noten.Noten;
import prozent.Prozent;

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

        calcProzent(noteModel);

        tableview.getItems().add(noteModel);
        input_Modulname.clear();
        input_MT.clear();
        input_ATL.clear();
        input_Praesenz.clear();
        input_ErreichbarLLP.clear();
    }

    public void calcProzent(NoteModel notenEntry) {
        ProzentCalculator.calc(notenEntry);
        noten.addEntry(notenEntry);
        tableview.refresh();
    }

    @FXML
    private void onDelete(ActionEvent event) {
        for (int i = 0; i < noten.getEntries().size(); i++) {
            String modulname = noten.getEntries().get(i).getModulname();
            if (tableview.getSelectionModel().getSelectedItem().getModulname().toString().equals(modulname)) {
                noten.removeEntry(noten.getEntries().get(i));
            }
        }

        tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItems());
    }

    @FXML
    private void onEditChangedModulname(TableColumn.CellEditEvent<NoteModel, String> notenStringCellEditEvent) {
        NoteModel noteModel = tableview.getSelectionModel().getSelectedItem();
        noteModel.setModulname(notenStringCellEditEvent.getNewValue());
    }

    @FXML
    private void onEditChangedMT(TableColumn.CellEditEvent<NoteModel, String> notenStringCellEditEvent) {
        NoteModel noteModel = tableview.getSelectionModel().getSelectedItem();
        noteModel.setMt(notenStringCellEditEvent.getNewValue());
        calcProzent(noteModel);
    }

    @FXML
    private void onEditChangedATL(TableColumn.CellEditEvent<NoteModel, String> notenStringCellEditEvent) {
        NoteModel notenEntry = tableview.getSelectionModel().getSelectedItem();
        notenEntry.setAtl(notenStringCellEditEvent.getNewValue());
        calcProzent(notenEntry);
    }

    @FXML
    private void onEditChangedPraesenz(TableColumn.CellEditEvent<NoteModel, String> notenStringCellEditEvent) {
        NoteModel notenEntry = tableview.getSelectionModel().getSelectedItem();
        notenEntry.setPraesenz(notenStringCellEditEvent.getNewValue());
        calcProzent(notenEntry);
    }

    public void initialize(){
        initiateCols();
        tableview.setEditable(true);
        modulname.setCellFactory(TextFieldTableCell.forTableColumn());
        mt.setCellFactory(TextFieldTableCell.forTableColumn());
        atl.setCellFactory(TextFieldTableCell.forTableColumn());
        praesenz.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void initiateCols() {
        modulname.setCellValueFactory(new PropertyValueFactory("modulname"));
        mt.setCellValueFactory(new PropertyValueFactory("mt"));
        atl.setCellValueFactory(new PropertyValueFactory("atl"));
        praesenz.setCellValueFactory(new PropertyValueFactory("praesenz"));
        prozent.setCellValueFactory(new PropertyValueFactory("prozent"));
    }

}

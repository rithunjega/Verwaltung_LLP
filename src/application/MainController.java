package application;

import Noten.NoteModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    public MainController() {
    }

    @FXML
    private void onAdd(ActionEvent event) { }

    @FXML
    private void onDelete(ActionEvent event) { }

}

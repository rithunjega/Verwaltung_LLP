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
import logic.JpaController;
import logic.ProzentCalculator;
import model.Score;
import model.Scores;
import model.Percent;

public class MainController {

    private JpaController jpaController;

    @FXML
    private Stage stage;
    @FXML
    private TableView<Score> tableview;
    @FXML
    private TableColumn<Score, String> modulname;
    @FXML
    private TableColumn<Score, String> mt;
    @FXML
    private TableColumn<Score, String> atl;
    @FXML
    private TableColumn<Score, String> presence;
    @FXML
    private TableColumn<Score, String> percent;

    @FXML
    private Label lbl_Warning;

    @FXML
    private TextField input_Modulname;
    @FXML
    private TextField input_MT;
    @FXML
    private TextField input_ATL;
    @FXML
    private TextField input_Presence;
    @FXML
    private TextField input_ReachableLLP;

    private Scores scores = new Scores();

    @FXML
    private void onAdd(ActionEvent event) {
        Score score = new Score();
        Percent percent = new Percent();

        if (!this.input_Modulname.getText().isEmpty() && !this.input_ReachableLLP.getText().isEmpty()) {
            this.lbl_Warning.setText("");
        } else {
            this.lbl_Warning.setText("Bitte alle Pflichtfelder ausfüllen!");
        }

        score.setModulname(this.input_Modulname.getText());

        if (this.input_MT.getText().isEmpty()) {
            score.setMt("0");
        } else {
            score.setMt(this.input_MT.getText());
        }

        if (this.input_ATL.getText().isEmpty()) {
            score.setAtl("0");
        } else {
            score.setAtl(this.input_ATL.getText());
        }

        if (this.input_Presence.getText().isEmpty()) {
            score.setPresence("0");
        } else {
            score.setPresence(this.input_Presence.getText());
        }

        score.setProzentObj(percent);
        score.getProzentObj().setReachableLLP(Integer.parseInt(this.input_ReachableLLP.getText()));

        calcPercent(score);

        tableview.getItems().add(score);
        input_Modulname.clear();
        input_MT.clear();
        input_ATL.clear();
        input_Presence.clear();
        input_ReachableLLP.clear();
    }

    public void calcPercent(Score scoreEntry) {
        ProzentCalculator.calc(scoreEntry);
        scores.addEntry(scoreEntry);
        //JpaController.startEm();
        //JpaController.save(scoreEntry);
        tableview.refresh();
    }

    @FXML
    private void onDelete(ActionEvent event) {
        for (int i = 0; i < scores.getEntries().size(); i++) {
            String modulname = scores.getEntries().get(i).getModulname();
            if (tableview.getSelectionModel().getSelectedItem().getModulname().toString().equals(modulname)) {
                scores.removeEntry(scores.getEntries().get(i));
                //JpaController.startEm();
                //JpaController.delete(scores.getEntries().get(i));
            }
        }
        tableview.getItems().removeAll(tableview.getSelectionModel().getSelectedItems());
    }

    @FXML
    private void onEditChangedModulname(TableColumn.CellEditEvent<Score, String> notenStringCellEditEvent) {
        Score score = tableview.getSelectionModel().getSelectedItem();
        score.setModulname(notenStringCellEditEvent.getNewValue());
        //JpaController.startEm();
        //JpaController.save(score);
    }

    @FXML
    private void onEditChangedMT(TableColumn.CellEditEvent<Score, String> notenStringCellEditEvent) {
        Score score = tableview.getSelectionModel().getSelectedItem();
        score.setMt(notenStringCellEditEvent.getNewValue());
        calcPercent(score);
        //JpaController.startEm();
        //JpaController.save(score);
    }

    @FXML
    private void onEditChangedATL(TableColumn.CellEditEvent<Score, String> notenStringCellEditEvent) {
        Score notenEntry = tableview.getSelectionModel().getSelectedItem();
        notenEntry.setAtl(notenStringCellEditEvent.getNewValue());
        calcPercent(notenEntry);
        //JpaController.startEm();
        //JpaController.save(score);
    }

    @FXML
    private void onEditChangedPraesenz(TableColumn.CellEditEvent<Score, String> notenStringCellEditEvent) {
        Score notenEntry = tableview.getSelectionModel().getSelectedItem();
        notenEntry.setPresence(notenStringCellEditEvent.getNewValue());
        calcPercent(notenEntry);
        //JpaController.startEm();
        //JpaController.save(score);
    }

    public void initialize(){
        initiateCols();
        tableview.setEditable(true);
        modulname.setCellFactory(TextFieldTableCell.forTableColumn());
        mt.setCellFactory(TextFieldTableCell.forTableColumn());
        atl.setCellFactory(TextFieldTableCell.forTableColumn());
        presence.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void initiateCols() {
        modulname.setCellValueFactory(new PropertyValueFactory("modulname"));
        mt.setCellValueFactory(new PropertyValueFactory("mt"));
        atl.setCellValueFactory(new PropertyValueFactory("atl"));
        presence.setCellValueFactory(new PropertyValueFactory("praesenz"));
        percent.setCellValueFactory(new PropertyValueFactory("prozent"));
    }

}

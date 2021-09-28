/**
 * Ein LLP-Verwaltungsprogramm welches mit Eingaben genaue Prozentwerte anzeigt
 * Dadurch können Schüler ihre Leistungen besser beurteilen
 *
 * @author Rithun Jegatheeswaran
 * @version 1.0
 */

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/scenebuilder.fxml"));
            Stage stage = fxmlLoader.load();
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
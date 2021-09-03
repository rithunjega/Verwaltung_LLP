//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("sample.fxml"));
        primaryStage.setTitle("LLP-Verwaltung");
        primaryStage.setScene(new Scene(root, 950.0D, 408.0D));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

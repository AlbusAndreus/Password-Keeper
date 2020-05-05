package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane gp = new GridPane();
        primaryStage.setTitle("Password Keeper");


        Button NewEntry = new Button("New Entry");
        GridPane.setConstraints(NewEntry, 0,0);
        NewEntry.setOnAction(event->{
            sample.NewPassword.display();

        });

        primaryStage.setScene(new Scene(gp, 300, 275));
        primaryStage.show();
        gp.getChildren().addAll(NewEntry);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

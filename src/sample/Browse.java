package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Browse {

    int position = 0;
    
    public static void display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Create New Entry");
        GridPane gp = new GridPane();

        Label account = new Label("Account:");

        Label email = new Label("Email:");

        Label password = new Label("Password:");

        Button forward = new Button("Forward");

        Button backward = new Button("Backward");

        Button delete = new Button("Delete");

        Scene scene = new Scene(gp);
        window.setScene(scene);
        window.showAndWait();
        gp.getChildren().addAll();
    }
}

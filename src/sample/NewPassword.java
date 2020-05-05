package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NewPassword {
    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Create New Entry");
        GridPane gp = new GridPane();
        Scene scene = new Scene(gp);
        window.setScene(scene);
        window.showAndWait();

        Label Account = new Label("Account");
        gp.setConstraints(Account, 0,0);

        TextField account = new TextField();
        gp.setConstraints(account, 1,0);

        Label email = new Label("Email");
        gp.setConstraints(email, 0,1);

        TextField Email = new TextField();
        gp.setConstraints(Email, 1,1);

        Label password = new Label("Email");
        gp.setConstraints(email, 0,2);

        TextField Password = new TextField();
        gp.setConstraints(Email, 1,2);

        Button SaveEntry = new Button("Save Entry");
        gp.setConstraints(SaveEntry, 2,2);

        Button Cancel = new Button("Cancel");
        gp.setConstraints(Cancel, 2,1);
        Cancel.setOnAction(event->{
           window.close();
        });

        gp.getChildren().addAll(Cancel,SaveEntry,Password,password, Email, email, account, Account);
    }
}
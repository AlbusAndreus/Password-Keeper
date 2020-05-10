package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.util.List;

public class NewPassword {
    static int count = 1;
    public static void display(List<Entry> list) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Create New Entry");
        GridPane gp = new GridPane();


        Label account = new Label("Account");
        GridPane.setConstraints(account, 0,0);

        TextField Account = new TextField();
        GridPane.setConstraints(Account, 1,0);

        Label email = new Label("Email");
        GridPane.setConstraints(email, 0,1);

        TextField Email = new TextField();
        GridPane.setConstraints(Email, 1,1);

        Label password = new Label("Password");
        GridPane.setConstraints(password, 0,2);

        TextField Password = new TextField();
        GridPane.setConstraints(Password, 1,2);

        Button SaveEntry = new Button("Save Entry");
        GridPane.setConstraints(SaveEntry, 2,3);
        SaveEntry.setOnAction(event->{
            String Account1 = Account.getText();
            String Email1 = Email.getText();
            String Pass = Password.getText();

            Entry entry = new Entry("Entry" + count);

            entry.setAccount(Account1);
            entry.setEmail(Email1);
            entry.setPassword(Pass);

            list.add(entry);

            Account.clear();
            Email.clear();
            Password.clear();
            count++;
        });

        Button Cancel = new Button("Cancel");
        GridPane.setConstraints(Cancel, 3,3);
        Cancel.setOnAction(event->{
           window.close();
        });

        gp.getChildren().addAll(Account, account, email, Email, password, Password, SaveEntry, Cancel);
        Scene scene = new Scene(gp);
        window.setScene(scene);
        window.showAndWait();
    }
}
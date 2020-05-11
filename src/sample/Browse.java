package sample;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Browse {

   static int position = 0;
    
    public static void display(List<Entry> Entries){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Create New Entry");
        window.setWidth(350);
        GridPane gp = new GridPane();



        Label account = new Label("Account:");
        GridPane.setConstraints(account, 0,0);

        Label email = new Label("Email:");
        GridPane.setConstraints(email,0,1);

        Label password = new Label("Password:");
        GridPane.setConstraints(password, 0,2);

        Button forward = new Button("Forward");
        GridPane.setConstraints(forward, 1,3);
        setProfileToGUI(position, account, email, password, Entries);
        forward.setOnAction(event -> {
            if(position == Entries.size()-1){
                //do nothing
                position = position;
            }else {
                position++;
                setProfileToGUI(position, account, email, password, Entries);
            }
        });


        Button backward = new Button("Backward");
        GridPane.setConstraints(backward, 0,3);
        backward.setOnAction(event -> {
            if(position == 0){
                position = position;
            }else {

                position--;
                setProfileToGUI(position, account, email, password, Entries);
            }
        });

        Button delete = new Button("Delete");

        gp.getChildren().addAll(backward, forward, email, password, account);
        Scene scene = new Scene(gp);
        window.setScene(scene);
        window.showAndWait();
    }
    public static void setProfileToGUI(int position, Label account, Label email, Label password, List<Entry> Entries){
        Thread thread = new Thread(){
            public void run(){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        account.setText("Account:" + Entries.get(position).getAccount());
                        email.setText("Email:" + Entries.get(position).getEmail());
                        password.setText("Password:" + Entries.get(position).getPassword());

                    }
                });
            }
        };
        thread.start();
    }
}

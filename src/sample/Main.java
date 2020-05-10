package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    List <Entry> Entries = new ArrayList<>();
    int count = 1;



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GridPane gp = new GridPane();
        primaryStage.setTitle("Password Keeper");

        /*RSAPublicKeySpec keySpec = new RSAPublicKeySpec(mod, exp);
        KeyFactory keyFactory = null;
        PublicKey rsaKey = null;
        try {
            keyFactory = KeyFactory.getInstance("RSA");
            rsaKey = keyFactory.generatePublic(keySpec);
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }*/
        

        Button NewEntry = new Button("New Entry");
        GridPane.setConstraints(NewEntry, 0,0);
        NewEntry.setOnAction(event->{
            sample.NewPassword.display(Entries);

        });

        Button CheckEntries = new Button("Check Entries");
        GridPane.setConstraints(CheckEntries, 0,1);
        CheckEntries.setOnAction(event->{
           sample.Browse.display();
        });

        //Button to save the Passwords to a file
        Button SaveToFile = new Button("Save to File");
        GridPane.setConstraints(SaveToFile, 0,2);
        SaveToFile.setOnAction(event->{
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extfilt = new FileChooser.ExtensionFilter("password file", ".pass");
            fileChooser.setSelectedExtensionFilter(extfilt);

            try{
               FileOutputStream fos = new FileOutputStream(fileChooser.showSaveDialog(primaryStage));

                for (Entry entry : Entries) {
                    String newLine = "/n";
                    String str = entry.getAccount() + newLine + entry.getEmail() + newLine + entry.getPassword() + newLine;
                    byte[] accountToFile = str.getBytes();
                    fos.write(accountToFile);


                }
                System.out.println("File Written");
                fos.flush();
                fos.close();
            }catch(IOException e){
                e.printStackTrace();
            }


        });

        Button loadAndOverWrite = new Button("Load and Overwrite from File");
        GridPane.setConstraints(loadAndOverWrite, 0,3);
        loadAndOverWrite.setOnAction(event->{
           FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extfilt = new FileChooser.ExtensionFilter("password file", ".pass");
            fileChooser.setSelectedExtensionFilter(extfilt);

            BufferedReader reader;
            try{
                reader = new BufferedReader(new FileReader(fileChooser.showOpenDialog(primaryStage)));
                String line = reader.readLine();
                while(line != null){
                    Entry entry = new Entry("Entry" + count);
                    entry.setAccount(line);
                    line = reader.readLine();
                    entry.setEmail(line);
                    line = reader.readLine();
                    entry.setPassword(line);
                    line = reader.readLine();
                    count++;
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        });

        primaryStage.setScene(new Scene(gp, 300, 275));
        primaryStage.show();
        gp.getChildren().addAll(NewEntry, SaveToFile, loadAndOverWrite);
    }



    public static void main(String[] args) {
        launch(args);
    }
}

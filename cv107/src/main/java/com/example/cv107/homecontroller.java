package com.example.cv107;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class homecontroller {
    private Parent root;
    private Stage stage;
    private Scene scene;


    @FXML
    public void create(ActionEvent event) throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("form.fxml"));
        root = loader.load();


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

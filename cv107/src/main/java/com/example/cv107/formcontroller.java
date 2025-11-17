package com.example.cv107;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class formcontroller {
    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    TextField user;
    @FXML
    TextField email;
    @FXML
    TextField mobile;
    @FXML
    TextField address;
    @FXML
    TextField education;
    @FXML
    TextField projects;
    @FXML
    TextField skills;
    @FXML
    TextField ex;
    @FXML
    TextArea ab;

    @FXML
    public void generate(ActionEvent event) throws IOException {
        String name1=user.getText();
        String email1=email.getText();
        String mb=mobile.getText();
        String ad=address.getText();
        String ed=education.getText();
        String pro=projects.getText();
        String sk=skills.getText();
        String exx=ex.getText();
        String abb=ab.getText();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("preview.fxml"));
        root = loader.load();

        previewcontroller Sc3=loader.getController();
        Sc3.displayy(name1);
        Sc3.displayy2(email1);
        Sc3.displayy3(mb);
        Sc3.displayy4(ad);
        Sc3.displayy5(ed);
        Sc3.displayy6(pro);
        Sc3.displayy7(sk);
        Sc3.displayy8(exx);
        Sc3.displayy9(abb);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

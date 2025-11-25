package com.example.cv107;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

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
    TextArea education;
    @FXML
    TextArea projects;
    @FXML
    TextArea skills;
    @FXML
    TextArea ex;
    @FXML
    TextArea ab;
    @FXML
    TextField id;

    @FXML
    Button img;

    private Image selectimg;

    @FXML
    private void gohome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void up(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );

        File file = fileChooser.showOpenDialog(img.getScene().getWindow());
        if (file != null) {
            selectimg = new Image(file.toURI().toString());

        }
    }


    public Image getSelectedImage() {
        return selectimg;
    }

    @FXML
    public void generate(ActionEvent event) throws IOException {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to generate the cv now?");
        alert.setContentText("Click OK to proceed to the preview page.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() &&result.get() != ButtonType.OK) {
            return;
        }

        if (user.getText().isEmpty() || email.getText().isEmpty() || mobile.getText().isEmpty() ||
                address.getText().isEmpty() || education.getText().isEmpty() || projects.getText().isEmpty() ||
                skills.getText().isEmpty() || ex.getText().isEmpty() || ab.getText().isEmpty()) {

            Alert warn = new Alert(Alert.AlertType.WARNING);
            warn.setTitle("Missing Information");
            warn.setHeaderText("Some fields are empty!");
            warn.setContentText("Please fill out all fields before generating your CV.");
            warn.showAndWait();
            return;
        }

        if (!mobile.getText().matches("\\d{11}")) {
            Alert mobileAlert = new Alert(Alert.AlertType.WARNING);
            mobileAlert.setTitle("Invalid Mobile Number");
            mobileAlert.setHeaderText("Mobile number must be exactly 11 digits!");
            mobileAlert.setContentText("Please enter a valid 11-digit mobile number.");
            mobileAlert.showAndWait();
            return;
        }


        String name1=user.getText();
        String email1=email.getText();
        String mb=mobile.getText();
        String ad=address.getText();
        String ed=education.getText();
        String pro=projects.getText();
        String sk=skills.getText();
        String exx=ex.getText();
        String abb=ab.getText();
        String id1=id.getText();


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
        Sc3.displayy10(id1);

        Sc3.setImage(getSelectedImage());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

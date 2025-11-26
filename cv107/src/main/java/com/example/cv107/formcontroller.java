package com.example.cv107;

import org.example.cv107.cvModel;
import javafx.concurrent.Task;
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

    private cvRepo repository;
    private Image selectimg;

    @FXML private TextField user, email, mobile, address, id;
    @FXML private TextArea education, projects, skills, ex, ab;
    @FXML private Button img, generateBtn, updateBtn;

    @FXML
    public void initialize() {
        repository = cvRepo.getInstance();
    }

    @FXML
    private void gohome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/cv107/hello-view.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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

    // ✅ Called from Edit button
    public void loadCV(cvModel cv) {
        user.setText(cv.getFullName());
        email.setText(cv.getEmail());
        mobile.setText(cv.getPhone());
        address.setText(cv.getAddress());
        education.setText(cv.getEducation());
        projects.setText(cv.getProjects());
        skills.setText(cv.getSkills());
        ex.setText(cv.getWorkExperience());
        ab.setText(cv.getPhotoPath());
        id.setText(cv.getId() != null ? cv.getId().toString() : "");

        generateBtn.setVisible(false);
        updateBtn.setVisible(true);
    }

    @FXML
    public void generate(ActionEvent event) throws IOException {
        if (!validateFields()) return;

        cvModel cv = new cvModel(user.getText(), email.getText(), mobile.getText(), address.getText(),
                education.getText(), projects.getText(), skills.getText(), ex.getText(), ab.getText(), null);

        Task<Void> saveTask = new Task<>() {
            @Override
            protected Void call() {
                repository.insertCV(cv);
                return null;
            }
        };
        new Thread(saveTask).start();

        goToPreview(event, cv);
    }

    @FXML
    public void update(ActionEvent event) throws IOException {
        if (!validateFields()) return;

        cvModel cv = new cvModel(user.getText(), email.getText(), mobile.getText(), address.getText(),
                education.getText(), projects.getText(), skills.getText(), ex.getText(), ab.getText(), id.getText());

        Task<Void> updateTask = new Task<>() {
            @Override
            protected Void call() {
                repository.updateCV(cv);
                return null;
            }
        };
        new Thread(updateTask).start();

        goToPreview(event, cv);
    }

    private boolean validateFields() {
        if (user.getText().isEmpty() || email.getText().isEmpty() || mobile.getText().isEmpty() ||
                address.getText().isEmpty() || education.getText().isEmpty() || projects.getText().isEmpty() ||
                skills.getText().isEmpty() || ex.getText().isEmpty() || ab.getText().isEmpty()) {

            new Alert(Alert.AlertType.WARNING, "Please fill out all fields.").showAndWait();
            return false;
        }

        if (!mobile.getText().matches("\\d{11}")) {
            new Alert(Alert.AlertType.WARNING, "Mobile number must be 11 digits.").showAndWait();
            return false;
        }

        return true;
    }

    private void goToPreview(ActionEvent event, cvModel cv) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cv107/preview.fxml"));
        root = loader.load();

        previewcontroller previewCtrl = loader.getController();
        previewCtrl.displayy(cv.getFullName());
        previewCtrl.displayy2(cv.getEmail());
        previewCtrl.displayy3(cv.getPhone());
        previewCtrl.displayy4(cv.getAddress());
        previewCtrl.displayy5(cv.getEducation());
        previewCtrl.displayy6(cv.getProjects());
        previewCtrl.displayy7(cv.getSkills());
        previewCtrl.displayy8(cv.getWorkExperience());
        previewCtrl.displayy9(cv.getPhotoPath());
        previewCtrl.displayy10(cv.getId() != null ? cv.getId().toString() : "");
        previewCtrl.setImage(getSelectedImage());

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
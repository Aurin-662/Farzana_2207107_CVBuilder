package com.example.cv107;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import org.example.cv107.cvModel;

import java.io.IOException;
import java.util.List;

public class tableviewcontroller {

    @FXML private VBox cardContainer;

    @FXML
    public void initialize() {
        List<cvModel> cvList = cvRepo.getInstance().getAllCVs();

        for (cvModel cv : cvList) {
            VBox card = new VBox();
            card.setSpacing(8);
            card.setStyle("""
                -fx-background-color: #ffffff;
                -fx-padding: 15;
                -fx-border-color: #cccccc;
                -fx-border-radius: 10;
                -fx-background-radius: 10;
                -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 2);
            """);

            if (cv.getPhotoPath() != null && !cv.getPhotoPath().isBlank()) {
                try {
                    ImageView profile = new ImageView(new Image(cv.getPhotoPath()));
                    profile.setFitWidth(80);
                    profile.setFitHeight(80);
                    profile.setPreserveRatio(true);
                    profile.setClip(new Rectangle(80, 80, Color.TRANSPARENT));
                    card.getChildren().add(profile);
                } catch (Exception e) {
                    System.out.println("Invalid image path: " + cv.getPhotoPath());
                }
            }

            Label name = new Label("👤 Name: " + cv.getFullName());
            Label email = new Label("📧 Email: " + cv.getEmail());
            Label phone = new Label("📱 Phone: " + cv.getPhone());
            Label education = new Label("🎓 Education: " + cv.getEducation());
            Label skills = new Label("🛠️ Skills: " + cv.getSkills());
            Label experience = new Label("💼 Experience: " + cv.getWorkExperience());

            name.setStyle("-fx-font-weight: bold; -fx-font-size: 14;");
            education.setWrapText(true);
            skills.setWrapText(true);
            experience.setWrapText(true);

            Button editBtn = new Button("✏️ Edit");
            Button deleteBtn = new Button("🗑️ Delete");

            editBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
            deleteBtn.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

            // ✅ EDIT button logic
            editBtn.setOnAction(e -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cv107/form.fxml"));
                    Parent root = loader.load();

                    formcontroller formCtrl = loader.getController();
                    formCtrl.loadCV(cv); // pass CV to form

                    Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

            // ✅ DELETE button logic
            deleteBtn.setOnAction(e -> {
                boolean success = cvRepo.getInstance().deleteCV(cv.getId());
                if (success) {
                    cardContainer.getChildren().remove(card);
                    System.out.println("Deleted CV ID: " + cv.getId());
                } else {
                    System.out.println("Failed to delete CV ID: " + cv.getId());
                }
            });

            HBox buttonBox = new HBox(10, editBtn, deleteBtn);
            card.getChildren().addAll(name, email, phone, education, skills, experience, buttonBox);

            Region spacer = new Region();
            VBox.setVgrow(spacer, Priority.NEVER);
            cardContainer.getChildren().addAll(card, spacer);
        }
    }

    @FXML
    private void goHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/cv107/hello-view.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}
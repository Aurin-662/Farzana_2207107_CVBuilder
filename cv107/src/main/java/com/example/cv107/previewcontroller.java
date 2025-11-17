package com.example.cv107;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class previewcontroller {
    @FXML
    Label myname;
    @FXML
    Label mail;
    @FXML
    Label phone;
    @FXML
    Label add;
    @FXML
    Label edu;
    @FXML
    Label pro;
    @FXML
    Label skil;
    @FXML
    Label work;
    @FXML
    Label about;

    public void displayy(String name){
        myname.setText( name);
    }
    public void displayy2(String name2){
        mail.setText( name2);
    }
    public void displayy3(String name3){
        phone.setText( name3);
    }
    public void displayy4(String name4){
        add.setText( name4);
    }

    public void displayy5(String name5){
        edu.setText( name5);
    }
    public void displayy6(String name6){
        pro.setText( name6);
    }
    public void displayy7(String name7){
        skil.setText( name7);
    }
    public void displayy8(String name8){
        work.setText( name8);
    }
    public void displayy9(String name9){
        about.setText( name9);
    }
}

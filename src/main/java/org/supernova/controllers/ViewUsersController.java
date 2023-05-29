package org.supernova.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ViewUsersController {

    @FXML
    public TextField creditTextField;

    @FXML
    public ListView<?> listOfUsers;

    @FXML
    public TextField mailTextField;

    @FXML
    public TextField nameTextField;

    @FXML
    public TextField phoneTextField;

    @FXML
    public TextField surnameTextField;

    @FXML
    public TextField usernameTextField;

    @FXML
    public void backToHomeButtonClicked(ActionEvent event) {

    }

}

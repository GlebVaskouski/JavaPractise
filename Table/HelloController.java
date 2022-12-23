package com.example.herewegoagain;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.io.FileWriter;

public class HelloController {
    @FXML
    private TableView<Shop> personTable;
    @FXML
    private TableColumn<Shop, String> firstNameColumn;
    @FXML
    private TableColumn<Shop, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;

    private HelloApplication mainApp;
    public HelloController() {
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().onlyNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getYear());

        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    private void showPersonDetails(Shop person) {
        if (person != null) {
            firstNameLabel.setText(person.getName());
            lastNameLabel.setText(person.getData());
            streetLabel.setText(Integer.toString(person.getPackages()));
            cityLabel.setText(Double.toString(person.getPrice()));

        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
        }
    }

    @FXML
    private void handleNewPerson() {
        Shop tempPerson = new Shop();
    //    FileWriter fr = new FileWriter("C:\\Users\\gleb\\Desktop\\18.11\\HereWeGoAgain\\src\\main\\java\\com\\example\\herewegoagain\\txt");
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    @FXML
    private void handleEditPerson() {
        Shop selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
    public void setMainApp(HelloApplication mainApp) {
        this.mainApp = mainApp;
        personTable.setItems(mainApp.getPersonData());
    }

    public void handleSaveShop(ActionEvent actionEvent) {
    }


//    public void handleFindShop(ActionEvent actionEvent) {
//        Shop tempPerson = new Shop();
//        personTable
//        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
//        if (okClicked) {
//            mainApp.getPersonData().add(tempPerson);
//        }
//
//    }
}





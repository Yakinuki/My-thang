import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class needsController implements Initializable {
    @FXML
    private ListView<String> posessList;
    @FXML
    private ListView<String> needsList;
    @FXML
    private Button transferToPosessButton;
    @FXML
    private Button transferToNeedsButton;
    @FXML
    private Button addToPosessButton;
    @FXML
    private Button addToNeedsButton;
    @FXML
    private TextField posessTextField;
    @FXML
    private TextField needsTextField;
    @FXML
    private Label unitNameLabel;
    @FXML
    private Button deleteFromPosessButton;
    @FXML
    private Button deleteFromNeedsButton;


    static int mouseLocationIndex = 0;

    public static int getMouseLocationIndex() {
        return mouseLocationIndex;
    }

    public static void setMouseLocationIndex(int mouseLocationIndex) {
        needsController.mouseLocationIndex = mouseLocationIndex;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupHasTable();


    }


    public void transferToPosess(ActionEvent actionEvent) {
        int index = needsList.getSelectionModel().getSelectedIndex();
        if (!needsList.getSelectionModel().isEmpty()) {
            String from = needsList.getSelectionModel().getSelectedItem();
            ObservableList<String> to = posessList.getItems();
            to.add(from);
            needsList.getItems().remove(index);
        }

    }


    public void transferToNeeds(ActionEvent actionEvent) {
        int index = posessList.getSelectionModel().getSelectedIndex();
        if (!posessList.getSelectionModel().isEmpty()) {
            String from = posessList.getSelectionModel().getSelectedItem();
            ObservableList<String> to = needsList.getItems();
            to.add(from);
            posessList.getItems().remove(index);
        }
    }

    public void addToPosess(ActionEvent actionEvent) {
        ObservableList<String> tmp = posessList.getItems();
        String skill = posessTextField.getText();
        for (String toAdd : tmp) {
            if (skill.equals(toAdd)) {
                ViewHelper.showError("Gibts schon retard");
                return;

            }
        }
        tmp.add(skill);
        posessTextField.clear();
    }

    public void addToNeeds(ActionEvent actionEvent) {
        ObservableList<String> tmp = needsList.getItems();
        String skill = needsTextField.getText();
        for (String toAdd : tmp) {
            if (skill.equals(toAdd)) {
                ViewHelper.showError("Gibts schon retard");
                return;

            }
        }
        tmp.add(skill);
        needsTextField.clear();
    }

    public void deleteFromPosess(ActionEvent actionEvent) {
        int del = posessList.getSelectionModel().getSelectedIndex();
        ObservableList<String> tmp = posessList.getItems();
        tmp.remove(del);
    }

    public void deleteFromNeeds(ActionEvent actionEvent) {
        int del = needsList.getSelectionModel().getSelectedIndex();
        ObservableList<String> tmp = needsList.getItems();
        tmp.remove(del);
    }

    public void setupHasTable() {
        Unit currentlyOn = listViewController.unitList.get(mouseLocationIndex);
        posessList.setItems(currentlyOn.getHas());
        needsList.setItems((currentlyOn.getNeeds()));
    }
}

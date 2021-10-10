
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class characterCreationController implements Initializable {
    public TextField skillField;
    public Button addSkillButton;
    public TextField unitNameField;
    public CheckBox finishedBox;
    public TextField starsField;
    public TextField amountField;
    public TextField weaponField;
    public TextField movementField;
    public ListView skillList;
    public Button createButton;

    ObservableList<String> skills = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void addSkill(ActionEvent actionEvent) {
        String add = skillField.getText();
        for(String tmp:skills){
            if(tmp.equals(add)) {
                ViewHelper.showError("Gibts schon retard");
                return;

            }
        }
        skills.add(add);
        skillList.setItems(skills);
    }

    public void createAndAdd(ActionEvent actionEvent){
        Unit tmp = new Unit(unitNameField.getText(), Integer.parseInt(amountField.getText()),finishedBox.isSelected(),weaponField.getText(),movementField.getText(),Integer.parseInt(starsField.getText()));
        listViewController.unitList.add(tmp);
    }

    public void boxTicked(ActionEvent actionEvent) {
    }
}

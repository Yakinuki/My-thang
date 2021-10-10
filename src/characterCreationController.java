
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
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
    public ListView<String> skillList;
    public Button createButton;
    public Button removeButton;

    ObservableList<String> skills = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        skillList.setItems(skills);
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
        try {
            Unit tmp = new Unit(unitNameField.getText(), Integer.valueOf(amountField.getText()), finishedBox.isSelected(), weaponField.getText(), movementField.getText(), Integer.valueOf(starsField.getText()));
            tmp.setHas(skillList.getItems());
            listViewController.unitList.add(tmp);

        }catch (NumberFormatException e){
            System.out.println("please enter the amount of units and the amount of stars");
        }
    }


    public void removeSkill(ActionEvent actionEvent) {
        int tmp = skillList.getSelectionModel().getSelectedIndex();
        skills.remove(tmp);
        skillList.setItems(skills);
    }



}


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.io.FileWriter;
import java.io.FileReader;

public class listViewController implements Initializable {
    @FXML
    public Button createButton;
    @FXML
    public TableColumn<Unit, Integer> starsColumn;
    @FXML
    public Button deleteButton;
    @FXML
    public Button refreshButton;
    public Menu load;
    public Menu save;
    @FXML
    private TableView<Unit> UnitTable;
    @FXML
    private TableColumn<Unit, String> nameColumn;
    @FXML
    private TableColumn<Unit, String> weaponColumn;
    @FXML
    private TableColumn<Unit, String> movementColumn;
    @FXML
    private TableColumn<Unit, String> amountColumn;
    @FXML
    private TableColumn<Unit, String> finishedColumn;
    @FXML
    private Label versionLabel;
    @FXML
    private TextField searchField;

    static ObservableList<Unit> unitList ;
    FileWriter fileWriter;
    FileReader fileReader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configure();

    }
    private void configure(){
        unitList = FXCollections.observableArrayList();
        UnitTable.setItems(unitList);

        nameColumn.setCellValueFactory(new PropertyValueFactory<Unit, String>("name"));
        weaponColumn.setCellValueFactory(new PropertyValueFactory<Unit, String>("weapon"));
        movementColumn.setCellValueFactory(new PropertyValueFactory<Unit, String>("movement"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<Unit, String>("amount"));
        finishedColumn.setCellValueFactory(new PropertyValueFactory<Unit, String>("finished"));
        starsColumn.setCellValueFactory(new PropertyValueFactory<Unit, Integer>("stars"));


    }

    public void createUnit(ActionEvent actionEvent) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("characterCreation.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deleteUnit(ActionEvent actionEvent) {
        if(!UnitTable.getSelectionModel().isEmpty()){
            int del = UnitTable.getSelectionModel().getSelectedIndex();
            unitList.remove(del);
        }
    }

    public void refresh(ActionEvent actionEvent) {
        UnitTable.setItems(unitList);
    }

    public void onDoubleClick(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2){
            Parent root = null;
            try {
                needsController.setMouseLocationIndex(UnitTable.getSelectionModel().getSelectedIndex());
                root = FXMLLoader.load(getClass().getResource("needsNStuff.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveFile(ActionEvent actionEvent) {
    }



    public void loadFile(ActionEvent actionEvent) {
    }
}

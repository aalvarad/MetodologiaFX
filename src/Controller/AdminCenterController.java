/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author castrorj
 */
public class AdminCenterController implements Initializable {

    @FXML
    private ListView <String> list_Create;
    @FXML
    private ListView <String> List_Activate;
    @FXML
    private TabPane tab_Result;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Loadlist();
        Selectmenu();
    }    
    
    private void Loadlist(){
        ObservableList<String> Create = FXCollections.observableArrayList();
        Create.add("Business Unit");
        Create.add("Area");
        Create.add("Department");
        Create.add("Employee");
        Create.add("Prod Number");
        list_Create.setItems(Create);
        List_Activate.setItems(Create);
    }
    
    private void Selectmenu(){
        list_Create.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int seleccion = list_Create.getSelectionModel().getSelectedIndex();
                SeleccionCreate(seleccion);
            }
        });
        List_Activate.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int seleccion = List_Activate.getSelectionModel().getSelectedIndex();
                SeleccionActivate(seleccion);
            }
            
        });
    }
    private void SeleccionCreate(int seleccion){
        switch (seleccion){
                    case 0:
                        NewTabCreate("/View/CreateBU.fxml", "BusinessUnit");
                        break;
                    case 1:
                        NewTabCreate("/View/CreateArea.fxml", "Area");
                        break;
                    case 2:
                        NewTabCreate("/View/CreateDep.fxml", "Department");
                        break;
                    case 3:
                        NewTabCreate("/View/CreateEmployee.fxml", "Employee");
                        break;
                    case 4:
                        NewTabCreate("/View/CreateProdNo.fxml", "Prod No");
                        break;
                    default:
                        break;
                }
    }
    private void NewTabCreate(String path, String tab){
        try {
                Node node = (AnchorPane) FXMLLoader.load(getClass().getResource(path));
                Tab tb = new Tab(tab, node);
                tab_Result.getTabs().add(tb);
            } catch (Exception e) {
            }
    }
    private void SeleccionActivate(int seleccion){
        switch (seleccion){
                    case 0:
                        NewTabCreate("/View/ADBU.fxml", "BusinessUnit");
                        break;
                    case 1:
                        NewTabCreate("/View/ADArea.fxml", "Area");
                        break;
                    case 2:
                        NewTabCreate("/View/ADDep.fxml", "Department");
                        break;
                    case 3:
                        NewTabCreate("/View/ADEmployee.fxml", "Employee");
                        break;
                    case 4:
                        NewTabCreate("/View/ADProdNo.fxml", "Prod No");
                        break;
                    default:
                        break;
                }
    }
}
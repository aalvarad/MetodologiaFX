/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Main;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
/**
 * FXML Controller class
 *
 * @author aalvarad
 */
public class CreateController implements Initializable {
    
    Main main = new Main();
    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs;

    @FXML
    private AnchorPane ap_Create;
    @FXML
    private TabPane tp_Create;
    @FXML
    private Tab tab_BusinessUnit;
    @FXML
    private AnchorPane ap_BU;
    @FXML
    private GridPane gp_BU;
    @FXML
    private Label lbl_BUName;
    @FXML
    private TextField txt_BUName;
    @FXML
    private Button btn_BUSave;
    @FXML
    private Tab tab_Area;
    @FXML
    private AnchorPane ap_Area;
    @FXML
    private GridPane gp_Area;
    @FXML
    private Label lbl_Area_BU;
    @FXML
    private Label lbl_Area_Name;
    @FXML
    private ChoiceBox<?> chb_Area_BU;
    @FXML
    private TextField txt_Area_Name;
    @FXML
    private Button btn_Area_Save;
    @FXML
    private Tab tab_Department;
    @FXML
    private AnchorPane ap_Department;
    @FXML
    private GridPane gp__Department;
    @FXML
    private Label lbl_Dep_BU;
    @FXML
    private Label lbl_Dep_Area;
    @FXML
    private Label lbl_Dep_Name;
    @FXML
    private ChoiceBox<?> chb_Dep_BU;
    @FXML
    private ChoiceBox<?> chb_Dep_Area;
    @FXML
    private TextField txt_Dep_Name;
    @FXML
    private Button btn_Dep_Save;
    @FXML
    private Tab tab_ProdNum;
    @FXML
    private AnchorPane ap_ProdNum;
    @FXML
    private GridPane gp_ProdNum;
    @FXML
    private Label lbl_Prod_BU;
    @FXML
    private Label lbl_Prod_Area;
    @FXML
    private Label lbl_Prod_Department;
    @FXML
    private Label lbl_Prod_Name;
    @FXML
    private ChoiceBox<?> chb_Prod_BU;
    @FXML
    private ChoiceBox<?> chb_Prod_Area;
    @FXML
    private ChoiceBox<?> chb_Prod_Department;
    @FXML
    private TextField txt_Prod_Name;
    @FXML
    private Button btn_Prod_Save;
    @FXML
    private Tab tab_Employee;
    @FXML
    private AnchorPane ap_Employee;
    @FXML
    private GridPane gp_Employee;
    @FXML
    private Label lbl_Emp_BU;
    @FXML
    private Label lbl_Emp_Area;
    @FXML
    private Label lbl_Emp_Department;
    @FXML
    private ChoiceBox<?> chb_Emp_BU;
    @FXML
    private ChoiceBox<?> chb_Emp_Area;
    @FXML
    private ChoiceBox<?> chb_Emp_Department;
    @FXML
    private Button btn_Emp_Save;
    @FXML
    private Label lbl_Emp_FName;
    @FXML
    private Label lbl_Emp_LName;
    @FXML
    private Label lbl_Emp_Password;
    @FXML
    private TextField txt_Emp_FName;
    @FXML
    private TextField txt_Emp_LName;
    @FXML
    private TextField txt_Emp_Password;
    @FXML
    private Label lbl_Emp_Role;
    @FXML
    private ChoiceBox<?> txt_Emp_Role;
    @FXML
    private Tab tab_ReworkType;
    @FXML
    private AnchorPane ap_ReworkType;
    @FXML
    private GridPane gp_ReworkType;
    @FXML
    private Label lbl_TaskName;
    @FXML
    private TextField txt_TaskName;
    @FXML
    private Button btn_RT_Save; 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void create_bu(ActionEvent event) {
                if(!txt_BUName.getText().isEmpty()){
                try {
                    Connection cn = conn.conexion();
                    stmt = cn.prepareCall("{CALL addBU(?,?)}");
                    stmt.setString(1, txt_BUName.getText());
                    stmt.setInt(2, 1);
                    stmt.execute();
                    cn.close();
                } catch (Exception e) {
                }
            }
            else {
                main.WarningAlert("New Password", "New password", "Passwords do not match");
            }
        }
    
}

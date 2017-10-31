/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Main;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

/**
 * FXML Controller class
 *
 * @author aalvarad
 */
public class AdminTopController implements Initializable {

    @FXML private Label lbl_Administration;
    @FXML private Label lbl_Employee;
    @FXML private Label lbl_EmployeeNum;
    @FXML private ToggleButton btn_Create;
    @FXML private ToggleButton btn_Manage;
    @FXML private ToggleButton btn_Reports;
    @FXML private ToggleButton btn_Logout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LoadLang(Main.Language);
    }    
    
    public void LoadLang(String lang){
        Main.locale = new Locale(lang);
        Main.bundle = ResourceBundle.getBundle("Properties.Bundle", Main.locale);
        lbl_Administration.setText(Main.bundle.getString("Administration"));
        lbl_Employee.setText(Main.bundle.getString("Employee"));
        lbl_EmployeeNum.setText(Main.bundle.getString("Employee_No"));
        btn_Create.setText(Main.bundle.getString("Create"));
        btn_Manage.setText(Main.bundle.getString("Manage"));
        btn_Manage.setText(Main.bundle.getString("Reports"));
        btn_Logout.setText(Main.bundle.getString("Log_Out"));
    }
    
}

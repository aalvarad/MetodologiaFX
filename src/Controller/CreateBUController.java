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
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author castrorj
 */
public class CreateBUController implements Initializable {

    Main main = new Main();
    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs;

    
    @FXML private Button btn_Save;
    @FXML private Label Lbl_Title;
    @FXML private TextField txt_Bu;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LoadLang(Main.Language);
    }    
    
    public void LoadLang(String lang){
        Main.locale = new Locale(lang);
        Main.bundle = ResourceBundle.getBundle("Properties.Bundle", Main.locale);
        Lbl_Title.setText(Main.bundle.getString("Business Unit"));
    }
    
    public void Save(){
        if (!txt_Bu.getText().isEmpty()){
            Connection cn = conn.conexion();
            int read = 0;
            try {
                stmt = cn.prepareCall("{CALL `addBU`(?)}");
                stmt.setString(1,txt_Bu.getText());
                rs = stmt.executeQuery();
                while(rs.next()) {
                    read =rs.getInt(1);
                }
                cn.close();
                main.CheckADD(read);
            } catch (Exception e) {
                main.ErrorAlert("Business_Unit", "Business_Unit", "Database_connection_error");
            }
        }
        else {
            main.ErrorAlert("Business_Unit", "Business_Unit", "empty_field");
        }
    }
}

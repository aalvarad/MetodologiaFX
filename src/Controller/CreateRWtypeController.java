/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
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
public class CreateRWtypeController implements Initializable {

    @FXML Label lbl_Title;
    @FXML TextField txt_rwktype;
    @FXML Button btn_Save;
    
    View.Main main = new View.Main();
    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void Save (){
        if (!txt_rwktype.getText().isEmpty()){
            Connection cn = conn.conexion();
            int read = 0;
            try {
                stmt = cn.prepareCall("{CALL `addReworkType`(?)}");
                stmt.setInt(1,Integer.parseInt(txt_rwktype.getText()));
                rs = stmt.executeQuery();
                while(rs.next()) {
                    read =rs.getInt(1);
                }
                cn.close();
                main.CheckADD(read);
            } catch (Exception e) {
                main.ErrorAlert("ReworkType", "ReworkType", "Database_connection_error");
            }
        }
        else {
            main.ErrorAlert("ReworkType", "ReworkType", "empty_field");
        }
    }
}

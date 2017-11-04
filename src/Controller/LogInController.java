/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Locale;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
/**
 * FXML Controller class
 *
 * @author jonathancastro
 */
public class LogInController implements Initializable {

    Main main = new Main();
    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs;
    
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LoadLang(Main.Language);
    }    
    
    @FXML
    private TextField txt_User;
    @FXML
    private PasswordField txt_Password;
    @FXML
    private Button btn_Exit;
    @FXML
    private Button btn_Language;
    @FXML
    private Button btn_FYP;
    
    public void LoadLang(String lang){
        Main.locale = new Locale(lang);
        Main.bundle = ResourceBundle.getBundle("Properties.Bundle", Main.locale);
        btn_FYP.setText(Main.bundle.getString("Forgot_your_password"));
        btn_Language.setText(Main.bundle.getString("Language"));
    }
    
    public void LogIn(){
        if (txt_User.getText().length() != 0 && !txt_Password.getText().isEmpty()){
            Connection cn = conn.conexion();
            int rol = 0;
            try {
                stmt = cn.prepareCall("{CALL `login`(?, ?)}");
                stmt.setInt(1,Integer.parseInt(txt_User.getText()));
                stmt.setString(2,txt_Password.getText());
                rs = stmt.executeQuery();
                while(rs.next()) {
                    rol =rs.getInt(1);
                }
                Go(rol);
                cn.close();
            } catch (Exception e) {
                main.ErrorAlert("Log_In", "Log_In_error", "Database_connection_error");
            }
        }
        else {
            main.ErrorAlert("Log In", "Log In error", "Empty_field");
        }
    }
    
    private void Go(int rol) throws IOException{
        switch (rol)
        {
            case 1:
                //Ventana Rework
            break;
            case 2:
                main.newWindow("/View/ReworkStart.fxml");
            break;
            case 3:
                main.newWindow("/View/AdminCenter.fxml");
            break;
            default:
                main.ErrorAlert("Log In", "Log In error", "Wrong user number or password");
                break;
        }      
    }
    
    public void FYP () throws IOException{
        main.newWindow("/View/ForgotPass.fxml");
    }
    
    public void Exit() {
        Stage stage = (Stage) btn_Exit.getScene().getWindow();
        stage.close();
    }
    
    public void Language() throws IOException{
        //Call Language window
    }
}

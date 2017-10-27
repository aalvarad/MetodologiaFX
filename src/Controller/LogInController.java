/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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

    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs;
    Connection cn = conn.conexion();
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private TextField txt_User;
    @FXML
    private PasswordField txt_Password;
    @FXML
    private Button btn_Exit;
    
    public void LogIn(){
        if (txt_User.getText().length() != 0 && !txt_Password.getText().isEmpty()){
            int rol = 0;
            try {
                stmt = cn.prepareCall("{CALL `login`(?, ?)}");
                stmt.setInt(1,Integer.parseInt(txt_User.getText()));
                stmt.setString(2,txt_Password.getText());
                rs = stmt.executeQuery();
                while(rs.next()) {
                    rol =rs.getInt(1);
                }
                switch (rol)
                {
                    case 1:
                        //Ventana Rework
                        break;
                    case 2:
                        //Ventana Tecnico
                        break;
                    case 3:
                        //Ventana Supervisor
                        break;
                    default:
                        ErrorAlert("Log In", "Log In error", "Wrong user number or password");
                        break;
                }
                        
            } catch (Exception e) {
                ErrorAlert("Log In", "Log In error", "Database connection was not established");
            }
        }
        else {
            WarningAlert("Log In", "Log In error", "User field or password field are empty");
        }
    }
    
    public void FYP () throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ForgotPass.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("App");
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    public void Language (){
        
    }
    
    public void Exit() {
        Stage stage = (Stage) btn_Exit.getScene().getWindow();
        stage.close();
    }
    
    public void WarningAlert (String titulo, String cabecera, String mensaje){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    public void ErrorAlert(String titulo, String cabecera, String mensaje){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

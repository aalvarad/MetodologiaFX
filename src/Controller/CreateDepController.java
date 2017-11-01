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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author castrorj
 */
public class CreateDepController implements Initializable {
    View.Main main = new View.Main();
    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs;

    @FXML private AnchorPane anc_Main;
    @FXML private ImageView img_Teradyne;
    @FXML private Pane pan_Main;
    @FXML private Label lbl_BU;
    @FXML private ChoiceBox<String> cmb_BU;
    @FXML private Label lbl_Department;
    @FXML private TextField txt_Department;
    @FXML private Label lbl_Dep_Name;
    @FXML private TextField txt_Dep_Name;
    @FXML private Button btn_Save;
    @FXML private Label lbl_Area;
    @FXML private ChoiceBox<String> cmb_Area;
    
    
    ObservableList<String> bus = FXCollections.observableArrayList();
    ObservableList<String> area = FXCollections.observableArrayList();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar_bu();
        listar_area();
        cmb_BU.setItems(bus);
        cmb_Area.setItems(area);
        cmb_BU.setValue(bus.get(0));
        cmb_Area.setValue(area.get(0));
    }    
    
    public void listar_bu(){
        try {
            Connection cn = conn.conexion();
            stmt = cn.prepareCall("{CALL listar_BU()}");
            rs = stmt.executeQuery();
            while (rs.next()){
                bus.add(rs.getString(1));
            }
            cn.close();
        } catch (Exception e) {
        }
    }
    
    public void listar_area(){
        try {
            Connection cn = conn.conexion();
            stmt = cn.prepareCall("{CALL listar_todas_areas()}");
            rs = stmt.executeQuery();
            while (rs.next()){
                area.add(rs.getString(1));
            }
            cn.close();
        } catch (Exception e) {
        }
    }
    
    public void Save (){
        if (!cmb_Area.getSelectionModel().getSelectedItem().isEmpty() && !txt_Department.getText().isEmpty() && !txt_Dep_Name.getText().isEmpty()){
            Connection cn = conn.conexion();
            int read = 0;
            try {
                stmt = cn.prepareCall("{CALL `addDepartamento`(?,?,?)}");
                stmt.setInt(1,Integer.parseInt(txt_Department.getText()));
                stmt.setString(2,txt_Dep_Name.getText());
                stmt.setString(3,cmb_Area.getSelectionModel().getSelectedItem());
                rs = stmt.executeQuery();
                while(rs.next()) {
                    read =rs.getInt(1);
                }
                cn.close();
                main.CheckADD(read);
            } catch (Exception e) {
                main.ErrorAlert("Department", "Department", "Database_connection_error");
            }
        }
        else {
            main.ErrorAlert("Department", "Department", "empty_field");
        }
    }
}

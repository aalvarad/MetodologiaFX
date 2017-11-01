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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class CreateEmployeeController implements Initializable {
        
    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs;


    @FXML
    private AnchorPane anc_Main;
    @FXML
    private ImageView img_Teradyne;
    @FXML
    private Pane pan_Main;
    @FXML
    private Label lbl_BU;
    @FXML
    private ChoiceBox<String> cmb_BU;
    @FXML
    private Label lbl_Department;
    @FXML
    private Button btn_Save;
    @FXML
    private Label lbl_Area;
    @FXML
    private ChoiceBox<String> cmb_Area;
    @FXML
    private ChoiceBox<String> cmb_Department;
    @FXML
    private ChoiceBox<String> cmb_Role;
    @FXML
    private Label lbl_Role;
    @FXML
    private Label lbl_Name;
    @FXML
    private TextField txt_Name;
    @FXML
    private Label lbl_LastName;
    @FXML
    private TextField txt_LastName;
    @FXML
    private PasswordField txt_Password;
    @FXML
    private PasswordField txt_ConfirmPass;
    @FXML
    private Label lbl_Password;
    @FXML
    private Label lbl_ConfirmPass;
    @FXML
    private Label lbl_EmpNo;
    @FXML
    private TextField txt_EmpNo;


    ObservableList<String> bus = FXCollections.observableArrayList();
    ObservableList<String> area = FXCollections.observableArrayList();
    ObservableList<String> dep = FXCollections.observableArrayList();
    ObservableList<String> rol = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar_bu();
        listar_area();
        listar_dep();
        listar_rol();
        cmb_BU.setItems(bus);
        cmb_Area.setItems(area);
        cmb_Department.setItems(dep);
        cmb_Role.setItems(rol);
        cmb_BU.setValue(bus.get(0));
        cmb_Area.setValue(area.get(0));
        cmb_Department.setValue(dep.get(0));
        cmb_Role.setValue(rol.get(0));
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
    
        public void listar_dep(){
        try {
            Connection cn = conn.conexion();
            stmt = cn.prepareCall("{CALL listar_todos_depart()}");
            rs = stmt.executeQuery();
            while (rs.next()){
                dep.add(rs.getString(1));
            }
            cn.close();
        } catch (Exception e) {
        }
    }
        
            public void listar_rol(){
        try {
            Connection cn = conn.conexion();
            stmt = cn.prepareCall("{CALL listar_roles()}");
            rs = stmt.executeQuery();
            while (rs.next()){
                rol.add(rs.getString(1));
            }
            cn.close();
        } catch (Exception e) {
        }
    }
    
}

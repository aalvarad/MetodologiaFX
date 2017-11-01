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
import javax.print.DocFlavor;

/**
 * FXML Controller class
 *
 * @author castrorj
 */
public class CreateProdNoController implements Initializable {
    
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
    private TextField txt_ProdNo;
    @FXML
    private Button btn_Save;
    @FXML
    private Label lbl_Area;
    @FXML
    private ChoiceBox<String> cmb_Area;
    @FXML
    private ChoiceBox<String> cmb_Department;
    @FXML
    private Label lbl_ProdNo;


    ObservableList<String> bus = FXCollections.observableArrayList();
    ObservableList<String> area = FXCollections.observableArrayList();
    ObservableList<String> dep = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar_bu();
        listar_area();
        listar_dep();
        cmb_BU.setItems(bus);
        cmb_Area.setItems(area);
        cmb_Department.setItems(dep);
        cmb_BU.setValue(bus.get(0));
        cmb_Area.setValue(area.get(0));
        cmb_Department.setValue(dep.get(0));
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
    
}

package Controller;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


public class ADProdNoController implements Initializable {
    
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
    private Label lbl_Department;
    @FXML
    private Button btn_Save;
    @FXML
    private Label lbl_Area;
    @FXML
    private Label lbl_ProdNo;
    @FXML
    private ChoiceBox<String> cmb_ProdNo;
    @FXML
    private Button btn_Act;
    @FXML
    private ComboBox<String> cmb_BU;
    @FXML
    private ComboBox<String> cmb_area;
    @FXML
    private ComboBox<String> cmb_dep;
    @FXML private RadioButton rdb_Activate;
    @FXML private RadioButton rdb_Deactivate;
    
    
    ObservableList<String> bus = FXCollections.observableArrayList();
    ObservableList<String> area = FXCollections.observableArrayList();
    ObservableList<String> dep = FXCollections.observableArrayList();
    ObservableList<String> prod = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       listar_bu();
       cmb_BU.setItems(bus);
    }    
    
    @FXML
    public void DActive () {
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

    @FXML
    private void listar_area(ActionEvent event) {
        area.clear();
          try {
            Connection cn = conn.conexion();
            stmt = cn.prepareCall("{CALL listar_Area(?)}");
            stmt.setString(1,cmb_BU.getSelectionModel().getSelectedItem());
            rs = stmt.executeQuery();
            while (rs.next()){
                area.add(rs.getString(1));
            }
            cn.close();
        } catch (Exception e) {
        }
        cmb_area.setItems(area);
    }

    @FXML
    private void listar_dep(ActionEvent event) {
        dep.clear();
          try {
            Connection cn = conn.conexion();
            stmt = cn.prepareCall("{CALL listar_Departamento(?)}");
            stmt.setString(1,cmb_area.getSelectionModel().getSelectedItem());
            rs = stmt.executeQuery();
            while (rs.next()){
                dep.add(rs.getString(1));
            }
            cn.close();
        } catch (Exception e) {
        }
        cmb_dep.setItems(dep);
    }
    
    @FXML
    private  void CheckStatus_Area(ActionEvent event){
        try {
            Connection cn = conn.conexion();
            stmt = cn.prepareCall("{CALL Check_Status_Prod_No(?)}");
            stmt.setString(1,cmb_ProdNo.getSelectionModel().getSelectedItem());
            rs = stmt.executeQuery();
            int read = 0;
            while (rs.next()){
                read = rs.getInt(1);
            }
            cn.close();
            if (read == 1){
                rdb_Activate.setSelected(true);
            }
            else {
                rdb_Deactivate.setSelected(true);
            }
        } catch (Exception e) {
        }
    }


    @FXML
    private void listar_prodno(ActionEvent event) {
        //listar PRODNO
    }
}

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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author castrorj
 */
public class ADAreaController implements Initializable {

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
    private Label lbl_Area;
    @FXML
    private Button btn_Save;
    @FXML
    private ChoiceBox<String> cmb_area;
    @FXML
    private Button btn_Act;


    ObservableList<String> bus = FXCollections.observableArrayList();
    ObservableList<String> area = FXCollections.observableArrayList();
    
    @FXML
    private ComboBox<String> cmb_BU;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar_bu();
        cmb_BU.setItems(bus);
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
    public void DActive () {
        
    }

    @FXML
    private void mostar_areas(ActionEvent event) {
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
        cmb_area.setValue(area.get(0));
    }
    
    
}

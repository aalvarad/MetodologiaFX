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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author castrorj
 */
public class ADBUController implements Initializable {
    
    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs;

    @FXML
    private Button btn_Act;
    @FXML
    private AnchorPane anc_Main;
    @FXML
    private ImageView img_Teradyne;
    @FXML
    private Pane pan_Main;
    @FXML
    private Label lbl_Title;
    @FXML
    private Button btn_Save;
    @FXML
    private ChoiceBox<String> cmb_Bu;
   
    
     ObservableList<String> bus = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar_bu();
        cmb_Bu.setItems(bus);
        cmb_Bu.setValue(bus.get(0));
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
    public void DActive (){
    }
}

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


public class CreateAreaController implements Initializable {
    
    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs;
    View.Main main = new View.Main();

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
    private Label lbl_Area;
    @FXML
    private TextField txt_Area;
    @FXML
    private Button btn_Save;

    
    ObservableList<String> bus = FXCollections.observableArrayList();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listar_bu();
        cmb_BU.setItems(bus);
        cmb_BU.setValue(bus.get(0));
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
        
    public void Save (){
        if (!cmb_BU.getSelectionModel().getSelectedItem().isEmpty() && !txt_Area.getText().isEmpty()){
            Connection cn = conn.conexion();
            int read = 0;
            try {
                stmt = cn.prepareCall("{CALL `addArea`(?,?)}");
                stmt.setString(1,txt_Area.getText());
                stmt.setString(2,cmb_BU.getSelectionModel().getSelectedItem());
                rs = stmt.executeQuery();
                while(rs.next()) {
                    read =rs.getInt(1);
                }
                cn.close();
                main.CheckADD(read);
            } catch (Exception e) {
                main.ErrorAlert("Area", "Area", "Database_connection_error");
            }
        }
        else {
            main.ErrorAlert("Area", "Area", "empty_field");
        }
    }
    
}

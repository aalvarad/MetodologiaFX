
package Controller;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;


public class ADRWtypeController implements Initializable {
    Model.Conection conn = new Model.Conection();
    CallableStatement stmt;
    ResultSet rs; 
    
    
    
    @FXML private ChoiceBox<String> cmb_RWtype;
    @FXML private RadioButton rdb_Activate;
    @FXML private RadioButton rdb_Deactivate;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    
    @FXML
    private  void CheckStatus_Area(ActionEvent event){
        try {
            Connection cn = conn.conexion();
            stmt = cn.prepareCall("{CALL Check_Status_ReworkType(?)}");
            stmt.setString(1,cmb_RWtype.getSelectionModel().getSelectedItem());
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

    
}

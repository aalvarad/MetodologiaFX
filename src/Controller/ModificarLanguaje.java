/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author castrorj
 */
public class ModificarLanguaje implements Initializable {

    @FXML
    private AnchorPane anc_Pane;
    @FXML
    private TableView<?> tbl_language;
    @FXML
    private TableColumn<?, ?> tbl_col_original;
    @FXML
    private TableColumn<?, ?> tbl_col_modify;
    @FXML
    private Button btn_add_Icon;
    @FXML
    private TextField txt_language;
    @FXML
    private Label lbl_Icon;
    @FXML
    private Label lbl_Lenguage;
    @FXML
    private Label lbl_Title;
    @FXML
    private Button btn_Save;
    @FXML
    private Button btn_Error;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

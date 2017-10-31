/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Main;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Fabian Castro G
 */
public class SeleccionarIdioma implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label lbl_title;
    @FXML
    private Label lbl_language;
    @FXML
    private ChoiceBox cmb_language;
    @FXML
    private Button btn_error;
    @FXML
    private Button btn_save;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LoadLang(Main.Language);
    }    
    
    public void LoadLang(String lang){
        Main.locale = new Locale(lang);
        Main.bundle = ResourceBundle.getBundle("Properties.Bundle", Main.locale);
        lbl_title.setText(Main.bundle.getString("Select_Language"));
        lbl_language.setText(Main.bundle.getString("Select_Language"));
    }
    
}

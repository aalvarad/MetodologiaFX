/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Main;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Fabian Castro G
 */
public class ModificarIdioma implements Initializable {
    @FXML private TableView<Lenguaje> tbl_language;
    @FXML private TableColumn<Lenguaje, String> firstwordsColumn;
        // TODO
    
     //These instance variables are used to create new Person objects
    @FXML private TextField firstwordsTextField;
    @FXML private Button detailedPersonViewButton;
    
    @FXML TableColumn tbl_col_original;
    @FXML TableColumn tbl_col_modify;
    @FXML Button btn_add_Icon;
    @FXML TextField txt_Language;
    @FXML Label lbl_Icon;
    @FXML Label lbl_Lenguage;
    @FXML Label lbl_Title;
    @FXML Button btn_Save;
    @FXML Button btn_Error;
    
    /**
     * Initializes the controller class.
     * @param url
     */
    AgregarController ac = new AgregarController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         //configure the table
         //set up the columns in the table
        ac.LoadTable();
        LoadLang(Main.Language);
    }    
    
    public void LoadLang(String lang){
        Main.locale = new Locale(lang);
        Main.bundle = ResourceBundle.getBundle("Properties.Bundle", Main.locale);
        lbl_Title.setText(Main.bundle.getString("Modify_Language"));
        lbl_Lenguage.setText(Main.bundle.getString("Select_Language"));
        lbl_Icon.setText(Main.bundle.getString("Icon"));
        tbl_col_modify.setText(Main.bundle.getString("Translation"));
        tbl_col_original.setText(Main.bundle.getString("Original_Words"));
    }
}
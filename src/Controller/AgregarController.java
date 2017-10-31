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

/**
 * FXML Controller class
 *
 * @author Fabian Castro G
 */
public class AgregarController implements Initializable {
    @FXML private TableView<Lenguaje> tableView;
    @FXML private TableColumn<Lenguaje, String> firstwordsColumn;
    @FXML private TextField firstwordsTextField;
    @FXML private Button detailedPersonViewButton;
    @FXML  private Label lbl_title;
    @FXML  private Label lbl_Language;
    @FXML  private Label lbl_Icon;
    @FXML  private TextField txt_language;
    @FXML private Button btn_load_Icon;
    @FXML private Button btn_error;
    @FXML private Button btn_Save;
    @FXML private TableColumn tbl_col_original;
    @FXML private TableColumn tbl_col_modify;
    /**
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          LoadTable();
          LoadLang(Main.Language);
    }    
    
    public ObservableList<Lenguaje>  getWords()
    {
        ObservableList<Lenguaje> people = FXCollections.observableArrayList();
        people.add(new Lenguaje("Forgot_your_password"));
        people.add(new Lenguaje("add"));
        people.add(new Lenguaje("Remove"));
        people.add(new Lenguaje("Add_Lenguaje_Menu"));
        people.add(new Lenguaje("Original_Words"));
        people.add(new Lenguaje("Translation"));
        people.add(new Lenguaje("Remove_lenguaje"));
        people.add(new Lenguaje("Languaje"));
        people.add(new Lenguaje("Create"));
        people.add(new Lenguaje("Active"));
        people.add(new Lenguaje("DeActive"));
        people.add(new Lenguaje("Report"));
        people.add(new Lenguaje("Log_Out"));
        people.add(new Lenguaje("User"));
        people.add(new Lenguaje("Prod_Number"));
        people.add(new Lenguaje("Serial_Number"));
        people.add(new Lenguaje("ReworkType"));
        people.add(new Lenguaje("Remarks"));
        people.add(new Lenguaje("ReworkType"));
        people.add(new Lenguaje("Selec_a_board_from_a_table_and_pression Select"));
        people.add(new Lenguaje("Select_Board"));
        people.add(new Lenguaje("Rework_End_Activity"));
        people.add(new Lenguaje("Initial_Time"));
        people.add(new Lenguaje("Rework_Start_Activity"));
        people.add(new Lenguaje("Prod_No"));
        people.add(new Lenguaje("Serial_No"));
        people.add(new Lenguaje("Owner"));
        people.add(new Lenguaje("Idle_Time"));
        people.add(new Lenguaje("Cancel"));
        people.add(new Lenguaje("Start_Activity"));
        people.add(new Lenguaje("End_Activity"));
        people.add(new Lenguaje("Employee_No"));
        people.add(new Lenguaje("Employee_Number"));
        people.add(new Lenguaje("Business_Unit"));
        people.add(new Lenguaje("Name"));
        people.add(new Lenguaje("Area"));
        people.add(new Lenguaje("Departament"));
        people.add(new Lenguaje("Departament_No"));
        people.add(new Lenguaje("Employee"));
        people.add(new Lenguaje("Last_Name"));
        people.add(new Lenguaje("Password"));
        people.add(new Lenguaje("Rol"));
        people.add(new Lenguaje("Task_Name"));
        people.add(new Lenguaje("MYSQL_Query"));
        people.add(new Lenguaje("Columns"));
        people.add(new Lenguaje("Run_Query"));
        
        
        
        return people;
    }
    
    public void LoadTable(){
        //configure the table
         //set up the columns in the table
        firstwordsColumn.setCellValueFactory(new PropertyValueFactory<Lenguaje, String>("firstName"));
          //load dummy data
        tableView.setItems(getWords());
         //Update the table to allow for the first and last name fields
        //to be editable
        tableView.setEditable(true);
        firstwordsColumn.setCellFactory(TextFieldTableCell.forTableColumn());     
        //This will allow the table to select multiple rows at once
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);   
        //Disable the detailed person view button until a row is selected
        this.detailedPersonViewButton.setDisable(true);
    }
    
    public void LoadLang(String lang){
        Main.locale = new Locale(lang);
        Main.bundle = ResourceBundle.getBundle("Properties.Bundle", Main.locale);
        lbl_title.setText(Main.bundle.getString("Add_Language"));
        lbl_Language.setText(Main.bundle.getString("Language"));
        lbl_Icon.setText(Main.bundle.getString("Icon"));
        tbl_col_original.setText(Main.bundle.getString("Original_Words"));
        tbl_col_modify.setText(Main.bundle.getString("Translation"));
    }
}

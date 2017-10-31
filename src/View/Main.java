package View;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author jonathancastro
 */
public class Main extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;
    public static String Language = "en";
    public static ResourceBundle bundle;
    public static Locale locale;
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("App");
        
        initialwindows();
    }
    
    public void initialwindows(){
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AdminCenter.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            primaryStage.setX(bounds.getMinX());
            primaryStage.setY(bounds.getMinY());
            primaryStage.setWidth(bounds.getWidth());
            primaryStage.setHeight(bounds.getHeight());
            primaryStage.setScene(scene);
            primaryStage.show();
            System.out.println(bounds.getMaxX());
            System.out.println(bounds.getMaxY());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void WarningAlert (String titulo, String cabecera, String mensaje){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    public void ErrorAlert(String titulo, String cabecera, String mensaje){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void newWindow(String path) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("App");
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setScene(scene);
        stage.showAndWait();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author Fabian Castro G
 */
public class Lenguaje {
     private SimpleStringProperty firstwords;
     public Lenguaje(String firstName) {
        this.firstwords = new SimpleStringProperty(firstName);
        
     
    }
     
       public String getFirstName() {
        return firstwords.get();
    }

    public void setFirstName(String firstName) {
        this.firstwords = new SimpleStringProperty(firstName);
    }

    
    
    public String toString()
    {
        return String.format("%s %s", firstwords);
    }
    
}

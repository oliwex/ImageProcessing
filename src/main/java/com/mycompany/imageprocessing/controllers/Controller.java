/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageprocessing.controllers;

import com.mycompany.imageprocessing.processors.GridpaneProcessor;
import com.mycompany.imageprocessing.processors.ImageProcessor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Minio
 */
public class Controller {
    
    protected ImageProcessor imageProcessor=new ImageProcessor();
    
    protected void setGridPane(GridPane gridpane,int rows)
    {
        new GridpaneProcessor().getGridPane(gridpane,rows); 
    }
    protected void setLabel(Label label,String text)
    {
        label.setText(text);
    }
    protected void setButton(ToggleButton button,String text)
    {
        button.setText(text);
    }
    protected void setLabelToZero(Label labelToSet)
    {
        labelToSet.setText("0");
    }
    
    protected void setSlider(Slider sliderToSet)
    {
        sliderToSet.setMin(0);
        sliderToSet.setMax(100);
        sliderToSet.setShowTickLabels(true);
        sliderToSet.setShowTickMarks(true);
    } 
    
    protected void sceneSetter(String pathToFxml,AnchorPane anchorToSet)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(pathToFxml));
            anchorToSet.getChildren().add((AnchorPane)loader.load());
            RgbController rgbController = loader.getController();
            
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

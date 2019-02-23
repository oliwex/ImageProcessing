/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageprocessing.controllers;

import com.mycompany.imageprocessing.processors.GridpaneProcessor;
import com.mycompany.imageprocessing.processors.ImageProcessor;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Minio
 */
public class Controller {
    
    protected ImageProcessor imageProcessor=new ImageProcessor();
    
    protected void setGridPane(GridPane gridpane)
    {
        new GridpaneProcessor().getGridPane(gridpane); 
    }
    protected void setLabel(Label label,String text)
    {
        label.setText(text);
    }
    protected void setButton(ToggleButton button,String text)
    {
        button.setText(text);
    }
}

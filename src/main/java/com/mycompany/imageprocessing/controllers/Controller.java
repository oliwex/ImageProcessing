/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageprocessing.controllers;

import com.mycompany.imageprocessing.processors.GridpaneProcessor;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Minio
 */
public class Controller {
    
    private final String FILEPATH="src/main/resources/img/image.jpg";
    
    protected Image getImageFromFileSystem() //for 1 time
    {
        File file=new File(FILEPATH);
        Image image=new Image(file.toURI().toString());
        return image;
    }
    
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

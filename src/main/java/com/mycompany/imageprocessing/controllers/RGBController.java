/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageprocessing.controllers;

import com.mycompany.imageprocessing.Colors;
import com.mycompany.imageprocessing.processors.ImageProcessor;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Minio
 */
public class RGBController extends Controller implements Initializable 
{

    private final ImageProcessor imageProcessor=new ImageProcessor(); //TO DO::REFACTORING

    
    @FXML
    private GridPane gridpaneRGB;
    
    @FXML
    private Label labelRed;
    
    @FXML
    private Label labelGreen;
    
    @FXML
    private Label labelBlue;

    @FXML
    private ToggleButton buttonRed;
    
    @FXML
    private ToggleButton buttonGreen;
    
    @FXML
    private ToggleButton buttonBlue;
    
    
    private void setGridPane() //TODO::Centering elements in gridpane by CSS
    {
        super.setGridane(this.gridpaneRGB);
        super.setLabel(this.labelRed,Colors.RED.toString());
        super.setLabel(this.labelGreen,Colors.GREEN.toString());
        super.setLabel(this.labelBlue,Colors.BLUE.toString());
    }
    private void setButton()
    {
        super.setButton(this.buttonRed,Colors.RED.toString());
        super.setButton(this.buttonGreen,Colors.GREEN.toString());
        super.setButton(this.buttonBlue,Colors.BLUE.toString());
    }
    
    @FXML
    private void onClickRed()
    {
        MainController.mainController.imageView.setImage(imageProcessor.setColor(buttonRed,  buttonRed.getText()));
    }

    @FXML
    private void onClickGreen()
    {
        MainController.mainController.imageView.setImage(imageProcessor.setColor(buttonGreen, buttonGreen.getText()));
    }
    
    @FXML
    private void onClickBlue()
    {
        MainController.mainController.imageView.setImage(imageProcessor.setColor(buttonBlue, buttonBlue.getText()));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setButton();
        this.setGridPane();
        
    }    
    
}
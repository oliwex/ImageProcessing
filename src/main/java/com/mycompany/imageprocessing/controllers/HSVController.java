package com.mycompany.imageprocessing.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.imageprocessing.processors.GridpaneProcessor;
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
public class HSVController extends Controller implements Initializable {

    @FXML
    private GridPane gridPaneHSV;
    
    @FXML
    private Label labelHue;
    
    @FXML
    private Label labelSaturate;
    
    @FXML
    private Label labelValue;

    @FXML
    private ToggleButton buttonHue;
    
    @FXML
    private ToggleButton buttonSaturate;
    
    @FXML
    private ToggleButton buttonValue;
    
    
    
    private void setGridPane() //TODO::Centering elements in gridpane by CSS
    {
        new GridpaneProcessor().getGridPane(this.gridPaneHSV); 
        
        super.setLabel(this.labelHue,"Hue");
        super.setLabel(this.labelSaturate,"Saturate");
        super.setLabel(this.labelValue,"Value");
    }
    private void setButton()
    {
        super.setButton(this.buttonHue,"Hue");
        super.setButton(this.buttonSaturate,"Saturate");
        super.setButton(this.buttonValue,"Value");
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setGridPane();
        this.setButton();
    }    
    
}

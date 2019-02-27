package com.mycompany.imageprocessing.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.imageprocessing.Colors;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Minio
 */
public class MiscController extends Controller implements Initializable {

    
    @FXML
    private GridPane gridpaneMisc;
    
    @FXML
    private Label labelBrighter;
    
    @FXML
    private Label labelDarker;
    
    @FXML
    private Label labelGreyscale;

    @FXML
    private Label labelInvert;

    @FXML
    private Slider sliderBrighter;
    
    @FXML
    private Slider sliderDarker;
    
    @FXML
    private Button buttonGreyscale;
    
    @FXML
    private Button buttonInvert;
    
    private void setGridPaneOnScene()
    {
        super.setGridPane(this.gridpaneMisc,4); 
        
        super.setLabel(this.labelDarker,Colors.Dark.toString());
        super.setLabel(this.labelBrighter,Colors.Bright.toString());
        super.setLabel(this.labelGreyscale,Colors.Greyscale.toString());
        super.setLabel(this.labelInvert,Colors.Invert.toString());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setGridPaneOnScene();
    }    
    
}

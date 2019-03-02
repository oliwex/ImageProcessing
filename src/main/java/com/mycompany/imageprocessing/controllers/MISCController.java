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
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import com.sun.javafx.util.Utils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.effect.ColorAdjust;

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
    private Label labelGreyscale;

    @FXML
    private Label labelInvert;

    @FXML
    private Label labelValueBrighter;

    @FXML
    private Slider sliderBrighter;
    
    @FXML
    private ToggleButton buttonGreyscale;
    
    @FXML
    private ToggleButton buttonInvert;
    
    private void setGridPaneOnScene()
    {
        super.setGridPane(this.gridpaneMisc); 
        
        super.setLabel(this.labelBrighter,Colors.Bright.toString());
        super.setLabel(this.labelGreyscale,Colors.Greyscale.toString());
        super.setLabel(this.labelInvert,Colors.Invert.toString());
    }
    
    private void setButtonOnScene()
    {
        super.setButton(this.buttonGreyscale,Colors.Greyscale.toString());
        super.setButton(this.buttonInvert,Colors.Invert.toString());
    }
   
    
    
    private void sliderListener(Slider sliderColor,Label labelValueColor,ColorAdjust ca)
    {
        sliderColor.valueProperty().addListener(
            new ChangeListener<Number>()
            {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue)
            {
                labelValueColor.setText(String.valueOf(newValue));
                double valueToSet=(double)newValue/100;
                ca.setBrightness(valueToSet);
            }
        });
    }
    private void sliderAdjuster()
    {
        ColorAdjust ca=new ColorAdjust();
        this.sliderListener(this.sliderBrighter,this.labelValueBrighter,ca);
        MainController.mainController.imageView.setEffect(ca);
    }
    
    @FXML
    private void onClickGreyscale()
    {

        MainController.mainController.imageView.setImage(super.imageProcessor.setColor(buttonGreyscale,  buttonGreyscale.getText()));
    }
    @FXML
    private void onClickInvert()
    {
        MainController.mainController.imageView.setImage(super.imageProcessor.setColor(buttonInvert,  buttonInvert.getText()));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.setGridPaneOnScene();
        this.setButtonOnScene();
        super.setSlider(this.sliderBrighter);
        this.sliderAdjuster();

        
        
       

        
        super.setLabelToZero(this.labelValueBrighter);
        
    }    
    
}

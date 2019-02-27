package com.mycompany.imageprocessing.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.imageprocessing.Colors;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.beans.value.ChangeListener;
import javafx.scene.effect.ColorAdjust;

/**
 * FXML Controller class
 *
 * @author Minio
 */
public class HsvController extends Controller implements Initializable {


    
    @FXML
    private GridPane gridpaneHSV;
    
    @FXML
    private Label labelHue;
    
    @FXML
    private Label labelSaturate;
    
    @FXML
    private Label labelValue;

    @FXML
    private Label labelValueHue;
    
    @FXML
    private Label labelValueSaturate;
    
    @FXML
    private Label labelValueValue;

    @FXML
    private Slider sliderHue;
    
    @FXML
    private Slider sliderSaturation;
    
    @FXML
    private Slider sliderValue;
    
    
    
    private void setGridPaneOnScene()
    {
        super.setGridPane(this.gridpaneHSV,3);
        
        super.setLabel(this.labelHue,Colors.Hue.toString());
        super.setLabel(this.labelSaturate,Colors.Saturate.toString());
        super.setLabel(this.labelValue,Colors.Value.toString());
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
                
                if (sliderColor.equals(sliderHue))
                {
                   ca.setHue(valueToSet); 
                }
                else if(sliderColor.equals(sliderSaturation))
                {
                    ca.setSaturation(valueToSet);
                }
                else if (sliderColor.equals(sliderValue))
                {
                    ca.setBrightness(valueToSet);
                }
            }
        });
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
            this.setGridPaneOnScene();
            
            super.setSlider(this.sliderHue);
            super.setSlider(this.sliderSaturation);
            super.setSlider(this.sliderValue);
            
            super.setLabelToZero(this.labelValueHue);
            super.setLabelToZero(this.labelValueSaturate);
            super.setLabelToZero(this.labelValueValue);
            
            
            ColorAdjust ca=new ColorAdjust();
            
            this.sliderListener(sliderSaturation,labelValueSaturate,ca);
            this.sliderListener(sliderValue,labelValueValue,ca);       
            this.sliderListener(sliderHue,labelValueHue,ca); 

            MainController.mainController.imageView.setEffect(ca);
            

        }       
    }

        


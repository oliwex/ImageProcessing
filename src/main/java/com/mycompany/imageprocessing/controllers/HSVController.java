package com.mycompany.imageprocessing.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class HSVController extends Controller implements Initializable {

    
    
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
        super.setGridPane(this.gridpaneHSV);
        
        super.setLabel(this.labelHue,"Hue");
        super.setLabel(this.labelSaturate,"Saturate");
        super.setLabel(this.labelValue,"Value");
    }
    
    
    private void setLabel(Label labelToSet)
    {
        labelToSet.setText("0");
    }
    private void setSlider(Slider sliderToSet)
    {
        sliderToSet.setMin(0);
        sliderToSet.setMax(100);
        sliderToSet.setShowTickLabels(true);
        sliderToSet.setShowTickMarks(true);
    }    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
            this.setGridPaneOnScene();
            this.setSlider(this.sliderHue);
            this.setSlider(this.sliderSaturation);
            this.setSlider(this.sliderValue);
            
            this.setLabel(this.labelValueHue);
            this.setLabel(this.labelValueSaturate);
            this.setLabel(this.labelValueValue);
            
            
            sliderHue.valueProperty().addListener(
                    new ChangeListener<Number>()
                    {
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue)
                        {
                            labelValueHue.setText(String.valueOf(newValue));
                            ColorAdjust ca=new ColorAdjust();
                            ca.setHue(((double) newValue)/100);
                            MainController.mainController.imageView.setEffect(ca);
                        }
                    });
            
            sliderSaturation.valueProperty().addListener(
                    new ChangeListener<Number>()
                    {
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue)
                        {
                            labelValueSaturate.setText(String.valueOf(newValue));
                            ColorAdjust ca=new ColorAdjust();
                            ca.setSaturation(((double) newValue)/100);
                            MainController.mainController.imageView.setEffect(ca);
                        }
                    });
                sliderValue.valueProperty().addListener(
                    new ChangeListener<Number>()
                    {
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue)
                        {
                            labelValueValue.setText(String.valueOf(newValue));
                            ColorAdjust ca=new ColorAdjust();
                            ca.setBrightness(((double) newValue)/100);
                            MainController.mainController.imageView.setEffect(ca);
                        }
                    });

            
            

        }       
    }

        


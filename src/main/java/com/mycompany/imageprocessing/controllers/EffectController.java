package com.mycompany.imageprocessing.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.imageprocessing.Colors;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.SepiaTone;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Minio
 */
//GLow,GAussian Blur,Sepia
public class EffectController extends Controller implements Initializable {
    
    @FXML
    private GridPane gridpaneEffect;
    
    @FXML
    private Label labelGlow;
    
    @FXML
    private Label labelBlur;
    
    @FXML
    private Label labelSepia;

    @FXML
    private Label labelValueGlow;
    
    @FXML
    private Label labelValueBlur;
    
    @FXML
    private Label labelValueSepia;

    @FXML
    private Slider sliderGlow;
    
    @FXML
    private Slider sliderBlur;
    
    @FXML
    private Slider sliderSepia;
    
    private void setGridPaneOnScene()
    {
        super.setGridPane(this.gridpaneEffect);
        
        super.setLabel(this.labelGlow,Colors.Glow.toString());
        super.setLabel(this.labelBlur,Colors.Blur.toString());
        super.setLabel(this.labelSepia,Colors.Sepia.toString());
    }
    private void setSliderOnScene()
    {
        super.setSlider(this.sliderGlow);
        super.setSlider(this.sliderBlur);
        super.setSlider(this.sliderSepia);
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setGridPaneOnScene();
        this.setSliderOnScene();
        
        super.setSlider(this.sliderGlow);
        super.setSlider(this.sliderBlur);
        super.setSlider(this.sliderSepia);
        

        Glow glow=new Glow();
        
        this.sliderGlow.valueProperty().addListener(
            new ChangeListener<Number>()
            {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue)
            {
                
                labelValueGlow.setText(String.valueOf(newValue));
                double valueToSet=(double)newValue/100;
                glow.setLevel(valueToSet);
                MainController.mainController.imageView.setEffect(glow);
            }
        });
        
        GaussianBlur blur=new GaussianBlur();
        
        this.sliderBlur.valueProperty().addListener(
            new ChangeListener<Number>()
            {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue)
            {
                labelValueBlur.setText(String.valueOf(newValue));
                double valueToSet=(double)newValue/100;
                blur.setRadius(valueToSet);
                MainController.mainController.imageView.setEffect(blur);
            }
        });
        
        SepiaTone sepia = new SepiaTone(); 
        
        this.sliderSepia.valueProperty().addListener(
            new ChangeListener<Number>()
            {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue)
            {
                labelValueSepia.setText(String.valueOf(newValue));
                double valueToSet=(double)newValue/100;
                sepia.setLevel(valueToSet);
                MainController.mainController.imageView.setEffect(sepia);
            }
        });

        super.setLabelToZero(this.labelValueGlow);
        super.setLabelToZero(this.labelValueBlur);
        super.setLabelToZero(this.labelValueSepia);
        
        
    }    
    
}

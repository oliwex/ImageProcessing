package com.mycompany.imageprocessing.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.beans.value.ChangeListener;

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
    
    private void setSlider(Slider sliderToSet,Label labelToSet)
    {
        sliderToSet.setMin(0);
        sliderToSet.setMax(100);
       // sliderToSet.setValue(50);
        sliderToSet.setShowTickLabels(true);
        sliderToSet.setShowTickMarks(true);

        sliderToSet.valueProperty().addListener(
        new ChangeListener<Number>()
        {
           @Override
           public void changed(ObservableValue<? extends Number> observable, Number oldValue,Number newValue)
            {
                labelToSet.setText(String.valueOf(newValue));
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
        this.setSlider(this.sliderHue,this.labelValueHue);
        this.setSlider(this.sliderSaturation,this.labelValueSaturate);
        this.setSlider(this.sliderValue,this.labelValueValue);
        
        
    }    
    
}
/*
MainController.mainController.imageView.setPreserveRatio(true);
        ColorAdjust ca=new ColorAdjust();

        ca.setInput(ca);
        MainController.mainController.imageView.setEffect(ca);
*/

package com.mycompany.imageprocessing.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class HSVController extends Controller implements Initializable {

    private final ImageProcessor imageProcessor=new ImageProcessor(); //TO DO::REFACTORING
    
    @FXML
    private GridPane gridpaneHSV;
    
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
    
    
    
    private void setGridPaneOnScene() //TODO::Centering elements in gridpane by CSS
    {
        super.setGridPane(this.gridpaneHSV);
        
        super.setLabel(this.labelHue,"Hue");
        super.setLabel(this.labelSaturate,"Saturate");
        super.setLabel(this.labelValue,"Value");
    }
    private void setButtonOnScene()
    {
        super.setButton(this.buttonHue,"Hue");
        super.setButton(this.buttonSaturate,"Saturate");
        super.setButton(this.buttonValue,"Value");
    }
    
    @FXML
    private void onClickHue()
    {
        System.out.println("Hue");
    //    MainController.mainController.imageView.setImage(imageProcessor.setColor(buttonRed,  buttonRed.getText()));
        MainController.mainController.imageView.setImage(imageProcessor.setColor(buttonHue,buttonHue.getText()));
    }

    @FXML
    private void onClickSaturate()
    {
        System.out.println("Saturate");
    //    MainController.mainController.imageView.setImage(imageProcessor.setColor(buttonGreen, buttonGreen.getText()));
        MainController.mainController.imageView.setImage(imageProcessor.setColor(buttonSaturate,buttonSaturate.getText()));
    }
    
    @FXML
    private void onClickValue()
    {
        System.out.println("Value");
    //    MainController.mainController.imageView.setImage(imageProcessor.setColor(buttonBlue, buttonBlue.getText()));
        MainController.mainController.imageView.setImage(imageProcessor.setColor(buttonValue,buttonValue.getText()));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        this.setGridPaneOnScene();
        this.setButtonOnScene();
    }    
    
}

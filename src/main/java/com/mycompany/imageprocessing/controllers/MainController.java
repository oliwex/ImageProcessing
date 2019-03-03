package com.mycompany.imageprocessing.controllers;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainController extends Controller implements Initializable 
{

 
    public static MainController mainController;

    @FXML
    public ImageView imageView;
    
    @FXML
    private AnchorPane background;
        
    @FXML
    private AnchorPane anchorHsv;
    
    @FXML
    private AnchorPane anchorRgb;
    
    @FXML
    private AnchorPane anchorMisc;
    
    @FXML
    private AnchorPane anchorEffect;

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        mainController = this;
        
        super.sceneSetter("/fxml/Rgb.fxml", this.anchorRgb); //working
        super.sceneSetter("/fxml/Hsv.fxml", this.anchorHsv); //working
        super.sceneSetter("/fxml/Misc.fxml", this.anchorMisc); //working
        super.sceneSetter("/fxml/Effect.fxml", this.anchorEffect);
        
        
        super.imageProcessor.setImageIntoImageView(this.imageView);
    }
}




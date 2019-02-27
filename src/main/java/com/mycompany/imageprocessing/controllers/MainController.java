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

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        mainController = this;
        
        super.sceneSetter("/fxml/Rgb.fxml", this.anchorRgb);
        super.sceneSetter("/fxml/Hsv.fxml", this.anchorHsv);
        super.sceneSetter("/fxml/Misc.fxml", this.anchorMisc);

        super.imageProcessor.setImageIntoImageView(this.imageView);
    }
}


//TODO::Make red/green/blue changing image color by a button
//TODO1::Make red/green/blue changing image color by a slider going from left

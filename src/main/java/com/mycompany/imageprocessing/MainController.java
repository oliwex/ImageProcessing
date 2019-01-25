package com.mycompany.imageprocessing;


import com.mycompany.imageprocessing.processors.ImageProcessor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.*;
import javafx.fxml.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MainController implements Initializable {

    private ImageProcessor imageProcessor=new ImageProcessor(); //TO DO::REFACTORING

    // Gleidson
    static MainController mainController;
    static RGBController rgbController;
    
    @FXML
    ImageView imageView;
    
    @FXML
    private AnchorPane background;
        
    @FXML
    private AnchorPane anchorHSV;
    
    @FXML
    private AnchorPane anchorRGB;


    public ImageView getImageView(){
        return imageView;
    }

    private void setFXML()
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RGB.fxml"));
            this.anchorRGB.getChildren().add((AnchorPane)loader.load());
            rgbController = loader.getController();
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        mainController = this;
        this.setFXML();
        this.imageProcessor.setImageIntoImageView(this.imageView);
        
    }
}


//TODO::Make red/green/blue changing image color by a button
//TODO1::Make red/green/blue changing image color by a slider going from left

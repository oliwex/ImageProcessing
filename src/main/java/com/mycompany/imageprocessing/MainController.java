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
    
    @FXML
    private ImageView imageView;
    
    @FXML
    private AnchorPane background;
        
    @FXML
    private AnchorPane anchorHSV;
    
    @FXML
    private AnchorPane anchorRGB;
    

    private void setFXML()
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RGB.fxml"));
            this.anchorRGB.getChildren().add((AnchorPane)loader.load());
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        this.setFXML();
        this.imageProcessor.setImageIntoImageView(this.imageView);
        
    }
}


//TODO::Make red/green/blue changing image color by a button
//TODO1::Make red/green/blue changing image color by a slider going from left

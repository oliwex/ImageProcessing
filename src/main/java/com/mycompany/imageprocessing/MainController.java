package com.mycompany.imageprocessing;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class MainController implements Initializable {

    private ImageProcessor imageProcessor=new ImageProcessor();
    private GridpaneProcessor gridpaneProcessor=new GridpaneProcessor();
    
    @FXML
    private AnchorPane background;
    
    @FXML
    private ImageView imageView;
    
    
    @FXML
    private GridPane gridpaneColors;
    
    @FXML
    private Label labelRed;
    
    @FXML
    private Label labelGreen;
    
    @FXML
    private Label labelBlue;

    @FXML
    private ToggleButton buttonRed;
    
    @FXML
    private ToggleButton buttonGreen;
    
    @FXML
    private ToggleButton buttonBlue;
    
    
    
    private void setGridPane() //TODO::Centering elements in gridpane by CSS
    {

        this.gridpaneProcessor.getGridPane(this.gridpaneColors);
        
        this.labelRed.setText(Colors.RED.toString());
        this.labelGreen.setText(Colors.GREEN.toString());
        this.labelBlue.setText(Colors.BLUE.toString());

    }
    private void setButton()
    {
        this.buttonRed.setText(Colors.RED.toString());
        this.buttonGreen.setText(Colors.GREEN.toString());
        this.buttonBlue.setText(Colors.BLUE.toString());
    }

    @FXML
    private void onClickRed()
    {
        this.imageView.setImage(this.imageProcessor.setColor(this.buttonRed,Colors.RED.toString())); //TODO:Steering with enums  
    }

    @FXML
    private void onClickGreen()
    {
        this.imageView.setImage(this.imageProcessor.setColor(this.buttonGreen,Colors.GREEN.toString())); //TODO:Steering with enums
    }
    
    @FXML
    private void onClickBlue()
    {
        this.imageView.setImage(this.imageProcessor.setColor(this.buttonBlue,Colors.BLUE.toString())); //TODO:Steering with enums
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        this.imageProcessor.setImageIntoImageView(this.imageView);

        this.setButton();
        this.setGridPane();

    }
}


//TODO::Make red/green/blue changing image color by a button
//TODO1::Make red/green/blue changing image color by a slider going from left

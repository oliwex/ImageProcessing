package com.mycompany.imageprocessing;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainController implements Initializable {

    
    
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
    private Label redPercent;
    
    @FXML
    private Label greenPercent;
    
    @FXML
    private Label bluePercent;
    
    
    @FXML
    private Slider sliderRed;
    @FXML
    private Slider sliderGreen;
    @FXML
    private Slider sliderBlue;
    
    private void setImage()
    {
        File file=new File("src/main/resources/img/image.jpg");
        Image image=new Image(file.toURI().toString());
        this.imageView.setImage(image);
    }
    private void setGridPane() //TODO::Centering elements in gridpane
    {
        this.gridpaneColors.getColumnConstraints().get(0).setPercentWidth(20);
        this.gridpaneColors.getColumnConstraints().get(1).setPercentWidth(60);
        this.gridpaneColors.getColumnConstraints().get(2).setPercentWidth(20);
        

        
        this.labelRed.setText("Red");
        this.labelGreen.setText("Green");
        this.labelBlue.setText("Blue");
        
        this.redPercent.setText("0");
        this.greenPercent.setText("0");
        this.bluePercent.setText("0");
        
    }
    

    
    
    private void setSlider(Slider sliderColor)
    {
        sliderColor.setShowTickLabels(true);
    }
    
        
    private void sliderListeners(Slider sliderColor,final Label percentLabel)
    {
        
        sliderColor.valueProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
            {
                int tmp=newValue.intValue();
                percentLabel.setText(String.format("%d", tmp));

                Image imageTmp=imageView.getImage();

                PixelReader pr = imageTmp.getPixelReader();
                int width = (int) imageTmp.getWidth();
                int height = (int) imageTmp.getHeight();

                WritableImage result = new WritableImage(width, height);
                PixelWriter pw = result.getPixelWriter();
                for (int x = 0;  x < width;  x++) {
                    for (int y = 0; y < height;  y++) {
                        Color col = pr.getColor(x, y);
                        
                        //(double)newValue/100
                       
    
    
                        
                        Color color=new Color(0, 0, col.getBlue() , 1);
                        
                        pw.setColor(x, y, color);
                        
                        
                        
                    }
                }
                

                imageView.setImage(result);
                
        }
        });
    }       
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.setImage();
        
        this.setSlider(this.sliderRed);
        this.setSlider(this.sliderGreen);
        this.setSlider(this.sliderBlue);
        
        this.setGridPane();
        
        this.sliderListeners(sliderRed,redPercent);
        this.sliderListeners(sliderGreen,greenPercent);
        this.sliderListeners(sliderBlue,bluePercent);

        this.setImage();
    }
}


//TODO::Make red/green/blue changing image color by a button
//TODO1::Make red/green/blue changing image color by a slider going from left

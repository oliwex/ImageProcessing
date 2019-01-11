package com.mycompany.imageprocessing;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

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
    private ToggleButton buttonRed;
    
    @FXML
    private ToggleButton buttonGreen;
    
    @FXML
    private ToggleButton buttonBlue;
    
    
    private void setImage()
    {
        File file=new File("src/main/resources/img/image.jpg");
        Image image=new Image(file.toURI().toString());
        this.imageView.setImage(image);
    }
    private void setGridPane() //TODO::Centering elements in gridpane by CSS
    {


       Gridpane gp=new Gridpane();
       gp.setGridPane(this.gridpaneColors);
       
       this.gridpaneColors=gp.getGridPane();
        
       
        
        this.labelRed.setText("Red");
        this.labelGreen.setText("Green");
        this.labelBlue.setText("Blue");

    }
    private void setButton()
    {
        this.buttonRed.setText("RED");
        this.buttonGreen.setText("GREEN");
        this.buttonBlue.setText("BLUE");
    }
    
    private void changeImageToRed()
    {
        Image imageToProcess=this.imageView.getImage();
        PixelReader pr = imageToProcess.getPixelReader();
        
        int width = (int) imageToProcess.getWidth();
        int height = (int) imageToProcess.getHeight();
        
        WritableImage result = new WritableImage(width, height);
        PixelWriter pw = result.getPixelWriter();
        
        for (int x = 0;  x < width;  x++) 
        {
            for (int y = 0; y < height;  y++) 
            {
                Color col = pr.getColor(x, y);
                pw.setColor(x, y, new Color(col.getRed(), 0, 0 , 1));  
            }
        }
        imageView.setImage(result);
    }
    private void changeImageToGreen()
    {
        Image imageToProcess=this.imageView.getImage();
        PixelReader pr = imageToProcess.getPixelReader();
        
        int width = (int) imageToProcess.getWidth();
        int height = (int) imageToProcess.getHeight();
        
        WritableImage result = new WritableImage(width, height);
        PixelWriter pw = result.getPixelWriter();
        
        for (int x = 0;  x < width;  x++) 
        {
            for (int y = 0; y < height;  y++) 
            {
                Color col = pr.getColor(x, y);
                pw.setColor(x, y, new Color(0, col.getGreen(), 0 , 1));  
            }
        }
        imageView.setImage(result);
    }
    private void changeImageToBlue()
    {
        Image imageToProcess=this.imageView.getImage();
        PixelReader pr = imageToProcess.getPixelReader();
        
        int width = (int) imageToProcess.getWidth();
        int height = (int) imageToProcess.getHeight();
        
        WritableImage result = new WritableImage(width, height);
        PixelWriter pw = result.getPixelWriter();
        
        for (int x = 0;  x < width;  x++) 
        {
            for (int y = 0; y < height;  y++) 
            {
                Color col = pr.getColor(x, y);
                pw.setColor(x, y, new Color(0, 0, col.getBlue() , 1));  
            }
        }
        imageView.setImage(result);
    }

    @FXML
    private void onClickRed()
    {
        Image imageToProcess=this.imageView.getImage();
        PixelReader pr = imageToProcess.getPixelReader();
        
        int width = (int) imageToProcess.getWidth();
        int height = (int) imageToProcess.getHeight();
        
        WritableImage result = new WritableImage(width, height);
        PixelWriter pw = result.getPixelWriter();
        
        if (this.buttonRed.isSelected())
        {
            for (int x = 0;  x < width;  x++) 
            {
                for (int y = 0; y < height;  y++) 
                {
                    Color col = pr.getColor(x, y);
                    pw.setColor(x, y, new Color(col.getRed(), 0, 0 , 1));  
                }
            }
            imageView.setImage(result);
            
            
        }
        else
        {
            this.setImage(); 
        }
        
        
    }
    
    @FXML
    private void onClickBlue()
    {
        Image imageToProcess=this.imageView.getImage();
        PixelReader pr = imageToProcess.getPixelReader();
        
        int width = (int) imageToProcess.getWidth();
        int height = (int) imageToProcess.getHeight();
        
        WritableImage result = new WritableImage(width, height);
        PixelWriter pw = result.getPixelWriter();
        
        if (this.buttonBlue.isSelected())
        {
            for (int x = 0;  x < width;  x++) 
            {
                for (int y = 0; y < height;  y++) 
                {
                    Color col = pr.getColor(x, y);
                    pw.setColor(x, y, new Color(0, 0, col.getBlue() , 1));  
                }
            }
            imageView.setImage(result);
            
            
        }
        else
        {
            this.setImage(); 
        }
        
        
    }
    
    @FXML
    private void onClickGreen()
    {
        Image imageToProcess=this.imageView.getImage();
        PixelReader pr = imageToProcess.getPixelReader();
        
        int width = (int) imageToProcess.getWidth();
        int height = (int) imageToProcess.getHeight();
        
        WritableImage result = new WritableImage(width, height);
        PixelWriter pw = result.getPixelWriter();
        
        if (this.buttonGreen.isSelected())
        {
            for (int x = 0;  x < width;  x++) 
            {
                for (int y = 0; y < height;  y++) 
                {
                    Color col = pr.getColor(x, y);
                    pw.setColor(x, y, new Color(0, col.getGreen(),  0, 1));  
                }
            }
            imageView.setImage(result);
            
            
        }
        else
        {
            this.setImage(); 
        }
        
        
    }
    /*
    
    
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
                for (int x = 0;  x < width/2;  x++) {
                    for (int y = 0; y < height/2;  y++) {
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
    */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.setImage();
        /*
        this.setSlider(this.sliderRed);
        this.setSlider(this.sliderGreen);
        this.setSlider(this.sliderBlue);
        this.sliderListeners(sliderRed,redPercent);
        this.sliderListeners(sliderGreen,greenPercent);
        this.sliderListeners(sliderBlue,bluePercent);
        */
        this.setButton();
        this.setGridPane();
        this.setImage();
    }
}


//TODO::Make red/green/blue changing image color by a button
//TODO1::Make red/green/blue changing image color by a slider going from left

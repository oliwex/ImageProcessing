/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageprocessing.processors;

import java.awt.image.BufferedImage;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 *
 * @author Minio
 */
public class ImageProcessor {
    
    private final String FILEPATH="src/main/resources/img/image.jpg";
    
    private Image getImageFromFileSystem() //for 1 time
    {
        File file=new File(FILEPATH);
        Image image=new Image(file.toURI().toString());
        return image;
    }
    public void setImageIntoImageView(ImageView imgView)
    {
        imgView.setImage(this.getImageFromFileSystem());
    }
    
    private Image convertWritableImageToImage(WritableImage wi)
    {
        Image image = null;
        BufferedImage bi =SwingFXUtils.fromFXImage((Image)wi, null); 
        WritableImage toFXImage = SwingFXUtils.toFXImage(bi, (WritableImage)image);
        return toFXImage;
    }
    
    private Color setColorToImage(String colorToSet,Color colorObject)
    {
        Color newColor=null;

        if (colorToSet.equalsIgnoreCase("RED"))
        {
            newColor=new Color(colorObject.getRed(),0,0,1);
        }
        else if(colorToSet.equalsIgnoreCase("GREEN"))
        {
            newColor=new Color(0,colorObject.getGreen(),0,1);
        }
        else if(colorToSet.equalsIgnoreCase("BLUE"))
        {
            newColor=new Color(0,0,colorObject.getBlue(),1);
        }
        return newColor;
    }
    
    public Image setColor(ToggleButton buttonState,String newImageColor)
    {
//        System.out.println(buttonState + ", " + newImageColor);


        Image img = this.getImageFromFileSystem();
        PixelReader pr = img.getPixelReader();
        
        int width = (int) img.getWidth();
        int height = (int) img.getHeight();
        
        WritableImage result = new WritableImage(width, height);
        PixelWriter pw = result.getPixelWriter();

        if (buttonState.isSelected())
        {
            for (int x = 0;  x < width;  x++) 
            {
                for (int y = 0; y < height;  y++) 
                {
                    Color colorFromImage = pr.getColor(x, y);

                    pw.setColor(x, y, this.setColorToImage(newImageColor, colorFromImage));

                }
            }

           return this.convertWritableImageToImage(result);
        }
        else
        {
            
           return this.getImageFromFileSystem();
        }
    }  
}

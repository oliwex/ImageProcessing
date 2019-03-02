/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageprocessing.processors;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Minio
 */
public class GridpaneProcessor 
{   
    private final HPos horizontalPosition=HPos.CENTER;
    private final VPos verticalPosition=VPos.CENTER;
            
    public void getGridPane(GridPane gridpaneToStyle) 
    {
        gridpaneToStyle.getColumnConstraints().get(0).setHalignment(horizontalPosition);
        gridpaneToStyle.getColumnConstraints().get(1).setHalignment(horizontalPosition);


        gridpaneToStyle.getRowConstraints().get(0).setValignment(verticalPosition);
        gridpaneToStyle.getRowConstraints().get(1).setValignment(verticalPosition);
        gridpaneToStyle.getRowConstraints().get(2).setValignment(verticalPosition);
  
        gridpaneToStyle.getColumnConstraints().get(0).setPercentWidth(30);
        gridpaneToStyle.getColumnConstraints().get(1).setPercentWidth(70);
    }
}

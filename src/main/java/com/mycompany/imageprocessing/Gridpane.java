/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageprocessing;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author Minio
 */
public class Gridpane {
    
    private GridPane gridPane;

    
    private final ObservableList<ColumnConstraints> columnConstraints=this.gridPane.getColumnConstraints();
    private final ObservableList<RowConstraints> rowConstraints=this.gridPane.getRowConstraints();
    
    private final HPos horizontalPosition=HPos.CENTER;
    private final VPos verticalPosition=VPos.CENTER;
            
    public GridPane getGridPane() {
        this.setGridpaneProperties();
        return this.gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }
    

    private void setGridpaneProperties()
    {
        columnConstraints.get(0).setHalignment(horizontalPosition);
        columnConstraints.get(1).setHalignment(horizontalPosition);
        
        rowConstraints.get(0).setValignment(verticalPosition);
        rowConstraints.get(1).setValignment(verticalPosition);
        rowConstraints.get(2).setValignment(verticalPosition);
    }
    private void setGridpaneColumns()
    {
        columnConstraints.get(0).setPercentWidth(50);
        columnConstraints.get(1).setPercentWidth(50);
    }
 
}

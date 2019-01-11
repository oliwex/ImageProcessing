/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.imageprocessing;

/**
 *
 * @author Minio
 */
public enum Colors { //TODO:Connect with main Controller
    Red("RED"),
    Green("Green"),
    Blue("Blue");

    private String color; 
    
    Colors(String color)
    {
        this.color=color;
    }
    public String getColor(String color)
    {
        return this.color;
    }
}

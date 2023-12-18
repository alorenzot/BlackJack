package org.example;

import com.diogonunes.jcolor.Attribute;

public enum Color{
    //Enumerar los datos
    BLACK(Attribute.BLACK_TEXT()),
    RED(Attribute.RED_TEXT());
    //Definir los datos
    private Attribute color;

    Color(Attribute color){
        this.color=color;
    }
    public Attribute getColor(){
        return color;
    }

}

package org.example;

import static com.diogonunes.jcolor.Ansi.colorize;

public enum Palo {
    SPADE   ('♠',Color.BLACK),
    HEART   ('♥',Color.RED),
    DIAMOND ('♦',Color.RED),
    CLUB    ('♣',Color.BLACK);
    private char shape;
    private Color color;

    Palo(char shape, Color color){
        this.shape=shape;
        this.color=color;
    }

    @Override
    public String toString(){
        return colorize(""+shape,color.getColor());
    }
}

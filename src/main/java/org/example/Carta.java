package org.example;

public class Carta {
    private Palo palo;
    private Tipo tipo;

    public Carta(Tipo tipo, Palo palo){
        this.tipo=tipo;
        this.palo=palo;
    }
    public int[] getValues(){
        return tipo.getValor();
    }
    @Override
    public String toString(){
        return tipo.toString()+palo.toString();
    }
}

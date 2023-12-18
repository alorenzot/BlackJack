package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Baraja {
    private Carta[] cartas;

    public Baraja(){
        cartas= new Carta[Palo.values().length*Tipo.values().length];
        int i=0;
        for (Palo palo: Palo.values())
            for (Tipo tipo : Tipo.values())
                cartas[i++]= new  Carta(tipo, palo);
    }
    public void barajar(){
        List<Carta> aux = Arrays.asList(cartas);
        Collections.shuffle(aux);

        int i=0;
        for (Carta c:aux)
            cartas[i++]=c;
    }
    public void cortar() {
        if (cartas.length!=0) {
           int corte = (int) (Math.random() * cartas.length - 1);
            Carta[] aux = new Carta[cartas.length];

            for (int i = 0; i + corte < cartas.length; i++) {
                aux[i] = cartas[i + corte];
            }
            for (int i = 0; i < corte; i++)
                aux[cartas.length - corte + i] = cartas[i];

            cartas = aux;
        }
    }
    public Carta verPrimera(){
        if (cartas.length==0) return null;
        else return cartas[0];
    }
    public Carta quitarPrimera(){
        if (cartas.length==0) return null;

        Carta c = cartas[0];
        Carta[] aux= new Carta[cartas.length-1];
        for (int i = 0 ; i < aux.length ; i++){
            aux[i]=cartas[i+1];
        }

        cartas=aux;
        return c;

    }
    public Carta quitarUltima(){
        if (cartas.length==0) return null;

        Carta c = cartas[cartas.length-1];
        Carta[] aux= new Carta[cartas.length-1];
        for (int i = 0 ; i < aux.length ; i++){
            aux[i]=cartas[i];
        }

        cartas=aux;
        return c;
    }


    @Override
    public String toString(){
        return Arrays.toString(cartas);
    }
}

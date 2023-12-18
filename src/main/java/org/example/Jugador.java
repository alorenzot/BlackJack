package org.example;

public class Jugador {
    private Mano mano;
    private String nombre;

    public Jugador(String nombre){
        this.nombre=nombre;
        mano=new Mano();
    }
    public void cogerCarta(Carta carta){
        mano.cogerCarta(carta);
    }
    public int getPuntuacion(){
        return mano.obtenerPuntuacion();
    }
    public boolean pasado(){
        return getPuntuacion()>21;
    }
    public String getNombre(){
        return this.nombre;
    }
    public boolean ganasA(Jugador jugador){
        if (getPuntuacion()>21) return false;
        if (jugador.pasado())return true;
        return jugador.getPuntuacion()<getPuntuacion();
    }
    public boolean ganasATodos(Jugador...jugadores){
        if (pasado()) return false;
        boolean gana = true;
        int i=0;

        while (gana && i< jugadores.length) {
            gana = jugadores[i].pasado() || jugadores[i].getPuntuacion() < getPuntuacion();
            i++;
        }
        return gana;
    }
    @Override
    public String toString(){
        return "Jugador: " + nombre + "\n" +
                "Cartas: " + mano + "\n" +
                "Puntuación: " + getPuntuacion();
    }
}

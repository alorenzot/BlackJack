package org.example;

public class Main {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Andrea");

        Juego juego=new Juego(jugador1,jugador2);
        juego.empezar();
    }
}
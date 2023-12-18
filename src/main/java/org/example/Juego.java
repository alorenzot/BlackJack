package org.example;

import java.util.Scanner;

public class Juego {
    private Jugador[] jugadores;
    private Jugador banca;
    private Baraja baraja;

    public Juego(){
        baraja=new Baraja();
        banca=new Jugador("PC");
        init();
    }
    public Juego(Jugador...jugadores){
        baraja=new Baraja();
        banca=new Jugador("PC");
        this.jugadores=jugadores;
    }
    private void init() {

    }
    public void empezar() {

        baraja.barajar();

        jueganJugadores();
        juegaBanca();
        mostrarGanadores();
    }

    private void mostrarGanadores() {
        if (banca.pasado()){
            for (Jugador jugador : jugadores){
                if (jugador.ganasA(banca)){
                    System.out.println("\n¡El jugador " + jugador.getNombre() + " ha ganado!");
                }
            }
        } else{
            System.out.println("\n¡Gana la banca!");
        }
    }

    private void juegaBanca() {

        while (!banca.pasado() && !banca.ganasATodos(jugadores)) {
            banca.cogerCarta(baraja.quitarPrimera());
            System.out.println(banca);

            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
        }
    }

    private void jueganJugadores() {
        boolean quiereCarta;

        for (Jugador jugador : jugadores){

            quiereCarta=true;

            System.out.println("Empieza a jugar " + jugador.getNombre());

            do {
                jugador.cogerCarta(baraja.quitarPrimera());
                System.out.println(jugador);

                if (!jugador.pasado())
                    quiereCarta=solicitarQuiereCarta(jugador);

            } while (quiereCarta && !jugador.pasado());
            if (jugador.pasado()){
                System.out.println("¡Te has pasado!");
            }
        }
    }

    private boolean solicitarQuiereCarta(Jugador jugador) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Quieres carta " + jugador.getNombre() + "? [ s | n ]");
        return sc.nextLine().toLowerCase().charAt(0)=='s';
    }
}

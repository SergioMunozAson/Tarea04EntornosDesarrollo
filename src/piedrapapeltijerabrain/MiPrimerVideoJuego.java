/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package piedrapapeltijerabrain;

import java.util.Scanner;

/**
 * Clase que ejecuta el programa
 * @author Sergio Muñoz
 */
public class MiPrimerVideoJuego {
/**
 * Metodo define un juego sencillo de piedra papel o tijera en el que jugamos contra la máquina.
 * Está formado por 5 rondas, las cuales en cada una de ellas aleatoriamente nos pedirá, tras la 
 * elección también aleatoria del programa, que intentemos ganar o intentemos perder.
 * También lleva consigo un temporizador que en el momento que se comienza a jugar nos medirá el 
 * tiempo hasta el final de las 5 rondas. Mediante puntos si no hacemos lo que nos pide
 * nos penalizará sumandonos segundos a nuestro tiempo total. Si sacamos la misma jugada que la
 * máquina nos dará un mensaje que dirá: No tiene sentido que intentes empatar". Al finalizar
 * nos hará un resumen de la partida.
 * 
 * @param args Argumentos del programa
 */
    public static void main(String[] args) {

        int chiquipuntos = 0;
        Scanner sc = new Scanner(System.in);
        String opcionJugador = "";
        String opcionBot = "";
        int exitoEnProposito = 1;

        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            int proposito = (int) Math.floor(Math.random() * 2 + 1);
            if (proposito == 1) {
                System.out.println("\n\tIntenta ganar");
            }
            if (proposito == 2) {
                System.out.println("\n\tIntenta perder");
            }
            int j = (int) Math.floor(Math.random() * 3 + 1);
            if (j == 1) {
                opcionBot = "tijera";
                System.out.println(opcionBot);
                tijera();
            }

            if (j == 2) {
                opcionBot = "papel";
                System.out.println(opcionBot);
                papel();
            }
            if (j == 3) {
                opcionBot = "piedra";
                System.out.println(opcionBot);
                piedra();
            }
            do {
                System.out.println("Introduce tu jugada");
                opcionJugador = sc.nextLine();
                if (opcionBot.equals(opcionJugador)) {
                    System.out.println("No tiene sentido que intentes empatar");
                }
            } while (opcionBot == opcionJugador);
            if (opcionJugador.equals("tijera") && (opcionBot.equals("papel"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("tijera") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("tijera"))) {
                exitoEnProposito = 1;
            }
            if (opcionJugador.equals("piedra") && (opcionBot.equals("papel"))) {
                exitoEnProposito = -1;
            }
            if (opcionJugador.equals("papel") && (opcionBot.equals("piedra"))) {
                exitoEnProposito = 1;
            }
            if (proposito == 2) {
                exitoEnProposito *= -1;
            }
            if (exitoEnProposito == 1) {
                chiquipuntos++;
            }
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio) / 1000);
        System.out.println("Has realizado el ejercicio en " + tiempo + " segundos");
        int nFallos = 5 - chiquipuntos;
        System.out.println("Penalización: " + nFallos + " x 5s = " + nFallos * 5);
        double tiempoFinal = tiempo + nFallos * 5;
        System.out.println("Tu tiempo final es de " + tiempoFinal + " segundos");
    }
/**
 * Método usado para imprimir por pantalla el Asciart de la tijera
 */
    public static void tijera(){
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " __________)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");

    }
/**
 * Método usado para imprimir por pantalla el Asciart del papel
 */
    public static void papel() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)____\n"
                + " ______)\n"
                + " _______)\n"
                + " _______)\n"
                + "---.__________)");
    }
/**
 * Método usado para imprimir por pantalla el Asciart de la piedra
 */
    public static void piedra() {
        System.out.println("'''\n"
                + " _______\n"
                + "---' ____)\n"
                + " (_____)\n"
                + " (_____)\n"
                + " (____)\n"
                + "---.__(___)\n"
                + "'''");
    }
}

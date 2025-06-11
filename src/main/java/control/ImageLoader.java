/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gaspa
 */
public class ImageLoader {

    private static String ruta;
    private static final ArrayList<String> listaRutasMonetariasA = new ArrayList<>();
    private static final ArrayList<String> listaRutasMonetariasB = new ArrayList<>();
    private static final ArrayList<String> listaRutasEroticasA = new ArrayList<>();
    private static final ArrayList<String> listaRutasEroticasB = new ArrayList<>();

    static {
        // Recompensas MonetariasA
            listaRutasMonetariasA.add("/Money75A.jpg");
            listaRutasMonetariasA.add("/Money50A.jpg");
            listaRutasMonetariasA.add("/Money25A.jpg");
       
        // Recompensas MonetariasB
            listaRutasMonetariasB.add("/Money75B.jpg");
            listaRutasMonetariasB.add("/Money50B.jpg");
            listaRutasMonetariasB.add("/Money25B.jpg");
        
        // Recompensas EroticasA
            listaRutasEroticasA.add("/Erotic75A.jpg");
            listaRutasEroticasA.add("/Erotic50A.jpg");
            listaRutasEroticasA.add("/Erotic25A.jpg");
        
        // Recompensas EroticasB
            listaRutasEroticasB.add("/Erotic75B.jpg");
            listaRutasEroticasB.add("/Erotic50B.jpg");
            listaRutasEroticasB.add("/Erotic25B.jpg");
        
        Collections.shuffle(listaRutasMonetariasA);
        Collections.shuffle(listaRutasMonetariasB);
        Collections.shuffle(listaRutasEroticasA);
        Collections.shuffle(listaRutasEroticasB);
    }

    public static String getRuta(int tipoRecompensa, String nombrePrueba) {
        if (nombrePrueba.equals("Monetary")) {
            if (tipoRecompensa == 0 || tipoRecompensa == 1 || tipoRecompensa == 2) {
                asignarRecompensaMonetaryA();
            }
            if (tipoRecompensa == 3 || tipoRecompensa == 4 || tipoRecompensa == 5) {
                asignarRecompensaMonetaryB();
            }
        }
        if (nombrePrueba.equals("Erotic")) {
            if (tipoRecompensa == 0 || tipoRecompensa == 1 || tipoRecompensa == 2) {
                asignarRecompensaEroticA();
            }
            if (tipoRecompensa == 3 || tipoRecompensa == 4 || tipoRecompensa == 5) {
                asignarRecompensaEroticB();
            }
        }
        return ruta;

    }
    private static void asignarRecompensaMonetaryA() {
        if (!listaRutasMonetariasA.isEmpty()) {
            ruta = listaRutasMonetariasA.remove(0);
            System.out.println("Mostrando imagen: "+ruta);
        } else {
            ruta = null;
        }
    }
    private static void asignarRecompensaMonetaryB() {
        if (!listaRutasMonetariasB.isEmpty()) {
            ruta = listaRutasMonetariasB.remove(0);
            System.out.println("Mostrando imagen: "+ruta);
        } else {
            ruta = null;
        }
    }
    private static void asignarRecompensaEroticA() {
        if (!listaRutasEroticasA.isEmpty()) {
            ruta = listaRutasEroticasA.remove(0);
            System.out.println("Mostrando imagen: "+ruta);
        } else {
            ruta = null;
        }
    }
    private static void asignarRecompensaEroticB() {
        if (!listaRutasEroticasB.isEmpty()) {
            ruta = listaRutasEroticasB.remove(0);
            System.out.println("Mostrando imagen: "+ruta);
        } else {
            ruta = null;
        }
    }

}

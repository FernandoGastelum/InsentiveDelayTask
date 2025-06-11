/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public class RecompensaManager {

    public enum TipoPrueba {
        MONETARY, EROTIC, CONTROL
    }

    public enum Recompensa {
        BUENA, NORMAL, MALA, CONTROL
    }

    private static final int MAX_POR_TIPO = 8;
    private static final int MAX_CONTROL = 9;
    private static final int TOTAL_RECOMPENSAS = 24;
    private static final Random random = new Random();

    private final List<Recompensa> recompensasMonetary = new ArrayList<>();
    private final List<Recompensa> recompensasErotic = new ArrayList<>();
    private int controlCount = 0;

    private final Map<Recompensa, Integer> contadorMonetary = new EnumMap<>(Recompensa.class);
    private final Map<Recompensa, Integer> contadorErotic = new EnumMap<>(Recompensa.class);

    public RecompensaManager() {
        contadorMonetary.put(Recompensa.BUENA, 0);
        contadorMonetary.put(Recompensa.NORMAL, 0);
        contadorMonetary.put(Recompensa.MALA, 0);

        contadorErotic.put(Recompensa.BUENA, 0);
        contadorErotic.put(Recompensa.NORMAL, 0);
        contadorErotic.put(Recompensa.MALA, 0);

        generarRecompensas(TipoPrueba.MONETARY, recompensasMonetary, contadorMonetary);
        generarRecompensas(TipoPrueba.EROTIC, recompensasErotic, contadorErotic);
    }

    private void generarRecompensas(TipoPrueba tipo, List<Recompensa> lista, Map<Recompensa, Integer> contador) {
        while (lista.size() < TOTAL_RECOMPENSAS) {
            double prob = random.nextDouble();
            Recompensa seleccionada;

            if (prob < 0.25) {
                seleccionada = Recompensa.MALA;
            } else if (prob < 0.75) {
                seleccionada = Recompensa.NORMAL;
            } else {
                seleccionada = Recompensa.BUENA;
            }

            if (contador.get(seleccionada) < MAX_POR_TIPO) {
                lista.add(seleccionada);
                contador.put(seleccionada, contador.get(seleccionada) + 1);
            }
        }
    }

    public Recompensa obtenerRecompensa(TipoPrueba tipo) {
        switch (tipo) {
            case MONETARY:
                return !recompensasMonetary.isEmpty() ? recompensasMonetary.remove(0) : null;
            case EROTIC:
                return !recompensasErotic.isEmpty() ? recompensasErotic.remove(0) : null;
            case CONTROL:
                if (controlCount < MAX_CONTROL) {
                    controlCount++;
                    return Recompensa.CONTROL;
                } else {
                    return null; 
                }
            default:
                return null;
        }
    }
}

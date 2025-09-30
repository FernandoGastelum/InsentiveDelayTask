
package control;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public class ImageLoader {

    private static Integer valor;
    private static String ruta;
    private static final ArrayList<String> listaRutasMonetariasA = new ArrayList<>();
    private static final ArrayList<Integer> listaRutasMonetariasValorA = new ArrayList<>();
    private static final ArrayList<String> listaRutasMonetariasB = new ArrayList<>();
    private static final ArrayList<Integer> listaRutasMonetariasValorB = new ArrayList<>();
    private static final ArrayList<String> listaRutasEroticasA = new ArrayList<>();
    private static final ArrayList<String> listaRutasEroticasB = new ArrayList<>();
    
    private static final ArrayList<Integer> valoresUsados = new ArrayList<>();
    
    //el formato del nombre no importa, yo lo hice asi porque pense que el programa funcionaba de otra forma
    static {
        /**
         * Se cambio el enfoque a una lista con una imagen, se dejo lista por si
         * se necesita ampliar a futuro
         */
        // Recompensas MonetariasA
            listaRutasMonetariasA.add("/MoneyRewardImg.jpg");
        // Recompensas MonetariasB
//            listaRutasMonetariasB.add("/MoneyRewardImg.png");
            
        // Valor de Recompensas MonetariasA
        for (int i = 0; i <= 12; i++) {
            Random random = new Random();
            int numero = random.nextInt(5,20);
            listaRutasMonetariasValorA.add(numero);
        }
        // Valor de Recompensas MonetariasB
        for (int i = 0; i <= 12; i++) {
            Random random = new Random();
            int numero = random.nextInt(30,50);
            listaRutasMonetariasValorB.add(numero);
        }    
            
        
        /**
         * El numero de imagenes cargadas en las dos listas no necesita ser igual
         * para que el programa funcione correctamente, solamente necesita ser
         * mayor, o igual al numero de pruebas que se van a ejecutar. Por ejemlo
         * si se quieren ejecutar 8 pruebas eroticas debe de haber minimo 4 imagenes
         * de tipo A y 4 imagenes de tipo B, si en este caso se agregaran mas imagenes
         * el programa se ejecutaria de manera normal, simplemente algunas imagenes
         * no alcanzarian a mostrarse.
         */    
        // Recompensas EroticasA
            listaRutasEroticasA.add("/EroticA1.jpg");
            listaRutasEroticasA.add("/EroticA2.jpg");
            listaRutasEroticasA.add("/EroticA4.jpg");
            listaRutasEroticasA.add("/EroticA5.jpg");
            listaRutasEroticasA.add("/EroticA6.jpg");
            listaRutasEroticasA.add("/EroticA7.jpg");
            listaRutasEroticasA.add("/EroticA8.jpg");
            listaRutasEroticasA.add("/EroticA9.jpg");
            listaRutasEroticasA.add("/EroticA10.jpg");
            listaRutasEroticasA.add("/EroticA11.jpg");
            listaRutasEroticasA.add("/EroticA12.jpg");
            listaRutasEroticasA.add("/EroticA3.jpg");
        
        // Recompensas EroticasB
            listaRutasEroticasB.add("/EroticB1.jpg");
            listaRutasEroticasB.add("/EroticB2.jpg");
            listaRutasEroticasB.add("/EroticB3.jpg");
            listaRutasEroticasB.add("/EroticB4.jpg");
            listaRutasEroticasB.add("/EroticB5.jpg");
            listaRutasEroticasB.add("/EroticB6.jpg");
            listaRutasEroticasB.add("/EroticB7.jpg");
            listaRutasEroticasB.add("/EroticB8.jpg");
            listaRutasEroticasB.add("/EroticB9.jpg");
            listaRutasEroticasB.add("/EroticB10.jpg");
            listaRutasEroticasB.add("/EroticB11.jpg");
            listaRutasEroticasB.add("/EroticB12.jpg");
            
        Collections.shuffle(listaRutasMonetariasA);
        Collections.shuffle(listaRutasEroticasA);
        Collections.shuffle(listaRutasEroticasB);
    }
    
    public static String getRuta(int tipoRecompensa, String nombrePrueba) {
        if (nombrePrueba.equals("Monetary")) {
            if (tipoRecompensa >= 0 && tipoRecompensa <= 2) {
                asignarRecompensaMonetaria(listaRutasMonetariasA, listaRutasMonetariasValorA);
            } else if (tipoRecompensa >= 3 && tipoRecompensa <= 5) {
                asignarRecompensaMonetaria(listaRutasMonetariasA, listaRutasMonetariasValorB);
            }
        } else if (nombrePrueba.equals("Erotic")) {
            if (tipoRecompensa >= 0 && tipoRecompensa <= 2) {
                asignarRecompensa(listaRutasEroticasA);
            } else if (tipoRecompensa >= 3 && tipoRecompensa <= 5) {
                asignarRecompensa(listaRutasEroticasB);
            }
        }
        return ruta;
    }

    private static void asignarRecompensa(ArrayList<String> listaRutas) {
        if (!listaRutas.isEmpty()) {
            ruta = listaRutas.remove(0);
            System.out.println("Mostrando imagen: " + ruta);
        } else {
            ruta = null;
        }
    }
    
    private static void asignarRecompensaMonetaria(ArrayList<String> listaRutas, ArrayList<Integer> listaValores) {
        if (!listaRutas.isEmpty() && !listaValores.isEmpty()) {
//            ruta = listaRutas.remove(0);
            ruta = listaRutas.get(0);
            valor = listaValores.remove(0);
            valoresUsados.add(valor);
            System.out.println("Mostrando imagen: " + ruta + " con valor $" + valor);
        } else {
            ruta = null;
        }
    }
    public static int getValorActual(){
        return valor;
    }
    public static int obtenerValorTotalUsado() {
        return valoresUsados.stream().mapToInt(Integer::intValue).sum();
    }
    

}


package control;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public class ImageLoader {

    private static Double valor;
    private static String ruta;
    private static final ArrayList<String> listaRutasMonetariasA = new ArrayList<>();
    private static final ArrayList<Double> listaRutasMonetariasValorA = new ArrayList<>();
    private static final ArrayList<String> listaRutasMonetariasB = new ArrayList<>();
    private static final ArrayList<Double> listaRutasMonetariasValorB = new ArrayList<>();
    private static final ArrayList<String> listaRutasEroticasA = new ArrayList<>();
    private static final ArrayList<String> listaRutasEroticasB = new ArrayList<>();
    
    private static final ArrayList<Double> valoresUsados = new ArrayList<>();
    
    //el formato del nombre no importa, yo lo hice asi porque pense que el programa funcionaba de otra forma
    static {
        /**
         * Se cambio el enfoque a una lista con una imagen, se dejo lista por si
         * se necesita ampliar a futuro
         */
        // Recompensas MonetariasA
            listaRutasMonetariasA.add("/MoneyRewardImg.jpg");
        // Recompensas MonetariasB
//            listaRutasMonetariasB.add("/MoneyRewardImg.jpg");
            
        // Valor de Recompensas MonetariasA
            listaRutasMonetariasValorA.add(5.0);
            listaRutasMonetariasValorA.add(10.0);
            listaRutasMonetariasValorA.add(20.0);
       
        // Valor de Recompensas MonetariasB
            listaRutasMonetariasValorB.add(30.0);
            listaRutasMonetariasValorB.add(35.0);
            listaRutasMonetariasValorB.add(50.0);
        
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
            listaRutasEroticasA.add("/Erotic75A.jpg");
            listaRutasEroticasA.add("/Erotic50A.jpg");
            listaRutasEroticasA.add("/Erotic25A.jpg");
        
        // Recompensas EroticasB
            listaRutasEroticasB.add("/Erotic75B.jpg");
            listaRutasEroticasB.add("/Erotic50B.jpg");
            listaRutasEroticasB.add("/Erotic25B.jpg");
            listaRutasEroticasB.add("/eroticTest.jpeg");
        
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
    
    private static void asignarRecompensaMonetaria(ArrayList<String> listaRutas, ArrayList<Double> listaValores) {
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
    public static double getValorActual(){
        return valor;
    }
    public static double obtenerValorTotalUsado() {
        return valoresUsados.stream().mapToDouble(Double::doubleValue).sum();
    }
    

}

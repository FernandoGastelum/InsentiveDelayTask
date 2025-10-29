
package control;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    private static ArrayList<String> listaRutasEroticasHeteroHombreA = new ArrayList<>();
    private static ArrayList<String> listaRutasEroticasHeteroHombreB = new ArrayList<>();
    private static ArrayList<String> listaRutasEroticasHeteroMujerA = new ArrayList<>();
    private static ArrayList<String> listaRutasEroticasHeteroMujerB = new ArrayList<>();
    private static ArrayList<String> listaRutasEroticasGayA = new ArrayList<>();
    private static ArrayList<String> listaRutasEroticasGayB = new ArrayList<>();
    private static ArrayList<String> listaRutasEroticasLesbicoA = new ArrayList<>();
    private static ArrayList<String> listaRutasEroticasLesbicoB = new ArrayList<>();
    
    
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
        // Recompensas Eroticas Hombre Hetero A
        String rutaHeteroHombreA = "/HeteroHombre/A/";
        // Recompensas Eroticas Hombre Hetero B
        String rutaHeteroHombreB = "/HeteroHombre/B/";
        // Recompensas Eroticas Mujer Hetero A
        String rutaHeteroMujerA = "/HeteroMujer/A/";
        // Recompensas Eroticas Mujer Hetero B
        String rutaHeteroMujerB = "/HeteroMujer/B/";    
        //recompensas Eroticas Gay A
        String rutaGayA = "/Gay/A/";        
        //recompensas Eroticas Gay B
        String rutaGayB = "/Gay/B/";    
        //recompensas Eroticas Lesbiana A
        String rutaLesbianaA = "/Lesbiana/A/";    
        //recompensas Eroticas Lesbiana B
        String rutaLesbianaB = "/Lesbiana/B/";        
        try {
            listaRutasEroticasHeteroHombreA = cargarRutasDesdeIndice(rutaHeteroHombreA);
            listaRutasEroticasHeteroHombreB = cargarRutasDesdeIndice(rutaHeteroHombreB);
            listaRutasEroticasHeteroMujerA = cargarRutasDesdeIndice(rutaHeteroMujerA);
            listaRutasEroticasHeteroMujerB = cargarRutasDesdeIndice(rutaHeteroMujerB);
            listaRutasEroticasGayA = cargarRutasDesdeIndice(rutaGayA);
            listaRutasEroticasGayB = cargarRutasDesdeIndice(rutaGayB);
            listaRutasEroticasLesbicoA = cargarRutasDesdeIndice(rutaLesbianaA);
            listaRutasEroticasLesbicoB = cargarRutasDesdeIndice(rutaLesbianaB);
            
        } catch (IOException ex) {
            System.out.println("Error "+ex.getMessage());
        }
        Collections.shuffle(listaRutasMonetariasA);
        Collections.shuffle(listaRutasEroticasHeteroHombreA);
        Collections.shuffle(listaRutasEroticasHeteroHombreB);
        Collections.shuffle(listaRutasEroticasHeteroMujerA);
        Collections.shuffle(listaRutasEroticasHeteroMujerB);
        Collections.shuffle(listaRutasEroticasGayA);
        Collections.shuffle(listaRutasEroticasGayB);
        Collections.shuffle(listaRutasEroticasLesbicoA);
        Collections.shuffle(listaRutasEroticasLesbicoB);
    }
    /**
    * Carga una lista de rutas de recursos leyendo un archivo 'index.txt'
    * desde una carpeta base de recursos.
    *
    * @param rutaBase La ruta del paquete/carpeta que contiene el index.txt 
    * @return Una Lista de Strings con las rutas completas a los recursos.
     * @throws java.io.IOException
    */
    public static ArrayList<String> cargarRutasDesdeIndice(String rutaBase) throws IOException {
        ArrayList<String> listaRutas = new ArrayList<>();
        String archivoIndice = rutaBase + "index.txt";
        try {
            InputStream is = ImageLoader.class.getResourceAsStream(archivoIndice);
            if (is == null) {
                System.err.println("Error: No se pudo encontrar el archivo índice: " + archivoIndice);
                return listaRutas; 
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(is)); 
            String nombreArchivo;
            // Lee cada línea del index.txt
            while ((nombreArchivo = reader.readLine()) != null) {
                
                // Nos aseguramos de que no sean líneas vacías
                if (!nombreArchivo.trim().isEmpty()) {
                    // Añade la ruta completa (carpeta + nombre de archivo) a la lista
                    listaRutas.add(rutaBase + nombreArchivo.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo índice: " + archivoIndice);
        }
        return listaRutas;
    }
    
    public static String getRuta(int tipoRecompensa, String nombrePrueba, int version) {
        
        if (nombrePrueba.equals("Monetary")) {
            if (tipoRecompensa >= 0 && tipoRecompensa <= 2) {
                asignarRecompensaMonetaria(listaRutasMonetariasA, listaRutasMonetariasValorA);
            } else if (tipoRecompensa >= 3 && tipoRecompensa <= 5) {
                asignarRecompensaMonetaria(listaRutasMonetariasA, listaRutasMonetariasValorB);
            }
            //0 = HOMBRE HETERO
            //1 = GAY
            //2 = MUJER HETERO
            //3 = LESBICO
        } else if (nombrePrueba.equals("Erotic")&&version == 0) {
            if (tipoRecompensa >= 0 && tipoRecompensa <= 2) {
                asignarRecompensa(listaRutasEroticasHeteroHombreA);
            } else if (tipoRecompensa >= 3 && tipoRecompensa <= 5) {
                asignarRecompensa(listaRutasEroticasHeteroHombreB);
            }
        } else if(nombrePrueba.equals("Erotic")&&version == 1){
            if (tipoRecompensa >= 0 && tipoRecompensa <= 2) {
                asignarRecompensa(listaRutasEroticasGayA);
            } else if (tipoRecompensa >= 3 && tipoRecompensa <= 5) {
                asignarRecompensa(listaRutasEroticasGayB);
            }
        }else if(nombrePrueba.equals("Erotic")&&version == 2){
            if (tipoRecompensa >= 0 && tipoRecompensa <= 2) {
                asignarRecompensa(listaRutasEroticasHeteroMujerA );
            } else if (tipoRecompensa >= 3 && tipoRecompensa <= 5) {
                asignarRecompensa(listaRutasEroticasHeteroMujerB);
            }
        }else if(nombrePrueba.equals("Erotic")&&version == 3){
            if (tipoRecompensa >= 0 && tipoRecompensa <= 2) {
                asignarRecompensa(listaRutasEroticasLesbicoA );
            } else if (tipoRecompensa >= 3 && tipoRecompensa <= 5) {
                asignarRecompensa(listaRutasEroticasLesbicoB);
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

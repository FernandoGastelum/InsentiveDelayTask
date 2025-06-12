/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package PanelesPrincipales;

import control.EstadisticasExcel;
import control.Navegacion;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author gaspa
 */
public class InsentiveDelayTask {

    public static void main(String[] args) {
        MainScreen main = MainScreen.getInstance();
        main.setVisible(true);
        Navegacion nevegacion = Navegacion.getInstance();
        nevegacion.mostrarIniciarPanel();
        // Guarda estadísticas al cerrar el programa
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                // Se guarda en la carpeta de documentos
                String userHome = System.getProperty("user.home");
                String documentosPath = userHome + File.separator + "Documents";

                // archivo con fecha y hora
                String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
                String nombreArchivo = documentosPath + File.separator + "estadisticas_" + timestamp + ".xlsx";

                EstadisticasExcel.getInstance().exportarAExcel(nombreArchivo);

                System.out.println("Estadísticas guardadas en: " + nombreArchivo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }));
    }
}

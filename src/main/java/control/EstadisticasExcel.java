/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import PanelesPrincipales.CuePanel;
import PanelesPrincipales.DiscriminationTaskPanel;
import PanelesPrincipales.RewardPanel;
import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public class EstadisticasExcel {

    public static EstadisticasExcel instancia;
    private List<String> listaPruebas;
    private List<Double> listaDelayPantallaBlanca;
    private List<String> listaRecompensa;
    private List<Double> listaProbabilidad;
    private List<Long> listaTiempoRespuesta;
    private List<Boolean> listaExitoPrueba;
    private List<Boolean> listaPruebaMostrada;
    private List<Integer> listaCalificacion;

    public EstadisticasExcel() {
        listaPruebas = new ArrayList<>();
        listaDelayPantallaBlanca = new ArrayList<>();
        listaRecompensa = new ArrayList<>();
        listaTiempoRespuesta = new ArrayList<>();
        listaExitoPrueba = new ArrayList<>();
        listaCalificacion = new ArrayList<>();
        listaProbabilidad = new ArrayList<>();
        listaPruebaMostrada = new ArrayList<>();
    }

    public void exportarAExcel(String nombreArchivo) {
        Workbook workbook = new XSSFWorkbook();
        Sheet hoja = workbook.createSheet("Estadísticas");

        // Crear encabezados
        Row encabezado = hoja.createRow(0);
        encabezado.createCell(0).setCellValue("Nombre Prueba");
        encabezado.createCell(1).setCellValue("Delay Pantalla Blanca (Seg)");
        encabezado.createCell(2).setCellValue("Tamaño Recompensa");
        encabezado.createCell(3).setCellValue("Probabilidad");
        encabezado.createCell(4).setCellValue("Tiempo de Respuesta (MS)");
        encabezado.createCell(5).setCellValue("Éxito en Prueba");
        encabezado.createCell(6).setCellValue("Éxito en Probabilidad de Recompensa");
        encabezado.createCell(7).setCellValue("Calificación");

        int total = listaPruebas.size(); 

        for (int i = 0; i < total; i++) {
            Row fila = hoja.createRow(i + 1);

            fila.createCell(0).setCellValue(listaPruebas.get(i));
            fila.createCell(1).setCellValue(listaDelayPantallaBlanca.get(i));
            fila.createCell(2).setCellValue(listaRecompensa.get(i));
            fila.createCell(3).setCellValue(listaProbabilidad.get(i));
            fila.createCell(4).setCellValue(listaTiempoRespuesta.get(i));
            fila.createCell(5).setCellValue(listaExitoPrueba.get(i) ? "Sí" : "No");
            fila.createCell(6).setCellValue(listaPruebaMostrada.get(i) ? "Sí" : "No");
            fila.createCell(7).setCellValue(listaCalificacion.get(i));
        }

        // Ajustar tamaño de columnas
        for (int i = 0; i <= 7; i++) {
            hoja.autoSizeColumn(i);
        }

        // Guardar el archivo
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo)) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Archivo Excel creado exitosamente: " + nombreArchivo);
        } catch (IOException e) {
        }
    }
    

    public static EstadisticasExcel getInstance() {
        if (instancia == null) {
            instancia = new EstadisticasExcel();
        }
        return instancia;
    }

    public void agregarPrueba(String prueba) {
        listaPruebas.add(prueba);
    }

    public void agregarDelayPantallaBlanca(Double delay) {
        listaDelayPantallaBlanca.add(delay);
    }

    public void agregarRecompensa(int recompensa) {

        if (recompensa <= 2 && recompensa >= 0) {
            listaRecompensa.add("Grande");
        }
        if (recompensa > 2 && recompensa <= 5) {
            listaRecompensa.add("Pequeña");
        }
        if (recompensa < 0 && recompensa > 5) {
            listaRecompensa.add("N/A");
        }
    }

    public void agregarProbabilidad(int recompensa) {
        if (recompensa == 0 || recompensa == 3) {
            listaProbabilidad.add(0.75);
        }
        if (recompensa == 1 || recompensa == 4) {
            listaProbabilidad.add(0.5);
        }
        if (recompensa == 2 || recompensa == 5) {
            listaProbabilidad.add(0.25);
        }
    }
    public void agregarPruebaMostrada(boolean exito){
        listaPruebaMostrada.add(exito);
    }

    public void agregarTiempoRespuesta(Long tiempo) {
        listaTiempoRespuesta.add(tiempo);
    }

    public void agregarExitoPrueba(Boolean exito) {
        listaExitoPrueba.add(exito);
    }

    public void agregarCalificacion(Integer calificacion) {
        listaCalificacion.add(calificacion);
    }
    public void cargarDatos(){
        EstadisticasExcel.getInstance().agregarPrueba(CuePanel.getInstance().getPrueba());
        EstadisticasExcel.getInstance().agregarDelayPantallaBlanca(CuePanel.getInstance().getDelay());
        EstadisticasExcel.getInstance().agregarRecompensa(CuePanel.getInstance().getRecompensa());
        EstadisticasExcel.getInstance().agregarProbabilidad(CuePanel.getInstance().getRecompensa());
        EstadisticasExcel.getInstance().agregarTiempoRespuesta(DiscriminationTaskPanel.getInstance().getTiempoRespuesta());
        EstadisticasExcel.getInstance().agregarExitoPrueba(DiscriminationTaskPanel.getInstance().getExito());
        EstadisticasExcel.getInstance().agregarPruebaMostrada(RewardPanel.getInstance().getExitoProbabilidad());
    }

}

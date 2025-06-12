/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelesPrincipales;

import control.EstadisticasExcel;
import control.ImageLoader;
import control.Navegacion;
import control.Temporizador;
import java.awt.GridBagLayout;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author gaspa
 */
public class RewardPanel extends javax.swing.JPanel {

    private JLabel imagenRecompensa;
    private ImageIcon icono;
    private CuePanel cuePanel;
    private boolean exito;

    public static RewardPanel instancia;

    /**
     * Creates new form rewardPanel
     */
    public RewardPanel() {
        initComponents();
        this.setLayout(new GridBagLayout());
        setearFiguraCentral();
    }

    public void metodosFlujoPrograma() {

        cargarIcono();
    }

    public static RewardPanel getInstance() {
        if (instancia == null) {
            instancia = new RewardPanel();
        }
        return instancia;
    }

    public final void setearFiguraCentral() {
        System.out.println("Seteando imagen de recompensa...");
        imagenRecompensa = new JLabel();
        this.add(imagenRecompensa);
    }

    public void cargarIcono() {
        exito = false;
        this.cargarRuta("/Static.gif");
        if (DiscriminationTaskPanel.getInstance().getExito()) {
            System.out.println("La prueba fue superada con exito");
            System.out.println("Cargando recompensa...");
            cuePanel = CuePanel.getInstance();
            int tipoRecompensa = cuePanel.getRecompensa();
            System.out.println("Prueba: " + cuePanel.getPrueba());
            if (cuePanel.getPrueba().equals("Monetary")) {
                switch (tipoRecompensa) {
                    case 0 -> {
                        System.out.println("La prueba es del 75%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.75)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 1 -> {
                        System.out.println("La prueba es del 50%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.5)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 2 -> {
                        System.out.println("La prueba es del 25%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.25)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 3 -> {
                        System.out.println("La prueba es del 75%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.75)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 4 -> {
                        System.out.println("La prueba es del 50%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.5)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 5 -> {
                        System.out.println("La prueba es del 25%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.25)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                }
            }
            if (cuePanel.getPrueba().equals("Erotic")) {
                switch (tipoRecompensa) {
                    case 0 -> {
                        System.out.println("La prueba es del 75%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.75)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 1 -> {
                        System.out.println("La prueba es del 50%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.5)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 2 -> {
                        System.out.println("La prueba es del 25%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.25)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 3 -> {
                        System.out.println("La prueba es del 75%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.75)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 4 -> {
                        System.out.println("La prueba es del 50%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.5)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 5 -> {
                        System.out.println("La prueba es del 25%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.25)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                }
            }
            if (cuePanel.getPrueba().equals("Control")) {
                System.out.println("La prueba es de tipo control, se mostrara pantalla en blanco");
                siguientePantallaFallido();
            }

        } else {
            System.out.println("La prueba no fue exitosa, se mostrara la pantalla en blanco");
            this.siguientePantallaFallido();
        }
        System.out.println("Guardando datos...");
        guardarDatos(exito);

    }

    private boolean calcularProbabilidad(double porcentaje) {
        Random random = new Random();
        double probabilidad = random.nextDouble();

        if (probabilidad <= porcentaje) {
            System.out.println("Exito en probabilidad, se mostrara una imagen como recompensa");
            return exito = true;
        } else {
            System.out.println("Fallo en probabilidad, se mostrara una imagen de estatica");
            return exito = false;
        }
    }

    private void siguientePantallaExito() {
        Temporizador.temporizador(2500, () -> {
            Navegacion.getInstance().mostrarRatePanel();
        });
    }

    private void siguientePantallaFallido() {
        Navegacion.getInstance().LimpiarPantalla();
        Temporizador.temporizador(2500, () -> {
            if (CuePanel.getInstance().comprobarPruebas()) {
                Navegacion.getInstance().mostrarPanelResultados();
            } else {
                Navegacion.getInstance().mostrarCuePanel();
            }
        });
    }

    private void guardarDatos(boolean exito) {
        if (!exito) {
            EstadisticasExcel.getInstance().cargarDatos();
            EstadisticasExcel.getInstance().agregarCalificacion(-1);
        } 
    }


    private void cargarRuta(String ruta) {
        if (ruta != null) {
            icono = new ImageIcon(getClass().getResource(ruta));
            imagenRecompensa.setIcon(icono);
        } else {
        }
    }
    public boolean getExitoProbabilidad(){
        return exito;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

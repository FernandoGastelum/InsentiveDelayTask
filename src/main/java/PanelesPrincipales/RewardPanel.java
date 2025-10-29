/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelesPrincipales;

import control.EstadisticasExcel;
import control.ImageLoader;
import control.Navegacion;
import control.Temporizador;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public class RewardPanel extends javax.swing.JPanel {

    private JLabel imagenRecompensa;
    private JLabel dinerillo;
    private ImageIcon icono;
    private CuePanel cuePanel;
    private boolean exito;

    public static RewardPanel instancia;

    /**
     * Creates new form rewardPanel
     */
    public RewardPanel() {
        initComponents();
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

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new java.awt.Dimension(1920, 1080));
        this.setLayout(new java.awt.BorderLayout());
        this.add(layeredPane, java.awt.BorderLayout.CENTER);

        imagenRecompensa = new JLabel();
        imagenRecompensa.setBounds(0, 0, 1920, 1080);
        imagenRecompensa.setHorizontalAlignment(JLabel.CENTER);
        imagenRecompensa.setVerticalAlignment(JLabel.CENTER);

        dinerillo = new JLabel();
        dinerillo.setFont(new java.awt.Font("Segoe UI", 0, 40));
        dinerillo.setForeground(new java.awt.Color(255, 255, 0));
        dinerillo.setBounds(860, 500, 200, 50); // Centrado aproximado
        dinerillo.setHorizontalAlignment(JLabel.CENTER);
        dinerillo.setVerticalAlignment(JLabel.CENTER);

        layeredPane.add(imagenRecompensa, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(dinerillo, JLayeredPane.PALETTE_LAYER); // Encima
    }

    public void cargarIcono() {
        exito = false;
        this.cargarRutaControl("/Static.gif");
        this.dinerillo.setText("");
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
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            establecerDinerillo();
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 1 -> {
                        System.out.println("La prueba es del 50%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.5)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            establecerDinerillo();
                            this.siguientePantallaExito();
                            
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 2 -> {
                        System.out.println("La prueba es del 25%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.25)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            establecerDinerillo();
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 3 -> {
                        System.out.println("La prueba es del 75%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.75)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            establecerDinerillo();
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 4 -> {
                        System.out.println("La prueba es del 50%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.5)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            establecerDinerillo();
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 5 -> {
                        System.out.println("La prueba es del 25%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.25)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            establecerDinerillo();
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
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 1 -> {
                        System.out.println("La prueba es del 50%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.5)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 2 -> {
                        System.out.println("La prueba es del 25%A, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.25)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 3 -> {
                        System.out.println("La prueba es del 75%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.75)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 4 -> {
                        System.out.println("La prueba es del 50%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.5)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
                            this.siguientePantallaExito();
                        } else {
                            this.siguientePantallaFallido();
                        }
                    }
                    case 5 -> {
                        System.out.println("La prueba es del 25%B, calculando probabilidad de recompensa...");
                        if (calcularProbabilidad(0.25)) {
                            this.cargarRuta(ImageLoader.getRuta(tipoRecompensa, cuePanel.getPrueba(),Navegacion.getInstance().getVersion()));
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
        if(!Navegacion.getInstance().isTest()){
            guardarDatos(exito);
        }

    }

    private boolean calcularProbabilidad(double porcentaje) {
        Random random = new Random();
        double probabilidad = random.nextDouble();

        if (probabilidad <= porcentaje) {
            System.out.println("Exito en probabilidad, se mostrara una imagen como recompensa");
            return exito = true;
        } else {
            System.out.println("Fallo en probabilidad, se mostrara una imagen de estatica");     
            //HARCODEAR A EXITO = TRUE PARA TESTEAR, DEBE DE SER EXITO = FALSE
            return exito = false;
        }
    }

    private void siguientePantallaExito() {
        Temporizador.temporizador(2500, () -> {
            Navegacion.getInstance().mostrarRatePanel();
        });
    }
    private void establecerDinerillo(){
        System.out.println("Valor actual: "+ImageLoader.getValorActual());
        this.dinerillo.setText("$"+ImageLoader.getValorActual());
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


    private void cargarRutaControl(String ruta) {
        if (ruta != null) {
            icono = new ImageIcon(getClass().getResource(ruta));
            imagenRecompensa.setIcon(icono);
        } else {
        }
    }
    private void cargarRuta(String ruta) {
        if (ruta != null) {
            try {
                // Cargar la imagen original
                Image original = new ImageIcon(getClass().getResource(ruta)).getImage();

                // Alto disponible (el del JLabel o de la ventana)
                int altoDisponible = imagenRecompensa.getHeight(); 
                if (altoDisponible <= 0) {
                    altoDisponible = this.getHeight(); // respaldo: usa el JFrame si el JLabel aún no está dibujado
                }

                // Mantener proporción de aspecto
                double relacion = (double) original.getWidth(null) / original.getHeight(null);
                int nuevoAlto = altoDisponible;
                int nuevoAncho = (int) (nuevoAlto * relacion);

                // Escalar
                Image escalada = original.getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH);

                // Asignar al JLabel
                icono = new ImageIcon(escalada);
                imagenRecompensa.setIcon(icono);

            } catch (Exception e) {
                e.printStackTrace();
            }
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

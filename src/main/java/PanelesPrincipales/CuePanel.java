package PanelesPrincipales;

import control.Navegacion;
import control.Temporizador;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public final class CuePanel extends javax.swing.JPanel {

    public static CuePanel instancia;
    private JLabel imagenCirculo;
    private ImageIcon icono;
    private int contadorControl = 0;
    private int contadorMonetary = 0;
    private int contadorErotic = 0;
    private String prueba;
    //0=75A
    //1=50A
    //2=25A
    //3=75B
    //4=50B
    //5=25B
    private int recompensa = -1;
    private double delayPantallaBlanca;

    private static final ArrayList<Integer> recompensasMonetaryDisponibles = new ArrayList<>();
    private static final ArrayList<Integer> recompensasEroticDisponibles = new ArrayList<>();
    private static final ArrayList<Integer> recompensasControl = new ArrayList<>();
    //Listas de las recompensas. El numero representa el porcentaje de obtener 
    //una imagen y la letra representa el tipo de imagen (A = small, B = Big)
    //por cada ciclo for se agrega un elemento de cada tipo. modificar la cantidad
    //de ciclos para agregar mas elementos.
    //Las listas se revuelven una vez se han llenado, osea que desde aqui se decide la aletoriedad de las listas
    static {
        // Recompensas Monetary
        for (int i = 0; i < 1; i++) {
            recompensasMonetaryDisponibles.add(0); // 75A
            recompensasMonetaryDisponibles.add(1); // 50A
            recompensasMonetaryDisponibles.add(2); // 25A
            recompensasMonetaryDisponibles.add(3); // 75B
            recompensasMonetaryDisponibles.add(4); // 50B
            recompensasMonetaryDisponibles.add(5); // 25B
        }
        Collections.shuffle(recompensasMonetaryDisponibles);
        // Recompensas Erotic
        for (int i = 0; i < 1; i++) {
            recompensasEroticDisponibles.add(0); // 75A
            recompensasEroticDisponibles.add(1); // 50A
            recompensasEroticDisponibles.add(2); // 25A
            recompensasEroticDisponibles.add(3); // 75B
            recompensasEroticDisponibles.add(4); // 50B
            recompensasEroticDisponibles.add(5); // 25B
        }
        Collections.shuffle(recompensasEroticDisponibles);

        // Recompensas Control (3 como marcador arbitrario)
        for (int i = 0; i < 3; i++) {
            recompensasControl.add(3); // única recompensa de tipo Control
        }
    }

    public static CuePanel getInstance() {
        if (instancia == null) {
            instancia = new CuePanel();
        }
        return instancia;
    }

    public CuePanel() {
        initComponents();
        this.setLayout(new GridBagLayout());
        setearCirculoCentral();
    }

    public void metodosFlujoPrograma() {
        if(!comprobarPruebas()){
            cargarIcono();
        }
    }

    public void setearCirculoCentral() {
        System.out.println("Setear circulo central");
        imagenCirculo = new JLabel();
        imagenCirculo.setPreferredSize(new Dimension(300, 300));
        imagenCirculo.setSize(new Dimension(300, 300));
        //Lineas de codigo para ajustar la imagen un poco mas hacia arriba.
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 100, 0);
        //Agrega el label al panel para que se muestre
        this.add(imagenCirculo, gbc);
    }

    /**
     * 0 = Monetary 1 = Erotic 2 = Control
     * @return true si las pruebas terminaron, false en caso contrario.
     */
    public boolean comprobarPruebas(){
        if (contadorMonetary >= 3&& contadorErotic >= 3 && contadorControl >= 3) {
            //se acabaron las pruebas
            System.out.println("TODAS LAS PRUEBAS TERMINARON");
            return true;
        } else{
            return false;
        }
    }
    public void cargarIcono() {
        Random random = new Random();
        int numero = random.nextInt(3);
        //9 de control - 24 monetary - 24 erotic
        //modificar estos valores si se necesita debugear con menos ciclos.
        if (contadorControl >= 3) {
            System.out.println("Pruebas de control maximas alcanzadas, generando nuevo numero...");
            numero = random.nextInt(2); // Solo Monetary y Erotic
        }
        if (contadorErotic >= 6 && contadorMonetary <= 6) {
            System.out.println("Pruebas eroticas maximas alcanzadas, generando nuevo numero...");
            numero = 0;
        }
        if (contadorMonetary >= 6 && contadorErotic <= 6) {
            System.out.println("Pruebas monetarias maximas alcanzadas, generando nuevo numero...");
            numero = 1;
        }
        if (contadorErotic >= 6 && contadorMonetary >= 6) {
            System.out.println("Pruebas Ero y Mone maximas, asignando control");
            numero = 2;
        }

        
            String ruta = null;
            switch (numero) {
                case 0 -> {
                    //Caso monetario
                    asignarRecompensaMonetary();
                    switch (recompensa) {
                        case 0 ->
                            ruta = "/MONEY75A.png";
                        case 1 ->
                            ruta = "/MONEY50A.png";
                        case 2 ->
                            ruta = "/MONEY25A.png";
                        case 3 ->
                            ruta = "/MONEY75B.png";
                        case 4 ->
                            ruta = "/MONEY50B.png";
                        case 5 ->
                            ruta = "/MONEY25B.png";
                        default ->
                            System.out.println("No se puede cargar la imagen, no hay recompensas disponibles " + recompensa + " " + numero);
                    }

                    contadorMonetary++;
                    prueba = "Monetary";
                    System.out.println("Prueba: " + prueba);
                    System.out.println("Pruebas monetarias realizadas: " + contadorMonetary);

                }
                case 1 -> {
                    //Caso erotico
                    asignarRecompensaErotic();
                    switch (recompensa) {
                        case 0 ->
                            ruta = "/EROTIC75A.png";
                        case 1 ->
                            ruta = "/EROTIC50A.png";
                        case 2 ->
                            ruta = "/EROTIC25A.png";
                        case 3 ->
                            ruta = "/EROTIC75B.png";
                        case 4 ->
                            ruta = "/EROTIC50B.png";
                        case 5 ->
                            ruta = "/EROTIC25B.png";
                        default ->
                            System.out.println("No se puede cargar la imagen, no hay recompensas disponibles " + recompensa + " " + numero);
                    }
                    contadorErotic++;
                    prueba = "Erotic";
                    System.out.println("Prueba: " + prueba);
                    System.out.println("Pruebas erotic realizadas: " + contadorErotic);

                }
                case 2 -> {
                    ruta = "/circulo.png";
                    contadorControl++;
                    prueba = "Control";
                    System.out.println("Prueba: " + prueba);
                    System.out.println("Pruebas de control realizadas: " + contadorControl);
                    asignarRecompensaControl();
                }
            }

            if (ruta != null) {
                icono = new ImageIcon(getClass().getResource(ruta));
                Image imagenEscalada = icono.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                imagenCirculo.setIcon(new ImageIcon(imagenEscalada));
            }
            cambiarPanel();
        

    }

    private void asignarRecompensaMonetary() {
        if (!recompensasMonetaryDisponibles.isEmpty()) {
            recompensa = recompensasMonetaryDisponibles.remove(0);
            System.out.println("Recompensa: " + recompensa);

        } else {
            recompensa = -1;
        }
    }

    private void asignarRecompensaErotic() {
        if (!recompensasEroticDisponibles.isEmpty()) {
            recompensa = recompensasEroticDisponibles.remove(0);
            System.out.println("Recompensa: " + recompensa);

        } else {
            recompensa = -1;
        }
    }

    private void asignarRecompensaControl() {
        if (!recompensasControl.isEmpty()) {
            recompensa = recompensasControl.remove(0); // siempre será 3
            System.out.println("Recompensa Control: " + recompensa);
        } else {
            recompensa = -1;
        }
    }

    public void cambiarPanel() {
        Temporizador.temporizador(2500, () -> {
            System.out.println("pasaron 2.5 segundos, mostrando panel vacio...");
            Navegacion.getInstance().LimpiarPantalla();
            Random random = new Random();
            int min = 1500;
            int max = 4500;
            int numero = random.nextInt(max - min + 1) + min;

            Temporizador.temporizador(numero, () -> {
                delayPantallaBlanca = numero / 1000;
                System.out.println("pasaron " + delayPantallaBlanca + " segundos, cambiando de panel...");
                Navegacion.getInstance().mostrarDiscriminationTaskPanel();
            });

        });
    }

    private void mostrarPanelFinal() {
        Navegacion.getInstance().mostrarPanelResultados();
    }

    public String getPrueba() {
        return this.prueba;
    }

    public Double getDelay() {
        return this.delayPantallaBlanca;
    }

    public int getRecompensa() {
        return this.recompensa;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

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

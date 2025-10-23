package PanelesPrincipales;

import control.Navegacion;
import control.Temporizador;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public final class CuePanel extends javax.swing.JPanel {

    public static CuePanel instancia;
    private JLabel imagenCirculo;
    private JLabel textoEnsayoPractica;
    private ImageIcon icono;
    private int contadorControl = 0;
    private int contadorMonetary = 0;
    private int contadorErotic = 0;
    private String prueba;
    private static final Random random = new Random();
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
    /**
     * Con estas listas se controla la cantidad de veces que aparece cada probabilidad,
     * por cada loop del ciclo for se garantiza que aparezca 1 vez una probabilidad.
     * Cuando una probabilidad aparece, se elimina de la lista, previniendo que se 
     * vuelva a mostrar.
     * por ejemplo, 8 ciclos garantiza que se muestre 8 veces cada probabilidad de una lista.
     * 
     * Solo modificar el numero de ciclos del metodo for.
     */
    static {
        // Recompensas Monetary
        for (int i = 0; i < 4; i++) {
            recompensasMonetaryDisponibles.add(0); // 75A
            recompensasMonetaryDisponibles.add(1); // 50A
            recompensasMonetaryDisponibles.add(2); // 25A
            recompensasMonetaryDisponibles.add(3); // 75B
            recompensasMonetaryDisponibles.add(4); // 50B
            recompensasMonetaryDisponibles.add(5); // 25B
        }
        Collections.shuffle(recompensasMonetaryDisponibles);
        // Recompensas Erotic
        for (int i = 0; i < 4; i++) {
            recompensasEroticDisponibles.add(0); // 75A
            recompensasEroticDisponibles.add(1); // 50A
            recompensasEroticDisponibles.add(2); // 25A
            recompensasEroticDisponibles.add(3); // 75B
            recompensasEroticDisponibles.add(4); // 50B
            recompensasEroticDisponibles.add(5); // 25B
        }
        Collections.shuffle(recompensasEroticDisponibles);

        // Recompensas Control (3 como marcador arbitrario)
        for (int i = 0; i < 9; i++) {
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
        textoEnsayoPractica = new JLabel("Ensayo de práctica");
        textoEnsayoPractica.setFont(new java.awt.Font("Segoe UI", 0, 48));

        GridBagConstraints gbcTexto = new GridBagConstraints();
        gbcTexto.gridx = 0;       // Columna 0 (centrado)
        gbcTexto.gridy = 0;       // Fila 0 (arriba)
        gbcTexto.anchor = GridBagConstraints.PAGE_START; // Anclar arriba
        // Margen superior, ajustado a 50 píxeles para separarlo del borde superior
        gbcTexto.insets = new Insets(50, 0, 1000, 0);
        
        imagenCirculo = new JLabel();    
        imagenCirculo.setPreferredSize(new Dimension(300, 300));
        imagenCirculo.setSize(new Dimension(300, 300));
        //Lineas de codigo para ajustar la imagen un poco mas hacia arriba.
        GridBagConstraints gbcCirtulo = new GridBagConstraints();
        gbcCirtulo.insets = new Insets(0, 0, 100, 0);
        //Agrega el label al panel para que se muestre
        this.add(imagenCirculo, gbcCirtulo);
        
        this.add(textoEnsayoPractica, gbcTexto);
        
    }

    /**
     * 0 = Monetary 1 = Erotic 2 = Control
     * Modificar el numero dependiendo de el numero de pruebas que se quieran realizar
     * valores default: 9 de control - 24 monetary - 24 erotic
     * @return true si las pruebas terminaron, false en caso contrario.
     */
    public boolean comprobarPruebas(){
        if (contadorMonetary >= 24&& contadorErotic >= 24 && contadorControl >= 12) {
            //se acabaron las pruebas
            System.out.println("TODAS LAS PRUEBAS TERMINARON");
            return true;
        } else{
            return false;
        }
    }
    /**
     * Aqui tambien se deben de ajustar los valores por valores iguales al metodo anterior
     */
    public void cargarIcono() {
        int numero;
        System.out.println("test?"+Navegacion.getInstance().isTest());
        System.out.println("contador?"+contadorControl);
        if(contadorControl<3){
            numero = 2;
        }else{ 
            Navegacion.getInstance().setTest(false);
            this.textoEnsayoPractica.setVisible(false);
            double probabilidad = random.nextDouble();
            if(probabilidad<=0.11){
                numero = 2;
            }else if (probabilidad <= 0.55) {
                numero = 1;
            }else{
                numero = 0;
            }
        }
        
        //9 de control - 24 monetary - 24 erotic
        //modificar estos valores si se necesita debugear con menos ciclos.
        if (contadorControl >= 12) {
            System.out.println("Pruebas de control maximas alcanzadas, generando nuevo numero...");
            numero = random.nextInt(2); // Solo Monetary y Erotic
        }
        if (contadorErotic >= 24 && contadorMonetary <= 24) {
            System.out.println("Pruebas eroticas maximas alcanzadas, generando nuevo numero...");
            numero = 0;
        }
        if (contadorMonetary >= 24 && contadorErotic <= 24) {
            System.out.println("Pruebas monetarias maximas alcanzadas, generando nuevo numero...");
            numero = 1;
        }
        if (contadorErotic >= 24 && contadorMonetary >= 24) {
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
                    if(Navegacion.getInstance().getVersion()==0){
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
                    }else if(Navegacion.getInstance().getVersion()==1){
                        switch (recompensa) {
                            case 0 ->
                                ruta = "/EROTIC75A2.png";
                            case 1 ->
                                ruta = "/EROTIC50A2.png";
                            case 2 ->
                                ruta = "/EROTIC25A2.png";
                            case 3 ->
                                ruta = "/EROTIC75B2.png";
                            case 4 ->
                                ruta = "/EROTIC50B2.png";
                            case 5 ->
                                ruta = "/EROTIC25B2.png";
                            default ->
                                System.out.println("No se puede cargar la imagen, no hay recompensas disponibles " + recompensa + " " + numero);
                        }
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
                delayPantallaBlanca = numero / 1000.0;
                System.out.println("pasaron " + delayPantallaBlanca + " segundos, cambiando de panel...");
                Navegacion.getInstance().mostrarDiscriminationTaskPanel();
            });

        });
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

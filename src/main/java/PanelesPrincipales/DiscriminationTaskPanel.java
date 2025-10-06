/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PanelesPrincipales;

import control.Navegacion;
import control.Temporizador;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author gaspa
 */
public final class DiscriminationTaskPanel extends javax.swing.JPanel {
    public static DiscriminationTaskPanel instancia;
    private Navegacion navegacion;
    private JLabel imagenFigura;
    private ImageIcon icono;
    private boolean clicked = false;
    private long startTime;
    private long tiempoRespuesta = 0L;
    private boolean exito;
    
    public static DiscriminationTaskPanel getInstance() {
        if (instancia == null) {
            instancia = new DiscriminationTaskPanel();
        }
        return instancia;
    }
    public DiscriminationTaskPanel() {
        initComponents();
        this.setLayout(new GridBagLayout());
        setearFiguraCentral();
    }
    public void metodosFlujoPrograma(){
        cargarIcono();
    }
    public void setearFiguraCentral(){
        System.out.println("Setear figura central");
        imagenFigura = new JLabel();
        imagenFigura.setPreferredSize(new Dimension(1980, 1080));
        imagenFigura.setSize(new Dimension(1980, 1080));
        //Lineas de codigo para ajustar la imagen un poco mas hacia arriba.
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 0, 0);
        //Agrega el label al panel para que se muestre
        this.add(imagenFigura,gbc);
    }
    /**
     * 0 = cuadrado
     * 1 = triangulo
     */
    public void cargarIcono(){
        System.out.println("Cargar Icono");
        Random random = new Random();
        int numero = random.nextInt(2);
        
        System.out.println("Numero de icono: "+ numero);
        String ruta=null;
        switch (numero) {
            case 0 -> {
                System.out.println("Estableciendo imagen de cuadrado...");
                ruta =  "/square.png";
                this.cargarRuta(ruta);
                this.cuadrado();
                break;
            }
            case 1 -> {
                System.out.println("Estableciendo imagen de triangulo...");
                ruta =  "/triangle.png";
                this.cargarRuta(ruta);
                this.triangulo();
                break;
            }
            default -> {
                break;
            }
        }
    }
    private void cargarRuta(String ruta){
        if (ruta != null) {
            icono = new ImageIcon(getClass().getResource(ruta)); 
            Image imagenEscalada = icono.getImage().getScaledInstance(
                1980, 1080, Image.SCALE_SMOOTH);
            imagenFigura.setIcon(new ImageIcon(imagenEscalada));
        } else {
        }
    }
    private void triangulo(){
        System.out.println("Entrando al metodo de triangulo...");
        clicked = false; 
        exito = false;
        navegacion = Navegacion.getInstance();
        
        for (MouseListener ml : imagenFigura.getMouseListeners()) {
            imagenFigura.removeMouseListener(ml);
        }
        
        imagenFigura.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!clicked) {
                    clicked = true; 
                    long elapsed = System.currentTimeMillis() - startTime;
                    String tipo = SwingUtilities.isLeftMouseButton(e) ? "izquierdo" :
                                  SwingUtilities.isRightMouseButton(e) ? "derecho" : "otro";
                    System.out.println("Hiciste clic " + tipo + " en " + elapsed + " milisegundos.");
                    tiempoRespuesta = elapsed;
                    if (tipo.equals("izquierdo")) {
                        exito = true;
                        navegacion.mostrarRewardPanel();
                    } else {
                        System.out.println("Prueba fallida por clic incorrecto. en triangulo");
                        navegacion.mostrarRewardPanel(); 
                    }
                }
            }
        });

        startTime = System.currentTimeMillis();

        Temporizador.temporizador(1000, () -> {
            if (!clicked) { 
                clicked = true; 
                System.out.println("No diste clic a tiempo.");
                
                exito = false;
                navegacion.mostrarRewardPanel();
            }
        });
    }
    private void cuadrado(){
        System.out.println("Entrando al metodo de cuadrado...");
        clicked = false; 
        exito = false;
        navegacion = Navegacion.getInstance();

        for (MouseListener ml : imagenFigura.getMouseListeners()) {
            imagenFigura.removeMouseListener(ml);
        }

        imagenFigura.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!clicked) {
                    clicked = true; 
                    long elapsed = System.currentTimeMillis() - startTime;
                    String tipo = SwingUtilities.isLeftMouseButton(e) ? "izquierdo" :
                                  SwingUtilities.isRightMouseButton(e) ? "derecho" : "otro";
                    System.out.println("Hiciste clic " + tipo + " en " + elapsed + " milisegundos.");
                    tiempoRespuesta = elapsed;
                    if (tipo.equals("derecho")) {
                        exito = true;
                        navegacion.mostrarRewardPanel();
                    } else {
                        System.out.println("Prueba fallida por clic incorrecto. en cuadrado");
                        navegacion.mostrarRewardPanel();
                    }
                }
            }
        });

        startTime = System.currentTimeMillis();

        Temporizador.temporizador(1000, () -> {
            if (!clicked) { 
                clicked = true; 
                System.out.println("No diste clic a tiempo.");
                
                exito = false;
                navegacion.mostrarRewardPanel();
            }
        });
    }
    public long getTiempoRespuesta(){
        return this.tiempoRespuesta;
    }
    public boolean getExito(){
        //EXITO HARDSETTED A TRUE PARA REALIZAR PRUEBAS
//        exito = true;
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

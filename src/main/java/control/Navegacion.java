/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import PanelesPrincipales.MainScreen;
import PanelesPrincipales.CuePanel;
import PanelesPrincipales.DiscriminationTaskPanel;
import PanelesPrincipales.IniciarPanel;
import PanelesPrincipales.PanelResultados;
import PanelesPrincipales.RatePanel;
import PanelesPrincipales.RewardPanel;
import javax.swing.JPanel;

/**
 *
 * @author Ilian Fernando Gastelum Romo
 */
public class Navegacion {
    private static Navegacion instancia;
    private CuePanel cuePanel;
    private DiscriminationTaskPanel discriminationPanel;
    private RewardPanel rewardPanel;
    private RatePanel ratePanel;
    private PanelResultados panelResultados;
    private IniciarPanel iniciarPanel;
    private int version;
    private boolean Test;
    public Navegacion(){
    }
    public static Navegacion getInstance() {
        if (instancia == null) {
            instancia = new Navegacion();
        }
        return instancia;
    }
    public void setVersion(int version){
        this.version = version;
    }
    public int getVersion(){
        return this.version;
    }

    public boolean isTest() {
        return Test;
    }

    public void setTest(boolean Test) {
        this.Test = Test;
    }
    
    public void mostrarIniciarPanel(){
        this.iniciarPanel = IniciarPanel.getInstance();
        mostrarPantalla(iniciarPanel);
    }
    public void mostrarCuePanel(){
        this.cuePanel = CuePanel.getInstance();
        cuePanel.metodosFlujoPrograma();
        System.out.println("Mostrando pantalla Cue...");
        mostrarPantalla(cuePanel);
    }
    public void mostrarDiscriminationTaskPanel(){
        this.discriminationPanel = DiscriminationTaskPanel.getInstance();
        discriminationPanel.metodosFlujoPrograma();
        System.out.println("Mostrando pantalla DiscriminationTask...");
        mostrarPantalla(discriminationPanel);
    }
    public void mostrarRewardPanel(){
        this.rewardPanel = RewardPanel.getInstance();
        rewardPanel.metodosFlujoPrograma();
        System.out.println("Mostrando pantalla Reward...");
        mostrarPantalla(rewardPanel);
    }
    public void mostrarRatePanel(){
        this.ratePanel = RatePanel.getInstance();
        ratePanel.limpiarSeleccion();
        System.out.println("Mostrando pantalla Rate...");
        mostrarPantalla(ratePanel);
        ratePanel.siguientePantalla();
    }
    public void mostrarPanelResultados(){
        this.panelResultados = PanelResultados.getInstance();
        System.out.println("Mostrando pantalla de resultados finales...");
        LimpiarPantalla();
        mostrarPantalla(panelResultados);
    }
    public void mostrarPantalla(JPanel nuevoPanel) {
        
        MainScreen main = MainScreen.getInstance();
        main.panelPrincipal.removeAll();
        main.panelPrincipal.add(nuevoPanel);
        main.panelPrincipal.revalidate();
        main.panelPrincipal.repaint();
    }
    public void LimpiarPantalla(){
        System.out.println("Limpiando pantalla...");
        MainScreen main = MainScreen.getInstance();
        main.panelPrincipal.removeAll();
        main.panelPrincipal.revalidate();
        main.panelPrincipal.repaint();
    }
}

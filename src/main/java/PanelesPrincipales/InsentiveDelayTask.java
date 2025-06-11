/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package PanelesPrincipales;

import control.Navegacion;

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
    }
}

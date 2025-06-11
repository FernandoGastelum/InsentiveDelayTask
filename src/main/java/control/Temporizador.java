/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author gaspa
 */
public class Temporizador {
    public static void temporizador(int milisegundos, Runnable accion){
        Timer timer = new Timer(milisegundos, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accion.run();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}

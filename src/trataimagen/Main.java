/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trataimagen;

import trataimagen.Controlador.Controlador;
import trataimagen.Modelo.Imagen;
import trataimagen.Vista.vista;

/**
 *
 * @author Cobian Perea Ricardo Emiliano
 */
public class Main {
    
    private static Imagen imagen;
    private static Controlador controlador;
    private static vista vista;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        imagen = new Imagen();
        vista = new vista();
        controlador = new Controlador(vista,imagen);
        controlador.iniciaAplicacion();
        vista.setVisible(true);
    }
    
}

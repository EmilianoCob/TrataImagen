/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trataimagen.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import trataimagen.Modelo.Imagen;
import trataimagen.Vista.vista;

/**
 *
 * @author Cobian Perea Ricardo Emiliano
 */
public class Controlador implements ActionListener {
    
   private final Imagen imagen;
   private final vista vista;
    
    public Controlador(vista vista, Imagen imagen){
        this.vista = vista;
        this.imagen = imagen;
        inicializaElementos();
    }
    
    public void iniciaAplicacion(){
        vista.setTitle("ProgramaFiltro");   
        vista.setLocationRelativeTo(null);
    }
    
    public void inicializaElementos(){
    vista.abrir.addActionListener(this);
    vista.gris.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch(e.getActionCommand()){
            case "Abrir":        
            try {
                imagen.abrirImagen(true);
                this.vista.imagenOriginal.setIcon(new ImageIcon(imagen.getImagenOriginal()));
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            case "Escala de Grises":
                imagen.creaImagen(imagen.getGris(), imagen.getAncho(), imagen.getAltura());
                this.vista.imagenModificada.setIcon(new ImageIcon(imagen.getImagenTrabajada()));
                break;
        }
    }
    
}

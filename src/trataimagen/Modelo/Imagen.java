/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trataimagen.Modelo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Cobian Perea Ricardo Emiliano
 */
public class Imagen {

    private final JFileChooser selector = new JFileChooser();
    private File imagenSeleccionada;
    private BufferedImage imagenOriginal;
    private BufferedImage segundaImagen;
    private BufferedImage imagenTrabajada;
    
    private int R[][];
    private int G[][];
    private int B[][];
    
    private int gris[][];

    //PROPIEDADES
    private int ancho;
    private int altura;

    public void abrirImagen(boolean opc) throws IOException {
        selector.setDialogTitle("Seleciona Imagen");
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & PNG", "jpg", "png");
        selector.setFileFilter(filtroImagen);
        int flag = selector.showOpenDialog(null);

        if(flag == JFileChooser.APPROVE_OPTION) {
            if (opc) {
            imagenSeleccionada = selector.getSelectedFile();
            imagenOriginal = ImageIO.read(imagenSeleccionada);
            ancho = imagenOriginal.getWidth();
            altura = imagenOriginal.getHeight();
        }else{
            imagenSeleccionada = selector.getSelectedFile();
            segundaImagen = ImageIO.read(imagenSeleccionada);
        }
            obtenRGB();
        }
    }
    
    public void obtenRGB(){
        int mediaPixel;
        Color colorAux;
        gris = new int[ancho][altura];
        R = new int[ancho][altura];
        G = new int[ancho][altura];
        B = new int[ancho][altura];
        for(int i = 0; i < ancho; i++){
            for(int j = 0; j < altura; j++){
                colorAux = new Color(imagenOriginal.getRGB(i, j));
                R[i][j] = colorAux.getRed();
                G[i][j] = colorAux.getGreen();
                B[i][j] = colorAux.getBlue();
                // R * ALFA + G * BETA + B * GAMA
                mediaPixel = (int) ((colorAux.getRed() * 0.3) + (colorAux.getGreen() * 0.59) + (colorAux.getBlue() * 0.11));
                gris[i][j] = mediaPixel;
            }
        }            
    }
    
    public void creaImagen(int[][] Imagen, int x, int y){
        try {
            imagenTrabajada = new BufferedImage(x,y, imagenOriginal.getType());
            for(int i = 0; i < Imagen.length; i++){
                for(int j = 0; j < Imagen[0].length; j++){
                    int rgb = Imagen[i][j]<<16 | Imagen[i][j] << 8 | Imagen[i][j];
                    imagenTrabajada.setRGB(i, j, new Color(rgb).getRGB());
                }
            }
        } catch (Exception e){
            System.out.print(e);
        }
    }

    public BufferedImage getImagenOriginal() {
        return imagenOriginal;
    }

    public BufferedImage getSegundaImagen() {
        return segundaImagen;
    }

    public BufferedImage getImagenTrabajada() {
        return imagenTrabajada;
    }

    public int[][] getR() {
        return R;
    }

    public int[][] getG() {
        return G;
    }

    public int[][] getB() {
        return B;
    }

    public int[][] getGris() {
        return gris;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAltura() {
        return altura;
    }
    
    
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica6;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class Umbral extends JPanel{
    
    private Mat imageMat, imageMatOriginal;
    private BufferedImage imagen;
    private BufferedImage imagen2;
    
    public Umbral(){    
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(imagen, 0, 0, null);
    }
    
    public void openImage(File fichero){
        try {
            imagen=ImageIO.read(fichero);
            imagen2 = imagen;
            repaint();
        } catch (IOException ex) {
            Logger.getLogger(Umbral.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void originalImageFilter(){
        imageMat = imageMatOriginal.clone();
        imagen = (BufferedImage) HighGui.toBufferedImage(imageMat);
        this.repaint();
    }
    
    void umbralizarImagen(int value) {
        imagen2 = ImagenUmbralizada(imagen, value);
        repaint(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void closeImage(){
        imagen=null;
        imageMat=null;
        this.repaint();
    }
    
    public void saveImage(String path){
        imageMatOriginal = imageMat.clone();
        Imgcodecs.imwrite(path,imageMat);
    }
    public static Mat bufferedImageAMat(BufferedImage imagenOriginal) {
        Mat mat = new Mat(imagenOriginal.getHeight(), imagenOriginal.getWidth(), CvType.CV_8UC3);
        byte[] data = ((DataBufferByte) imagenOriginal.getRaster().getDataBuffer()).getData();
        mat.put(0, 0, data);
        return mat;
    }
    
    private static BufferedImage ImagenUmbralizada(BufferedImage imagenOriginal, int umbral) throws UnsupportedOperationException {
        try {
            Mat imagenMat = bufferedImageAMat(imagenOriginal);
            Mat imagenMatGris = new Mat(imagenMat.rows(), imagenMat.cols(), CvType.CV_8U);
            Mat imagenMatUmbral = new Mat(imagenMat.rows(), imagenMat.cols(), CvType.CV_8U);
            Imgproc.cvtColor(imagenMat, imagenMatGris, Imgproc.COLOR_BGR2GRAY);
            Imgproc.threshold(imagenMatGris, imagenMatUmbral, umbral, 255, Imgproc.THRESH_BINARY);
            return (BufferedImage) HighGui.toBufferedImage(imagenMatUmbral);
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getName() + " " + e.getMessage());
            return null;
        }
    }
        
    public BufferedImage getImage() {
        return imagen2;
    }

    
}



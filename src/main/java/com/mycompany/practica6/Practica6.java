package com.mycompany.practica6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;

/**
 *
 * @author marti
 */
public class Practica6 extends javax.swing.JFrame {

    JFileChooser fc= new JFileChooser();
    FileNameExtensionFilter filtro=null;
    public Practica6() {
        initComponents();
        setLocationRelativeTo(null);
        filtro=new FileNameExtensionFilter("Imágenes (jpg, png, jpeg)", "jpg", "png", "jpeg");
        fc.setFileFilter(filtro);
        avisoLabel.setVisible(false);
        nu.pattern.OpenCV.loadShared(); 
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avisoLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        abrirItem = new javax.swing.JMenuItem();
        guardarItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        closeItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        umbralItem = new javax.swing.JMenuItem();
        verMenu = new javax.swing.JMenu();
        verItem = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        acercaItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Umbralización Imagen");

        avisoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        avisoLabel.setText("Archivo seleccionado no es una imagen válida. Comprueba la extensión");

        archivoMenu.setMnemonic('A');
        archivoMenu.setText("Archivo");

        abrirItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        abrirItem.setText("Abrir");
        abrirItem.setToolTipText("");
        abrirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirItemActionPerformed(evt);
            }
        });
        archivoMenu.add(abrirItem);

        guardarItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        guardarItem.setText("Guardar");
        guardarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarItemActionPerformed(evt);
            }
        });
        archivoMenu.add(guardarItem);
        archivoMenu.add(jSeparator1);

        closeItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        closeItem.setText("Cerrar aplicación");
        closeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeItemActionPerformed(evt);
            }
        });
        archivoMenu.add(closeItem);

        jMenuBar1.add(archivoMenu);

        editMenu.setMnemonic('E');
        editMenu.setText("Edición");

        umbralItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        umbralItem.setText("Umbralización");
        umbralItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umbralItemActionPerformed(evt);
            }
        });
        editMenu.add(umbralItem);

        jMenuBar1.add(editMenu);

        verMenu.setMnemonic('V');
        verMenu.setText("Ver");

        verItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        verItem.setText("Ver Imagen");
        verItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verItemActionPerformed(evt);
            }
        });
        verMenu.add(verItem);

        jMenuBar1.add(verMenu);

        ayudaMenu.setMnemonic('H');
        ayudaMenu.setText("Ayuda");

        acercaItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        acercaItem.setText("Acerca de");
        acercaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaItemActionPerformed(evt);
            }
        });
        ayudaMenu.add(acercaItem);

        jMenuBar1.add(ayudaMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(avisoLabel)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(avisoLabel)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirItemActionPerformed
        System.out.println("Abriendo"); 
        fc.addChoosableFileFilter(filtro);
        int rDialog=fc.showOpenDialog(null);
        if (rDialog==JFileChooser.APPROVE_OPTION){
            System.out.println("Archivo seleccionado");
            File fichero=  fc.getSelectedFile();
            checkFileExtension(fichero);
            
        }
        if (rDialog==JFileChooser.CANCEL_OPTION){
            avisoLabel.setText("Nada seleccionado");
            avisoLabel.setVisible(true);
        }
        
        if(!avisoLabel.isVisible()){
            
        }
        
    }//GEN-LAST:event_abrirItemActionPerformed

    private void guardarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarItemActionPerformed
        System.out.println("Guardando");
        int rDialog=fc.showSaveDialog(null);
        if (rDialog==JFileChooser.APPROVE_OPTION){
            System.out.println("Archivo seleccionado");
            File fichero=  fc.getSelectedFile();
            String ext=checkFileExtension(fichero);
            if(ext==""){
                avisoLabel.setText("Guardando algo que no es una imagen");
                avisoLabel.setVisible(true);
            }
            else if(fichero.exists()){
               int res2 = JOptionPane.showConfirmDialog(rootPane
                        , "AVISO: El fichero \""+fichero.getName()+"\" ya existe, ¿Quiere sobrescribirlo?."
                        ,"Sobrescribir Fichero", JOptionPane.YES_NO_OPTION);
                if(res2==JOptionPane.YES_OPTION){
                    System.out.println("Imagen Guardada sobreescrita");
                }else{
                    System.out.println("Imagen Guardada");

                }
            }
            /*try{
                //ImageIO.write((BufferedImage)imagen,ext ,fichero);
            }catch(IOException e){
                System.out.println("Error al guardar imagen");
            }*/
        }
        if (rDialog==JFileChooser.CANCEL_OPTION){
            avisoLabel.setText("Nada seleccionado");
            avisoLabel.setVisible(true);
        }
    }//GEN-LAST:event_guardarItemActionPerformed

    private void closeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeItemActionPerformed
        exitAplication();
    }//GEN-LAST:event_closeItemActionPerformed

    private void umbralItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umbralItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_umbralItemActionPerformed

    private void verItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verItemActionPerformed

    private void acercaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaItemActionPerformed
        JOptionPane.showMessageDialog(rootPane,  "Software para aplicar proceso de umbralización de una imagen dado por el usuario.\n" +
                                                 "Product Version: Umbralización Imagen Beta\n"+
                                                 "Devs: @martinvplopez, @joelnavri"
                        , "AYUDA", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_acercaItemActionPerformed

    private void exitAplication(){
        int res = JOptionPane.showConfirmDialog(rootPane, "¿Quieres cerrar la aplicación?."
                ,"Cerrar Aplicación", JOptionPane.YES_NO_OPTION);
        if(res==JOptionPane.YES_OPTION){
            System.exit(0);
            setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        }
    }  
    
    
    private String checkFileExtension(File fichero){
        String [] extensionArr= fichero.getName().split("\\.");
            String extension= extensionArr[extensionArr.length-1].trim();
            System.out.println("Fichero: " + fichero.getName()+ " extension: " + extensionArr[extensionArr.length-1]);
            switch(extension){
                case "jpg":
                    avisoLabel.setVisible(false);
                    return "jpg";
                case "png":
                    avisoLabel.setVisible(false);
                    return "png";
                case "jpeg":
                    avisoLabel.setVisible(false);
                    return "jpeg";
                default:
                    avisoLabel.setText("Archivo seleccionado no es una imagen válida. Comprueba la extensión");
                    avisoLabel.setVisible(true);
                    return "";
            }

    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Practica6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practica6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practica6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practica6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practica6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirItem;
    private javax.swing.JMenuItem acercaItem;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JLabel avisoLabel;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JMenuItem closeItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem guardarItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem umbralItem;
    private javax.swing.JMenuItem verItem;
    private javax.swing.JMenu verMenu;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.FileDialog;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author buidu
 */
public class XImage {
    public static byte[] img;

    public static void openImageFile(JLabel j) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                byte[] imageData;
                try ( 
                        FileInputStream fileInputStream = new FileInputStream(selectedFile)) {
                    imageData = new byte[(int) selectedFile.length()];
                    img = imageData;
                    fileInputStream.read(imageData);
                }
               convertByteToImage(j,img);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(XImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(XImage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void convertByteToImage(JLabel j, byte[] img) {
        try {
            XImage.img = img;
            ImageIcon icon = new ImageIcon(img);
            Image resized = icon.getImage();
            Image scaledImage = resized.getScaledInstance(j.getWidth(), j.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon resizedImageIcon = new ImageIcon(scaledImage);
            j.setIcon(resizedImageIcon);
        } catch (Exception e) {
            j.setIcon(null);
        }
       
    }
    //FileDialog fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
//fd.setDirectory("C:\\");
//fd.setFile("*");
//fd.setVisible(true);
//String filename = fd.getFile();
//if (filename == null)
//  System.out.println("You cancelled the choice");
//else
//  System.out.println("You chose " + filename);
}

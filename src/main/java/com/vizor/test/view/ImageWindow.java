package com.vizor.test.view;

import com.vizor.test.controller.ImageController;
import com.vizor.test.panel.ButtonPanel;
import com.vizor.test.panel.ImagePanel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageWindow extends JFrame {

    ImageController controller;
    ImagePanel imagePanel;
    ButtonPanel buttonPanel;

    public ImageWindow(ImageController controller) throws HeadlessException {
        this.controller = controller;
        this.imagePanel =  new ImagePanel();
        this.buttonPanel =  new ButtonPanel(controller);

        super.add(this.imagePanel, BorderLayout.CENTER);
        super.add(this.buttonPanel, BorderLayout.SOUTH);
    }

    public void setImage(BufferedImage image) {
        this.imagePanel.setSize(image.getWidth(), image.getHeight());
        this.imagePanel.setImage(image);

        int width = super.getInsets().left + super.getInsets().right + this.imagePanel.getWidth();
        int height = super.getInsets().top + super.getInsets().bottom + this.imagePanel.getHeight();

        super.setSize(width, height);
    }

    public File chooseImageFile() {
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Only Image Files", "JPG", "JPEG", "PNG", "GIF");
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(extensionFilter);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }
}

package com.vizor.test.controller;

import com.vizor.test.model.ImageModel;
import com.vizor.test.panel.ButtonPanel;
import com.vizor.test.view.ImageWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageController implements ActionListener {
    private ImageWindow view;
    private ImageModel model;
    private ButtonPanel buttonPanel;

    public void run() {
        view = new ImageWindow(this);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Image Viewer");
        view.setResizable(false);
        view.pack();
        view.setVisible(true);
    }

    public void openImage() {
        File file = view.chooseImageFile();

        model.addFile(file);
        model.loadImage(file);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case ButtonPanel.OPEN_BUTTON_LABEL:{
                this.openImage();
                break;
            }
            case ButtonPanel.GO_BACK_BUTTON_LABEL: {
                model.loadImage(model.getPrevFile());
                break;
            }
            case ButtonPanel.GO_FORWARD_BUTTON_LABEL: {
                model.loadImage(model.getNextFile());
                break;
            }

        }


    }
}

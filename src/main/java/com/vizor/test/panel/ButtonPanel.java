package com.vizor.test.panel;

import com.vizor.test.controller.ImageController;

import javax.swing.*;

public class ButtonPanel extends JPanel {

    ImageController controller;

    JButton openButton;
    JButton goBackButton;
    JButton goForwardButton;

    public final static String OPEN_BUTTON_LABEL = "open";
    public final static String GO_BACK_BUTTON_LABEL = "go back";
    public final static String GO_FORWARD_BUTTON_LABEL = "go forward";

    public ButtonPanel(ImageController controller) {
        this.controller = controller;

        openButton = new JButton(OPEN_BUTTON_LABEL);
        goBackButton = new JButton(GO_BACK_BUTTON_LABEL);
        goForwardButton = new JButton(GO_FORWARD_BUTTON_LABEL);

        openButton.addActionListener(controller);
        goBackButton.addActionListener(controller);
        goForwardButton.addActionListener(controller);

        super.add(openButton);
        super.add(goBackButton);
        super.add(goForwardButton);

    }
}

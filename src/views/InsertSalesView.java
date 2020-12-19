package views;

import controllers.FundController;
import controllers.IndexController;
import models.Fund;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class InsertSalesView extends JFrame {

    protected FundController controller;
    public InsertSalesView(FundController controller)
    {
        this.controller = controller;

        setSize(500,500);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        createPanelUI(this);

        pack();
        setVisible(true);
    }

    public void createPanelUI(Container container) {
        JButton button;
        JLabel label;

        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;

        label = new JLabel("Внести выручку");
        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        container.add(label, constraints);

        label = new JLabel("Счета:");
        constraints.gridy = 2;
        constraints.insets = new Insets(20, 0, 0, 0);
        container.add(label, constraints);

        JTextField textField = new JTextField(20);
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 3;
        container.add(textField, constraints);

        button = new JButton("Внести выручку");
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 4;

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insert( Integer.parseInt( textField.getText() ) );
            }
        });

        container.add(button, constraints);

    }

    public void close()
    {
        setVisible(false);
    }
}

package views;

import controllers.FundController;
import controllers.TargetController;
import helper.ComboItem;
import models.Fund;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class ReportView extends JFrame {
    TargetController controller;
    public ReportView(TargetController controller)
    {
        this.controller = controller;

        setSize(500,500);

        createPanelUI(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        label = new JLabel("Просмотреть отчетность");
        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        container.add(label, constraints);

        label = new JLabel("Начало периода:");
        constraints.gridy = 2;
        constraints.insets = new Insets(20, 0, 0, 0);
        container.add(label, constraints);

        label = new JLabel("Конец периода:");
        constraints.gridy = 2;
        constraints.insets = new Insets(20, 0, 0, 0);
        container.add(label, constraints);

        JTextField textField = new JTextField(20);
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 5;
        container.add(textField, constraints);

        JTextField textField2 = new JTextField(20);
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 5;
        container.add(textField2, constraints);

        button = new JButton("Поставить цель");
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 6;

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                controller.makeReport(  );
            }
        });

        container.add(button, constraints);

    }

    public void close()
    {
        setVisible(false);
    }
}

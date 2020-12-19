package views;

import controllers.FundController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import helper.*;

import models.Fund;

public class WithdrawView extends JFrame {
    FundController controller;
    Vector<Fund> funds;

    public WithdrawView(FundController controller, Vector<Fund> funds)
    {
        this.controller = controller;
        this.funds = funds;

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

        label = new JLabel("Снять средства");
        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        container.add(label, constraints);

        label = new JLabel("Выберите счет:");
        constraints.gridy = 2;
        constraints.insets = new Insets(20, 0, 0, 0);
        container.add(label, constraints);

        Fund item;
        String[] fundsItem = new String[ funds.size() ];
        JComboBox list = new JComboBox();

        for (int i = 0; i < funds.size(); i++){
            list.addItem( new ComboItem( funds.get(i).getIndex(), funds.get(i).getName()) );
        }

        list.setSelectedIndex(1);
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 3;
        container.add(list, constraints);

        label = new JLabel("Введите сумму:");
        constraints.gridy = 4;
        constraints.insets = new Insets(20, 0, 0, 0);
        container.add(label, constraints);

        JTextField textField = new JTextField(20);
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 5;
        container.add(textField, constraints);

        button = new JButton("Снять средства");
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 6;

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object item = list.getSelectedItem();
                int value = ((ComboItem)item).getKey();
                controller.withdrawPayment( Integer.parseInt( textField.getText() ), value );
            }
        });

        container.add(button, constraints);

    }

    public void close()
    {
        setVisible(false);
    }

}

package views;

import controllers.FundController;
import helper.ComboItem;
import models.Fund;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class TransferView extends JFrame {
    FundController controller;
    Vector<Fund> funds;

    public TransferView(FundController controller, Vector<Fund> funds)
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

        label = new JLabel("Перевести средства");
        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        container.add(label, constraints);

        label = new JLabel("Откуда:");
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



        label = new JLabel("Куда:");
        constraints.gridy = 2;
        constraints.insets = new Insets(20, 0, 0, 0);
        container.add(label, constraints);

        JComboBox list_to = new JComboBox();

        for (int i = 0; i < funds.size(); i++){
            list_to.addItem( new ComboItem( funds.get(i).getIndex(), funds.get(i).getName()) );
        }

        list.setSelectedIndex(1);
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 3;
        container.add(list_to, constraints);




        label = new JLabel("Введите сумму:");
        constraints.gridy = 4;
        constraints.insets = new Insets(20, 0, 0, 0);
        container.add(label, constraints);

        JTextField textField = new JTextField(20);
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 5;
        container.add(textField, constraints);

        button = new JButton("Перевести средства");
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 6;

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object item = list.getSelectedItem();
                Object item_to = list_to.getSelectedItem();

                int value = ((ComboItem)item).getKey();
                int value_to = ((ComboItem)item_to).getKey();
                controller.makeTransfer( Integer.parseInt( textField.getText() ), value, value_to );
            }
        });

        container.add(button, constraints);

    }

    public void close()
    {
        setVisible(false);
    }
}

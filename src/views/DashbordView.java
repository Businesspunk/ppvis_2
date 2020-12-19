package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import controllers.IndexController;
import models.*;

public class DashbordView extends JFrame {

    protected int timeFund = 0;
    protected int marketingFund = 0;
    protected int salaryFund = 0;
    protected int stabilizationFund = 0;
    protected int fixedCostsFund = 0;
    protected int developmentFund = 0;

    protected Vector<Fund> funds;
    protected IndexController controller;


    public DashbordView(Vector<Fund> funds, IndexController controller)
    {
        super("Dashbord");
        this.funds = funds;
        this.controller = controller;

        setSize(500,500);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        createPanelUI(this);

        pack();
        setVisible(true);
    }

    public void createPanelUI(Container container)
    {
        JButton button;
        JLabel label;

        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        container.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;

        label = new JLabel("Дашборд");
        label.setAlignmentX(Component.RIGHT_ALIGNMENT);
        container.add(label, constraints);

        label = new JLabel("Счета:");
        constraints.gridy = 2;
        constraints.insets = new Insets(20,0,0,0);
        container.add(label, constraints);

        Fund item;
        for (int i = 0; i < funds.size(); i++){
            item = funds.get(i);
            label = new JLabel(item.getName()+" "+item.getCost());
            constraints.gridy = i+4;
            container.add(label, constraints);
        }

        button = new JButton("Внести выручку");
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 10;
        container.add(button, constraints);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getFundController().getInsertSales();
            }
        });

        button = new JButton("Снять средства");
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 10;
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getFundController().getWithdraw();
            }
        });

        container.add(button, constraints);



        button = new JButton("Перевести средства");
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 10;
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getFundController().getTransfer();
            }
        });
        container.add(button, constraints);



        button = new JButton("Поставить цель");
        constraints.insets = new Insets(10,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 10;

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getTargetController().getAddTarget();
            }
        });
        container.add(button, constraints);

        button = new JButton("Посмотреть отчет");
        constraints.insets = new Insets(20,0,0,0);
        constraints.anchor = GridBagConstraints.PAGE_END;
        constraints.gridy = 10;
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.getTargetController().getReport();
            }
        });
        container.add(button, constraints);
    }
}

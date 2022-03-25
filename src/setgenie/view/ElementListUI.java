package setgenie.view;

import setgenie.controller.ElementListCtl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ElementListUI extends JFrame {
    private JPanel tablePanel, buttonPanel;
    private JTable listTable;
    private JButton doneButton, detailsButton, newButton;
    private JScrollPane listScroller;
    private ElementListCtl listCtl;

    public ElementListUI(ElementListCtl listCtl){
        this.listCtl = listCtl;
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    public void initComponents(){
        tablePanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(1, 4));
        listTable = new JTable(listCtl.getTableModel());
        listTable.getColumnModel().getColumn(3).setPreferredWidth(15);
        doneButton = new JButton("Done");
        doneButton.addActionListener(new ExitButtonListener());
        newButton = new JButton("Add New Workout");
        newButton.addActionListener(new AddButtonListener());
        detailsButton = new JButton("Get Workout Details");
        detailsButton.addActionListener(new DetailsButtonListener());
        buttonPanel.add(newButton);
        buttonPanel.add(detailsButton);
        buttonPanel.add(doneButton);
        listScroller = new JScrollPane(listTable);
        listTable.setFillsViewportHeight(true);
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listScroller.setPreferredSize(new Dimension(400, 400));
        tablePanel.add(listScroller);
        this.setTitle("Workout Elements");
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(buttonPanel,BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel,BorderLayout.CENTER);
    }

    class DetailsButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedTableRow = listTable.getSelectedRow();
            int selectedModelRow = listTable.convertRowIndexToModel(selectedTableRow);
            ElementListUI.this.listCtl.getElementDetailUI(selectedModelRow);
        }
    }

    class AddButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ElementListUI.this.listCtl.getElementDetailUI();
        }
    }

    class ExitButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}

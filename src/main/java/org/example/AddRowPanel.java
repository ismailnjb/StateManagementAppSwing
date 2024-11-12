package org.example;

import javax.swing.*;
import java.awt.*;

public class AddRowPanel extends JPanel {
    private DataStore dataStore;

    public AddRowPanel(DataStore dataStore) {
        this.dataStore = dataStore;
        setLayout(new FlowLayout());

        JButton addRowButton = new JButton("Add Row");
        JTextField rowDataField = new JTextField(20);
        JButton deleteRowButton = new JButton("Delete Row");

        addRowButton.addActionListener(e -> {
            String rowData = rowDataField.getText();
            if (!rowData.isEmpty()) {
                dataStore.addRowToTable(rowData);
                rowDataField.setText("");  // Clear the input field
            }
        });

        deleteRowButton.addActionListener(e -> {
            String rowData = rowDataField.getText();
            for (int i = 0; i < dataStore.getTableModel().getRowCount(); i++) {
                if (dataStore.getTableModel().getValueAt(i, 0).equals(rowData)) {
                    dataStore.deleteRowFromTable(i);
                    break;
                }
            }
            rowDataField.setText("");  // Clear the input field
        });

        add(new JLabel("Enter Row Data:"));
        add(rowDataField);
        add(addRowButton);
        add(deleteRowButton);
    }
}

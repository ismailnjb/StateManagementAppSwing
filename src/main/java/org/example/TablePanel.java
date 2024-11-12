package org.example;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private JTable table;
    private DataStore dataStore;

    public TablePanel(DataStore dataStore) {
        this.dataStore = dataStore;
        setLayout(new BorderLayout());

        table = new JTable(dataStore.getTableModel());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}

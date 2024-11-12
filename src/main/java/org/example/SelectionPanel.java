package org.example;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class SelectionPanel extends JPanel {
    private JList<String> selectionList;
    private DataStore dataStore;

    public SelectionPanel(DataStore dataStore) {
        this.dataStore = dataStore;
        setLayout(new BorderLayout());

        String[] selectionOptions = {"Option 1", "Option 2", "Option 3"};
        selectionList = new JList<>(selectionOptions);
        selectionList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        selectionList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedValue = selectionList.getSelectedValue();
                    if (selectedValue != null && !dataStore.getSelectionList().contains(selectedValue)) {
                        dataStore.addSelection(selectedValue);
                    }
                }
            }
        });

        add(new JScrollPane(selectionList), BorderLayout.CENTER);
    }
}

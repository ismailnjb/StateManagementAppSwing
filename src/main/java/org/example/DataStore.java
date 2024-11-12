package org.example;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private DefaultTableModel tableModel;
    private List<String> selectionList;

    public DataStore() {
        this.tableModel = new DefaultTableModel(new String[]{"Data"}, 0);
        this.selectionList = new ArrayList<>();
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public List<String> getSelectionList() {
        return selectionList;
    }

    public void addRowToTable(String rowData) {
        tableModel.addRow(new Object[]{rowData});
    }

    public void deleteRowFromTable(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()) {
            tableModel.removeRow(rowIndex);
        }
    }

    public void addSelection(String selection) {
        selectionList.add(selection);
    }

    public void removeSelection(String selection) {
        selectionList.remove(selection);
    }
}

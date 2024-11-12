package org.example;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

public class PanelSwitcherApp extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private DataStore dataStore;

    public PanelSwitcherApp() {
        setTitle("Panel Switcher Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        dataStore = new DataStore();

        // Left Navigation Tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Panels");
        DefaultMutableTreeNode tablePanelNode = new DefaultMutableTreeNode("Table Panel");
        DefaultMutableTreeNode addRowPanelNode = new DefaultMutableTreeNode("Add Row Panel");
        DefaultMutableTreeNode selectionPanelNode = new DefaultMutableTreeNode("Selection Panel");
        root.add(tablePanelNode);
        root.add(addRowPanelNode);
        root.add(selectionPanelNode);
        JTree tree = new JTree(root);

        tree.addTreeSelectionListener(e -> {
            String selectedNode = e.getPath().getLastPathComponent().toString();
            cardLayout.show(mainPanel, selectedNode);
        });

        // Main panel with CardLayout
        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        // Add panels to the main panel
        mainPanel.add(new TablePanel(dataStore), "Table Panel");
        mainPanel.add(new AddRowPanel(dataStore), "Add Row Panel");
        mainPanel.add(new SelectionPanel(dataStore), "Selection Panel");

        // Layout for the main frame
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), mainPanel);
        splitPane.setDividerLocation(150);
        add(splitPane);

        // Default to the Table Panel
        cardLayout.show(mainPanel, "Table Panel");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PanelSwitcherApp app = new PanelSwitcherApp();
            app.setVisible(true);
        });
    }
}

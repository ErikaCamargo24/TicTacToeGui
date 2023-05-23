package view;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class PanelScreenHistory {
	
	public JFrame mostrarVentanaHistorial() {
        JFrame historialFrame = new JFrame("Historial de Juegos");
        historialFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        historialFrame.setSize(600, 400);
        historialFrame.setLocationRelativeTo(null);
        historialFrame.setLayout(new BorderLayout());

        File archivo = new File("data/historial.txt");
        String[] columnas = {"Nombre", "Estado", "Símbolo", "Fecha y Hora"};
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tablaHistorial = new JTable(modeloTabla);

        try {
            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(",");
                modeloTabla.addRow(datos);
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tablaHistorial.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaHistorial.getColumnModel().getColumn(0).setPreferredWidth(150);
        tablaHistorial.getColumnModel().getColumn(1).setPreferredWidth(100);
        tablaHistorial.getColumnModel().getColumn(2).setPreferredWidth(100);
        tablaHistorial.getColumnModel().getColumn(3).setPreferredWidth(150);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTabla);
        tablaHistorial.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);

        JScrollPane scrollPane = new JScrollPane(tablaHistorial);
        historialFrame.add(scrollPane, BorderLayout.CENTER);

        historialFrame.setVisible(true);
        return historialFrame;
    }
}

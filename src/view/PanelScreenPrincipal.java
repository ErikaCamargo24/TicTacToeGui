package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PanelScreenPrincipal extends JFrame {
    private JButton jugarButton;
    private JButton verHistorialButton;
    private PanelDataUser panelDataUser;
    private PanelScreenHistory panelScreenHistory;
    
    public PanelScreenPrincipal() {
    	panelDataUser = new PanelDataUser();
    	panelScreenHistory = new PanelScreenHistory();
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("          Tic Tac Toe         ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel);

        jugarButton = new JButton("Jugar");
        jugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDataUser.mostrarVentanaDatosUsuario();
            }
        });
        add(jugarButton);

        verHistorialButton = new JButton("Ver Historial");
        verHistorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelScreenHistory.mostrarVentanaHistorial();
            }
        });
        add(verHistorialButton);
    }
}

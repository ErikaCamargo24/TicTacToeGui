package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class PanelDataUser {
	private PanelScreenPrincipal pantallaInicial;
	private PanelScreenPlay panelScreenPlay;
	
	
	 public PanelDataUser() {
		panelScreenPlay = new PanelScreenPlay();
	}



	public JFrame mostrarVentanaDatosUsuario() {
	        JFrame datosUsuarioFrame = new JFrame("Datos de Usuario");
	        datosUsuarioFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        datosUsuarioFrame.setSize(300, 170);
	        datosUsuarioFrame.setLocationRelativeTo(null);
	        datosUsuarioFrame.setLayout(new FlowLayout());

	        JLabel nombreLabel = new JLabel("Nombre de Usuario:");
	        JTextField nombreTextField = new JTextField(20);
	        JLabel simboloLabel = new JLabel("Tipo de Símbolo:");
	        JComboBox<String> simboloComboBox = new JComboBox<>(new String[]{" X ", " O "});

	        JButton continuarButton = new JButton("Continuar");
	        continuarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String nombreUsuario = nombreTextField.getText();
	                String simboloSeleccionado = (String) simboloComboBox.getSelectedItem();

	                if (!nombreUsuario.isEmpty()) {
	                    datosUsuarioFrame.dispose();
	                   panelScreenPlay.mostrarVentanaJuego(nombreUsuario, simboloSeleccionado);
	                } else {
	                    JOptionPane.showMessageDialog(datosUsuarioFrame, "Por favor ingrese un nombre de usuario",
	                            "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });

	        datosUsuarioFrame.add(nombreLabel);
	        datosUsuarioFrame.add(nombreTextField);
	        datosUsuarioFrame.add(simboloLabel);
	        datosUsuarioFrame.add(simboloComboBox);
	        datosUsuarioFrame.add(continuarButton);

	        datosUsuarioFrame.setVisible(true);
	        return datosUsuarioFrame;
	    }
}

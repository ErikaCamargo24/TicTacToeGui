package view;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ShowMessage {
	
	 public JDialog mostrarMensaje(String mensaje, Color color) {
	        JOptionPane optionPane = new JOptionPane(mensaje, JOptionPane.INFORMATION_MESSAGE);
	        JDialog dialog = optionPane.createDialog("Resultado del Juego");
	        optionPane.setBackground(color);
	        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        dialog.setVisible(true);
	        return dialog;
	    }
}

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Play;
import model.SaveRegisterPlay;

public class PanelScreenPlay {
	private Play play;
	private ShowMessage showMessage;
	private SaveRegisterPlay saveRegisterPlay;
	
	 public PanelScreenPlay() {
		play = new Play();
		showMessage = new ShowMessage();
		saveRegisterPlay = new SaveRegisterPlay();
	}

	public JFrame mostrarVentanaJuego(String nombreUsuario, String simboloUsuario) {
	        JFrame juegoFrame = new JFrame("Tic Tac Toe");
	        juegoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        juegoFrame.setSize(620, 620);
	        juegoFrame.setLocationRelativeTo(null);
	        juegoFrame.setLayout(new BorderLayout());

	        JPanel juegoPanel = new JPanel();
	        juegoPanel.setLayout(new GridLayout(3, 3));

	        JButton[][] casillas = new JButton[3][3];
	        String[][] tablero = new String[3][3];
	       

	        String simboloMaquina = simboloUsuario.equals(" X ") ? " O " : " X ";

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                casillas[i][j] = new JButton();
	                casillas[i][j].setFont(new Font("Arial", Font.BOLD, 100));
	                final int fila = i;
	                final int columna = j;
	                casillas[i][j].addActionListener(new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                    	 boolean  turnoJugador = true;
	                        if (casillas[fila][columna].getText().isEmpty()) {
	                            if (turnoJugador) {
	                                casillas[fila][columna].setText(simboloUsuario);
	                                tablero[fila][columna] = simboloUsuario;
	                                turnoJugador = false;
	                                if (play.verificarGanador(tablero, simboloUsuario)) {
	                                    showMessage.mostrarMensaje("¡Ganaste!", Color.GREEN);
	                                    saveRegisterPlay.guardarRegistroJuego(nombreUsuario, "Ganado", simboloUsuario);
	                                    juegoFrame.dispose();
	                                    return;
	                                }
	                                if (play.tableroCompleto(tablero)) {
	                                    showMessage.mostrarMensaje("¡Empate!", Color.YELLOW);
	                                    saveRegisterPlay.guardarRegistroJuego(nombreUsuario, "Empatado", simboloUsuario);
	                                    juegoFrame.dispose();
	                                    return;
	                                }
	                                play.turnoMaquina(casillas, tablero, simboloMaquina);
	                                if (play.verificarGanador(tablero, simboloMaquina)) {
	                                    showMessage.mostrarMensaje("¡Perdiste!", Color.RED);
	                                    saveRegisterPlay.guardarRegistroJuego(nombreUsuario, "Perdido", simboloUsuario);
	                                    juegoFrame.dispose();
	                                }
	                            }
	                        }
	                    }
	                });
	                juegoPanel.add(casillas[i][j]);
	            }
	        }

	        juegoFrame.add(juegoPanel, BorderLayout.CENTER);

	        JTabbedPane tabbedPane = new JTabbedPane();

	        JPanel juegoTab = new JPanel();
	        juegoTab.setLayout(new BorderLayout());
	        juegoTab.add(juegoPanel, BorderLayout.CENTER);

	        JPanel informacionTab = new JPanel();
	        informacionTab.setLayout(new GridLayout(2, 1));
	        informacionTab.add(new JLabel("Nombre: " + nombreUsuario));
	        informacionTab.add(new JLabel("Símbolo: " + simboloUsuario));

	        JPanel integrantesTab = new JPanel();
	        integrantesTab.setLayout(new GridLayout(8, 1));
	        integrantesTab.add(new JLabel("Integrantes:"));
	        integrantesTab.add(new JLabel(" "));
	        integrantesTab.add(new JLabel("Nelson Fabian Moreno - 202023289"));
	        integrantesTab.add(new JLabel("Universidad Pedagogica y Tecnologica de Colombia"));
	        integrantesTab.add(new JLabel("Erika Tatiana Camargo - 202023423"));
	        integrantesTab.add(new JLabel("Facultad de ingenieria"));
	        integrantesTab.add(new JLabel("Yeison Fernando Piracon - 202024013"));
	        integrantesTab.add(new JLabel("Ingenieria de Sistemas"));
	        integrantesTab.add(new JLabel(" "));
	        integrantesTab.add(new JLabel("Programacion 2, 2023, 1"));
	        integrantesTab.add(new JLabel(" "));
	        integrantesTab.add(new JLabel(new ImageIcon("images/logoUPTC.png")));

	        tabbedPane.addTab("Juego", juegoTab);
	        tabbedPane.addTab("Información", informacionTab);
	        tabbedPane.addTab("Integrantes", integrantesTab);

	        juegoFrame.add(tabbedPane, BorderLayout.EAST);

	        juegoFrame.setVisible(true);
	        
	        return juegoFrame;
	    }
}

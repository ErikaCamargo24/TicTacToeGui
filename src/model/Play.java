package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class Play {

	 public boolean verificarGanador(String[][] tablero, String simbolo) {
	        for (int i = 0; i < 3; i++) {
	            if (tablero[i][0] != null && tablero[i][0].equals(simbolo) &&
	                    tablero[i][1] != null && tablero[i][1].equals(simbolo) &&
	                    tablero[i][2] != null && tablero[i][2].equals(simbolo)) {
	                return true;
	            }
	            if (tablero[0][i] != null && tablero[0][i].equals(simbolo) &&
	                    tablero[1][i] != null && tablero[1][i].equals(simbolo) &&
	                    tablero[2][i] != null && tablero[2][i].equals(simbolo)) {
	                return true;
	            }
	        }
	        if (tablero[0][0] != null && tablero[0][0].equals(simbolo) &&
	                tablero[1][1] != null && tablero[1][1].equals(simbolo) &&
	                tablero[2][2] != null && tablero[2][2].equals(simbolo)) {
	            return true;
	        }
	        if (tablero[0][2] != null && tablero[0][2].equals(simbolo) &&
	                tablero[1][1] != null && tablero[1][1].equals(simbolo) &&
	                tablero[2][0] != null && tablero[2][0].equals(simbolo)) {
	            return true;
	        }
	        return false;
	    }
	 
	 public boolean tableroCompleto(String[][] tablero) {
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (tablero[i][j] == null) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	 
	  public void turnoMaquina(JButton[][] casillas, String[][] tablero, String simboloMaquina) {
	        List<int[]> movimientosPosibles = new ArrayList<>();
	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (tablero[i][j] == null) {
	                    movimientosPosibles.add(new int[]{i, j});
	                }
	            }
	        }
	        if (!movimientosPosibles.isEmpty()) {
	            int[] movimiento = movimientosPosibles.get((int) (Math.random() * movimientosPosibles.size()));
	            int fila = movimiento[0];
	            int columna = movimiento[1];
	            casillas[fila][columna].setText(simboloMaquina);
	            tablero[fila][columna] = simboloMaquina;
	        }
	    }
	 
	 
}

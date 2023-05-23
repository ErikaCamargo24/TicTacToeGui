package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveRegisterPlay {
	
	 public void guardarRegistroJuego(String nombreUsuario, String estadoJuego, String simboloUsuario) {
	        try {
	            File archivo = new File("data/historial.txt");
	            FileWriter escritor = new FileWriter(archivo, true);
	            BufferedWriter bufferedWriter = new BufferedWriter(escritor);
	            String registro = nombreUsuario + "," + estadoJuego + "," + simboloUsuario + "," + getCurrentDateTime();
	            bufferedWriter.write(registro);
	            bufferedWriter.newLine();
	            bufferedWriter.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private String getCurrentDateTime() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = new Date();
	        return dateFormat.format(date);
	    }
}

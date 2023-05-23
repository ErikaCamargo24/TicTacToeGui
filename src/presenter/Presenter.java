package presenter;

import javax.swing.SwingUtilities;

import view.PanelScreenPrincipal;

public class Presenter {
	
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                PanelScreenPrincipal pantallaInicial = new PanelScreenPrincipal();
	                pantallaInicial.setVisible(true);
	            }
	        });
	    }
}

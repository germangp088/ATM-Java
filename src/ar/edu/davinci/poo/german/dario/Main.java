package ar.edu.davinci.poo.german.dario;

import java.awt.EventQueue;
import Models.ATM;

public class Main {

	public static void main(String[] args) {
		ATM.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ATM.getInstance().getMediator().getInicioView().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

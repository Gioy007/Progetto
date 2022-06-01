package CentroVaccinale;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class CentroVaccinale {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		System.out.print("bella");	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CentroVaccinale window = new CentroVaccinale();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CentroVaccinale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

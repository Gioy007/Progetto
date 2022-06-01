package Cittadino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrati extends JFrame {

	private JPanel registrati;
	private JTextField jnome;
	private JTextField jcognome;
	private JTextField jcf;
	private JTextField jemail;
	private JTextField jpsw;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private JTextField jrpsw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrati frame = new Registrati();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registrati() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 249, 351);
		registrati = new JPanel();
		registrati.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(registrati);
		
		JLabel lblNewLabel = new JLabel("Registrazione");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		jnome = new JTextField();
		jnome.setColumns(10);
		
		jcognome = new JTextField();
		jcognome.setColumns(10);
		
		jcf = new JTextField();
		jcf.setColumns(10);
		
		jemail = new JTextField();
		jemail.setColumns(10);
		
		jpsw = new JTextField();
		jpsw.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nome");
		
		lblNewLabel_2 = new JLabel("Cognome");
		
		lblNewLabel_3 = new JLabel("CF");
		
		lblNewLabel_4 = new JLabel("E-mail");
		
		lblNewLabel_5 = new JLabel("Password");
		
		btnNewButton = new JButton("Registrati");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome= jnome.getText();
				String cognome= jcognome.getText();
				String cf= jcf.getText();
				String email= jemail.getText();
				String psw= jpsw.getText();
				String rpsw= jrpsw.getText();
				
				if(psw.equals(rpsw)&& !psw.equals("")) {
					//registraCittadino(nome, cognome, cf, email, psw);
					setVisible(false);
					Login l=new Login();
					l.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Password diverse");
				}
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Ripeti password");
		
		jrpsw = new JTextField();
		jrpsw.setColumns(10);
		GroupLayout gl_registrati = new GroupLayout(registrati);
		gl_registrati.setHorizontalGroup(
			gl_registrati.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_registrati.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_registrati.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_registrati.createSequentialGroup()
							.addGroup(gl_registrati.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_registrati.createSequentialGroup()
									.addGroup(gl_registrati.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_3)
										.addComponent(lblNewLabel_4)
										.addComponent(lblNewLabel_5))
									.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
									.addGroup(gl_registrati.createParallelGroup(Alignment.TRAILING)
										.addComponent(jnome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jcognome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jcf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(jpsw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(35, Short.MAX_VALUE))
						.addGroup(gl_registrati.createSequentialGroup()
							.addGroup(gl_registrati.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton)
								.addGroup(gl_registrati.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addGap(18)
									.addComponent(jrpsw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())))
		);
		gl_registrati.setVerticalGroup(
			gl_registrati.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_registrati.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_registrati.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(jnome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_registrati.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(jcognome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_registrati.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(jcf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_registrati.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(jemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_registrati.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(jpsw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_registrati.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(jrpsw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		registrati.setLayout(gl_registrati);
	}
}

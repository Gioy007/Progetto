package Cittadino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel login;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 306);
		login = new JPanel();
		login.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(login);
		SpringLayout sl_login = new SpringLayout();
		login.setLayout(sl_login);
		
		JLabel lblNewLabel = new JLabel("Login");
		sl_login.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, login);
		sl_login.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, login);
		sl_login.putConstraint(SpringLayout.EAST, lblNewLabel, -147, SpringLayout.EAST, login);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		login.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail");
		sl_login.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 19, SpringLayout.SOUTH, lblNewLabel);
		sl_login.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		login.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		sl_login.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 23, SpringLayout.SOUTH, lblNewLabel_1);
		sl_login.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		sl_login.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -140, SpringLayout.SOUTH, login);
		login.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		sl_login.putConstraint(SpringLayout.NORTH, passwordField, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_login.putConstraint(SpringLayout.WEST, passwordField, 49, SpringLayout.EAST, lblNewLabel_2);
		sl_login.putConstraint(SpringLayout.EAST, passwordField, -18, SpringLayout.EAST, login);
		login.add(passwordField);
		
		textField = new JTextField();
		sl_login.putConstraint(SpringLayout.WEST, textField, 72, SpringLayout.EAST, lblNewLabel_1);
		sl_login.putConstraint(SpringLayout.SOUTH, textField, -12, SpringLayout.NORTH, passwordField);
		sl_login.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, passwordField);
		login.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_login.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, login);
		sl_login.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, login);
		login.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrati");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Registrati r=new Registrati();
				r.setVisible(true);
				
			}
		});
		sl_login.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, btnNewButton);
		sl_login.putConstraint(SpringLayout.EAST, btnNewButton_1, -6, SpringLayout.WEST, btnNewButton);
		login.add(btnNewButton_1);
	}
}

package Cittadino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel login;
	private JPasswordField jpsw;
	private JTextField jemail;

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
		
		jpsw = new JPasswordField();
		sl_login.putConstraint(SpringLayout.NORTH, jpsw, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_login.putConstraint(SpringLayout.WEST, jpsw, 49, SpringLayout.EAST, lblNewLabel_2);
		sl_login.putConstraint(SpringLayout.EAST, jpsw, -18, SpringLayout.EAST, login);
		login.add(jpsw);
		
		jemail = new JTextField();
		sl_login.putConstraint(SpringLayout.WEST, jemail, 72, SpringLayout.EAST, lblNewLabel_1);
		sl_login.putConstraint(SpringLayout.SOUTH, jemail, -12, SpringLayout.NORTH, jpsw);
		sl_login.putConstraint(SpringLayout.EAST, jemail, 0, SpringLayout.EAST, jpsw);
		login.add(jemail);
		jemail.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email= jemail.getText();
				String jpsw=jemail.getText();
				
				String url = "jdbc:postgresql://localhost:5432/CentriVaccinali";
		        String username = "eclipse";
		        String password = "1234";

		        try {
		        	
		            Connection conn = DriverManager.getConnection(url, username, password);
		            Statement stmt = conn.createStatement();
		            
		            ResultSet rs = stmt.executeQuery(""
		            		+ "SELECT * FROM utenti WHERE email='"+email+"' and password='"+password+"'");
		            conn.close();
		            
		            if(!rs.equals("")) {
		            	//TODO 
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "Email o password non corrette");
		            }
		            
		        } catch (SQLException ex) {
		            JOptionPane.showMessageDialog(null, ex);
		        }
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

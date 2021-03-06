package Cittadino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NuovoSintomo extends JFrame {

	private JPanel contentPane;
	private JTextField jnome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuovoSintomo frame = new NuovoSintomo("5");
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
	public NuovoSintomo(String userid) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 251, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Nuovo sintomo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 22, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		jnome = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, jnome, -3, SpringLayout.NORTH, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, jnome, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, jnome, 2, SpringLayout.EAST, lblNewLabel);
		contentPane.add(jnome);
		jnome.setColumns(10);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome= jnome.getText();
				
				String url = "jdbc:postgresql://localhost:5432/CentriVaccinali";
		        String username = "eclipse";
		        String password = "1234";

		        try {
		        	
		            Connection conn = DriverManager.getConnection(url, username, password);
		            Statement stmt = conn.createStatement();
		            
		            String query = "INSERT INTO eventi (nome) VALUES ('"+nome+"');";

		            stmt.executeUpdate(query);
		            JOptionPane.showMessageDialog(null, "Tipo di evento aggiunto");
		            conn.close();
		            
		            setVisible(false);
		            Sintomi s= new Sintomi(userid);
		            s.setVisible(true);
		            
		        } catch (SQLException e1) {
		            JOptionPane.showMessageDialog(null, e1);
		        }
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(btnNewButton);
	}

}

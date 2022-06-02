package Cittadino;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Cittadino {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cittadino window = new Cittadino();
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
	public Cittadino() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 345, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Menu Cittadino");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 224, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Centro vaccinale da consultare");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 21, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, -4, SpringLayout.NORTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 129, SpringLayout.EAST, lblNewLabel_1);
		
		String url = "jdbc:postgresql://localhost:5432/CentriVaccinali";
        String username = "eclipse";
        String password = "1234";
        
        try {
        	
        	Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT nome FROM centrivaccinali");
            
            while(rs.next()) {            	
            	comboBox.addItem(rs.getString("nome"));
            }

            comboBox.setSelectedIndex(-1);
            
            conn.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("Login");
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, comboBox);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registrati");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 0, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 0, SpringLayout.EAST, lblNewLabel);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrati r=new Registrati();
				r.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 46, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Indirizzo:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 6, SpringLayout.SOUTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipologia:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 6, SpringLayout.SOUTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel jnome = new JLabel("ND");
		springLayout.putConstraint(SpringLayout.NORTH, jnome, 0, SpringLayout.NORTH, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.WEST, jnome, 6, SpringLayout.EAST, lblNewLabel_2);
		frame.getContentPane().add(jnome);
		
		JLabel jindirizzo = new JLabel("ND");
		springLayout.putConstraint(SpringLayout.NORTH, jindirizzo, 0, SpringLayout.NORTH, lblNewLabel_3);
		springLayout.putConstraint(SpringLayout.WEST, jindirizzo, 6, SpringLayout.EAST, lblNewLabel_3);
		frame.getContentPane().add(jindirizzo);
		
		JLabel jtipologia = new JLabel("ND");
		springLayout.putConstraint(SpringLayout.NORTH, jtipologia, 0, SpringLayout.NORTH, lblNewLabel_4);
		springLayout.putConstraint(SpringLayout.WEST, jtipologia, 6, SpringLayout.EAST, lblNewLabel_4);
		frame.getContentPane().add(jtipologia);
		
		JButton jcerca = new JButton("Cerca");
		jcerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = comboBox.getSelectedItem().toString();
                try {
                	Connection conn = DriverManager.getConnection(url, username, password);
                    Statement stmt = conn.createStatement();
                	ResultSet rs = stmt.executeQuery("SELECT * FROM centrivaccinali where nome='"+nome+"'");
					
					rs.next();
					jnome.setText(nome);
					jindirizzo.setText(rs.getString("indirizzo"));
					jtipologia.setText(rs.getString("tipologia"));
					
					conn.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, jcerca, 6, SpringLayout.SOUTH, comboBox);
		springLayout.putConstraint(SpringLayout.EAST, jcerca, 0, SpringLayout.EAST, comboBox);
		frame.getContentPane().add(jcerca);
	}
}

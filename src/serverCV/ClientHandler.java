package serverCV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ClientHandler implements Runnable{

	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	private String url = ""; //jdbc:postgresql://localhost:5432/CentriVaccinali
	private String username = ""; //eclipse
	private String password = ""; //1234
	
	private Connection conn;
	
	public ClientHandler(Socket clientSocket, String url, String username, String password) throws IOException {
		this.client=clientSocket;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
        this.url=url;
        this.password=password;
        this.username=username;

	}
	
	@Override
	public void run() {
		try {
			System.out.println("connessione stabilita con un client");
			while(true) {
				
				String request = in.readLine();
				String[] requestArray = request.split("#");
				
				if(requestArray[0].equals("login")) {
					connessioneDB();
					/*String query = "SELECT admin "
							+ "FROM cittadini "
							+ "WHERE mail = " + requestArray[1] + " AND password = " + requestArray[2]; 
					*/
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(requestArray[1]);
					conn.close();
					/*
					while(result.next()) {
						if(result.getBoolean(0)) 	{//true
							//operatore
							
						}else {						//false
							//cittadino
						}
					}*/
					
				}
				else if(requestArray[0].equals("nuovoVaccinato")) {
					connessioneDB();
					Statement statement = conn.createStatement();
					statement.executeUpdate(requestArray[1]);
					conn.close();
				}
				else if(requestArray[0].equals("nuovoCentroVaccinale")) {
					connessioneDB();
					Statement statement = conn.createStatement();
					statement.executeUpdate(requestArray[1]);
					conn.close();
				}
				else if(requestArray[0].equals("registratiACV")) {
					connessioneDB();
					Statement statement = conn.createStatement();
					statement.executeUpdate(requestArray[1]);
					conn.close();
				}
				else if(requestArray[0].equals("cercaInfo")) {
					connessioneDB();
					Statement statement = conn.createStatement();
					statement.executeQuery(requestArray[1]);
					
					
					
					conn.close();
				}
				else if(requestArray[0].equals("inserisciSegnalazione")) {
					connessioneDB();
					Statement statement = conn.createStatement();
					statement.executeUpdate(requestArray[1]);
					conn.close();
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	private void connessioneDB() throws SQLException {
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println("errore di connessione al db");
		}
		
	} 
	
}

package serverCV;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServerCV {
	
	private static final int PORT = 9090;
	
	private static String url = "jdbc:postgresql://localhost:5432/CentriVaccinali";
	private static String username = "eclipse";
	private static String password = "1234";
	
	private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		System.out.println("collegamento al db...");
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
		
			System.out.println("connesso");
		}catch(SQLException e) {
			System.out.print(e);
		}
		
		try {
			ServerSocket listener = new ServerSocket(PORT);
			while (true) {
				Socket client = listener.accept();
				ClientHandler clientThread = new ClientHandler(client);
				clients.add(clientThread);
				System.out.print("connesso");
			}
		}catch (Exception e) {
			System.out.print(e);
		}
		
		
		
	}

}

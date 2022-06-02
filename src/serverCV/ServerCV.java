package serverCV;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ServerCV {
	
	private static final int PORT = 9090;
	
	private static String url = "jdbc:postgresql://localhost:5432/CentriVaccinali";
	private static String username = "eclipse";
	private static String password = "1234";
	
	private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		System.out.println("collegamento al db...");
		
		Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
		
		ServerSocket listener = new ServerSocket(PORT);
		
		while (true) {
			Socket client = listener.accept();
			ClientHandler clientThread = new ClientHandler(client);
			clients.add(clientThread);
		}
		
		
	}

}

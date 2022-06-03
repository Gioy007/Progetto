package serverCV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientHandler implements Runnable{

	private Socket client;
	private BufferedReader in;
	private PrintWriter out;
	
	public ClientHandler(Socket clientSocket) throws IOException {
		this.client=clientSocket;
		in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		out = new PrintWriter(client.getOutputStream(), true);
		
	}
	public void run(Connection conn) {
		try {
			while(true) {
				System.out.println("connessione stabilita con un client");
				String request = in.readLine();
				String[] requestArray = request.split(";");
				
				if(requestArray[0].equals("login")) {
					String query = "SELECT *"
							+ "FROM utenti "
							+ "WHERE email = '" + requestArray[1] + "' AND password = '" + requestArray[2]+"'"; 
					
					Statement statement = conn.createStatement();
					ResultSet result = statement.executeQuery(query);
					
					result.next();
					System.out.println(result.getString("admin"));
					System.out.println(result.getString("userid"));
					out.println(result.getString("admin")+";"+result.getString("userid"));	
					
				}
				else if(requestArray[0].equals("nuovoVaccinato")) {
					
				}
				else if(requestArray[0].equals("nuovoCentroVaccinale")) {
					
				}
				else if(requestArray[0].equals("registratiACV")) {
					
				}
				else if(requestArray[0].equals("cercaInfo")) {
					
				}
				else if(requestArray[0].equals("inserisciSegnalazione")) {
					
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		//mi aspetto le credenziali per il login
		
		//controllo
		
		//mando la response con codice per dire quale finestra aprire(cittadini/operatori)
		
		//attendo nuove disposizioni
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	} 
	
}

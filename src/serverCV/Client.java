package serverCV;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9090;

	public static void main(String[] args) throws IOException{
		Socket socket = new Socket(SERVER_IP, SERVER_PORT);
		
		// da qua è connesso al server
		
				

	}

}

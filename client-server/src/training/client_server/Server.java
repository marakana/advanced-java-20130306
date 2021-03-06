package training.client_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(31337);
			try {
				Socket client = server.accept();
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					try {
						// BEGIN THE INTERESTING PART
						System.out.println(in.readLine());
						// END
					} finally {
						in.close();
					}
				} finally {
					client.close();
				}
			} finally {
				server.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package com.harman.Model;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

import com.harman.utils.ErrorType;

public class TCPStreamingSparkServer {
	
	public ErrorType StartTCPServer() throws IOException {
	 
		  String clientSentence = "Data From Server";
		  String capitalizedSentence;
		  ServerSocket welcomeSocket = new ServerSocket(9999);

		  while (true) {
		   Socket connectionSocket = welcomeSocket.accept();
		   BufferedReader inFromClient =
		   new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		   DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
		   //clientSentence = inFromClient.readLine();
		   //System.out.println("Received: " + clientSentence);
		   capitalizedSentence = clientSentence.toUpperCase() + '\n';
		   outToClient.writeBytes(capitalizedSentence);
		  }
		 }
}

package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkHelper {

    private static final int PORT = 131313;
    private ServerSocket server;
    private Socket waitingClientConnect;
    BufferedReader inputServer;
    BufferedReader inputServerUser;
    PrintWriter    outputServer;

    private Socket client;
    BufferedReader inputClient;
    PrintWriter    outputClient;
    BufferedReader inputUser;

    public void createServerNetworkPlayer() throws IOException {
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port 131313");
            System.exit(-1);
        }

        try {
            System.out.print("Waiting for a client...");
            waitingClientConnect = server.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            System.out.println("Can't accept");
            System.exit(-1);
        }

        inputServer  = new BufferedReader(new InputStreamReader(
                        waitingClientConnect.getInputStream()));
        outputServer = new PrintWriter(waitingClientConnect.getOutputStream(),true);
        inputServerUser = new BufferedReader(new InputStreamReader(System.in));
    }

    public void closeServer() throws IOException {
        outputServer.close();
        inputServer.close();
        waitingClientConnect.close();
        server.close();
    }

    public void createClientNetworkPlayer(String serverIP) throws IOException {
        client = new Socket(serverIP, PORT);
        inputClient  = new BufferedReader(new InputStreamReader(client.getInputStream()));
        outputClient = new PrintWriter(client.getOutputStream(),true);
        inputUser = new BufferedReader(new InputStreamReader(System.in));

    }

    public void closeClient() throws IOException {
        outputClient.close();
        inputClient.close();
        client.close();
        inputUser.close();
    }
}

package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main(String command) throws IOException {
        String serverAddress = "127.0.0.1"; // server ip
        int PORT = 8100; // server port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {

            //request to the server
            if(command.equals("exit")){
                System.out.println("Closing the connection with the server...");
                return;
            }
            out.println(command);
            // Waiting for response from the serve
            String response = in.readLine();
            System.out.println(response);
        } catch (UnknownHostException e) {
            System.err.println("Server not found" + e);
        }
    }
}
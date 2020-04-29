package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.rmi.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void init(String request) throws IOException{
        //setting server address and port
        String serverAddress = "127.0.0.1";
        int PORT  = 8100;

        try(
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                ){
                //request to server
                if(request.equals("exit")){
                    System.out.println("The client is closing...");
                }
                out.println(request);
                //server response
                String response = in.readLine();
                System.out.println(response);

            }
        catch(UnknownHostException e){
            System.err.println(("Server stopped working...\n" + e));
        }
    }
}

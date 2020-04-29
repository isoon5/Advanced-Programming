package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ClientThread extends Thread{
    private Socket socket = null;
    public ClientThread(Socket socket) { this.socket = socket; }
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            PrintWriter out  = new PrintWriter(socket.getOutputStream());

                if (request.equals("stop")) {
                    String response = "The connection is about to be closed...";
                    out.println(response);
                    out.flush();
                    socket.close();

                } else {
                    String response = "The command recieved from the client is: " + request;
                    out.println(response);
                    out.flush();
                }
        }catch(IOException|NullPointerException e){
            System.err.println("Client has disconnected " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

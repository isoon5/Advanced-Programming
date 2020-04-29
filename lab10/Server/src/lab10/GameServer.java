package lab10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;

    public GameServer() throws IOException{
        ServerSocket serverSocket = null;

        try{
            serverSocket = new ServerSocket(PORT);
            while(true){

                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch(IOException e){
            System.err.println(e);
        }finally {
            serverSocket.close();
        }
    }
}

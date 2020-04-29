package lab10;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        GameClient.init("play");
        GameClient.init("connect");
        GameClient.init("invite");
        GameClient.init("exit");
        GameClient.init("stop");


    }
}

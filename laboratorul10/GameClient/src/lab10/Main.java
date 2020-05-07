package lab10;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        GameClient gameClient = new GameClient();
        gameClient.main("test");
        gameClient.main("connect");
        gameClient.main("stop");
        gameClient.main("reconnect");
        gameClient.main("exit");
    }
}
public class Main {
    public static void main(String[] args) {
        Board board = new Board(30);
        Player P1 = new Player("P1", 3, board);
        Player P2 = new Player("P2", 3, board);
        new Thread(P1).start();
        new Thread(P2).start();
    }
}

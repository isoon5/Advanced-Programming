import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Player implements Runnable{
    private String name;
    private int conditionToWin;
    private Board board;
    public List<Token> tokens = new ArrayList<Token>();


    public Player(String name, int conditionToWin, Board board){
        this.name = name;
        this.conditionToWin = conditionToWin;
        this.board = board;
    }

    //functie luata de pe www.geeksforgeeks.org/longest-arithmetic-progression-dp-35/
    //returneaza lungimea celei mai lungi progresii aritmetice si va fi folosita  pentru a afla castigatorul
    public static int lengthOfLongestAP(List<Token> tokens, int n) {
        int L[][] = new int[n][n];
        int llap = 2;

        for (int i = 0; i < n; i++) {
            L[i][n - 1] = 2;
        }

        for (int j = n - 2; j >= 1; j--) {
            int i = j-1, k = j+1;
            while (i >= 0 && k <= n-1) {
                if (tokens.get(i).getNumber() + tokens.get(k).getNumber() < 2 * tokens.get(j).getNumber()) {
                    k++;
                }
                else if (tokens.get(i).getNumber() + tokens.get(k).getNumber() > 2 * tokens.get(j).getNumber()) {
                    L[i][j] = 2;
                    i--;
                }
                else {
                    L[i][j] = L[j][k] + 1;
                    llap = Math.max(llap, L[i][j]);
                    i--;
                    k++;
                }
            }

            while (i >= 0) {
                L[i][j] = 2;
                i--;
            }
        }

        return llap;
    }

    public boolean gameWonBy(){
        if(tokens.size() < conditionToWin){
            return false;
        }

        tokens.sort(Comparator.comparing(Token::getNumber));

        if(lengthOfLongestAP(tokens, tokens.size()) < conditionToWin){
            return false;
        }

        System.out.println(name + " wins." );
        return true;
    }


    @Override
    public void run() {

        Random random = new

    }
}

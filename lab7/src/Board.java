import java.util.*;

public class Board {
    private List<Token> tokens = new ArrayList<Token>();
    private List<Token> synchronizedTokens = Collections.synchronizedList(tokens);
    private boolean playerSwitch = false;

    public Board(int n){
        for(int i = 0; i < n; i++){
            synchronizedTokens.add(new Token(i+1));
        }
    }

    public synchronized int getTokens(int index){
        return synchronizedTokens.get(index).getNumber();
    }



    public synchronized void firstPlayerMoves(int index){
        while(playerSwitch == false){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("First player chose the token with the index: "+index+" with tha value: " + getTokens(index));
        synchronizedTokens.remove(index);
        playerSwitch = true;
        notifyAll();
    }

    public synchronized void secondPlayerMoves(int index){
        while(playerSwitch == true){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Second player chose the token with the index: "+index+" with tha value: " + getTokens(index));
        synchronizedTokens.remove(index);
        playerSwitch = true;
        notifyAll();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Token token : synchronizedTokens){
            sb.append("Token value ");
            sb.append(token.getNumber());
            sb.append("; \n");
        }
           return sb.toString();
    }
}

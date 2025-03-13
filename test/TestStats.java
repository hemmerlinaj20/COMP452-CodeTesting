import java.util.Map;
import java.util.HashMap;

public class TestStats extends GameStats{
    //map a number of guesses to how many times the player won in that number of guesses
    private final Map<Integer, Integer> mapGuessesToFreq;

    //pass in a list of ints representing
    public TestStats(int[] guessesTaken){
        mapGuessesToFreq = new HashMap<>();

        for(int x : guessesTaken){
            int guessesForX = mapGuessesToFreq.getOrDefault(x, 0);

            mapGuessesToFreq.put(x, guessesForX + 1);
        }
    }

    public int numGames(int numGuesses){
        return mapGuessesToFreq.getOrDefault(numGuesses,0);
    }

    public int maxNumGuesses(){
        int maxKey = 0; //zero is a sensible minimum; there's no way to win in less than one guess.
        for(int k : mapGuessesToFreq.keySet()){
            if (k > maxKey){
                maxKey = k;
            }
        }
        return maxKey;
    }
}

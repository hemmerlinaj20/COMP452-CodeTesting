import java.time.LocalDateTime;

public class GameOverPanelHelper {
    public static String getGuessesMessage(GameResult gameResult){
        if(gameResult.numGuesses == 1){
            return (gameResult.humanWasPlaying ? "You" : "I") + " guessed it on the first try!";
        }
        else {
            return "It took " + (gameResult.humanWasPlaying ? "you" : "me") + " " + gameResult.numGuesses + " guesses.";
        }
    }

    public static String[] createRecord(GameResult gameResult){
        String [] record = new String[2];
        record[0] = LocalDateTime.now().toString();
        record[1] = Integer.toString(gameResult.numGuesses);

        return record;
    }
}

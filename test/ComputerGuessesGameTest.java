import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputerGuessesGameTest {
    @Test
    void setUpTest(){
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(1, game.getLowerBound());
        assertEquals(1000, game.getUpperBound());
        assertEquals(501, game.getLastGuess());
        assertEquals(1, game.getNumGuesses());
    }

    void makeGuessTest(){

    }

}

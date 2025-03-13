import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

//using dependency injection
public class HumanGuessesGameTest {

    @Test
    void makeCorrectGuessTest(){
        //using dependency injection
        NotRandom notRandGen = new NotRandom(new ArrayList<Integer>(List.of(777)));
        HumanGuessesGame game = new HumanGuessesGame(notRandGen);

        assertEquals(GuessResult.CORRECT, game.makeGuess(778));
        assertEquals(1, game.getNumGuesses());
        assertTrue(game.isDone());
    }

    @Test
    void makeLowerGuessTest(){
        //using dependency injection
        NotRandom notRandGen = new NotRandom(new ArrayList<Integer>(List.of(777)));
        HumanGuessesGame game = new HumanGuessesGame(notRandGen);

        assertEquals(GuessResult.LOW, game.makeGuess(500));
        assertEquals(1, game.getNumGuesses());
        assertFalse(game.isDone());
    }

    @Test
    void makeHigherGuessTest(){
        //using dependency injection
        NotRandom notRandGen = new NotRandom(new ArrayList<Integer>(List.of(777)));
        HumanGuessesGame game = new HumanGuessesGame(notRandGen);

        assertEquals(GuessResult.HIGH, game.makeGuess(999));
        assertEquals(1, game.getNumGuesses());
        assertFalse(game.isDone());
    }

    @Test
    void multipleGuessesTest(){
        //using dependency injection
        NotRandom notRandGen = new NotRandom(new ArrayList<Integer>(List.of(777)));
        HumanGuessesGame game = new HumanGuessesGame(notRandGen);

        assertEquals(GuessResult.HIGH, game.makeGuess(999));
        assertEquals(1, game.getNumGuesses());
        assertFalse(game.isDone());

        assertEquals(GuessResult.LOW, game.makeGuess(500));
        assertEquals(2, game.getNumGuesses());
        assertFalse(game.isDone());

        assertEquals(GuessResult.CORRECT, game.makeGuess(778));
        assertEquals(3, game.getNumGuesses());
        assertTrue(game.isDone());
    }

}

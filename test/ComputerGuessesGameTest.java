import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * NOTE: Due to the bugs in the guessing and bounds updating, some
 *       of the intended functionality was assumed. The assumed intended
 *       functionality is what is reflected in the tests. Some comments also
 *       note what functionality was assumed to be intended.
 */

public class ComputerGuessesGameTest {
    @Test
    void makesFirstGuessTest(){
        ComputerGuessesGame game = new ComputerGuessesGame(1, 1000);
        assertEquals(1, game.getLowerBound());
        assertEquals(1000, game.getUpperBound());
        assertEquals(501, game.getLastGuess());
        assertEquals(1, game.getNumGuesses()); //Assume the initial guess should count as a guess
    }

    @Test
    void makeNormalGuessTest(){
        ComputerGuessesGame game = new ComputerGuessesGame(1, 1000);
        int numGuesses = game.getNumGuesses();

        assertEquals(501, game.makeGuess());
        assertEquals(numGuesses+1, game.getNumGuesses());
    }


    @Test
    void updateUpperBoundTest(){
        ComputerGuessesGame game = new ComputerGuessesGame(1, 1000);
        int prevGuess = game.makeGuess();
        game.updateBound(true);
        assertEquals(prevGuess-1, game.getUpperBound()); //Upper Bound should be inclusive, and so should be equal to the guess-1
    }

    @Test
    void updateLowerBoundTest(){
        ComputerGuessesGame game = new ComputerGuessesGame(1, 1000);
        int prevGuess = game.makeGuess();
        game.updateBound(false);
        assertEquals(prevGuess+1, game.getLowerBound()); //Lower Bound should be inclusive and so should be equal to the guess+1
    }

    @Test
    void onePossibleAnswer(){
        ComputerGuessesGame game = new ComputerGuessesGame(1000, 1000);
        assertEquals(1000, game.makeGuess()); //Should guess correctly when both bounds are the same
    }

    @Test
    void guessBewtweenBounds(){
        ComputerGuessesGame game = new ComputerGuessesGame(998, 1000);
        assertEquals(999, game.makeGuess()); //Should guess directly between the bounds
    }

    @Test
    void guessUpper(){
        //Assume the intended behavior is to guess the Upper Bound when the bounds are next to each other
        ComputerGuessesGame game = new ComputerGuessesGame(999, 1000);
        assertEquals(1000, game.makeGuess());
    }

    @Test
    void lowerBoundStaysBelowUpperBound(){
        ComputerGuessesGame game = new ComputerGuessesGame(1000, 1000);
        game.updateBound(false);
        assertEquals(1000, game.getLowerBound()); //Lower Bound should not be able to go above upper bound
    }

    @Test
    void upperBoundStaysAboveLowerBound(){
        ComputerGuessesGame game = new ComputerGuessesGame(999, 999);
        game.updateBound(true);
        assertEquals(999, game.getUpperBound()); //Upper Bound should not be able to go below lower bound
    }

    @Test
    void upperBoundUpdatesToLowerBound(){
        ComputerGuessesGame game = new ComputerGuessesGame(999, 1000);
        game.updateBound(true);
        assertEquals(999, game.getUpperBound()); //When bounds are next to each other, an update to upper bound should make it equal to lower bound
    }


}

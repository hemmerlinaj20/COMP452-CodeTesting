import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;


public class GameOverPanelHelperTest {
    @Test
    public void getGuessesMessageTest(){
        GameResult humanIn1 = new GameResult(true, 500, 1);
        String expectation1 = "You guessed it on the first try!";
        assertEquals(expectation1, GameOverPanelHelper.getGuessesMessage(humanIn1));

        GameResult compIn1 = new GameResult(false, 500, 1);
        String expectation2 = "I guessed it on the first try!";
        assertEquals(expectation2, GameOverPanelHelper.getGuessesMessage(compIn1));

        GameResult compIn32 = new GameResult(false, 500, 32);
        String expectation3 = "It took me 32 guesses.";
        assertEquals(expectation3, GameOverPanelHelper.getGuessesMessage(compIn32));

        GameResult humanIn1433541 = new GameResult(true, 500, 1433541);
        String expectation4 = "It took you 1433541 guesses.";
        assertEquals(expectation4, GameOverPanelHelper.getGuessesMessage(humanIn1433541));
    }

    @Test
    public void createRecordTest(){
        LocalDateTime now = LocalDateTime.now();

        GameResult gr1 = new GameResult(true, 500, 99);
        String[] record1 = GameOverPanelHelper.createRecord(gr1);

        LocalDateTime ldt1 = LocalDateTime.parse(record1[0]);
        assertEquals(0,now.until(ldt1, ChronoUnit.SECONDS),1);
        assertEquals("99", record1[1]);

        GameResult gr2 = new GameResult(false, -500, -123);
        String[] record2 = GameOverPanelHelper.createRecord(gr2);

        LocalDateTime ldt2 = LocalDateTime.parse(record2[0]);
        assertEquals(0,now.until(ldt2, ChronoUnit.SECONDS),1);
        assertEquals("-123", record2[1]);
    }
}

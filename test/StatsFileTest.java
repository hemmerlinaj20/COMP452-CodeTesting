import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

//using dependency injection
public class StatsFileTest {

    @Test
    void goodInputNumGames1(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[][] toRead = new String[1][2];
        LocalDateTime date = LocalDateTime.now();
        toRead[0][0] = date.toString();
        toRead[0][1] = "3";
        notCSVReader.setStuffToRead(toRead);

        StatsFile s = new StatsFile(notCSVReader);
        assertEquals(1, s.numGames(3));
    }

    @Test
    void throwsNumberFormatException(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[][] toRead = new String[1][2];
        LocalDateTime date = LocalDateTime.now();
        toRead[0][0] = date.toString();
        toRead[0][1] = "NaN";

        notCSVReader.setStuffToRead(toRead);
        assertThrows(NumberFormatException.class, () -> new StatsFile(notCSVReader));
    }

    @Test
    void DateTimeParseException(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[][] toRead = new String[3][2];
        toRead[0][0] = "NotADate";
        toRead[0][1] = "3";

        notCSVReader.setStuffToRead(toRead);
        assertThrows(DateTimeParseException.class, () -> new StatsFile(notCSVReader));
    }

    @Test
    void goodInputNumGamesMultiple(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[][] toRead = new String[6][2];
        LocalDateTime date = LocalDateTime.now();
        toRead[0][0] = date.toString();
        toRead[0][1] = "3";
        toRead[1][0] = date.toString();
        toRead[1][1] = "2";
        toRead[2][0] = date.toString();
        toRead[2][1] = "1";
        toRead[3][0] = date.toString();
        toRead[3][1] = "3";
        toRead[4][0] = date.toString();
        toRead[4][1] = "1";
        toRead[5][0] = date.toString();
        toRead[5][1] = "1";
        notCSVReader.setStuffToRead(toRead);

        StatsFile s = new StatsFile(notCSVReader);
        assertEquals(2, s.numGames(3));
        assertEquals(1, s.numGames(2));
        assertEquals(3, s.numGames(1));
    }

    @Test
    void maxNumGuessesNoGames(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        notCSVReader.setStuffToRead(null);

        StatsFile s = new StatsFile(notCSVReader);
        assertEquals(0, s.maxNumGuesses());
    }

    @Test
    void maxNumGuessesOneGame(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[][] toRead = new String[1][2];
        LocalDateTime date = LocalDateTime.now();
        toRead[0][0] = date.toString();
        toRead[0][1] = "4";
        notCSVReader.setStuffToRead(toRead);

        StatsFile s = new StatsFile(notCSVReader);
        assertEquals(4, s.maxNumGuesses());
    }

    @Test
    void maxNumGuessesMultipleGames(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[][] toRead = new String[6][2];
        LocalDateTime date = LocalDateTime.now();
        toRead[0][0] = date.toString();
        toRead[0][1] = "3";
        toRead[1][0] = date.toString();
        toRead[1][1] = "2";
        toRead[2][0] = date.toString();
        toRead[2][1] = "1";
        toRead[3][0] = date.toString();
        toRead[3][1] = "3";
        toRead[4][0] = date.toString();
        toRead[4][1] = "1";
        toRead[5][0] = date.toString();
        toRead[5][1] = "1";
        notCSVReader.setStuffToRead(toRead);

        StatsFile s = new StatsFile(notCSVReader);
        assertEquals(3, s.maxNumGuesses());
    }

}

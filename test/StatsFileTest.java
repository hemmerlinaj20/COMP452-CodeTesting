import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//using dependency injection
public class StatsFileTest {

    @Test
    void throwsNoExceptionOnGoodInput(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[][] toRead = new String[3][2];
        toRead[0][0] = "";
        toRead[0][1] = "";
        toRead[1][0] = "";
        toRead[1][1] = "";
        toRead[2][0] = "";
        toRead[2][1] = "";

        notCSVReader.setStuffToRead(toRead);
        // testing here -> Requires Refactor of StatsFile to support test double
    }

    @Test
    void throwsNumberFormatException(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[][] toRead = new String[3][2];
        toRead[0][0] = "";
        toRead[0][1] = "";
        toRead[1][0] = "";
        toRead[1][1] = "";
        toRead[2][0] = "";
        toRead[2][1] = "";

        notCSVReader.setStuffToRead(toRead);
        // testing here -> Requires Refactor of StatsFile to support test double
    }

    @Test
    void DateTimeParseException(){
        //using dependency injection
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[][] toRead = new String[3][2];
        toRead[0][0] = "";
        toRead[0][1] = "";
        toRead[1][0] = "";
        toRead[1][1] = "";
        toRead[2][0] = "";
        toRead[2][1] = "";

        notCSVReader.setStuffToRead(toRead);
        // testing here -> Requires Refactor of StatsFile to support test double
    }

}

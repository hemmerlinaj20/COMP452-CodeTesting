import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatsFileTest {

    @Test
    void throwsNumberFormatException(){
        NotCSVReader notCSVReader = new NotCSVReader(new NotReader());
        String[] toRead = new String[2];
        toRead[0] = "";
        toRead[1] = "";

        notCSVReader.setStuffToRead(toRead);
        // testing here -> Requires Refactor of StatsFile to support test double
    }

}

import com.opencsv.CSVReader;
import java.io.Reader;

//using dependency injection
// Test Double
public class NotCSVReader extends CSVReader {

    private String[][] stuffToRead;
    private int index;

    public NotCSVReader(Reader notReader){
        super(notReader);
        index = 0;
    }

    public void setStuffToRead(String[][] stuffToRead){
        this.stuffToRead = stuffToRead;
    }

    public String[] readNext(){
        if(index >= stuffToRead.length){
            return null;
        }
        String[] toReturn = stuffToRead[index];
        index++;
        return toReturn;
    }

}

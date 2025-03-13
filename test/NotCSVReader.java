import com.opencsv.CSVReader;
import java.io.Reader;

public class NotCSVReader extends CSVReader {

    private String [] stuffToRead;

    public NotCSVReader(Reader notReader){
        super(notReader);
    }

    public void setStuffToRead(String[] stuffToRead){
        this.stuffToRead = stuffToRead;
    }

    public String[] readNext(){
        return stuffToRead;
    }

}

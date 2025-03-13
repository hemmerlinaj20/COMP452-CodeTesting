import java.io.Reader;

//using dependency injection
// Test Double
public class NotReader extends Reader {

    private String toRead;

    public NotReader(){

    }

    @Override
    public int read(char[] cbuf, int off, int len) {
        return 0;
    }

    @Override
    public void close() {

    }

}

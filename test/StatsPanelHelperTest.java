import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StatsPanelHelperTest {
    @Test
    public void getGamesInBinTest() {
        int[] BIN_EDGES = {1, 2, 4, 6, 8, 10, 12, 14};
        int[] gameResults = {10, 11, 10, 1, 100000, 2, 12, 1, 7, 8, 7, 4, 13, 14, 999, 11, 1, 2, 6, 9, 10, 9, 7, 3, 11, 10487, 3, 5, 6};
        TestStats ts = new TestStats(gameResults);

        assertThrows(IndexOutOfBoundsException.class, () -> {StatsPanelHelper.getGamesInBin(ts, -1, BIN_EDGES);});
        assertThrows(IndexOutOfBoundsException.class, () -> {StatsPanelHelper.getGamesInBin(ts, 8, BIN_EDGES);});

        int ones = StatsPanelHelper.getGamesInBin(ts, 0, BIN_EDGES);
        assertEquals(3, ones);

        int twosAndThrees = StatsPanelHelper.getGamesInBin(ts, 1, BIN_EDGES);
        assertEquals(4, twosAndThrees);

        int foursAndFives = StatsPanelHelper.getGamesInBin(ts, 2, BIN_EDGES);
        assertEquals(2, foursAndFives);

        int sixesAndSevens = StatsPanelHelper.getGamesInBin(ts, 3, BIN_EDGES);
        assertEquals(5, sixesAndSevens);

        int eightsAndNines = StatsPanelHelper.getGamesInBin(ts, 4, BIN_EDGES);
        assertEquals(3, eightsAndNines);

        int tensAndElevens = StatsPanelHelper.getGamesInBin(ts, 5, BIN_EDGES);
        assertEquals(6, tensAndElevens);

        int twelvesAndThirteens = StatsPanelHelper.getGamesInBin(ts, 6, BIN_EDGES);
        assertEquals(2, twelvesAndThirteens);

        int fourteenPlus = StatsPanelHelper.getGamesInBin(ts, 7, BIN_EDGES);
        assertEquals(4, fourteenPlus);
    }

    @Test
    public void findBinNameTest(){
        int[] bin_edges = {1, 3, 4, 35, -9, 40};

        assertThrows(IndexOutOfBoundsException.class, () -> {StatsPanelHelper.findBinName( -1, bin_edges);});
        assertThrows(IndexOutOfBoundsException.class, () -> {StatsPanelHelper.findBinName( 6, bin_edges);});

        String name1 = StatsPanelHelper.findBinName(0, bin_edges);
        assertEquals("1-2", name1);

        String name2 = StatsPanelHelper.findBinName(1, bin_edges);
        assertEquals("3", name2);

        String name3 = StatsPanelHelper.findBinName(2, bin_edges);
        assertEquals("4-34", name3);

        String name4 = StatsPanelHelper.findBinName(3, bin_edges);
        assertEquals("35", name4);

        String name5 = StatsPanelHelper.findBinName(4, bin_edges);
        assertEquals("-9-39", name5);

        String name6 = StatsPanelHelper.findBinName(5, bin_edges);
        assertEquals("40 or more", name6);
    }
}

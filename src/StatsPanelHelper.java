public class StatsPanelHelper {
    public static int getGamesInBin(GameStats stats, int binIndex, int[] binEdges){
        final int lowerBound = binEdges[binIndex];
        int numGames = 0;

        if(binIndex == binEdges.length-1){
            // last bin
            // Sum all the results from lowerBound on up
            for(int numGuesses=lowerBound; numGuesses<stats.maxNumGuesses(); numGuesses++){
                numGames += stats.numGames(numGuesses);
            }
        }
        else{
            int upperBound = binEdges[binIndex+1];
            for(int numGuesses=lowerBound; numGuesses <= upperBound; numGuesses++) {
                numGames += stats.numGames(numGuesses);
            }
        }
        return numGames;
    }

    public static String findBinName(int binIndex, int[] binEdges){
        String binName;
        if(binIndex == binEdges.length-1){
            // last bin
            binName = binEdges[binIndex] + " or more";
        }
        else{
            int upperBound = binEdges[binIndex+1] - 1;
            if(upperBound > binEdges[binIndex]){
                binName = binEdges[binIndex] + "-" + upperBound;
            }
            else{
                binName = Integer.toString(binEdges[binIndex]);
            }
        }
        return binName;
    }
}

public class ComputerGuessesGame {
    private int numGuesses;
    private int lastGuess;

    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    public ComputerGuessesGame(int lowerBound, int upperBound){
        numGuesses = 0;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        lastGuess = (lowerBound + upperBound + 1) / 2;
    }

    // TODO: TEST
    public int makeGuess(){
        numGuesses += 1;
        lastGuess = (lowerBound + upperBound + 1) / 2;
        return lastGuess;
    }

    // TODO: TEST
    public void updateBound(Boolean upper){
        if(upper){
            upperBound = Math.min(upperBound, lastGuess);
        }else{
            lowerBound = Math.max(lowerBound, lastGuess + 1);
        }
    }

    public int getLastGuess(){
        return lastGuess;
    }

    public int getNumGuesses(){
        return numGuesses;
    }

    public int getUpperBound(){
        return upperBound;
    }

    public int getLowerBound(){
        return lowerBound;
    }

}

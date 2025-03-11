import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/**
 * UI screen for when the computer is guessing a number
 *
 * Displays the computer's guesses and processes human's answers
 * Tracks the computer's guesses
 *
 * TODO: refactor this class
 */
public class ComputerGuessesPanel extends JPanel {

    private int numGuesses;
    private int lastGuess;

    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    public ComputerGuessesPanel(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback){

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel guessMessage = new JLabel("I guess ___.");
        guessMessage.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(guessMessage);
        guessMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0, 40)));

        JLabel prompt = new JLabel("Your number is...");
        this.add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,10)));

        // Lower Button
        createLowerButton(guessMessage);
        this.add(Box.createRigidArea(new Dimension(0,10)));

        // Correct Button
        JButton correctBtn = new JButton("Equal");
        correctBtn.addActionListener(e -> {
            guessMessage.setText("I guess ___.");

            // Send the result of the finished game to the callback
            GameResult result = new GameResult(false, lastGuess, numGuesses);
            gameFinishedCallback.accept(result);

            CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
            cardLayout.show(cardsPanel, ScreenID.GAME_OVER.name());
        });
        this.add(correctBtn);
        correctBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,10)));

        // higher button
        createHigherButton(guessMessage);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                numGuesses = 0;
                upperBound = 1000;
                lowerBound = 1;

                lastGuess = makeGuess();
                guessMessage.setText("I guess " + lastGuess + ".");
            }
        });
    }

    // TODO: TEST
    private int makeGuess(){
        return (lowerBound + upperBound + 1) / 2;
    }

    // TODO: TEST
    private int updateBound(Boolean upper){
        if(upper){
            return Math.min(upperBound, lastGuess);
        }else{
            return Math.max(lowerBound, lastGuess + 1);
        }
    }

    private void createLowerButton(JLabel guessMessage){
        JButton lowerBtn = new JButton("Lower");
        lowerBtn.addActionListener(e -> {
            upperBound = updateBound(true);

            lastGuess = makeGuess();
            numGuesses += 1;
            guessMessage.setText("I guess " + lastGuess + ".");
        });
        this.add(lowerBtn);
        lowerBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void createHigherButton(JLabel guessMessage){
        JButton higherBtn = new JButton("Higher");
        higherBtn.addActionListener(e -> {
            lowerBound = updateBound(false);

            lastGuess = makeGuess();
            numGuesses += 1;
            guessMessage.setText("I guess " + lastGuess + ".");
        });
        this.add(higherBtn);
        higherBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

}

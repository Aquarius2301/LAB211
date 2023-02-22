import java.util.Random;

public class LuckyNumber {
    private int totalGames, totalGuess, bestGame, luckyNumber, maxNumber;

    /**
     * Constructor
     */
    public LuckyNumber() {
        totalGames = totalGuess = 0;
    }

    /**
     * Play game
     */
    public void play() {
        prepare();
        int guess = 0;
        do {
            guess++;
            System.out.println("Guess " + guess);
            int choose = Validation.getInteger("Enter a number:",
                    "Error! Please enter an integer from 1 to " + maxNumber, 1, maxNumber);
            if (choose < luckyNumber)
                System.out.println("The lucky number is greater than your number!");
            else if (choose > luckyNumber)
                System.out.println("The lucky number is smaller than your number!");
            else {
                System.out.println("You found the lucky number! The lucky number is " + luckyNumber);
                break;
            }
        } while (true);
        totalGuess += guess;
        if (totalGames == 1)
            bestGame = guess;
        else if (guess < bestGame)
            bestGame = guess;
    }

    /**
     * Print out the result
     */
    public void report() {
        System.out.println("Total games   : " + getTotalGames());
        System.out.println("Total guess   : " + getTotalGuess());
        System.out.println("Average guess : " + getAvgGuess());
        System.out.println("Best game     : " + getBestGame());
    }

    /**
     * Finding the lucky number
     */
    private void prepare() {
        totalGames++;
        System.out.println("\n----------- Game " + getTotalGames() + " -----------");
        maxNumber = Validation.getInteger("Enter the maximum number:", "Error! Please enter an integer greater than 0",
                1, Integer.MAX_VALUE);
        Random rand = new Random();
        luckyNumber = rand.nextInt(maxNumber) + 1;
    }

    /**
     * get the total game
     * 
     * @return the total game
     */
    public int getTotalGames() {
        return this.totalGames;
    }

    /**
     * get the total guess
     * 
     * @return the total guess
     */
    public int getTotalGuess() {
        return this.totalGuess;
    }

    /**
     * get the average guess = total guess / total games
     * 
     * @return the average guess
     */
    public double getAvgGuess() {
        double a = getTotalGuess() / (double) getTotalGames();
        long b = Math.round(a * 10);
        return b / 10.0;
    }

    /**
     * get the best game
     * 
     * @return the best game
     */
    public int getBestGame() {
        return this.bestGame;
    }

}

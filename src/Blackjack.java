import java.util.Scanner;
import javax.swing.*;
import java.io.FileReader;

/**
 * Ett koncept av hur man kan göra ett simpelt Blackjack-spel som kan fungera både via konsolen och via
 * ett GUI.
 *
 * <p>Finns många möjligheter att utveckla applikationen, exempelvis att föra någon form av statistik, införa
 * olika regler, språk med mera.
 *
 * @author Kevin Nilsson
 * @since 05/15/2019
 */
public class Blackjack extends JFrame {


    public Blackjack() {

    }

    public void Game() {
        System.out.println("Välkommen till Blackjack!");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        Rules rules = new Rules(playerDeck, playingDeck, dealerDeck);
        Stats stats = new Stats();

        Scanner userInput = new Scanner(System.in);
        stats.readFile();

        while (stats.getPlayerMoney() > 0) {

            double playerMoney = stats.getPlayerMoney();

            boolean endRound = false;
            System.out.println("You have " + playerMoney + " , how much would you like to bet?");

            try {
                stats.setPlayerBet(userInput.nextDouble());
            } catch (Exception e) {
                e.getMessage();
                System.out.println("Write a number please.\n");
                break;
            }
            userInput.nextLine();
            double playerBet = stats.getPlayerBet();

            if (playerBet > playerMoney) {
                System.out.println("You only have " + playerMoney + ", please try again.\n");
            }

            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            //new GUI(playerDeck, dealerDeck);


            while (true) {
                System.out.println("Your hand:");
                System.out.println(playerDeck.toString());
                System.out.println("\nYou hand is valued at: " + playerDeck.cardsValue());

                System.out.println("\nDealers card: " + dealerDeck.getCard(0).toString() + " and [Hidden]\n");
                if (playerDeck.getCard(0).getValue() == playerDeck.getCard(1).getValue()) {
                    rules.split(userInput);
                    endRound = true;
                    break;
                }

                if (playerDeck.cardsValue() == 21) {
                    System.out.println("\nBlackjack!");
                    stats.gameWon(playerBet);
                    endRound = true;
                    break;
                }


                System.out.println("Would you like to (H) Hit or (S) Stand?");
                String response = userInput.nextLine();

                if ((response.equals("H") || response.equals("h") && !endRound)) {
                    playerDeck.draw(playingDeck);
                    System.out.println("You drew: " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());

                    if (playerDeck.cardsValue() > 21) {
                        System.out.println("Bust. You got: " + playerDeck.cardsValue());
                        stats.gameLost(playerBet);
                        endRound = true;
                        break;
                    }
                }
                if (response.equals("S") || response.equals("s")) {
                    System.out.println("You stand.");
                    break;
                }
            }

            if(endRound) {
                break;
            }

            System.out.println("\nDealer cards: " + dealerDeck.toString());

            if (dealerDeck.cardsValue() > playerDeck.cardsValue() && !endRound) {
                System.out.println("\nDealer wins.");
                stats.gameLost(playerBet);
                endRound = true;

            }
            /*
              Dealer draws at 16. Stands at 17.

             */
            while (dealerDeck.cardsValue() < 17 && !endRound) {
                dealerDeck.draw(playingDeck);
                System.out.println("\nDealer draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }

            System.out.println("\nDealers hand is valued at " + dealerDeck.cardsValue());

            if ((dealerDeck.cardsValue() > 21) && !endRound) {
                System.out.println("\nDealer busts! You win!");
                stats.gameWon(playerBet);
                endRound = true;
            }

            if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && !endRound) {
                System.out.println("\nPush");
                stats.setGamesPlayed(1);
                endRound = true;
            }

            if ((playerDeck.cardsValue() > dealerDeck.cardsValue() && !endRound)) {
                System.out.println("\nYou win the hand!");
                stats.gameWon(playerBet);
            } else if (!endRound) {
                System.out.println("\nYou lose the hand.");
                stats.gameLost(playerBet);
            }

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("\nEnd of hand.");
        }
        System.out.println("Game over!");
        System.out.println("\nWin percentage = " + (stats.winPercentage()));
        stats.writeToFile();
        userInput.close();
    }


    public static void main(String[] args) {

        //Blackjack b1 = new Blackjack();
        //b1.Game();
        new GUI();
    }

}

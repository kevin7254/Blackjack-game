import java.text.NumberFormat;
import java.util.Scanner;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * Ett koncept av hur man kan göra ett simpelt Blackjack-spel som kan fungera både via konsolen och via
 * ett GUI.
 *
 * <p>Finns många möjligheter att utveckla applikationen, exempelvis att föra någon form av statistik, införa
 * olika regler, språk med mera.
 *
 *
 *
 * @author Kevin Nilsson
 * @since 05/15/2019
 *
 */
public class Blackjack extends JFrame {


    Blackjack() {

    }

    private void Game() {
        System.out.println("Välkommen till Blackjack!");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();

        new GUI(playingDeck, playerDeck, dealerDeck); /*



        Scanner userInput = new Scanner(System.in);

        while(playerMoney > 0) {

            System.out.println("You have " + playerMoney + " , how much would you like to bet?");
            double playerBet = userInput.nextDouble();
            userInput.nextLine();
            if(playerBet > playerMoney) {
                System.out.println("You only have " + playerMoney + ", please try again.\n");
            }


            while(true) {
                System.out.println("Your hand:");
                System.out.println(playerDeck.toString());
                System.out.println("\nYou hand is valued at: " + playerDeck.cardsValue());

                if(playerDeck.cardsValue() == 21) {
                    System.out.println("\nBlackjack!");
                    playerMoney += playerBet;
                    playerWins += 1;
                    break;
                }


                System.out.println("\nDealers card: " + dealerDeck.getCard(0).toString() + " and [Hidden]\n"); //TODO: om det är kung skriv (10)

                System.out.println("Would you like to (H) Hit or (S) Stand?");
                String response = userInput.nextLine();

                if((response.equals("H") || response.equals("h"))) {

                    if(playerDeck.cardsValue() > 21) {
                        System.out.println("Bust. You got: " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        break;
                    }
                }
                if(response.equals("S") || response.equals("s")) {
                    break;
                }
            }
            System.out.println("\nDealer cards: " + dealerDeck.toString());

            if(dealerDeck.cardsValue() > playerDeck.cardsValue()) {
                System.out.println("\nDealer wins.");
                playerMoney -= playerBet;

            }
            while(dealerDeck.cardsValue() < 17) {
                dealerDeck.draw(playingDeck);
                System.out.println("\nDealer draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }

            System.out.println("\nDealers hand is valued at " + dealerDeck.cardsValue());

            if((dealerDeck.cardsValue() >21)) {
                System.out.println("\nDealer busts! You win!");
                playerMoney += playerBet;
                playerWins += 1;
            }

            if((playerDeck.cardsValue() == dealerDeck.cardsValue() )) {
                System.out.println("\nPush");
            }

            if((playerDeck.cardsValue() > dealerDeck.cardsValue())) {
                System.out.println("\nYou win the hand!");
                playerMoney += playerBet;
                playerWins += 1;
            }

            else if(false) {
                System.out.println("\nYou lose the hand.");
                playerMoney -= playerBet;
            }

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("\nEnd of hand.");
            totalplays += 1;
        }
        System.out.println("Game over!");
        System.out.println("\nWin percentage = " + (playerWins/totalplays));

        userInput.close(); */
    }

    public static void main(String[] args) {

        Blackjack b1 = new Blackjack();
        b1.Game();

    }

}

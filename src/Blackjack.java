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

    Color colorbg = new Color(39,119,20);

    JButton hit	= new JButton("Hit");
    JButton stay = new JButton("Stay");

    public Blackjack() {
        /*
        JLabel lbl1 = new JLabel("");

        //frame
        this.setSize(600, 500);
        this.setTitle("Blackjack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(colorbg);
        this.setLayout(null);

        //buttons
        hit.setBounds(400,400,95,30);
        this.add(hit);
        stay.setBounds(490,400,95,30);
        this.add(stay);
        this.add(lbl1);
        lbl1.setBounds(300,100,100,100);
        this.setVisible(true);

         */
    }

    public void Game() {
        System.out.println("Välkommen till Blackjack!");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();


        double playerMoney = 100.00;
        double totalplays = 0;
        double playerWins = 0;

        Scanner userInput = new Scanner(System.in);

        while(playerMoney > 0) {

            boolean endRound = false;
            System.out.println("You have " + playerMoney + " , how much would you like to bet?");
            double playerBet = userInput.nextDouble();
            userInput.nextLine();
            if(playerBet > playerMoney) {
                System.out.println("You only have " + playerMoney + ", please try again.\n");
            }

            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);

            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);

            new GUI(playerDeck, dealerDeck);


            while(true) {
                System.out.println("Your hand:");
                System.out.println(playerDeck.toString());
                System.out.println("\nYou hand is valued at: " + playerDeck.cardsValue());

                if(playerDeck.cardsValue() == 21) {
                    System.out.println("\nBlackjack!");
                    playerMoney += playerBet;
                    playerWins += 1;
                    endRound = true;
                    break;
                }

                if(endRound) break;

                System.out.println("\nDealers card: " + dealerDeck.getCard(0).toString() + " and [Hidden]\n"); //TODO: om det är kung skriv (10)

                System.out.println("Would you like to (H) Hit or (S) Stand?");
                String response = userInput.nextLine();

                if((response.equals("H") || response.equals("h") && !endRound)) {
                    playerDeck.draw(playingDeck);
                    System.out.println("You drew: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());

                    if(playerDeck.cardsValue() > 21) {
                        System.out.println("Bust. You got: " + playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                if(response.equals("S") || response.equals("s")) {
                    break;
                }
            }
            System.out.println("\nDealer cards: " + dealerDeck.toString());

            if(dealerDeck.cardsValue() > playerDeck.cardsValue() && !endRound) {
                System.out.println("\nDealer wins.");
                playerMoney -= playerBet;
                endRound = true;

            }
            /*
              Dealer draws at 16. Stands at 17.

             */
            while(dealerDeck.cardsValue() < 17 && !endRound) {
                dealerDeck.draw(playingDeck);
                System.out.println("\nDealer draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
            }

            System.out.println("\nDealers hand is valued at " + dealerDeck.cardsValue());

            if((dealerDeck.cardsValue() >21) && !endRound) {
                System.out.println("\nDealer busts! You win!");
                playerMoney += playerBet;
                playerWins += 1;
                endRound = true;
            }

            if((playerDeck.cardsValue() == dealerDeck.cardsValue() ) && !endRound) {
                System.out.println("\nPush");
                endRound = true;
            }

            if((playerDeck.cardsValue() > dealerDeck.cardsValue() && !endRound)) {
                System.out.println("\nYou win the hand!");
                playerMoney += playerBet;
                playerWins += 1;
                endRound = true;
            }

            else if(!endRound) {
                System.out.println("\nYou lose the hand.");
                playerMoney -= playerBet;
                endRound = true;
            }

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("\nEnd of hand.");
            totalplays += 1;
        }
        System.out.println("Game over!");
        System.out.println("\nWin percentage = " + (playerWins/totalplays));

        userInput.close();
    }


    public static void main(String[] args) {

        Blackjack b1 = new Blackjack();
        b1.Game();
    }

}

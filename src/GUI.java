import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

    private Color colorbg = new Color(39,119,20);

    private JButton hit	= new JButton("Hit");
    private JButton stay = new JButton("Stay");

   // private JTextArea textArea = new JTextArea();
    private JTextArea textArea2 = new JTextArea();
    private JTextArea sumBank = new JTextArea();

    private Deck playingDeck;
    private Deck playerDeck;
    private Deck dealerDeck;

    private Stats stats1;

    private boolean endRound = true;

    /**
     * @param playingDeck
     * @param playerDeck
     * @param dealerDeck
     */
    GUI(Deck playingDeck, Deck playerDeck, Deck dealerDeck) {

        this.playerDeck = playerDeck;
        this.dealerDeck = dealerDeck;
        this.playingDeck = playingDeck;

        setFrame();
    }

    private void setFrame() {
        //frame
        this.setSize(600, 500);
        this.setTitle("Blackjack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(colorbg);
        this.setLayout(null);

        //buttons + textarea
        hit.setBounds(400,400,95,30);
        this.add(hit);
        stay.setBounds(490,400,95,30);
        this.add(stay);

        hit.addActionListener(this);
        this.setVisible(true);

        if(endRound) {
            createTextArea(440,300,140,20, true, true);

            textArea2.setBounds(440,280,140,20);
            textArea2.setOpaque(false);
            textArea2.setEditable(false);
            textArea2.setText("How much money?");
            this.add(textArea2);
        }
    }

    private JTextArea createTextArea(int x, int y, int width, int height, boolean opaque, boolean editable) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(x, y, width, height);
        textArea.setOpaque(opaque);
        textArea.setEditable(editable);
        this.add(textArea);
        return textArea;

    }

    private double getWager() {

        endRound = false;
        return Double.parseDouble(createTextArea(440,300,140,20, true, true).getText());
    }

    private void showCards() {

        playerDeck.draw(playingDeck);
        playerDeck.draw(playingDeck);

        dealerDeck.draw(playingDeck);
        dealerDeck.draw(playingDeck);

        /*textArea.setBounds(440,300,140,100);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setText("Your cards - Valued at: " + playerDeck.cardsValue() + playerDeck.toString());
        this.add(textArea); */

        textArea2.setBounds(100,100,300,300);
        textArea2.setOpaque(false);
        textArea2.setEditable(false);
        textArea2.setText("Dealer cards " + dealerDeck.getCard(0).toString() + ", [Hidden]");
        this.add(textArea2);

    }

    private void hitFirst() {
        playerDeck.draw(playingDeck);
        System.out.println("You drew: " + playerDeck.getCard(playerDeck.deckSize()-1).toString());
        //textArea.setText("Your cards - Valued at: " + playerDeck.cardsValue() + playerDeck.toString());

        if(playerDeck.cardsValue() > 21) {
            System.out.println("Bust. You got: " + playerDeck.cardsValue());
            textArea2.setText("Bust. You got: " + playerDeck.cardsValue());
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if((e.getSource() == hit)&& endRound) {
            System.out.println("working");
            endRound = false;
        }
        else if((e.getSource() == hit)&& !endRound) {
            System.out.println("test");
            remove(textArea2);
        }
    }
}


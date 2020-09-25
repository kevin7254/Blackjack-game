import java.awt.*;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame {

    Color colorbg = new Color(39, 119, 20);

    JButton hit = new JButton("Hit");
    JButton stay = new JButton("Stay");

    public GUI(Deck playerDeck, Deck dealerDeck) {

        //JLabel lbl1 = new JLabel(playerDeck.toString()); test
        JTextArea textArea = new JTextArea("Your cards: " + playerDeck.toString());

        JTextArea textArea2 = new JTextArea("Dealer cards " + dealerDeck.getCard(0).toString() + ", [Hidden]");

        //frame
        this.setSize(600, 500);
        this.setTitle("Blackjack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(colorbg);
        this.setLayout(null);

        //buttons
        hit.setBounds(400, 400, 95, 30);
        this.add(hit);
        stay.setBounds(490, 400, 95, 30);
        this.add(stay);
        this.add(textArea);
        textArea.setBounds(440, 350, 100, 100);
        textArea.setOpaque(false);
        textArea.setEditable(false);

        this.add(textArea2);
        textArea2.setBounds(100, 100, 300, 300);
        textArea2.setOpaque(false);
        textArea2.setEditable(false);
        this.setVisible(true);
        System.out.println("test bara");


    }

}


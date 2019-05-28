import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stats {

    private double playerMoney;
    private double playerBet;
    private double playerWins;
    private double gamesPlayed;

    private double totalMoneyBetted;
    private double totalMoneyWon;

    private double totalGamesPlayed;
    private double totalPlayerWins;


    public Stats() {
        this.playerMoney = 100.0;
    }

    public double getPlayerMoney() {
        return playerMoney;
    }

    public double getPlayerBet() {
        return playerBet;
    }

    public void setPlayerBet(double playerBet) {
        this.playerBet = playerBet;
    }


    public void setGamesPlayed(double gamesPlayed) {
        this.gamesPlayed += gamesPlayed;
        this.totalGamesPlayed += gamesPlayed;
    }

    public void gameWon(double i) {
        this.playerMoney += i;
        this.gamesPlayed += 1;
        this.playerWins += 1;
        this.totalPlayerWins += 1;
        this.totalGamesPlayed += 1;
        this.totalMoneyBetted += i;
        this.totalMoneyWon += i;
    }

    public void gameLost(double i) {
        this.playerMoney -= i;
        this.gamesPlayed += 1;
        this.totalGamesPlayed += 1;
        this.totalMoneyBetted += i;
    }

    public double winPercentage() {
        return (this.playerWins / this.gamesPlayed);
    }

    public void writeToFile() { //TODO: fixa all-time stats för resten oxå
        try {
            FileWriter writer = new FileWriter("stats/totalGames.txt");

            writer.write("Total games played: " + this.totalGamesPlayed);
            writer.write("\nTotal games won: " + this.totalPlayerWins);
            writer.write("\nTotal money betted: " + this.totalMoneyBetted);
            writer.write("\nTotal money won: " + this.totalMoneyWon);

            writer.close();
            System.out.println("Success writing");
        } catch (Exception e) {
            e.getStackTrace();

        }
    }

    public void readFile() {
        try {
            FileReader fin = new FileReader("stats/totalGames.txt");
            Scanner scanner = new Scanner(fin);
            List<String> list = new ArrayList<String>();

            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
            this.totalGamesPlayed += Double.parseDouble(list.get(0).replace("Total games played: ", ""));
            this.totalPlayerWins += Double.parseDouble(list.get(1).replace("Total games won: ", ""));
            this.totalMoneyBetted += Double.parseDouble(list.get(2).replace("Total money betted: ", ""));
            this.totalMoneyWon += Double.parseDouble(list.get(3).replace("Total money won: ", ""));
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}

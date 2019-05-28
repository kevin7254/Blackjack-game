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
        this.totalPlayerWins +=1;
        this.totalGamesPlayed += 1;
    }
    public void gameLost(double i){
        this.playerMoney -= i;
        this.gamesPlayed += 1;
        this.totalGamesPlayed += 1;
    }

    public double winPercentage() {
        return (this.playerWins/this.gamesPlayed);
    }
}

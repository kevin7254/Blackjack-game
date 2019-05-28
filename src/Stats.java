public class Stats {

    private double playerMoney;
    private double totalPlays;
    private double playerWins;

    /**
     *
     */
    Stats() {
        this.playerMoney = 100.0;
        this.totalPlays = 0;
        this.playerWins = 0;
    }

    public void setPlayerMoney(double playerMoney) {
        this.playerMoney = playerMoney;
    }

    public void setTotalPlays(double totalPlays) {
        this.totalPlays = totalPlays;
    }

    public void setPlayerWins(double playerWins) {
        this.playerWins = playerWins;
    }

    public double getPlayerMoney() {
        return this.playerMoney;
    }

    public double getPlayerWins() {
        return this.playerWins;
    }

    public double getTotalPlays() {
        return this.totalPlays;
    }
}

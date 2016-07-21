import java.util.List;

public class Player {
    private int score;
    private int totalRuns;
    List<BonusApplier> bonusAppliers;

    public Player(List<BonusApplier> bonusAppliers) {
        this.bonusAppliers = bonusAppliers;
    }

    public int getPoints() {
        return score;
    }

    public void scoreRuns(int runs) {
        totalRuns += runs;
        score += runs;
        for (BonusApplier applier : bonusAppliers){
            score += applier.getApplicableBonus(totalRuns);
        }
    }
}

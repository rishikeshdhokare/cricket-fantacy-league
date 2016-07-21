
public class BonusApplierFor100Runs extends BonusApplier {
    int getBonus() {
        return 40;
    }

    boolean shouldApplyBonus(int runs) {
        return runs >= 100;
    }
}

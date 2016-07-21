
public class BonusApplierForDuck extends BonusApplier {
    int getBonus() {
        return -5;
    }

    boolean shouldApplyBonus(int runs) {
        return runs == 0;
    }
}

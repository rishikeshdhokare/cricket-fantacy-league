/**
 * Created by anujm on 19/7/16.
 */
public class RuleForDuck implements RunsRule {
    @Override
    public int apply(int runs) {
        if (runs ==0) {
            return -5;
        }
        return 0;
    }
}

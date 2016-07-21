/**
 * Created by anujm on 19/7/16.
 */
public class RuleForEachCatch implements CatchRule {
    @Override
    public int apply(int catches) {
        if (catches >= 0) {
            return catches * 10;
        }
        return 0;
    }
}

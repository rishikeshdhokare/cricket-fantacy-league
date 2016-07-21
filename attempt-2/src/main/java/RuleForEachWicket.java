/**
 * Created by anujm on 19/7/16.
 */
public class RuleForEachWicket implements WicketRule {
    @Override
    public int apply(int wickets) {
        if (wickets > 0) {
            return wickets * 40;
        }
        return 0;
    }
}

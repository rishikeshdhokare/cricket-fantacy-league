/**
 * Created by anujm on 19/7/16.
 */
public class RuleForLessThan25 implements RunsRule {
    @Override
    public int apply(int runs) {
        if (runs <25){
            return runs;
        }
        return 0;
    }
}

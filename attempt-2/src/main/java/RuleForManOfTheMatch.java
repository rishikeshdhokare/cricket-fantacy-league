/**
 * Created by anujm on 19/7/16.
 */
public class RuleForManOfTheMatch implements MiscRule {
    @Override
    public int apply(int input) {
        if (input == 1) {
            return 50;
        }
        return 0;
    }
}

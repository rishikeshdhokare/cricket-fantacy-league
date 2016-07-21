
public class RuleFor25Runs implements RunsRule {

    @Override
    public int apply(int runs) {
        if (runs >= 25) {
            return runs + 10;
        }
        return 0;
    }
}

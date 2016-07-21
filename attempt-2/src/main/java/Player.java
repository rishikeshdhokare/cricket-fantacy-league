import java.util.List;

/**
 * Created by anujm on 19/7/16.
 */
public class Player {

    private int runs;
    private int wickets;
    private int catches;
    private boolean isManOfTheMatch;

    private List<RunsRule> runsRules;
    private List<WicketRule> wicketRules;
    private List<CatchRule> catchRules;
    private List<MiscRule> miscRules;

    public Player(int runs, int wickets, int catches, boolean isManOfTheMatch,
                  List<RunsRule> runsRules, List<WicketRule> wicketRules,
                  List<CatchRule> catchRules, List<MiscRule> miscRules) {
        this.runs = runs;
        this.wickets = wickets;
        this.catches = catches;
        this.isManOfTheMatch = isManOfTheMatch;
        this.runsRules = runsRules;
        this.wicketRules = wicketRules;
        this.catchRules = catchRules;
        this.miscRules = miscRules;
    }

    public int calculatePoints() {
        int batsmanPoints = applyRules(runsRules, runs);
        int bowlerPoints = applyRules(wicketRules, wickets);
        int catchPoints = applyRules(catchRules, catches);
        int miscPoints = applyMiscRules(miscRules, isManOfTheMatch);
        return batsmanPoints + bowlerPoints + catchPoints + miscPoints;
    }

    private int applyMiscRules(List<MiscRule> miscRules, boolean input) {
        int points = 0;
        for(MiscRule rule : miscRules) {
            points += rule.apply(input ? 1 : 0);
        }
        return points;
    }

    private int applyRules(List<? extends Rule> rules, int input) {
        int points = 0;
        for (Rule rule : rules) {
            points += rule.apply(input);
        }
        return points;
    }
}

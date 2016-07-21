import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CricketFantasyTest {

    @Test
    public void aPlayerEarns1PointFor1RunScored() {
        //given
        int runsScored = 1;
        int wicketsTaken = 0;
        int catchesTaken = 0;
        boolean isManOfTheMatch = false;

        List<RunsRule> runsRules = Arrays.asList(new RuleForLessThan25());
        List<WicketRule> wicketRules = Collections.emptyList();
        List<CatchRule> catchRules = Collections.emptyList();
        List<MiscRule> miscRule = Collections.emptyList();

        //when
        int points = new Player(runsScored, wicketsTaken, catchesTaken, isManOfTheMatch, runsRules, wicketRules, catchRules, miscRule)
                    .calculatePoints();
        //then
        assertEquals(1, points);
    }

    @Test
    public void aPlayerEarns10BonusPointsFor25RunsScored() throws Exception {
        //given,
        int runsScored = 25;
        int wicketsTaken = 0;
        int catchesTaken = 0;
        boolean isManOfTheMatch = false;

        List<RunsRule> runsRules = Arrays.asList(new RuleFor25Runs());
        List<WicketRule> wicketRules = Collections.emptyList();
        List<CatchRule> catchRules = Collections.emptyList();
        List<MiscRule> miscRule = Collections.emptyList();

        //when
        int points = new Player(runsScored, wicketsTaken, catchesTaken, isManOfTheMatch, runsRules, wicketRules, catchRules, miscRule)
                .calculatePoints();
        //then
        assertEquals(35, points);
    }

    @Test
    public void aPlayerLoses5PointsForScoringDuck() throws Exception {
        //given
        int runsScored = 0;
        int wicketsTaken = 0;
        int catchesTaken = 0;
        boolean isManOfTheMatch = false;

        List<RunsRule> runsRules = Arrays.asList(new RuleForDuck());
        List<WicketRule> wicketRules = Collections.emptyList();
        List<CatchRule> catchRules = Collections.emptyList();
        List<MiscRule> miscRule = Collections.emptyList();

        //when
        int points = new Player(runsScored, wicketsTaken, catchesTaken, isManOfTheMatch, runsRules, wicketRules, catchRules, miscRule)
                .calculatePoints();
        //then
        assertEquals(-5, points);
    }

    @Test
    public void aPlayerEarns40PointsFor1WicketTaken() {
        int wicketsTaken = 1;
        int runsScored = 0;
        int catchesTaken = 0;
        boolean isManOfTheMatch = false;

        List<RunsRule> runsRules = Collections.emptyList();
        List<WicketRule> wicketRules = Arrays.asList(new RuleForEachWicket());
        List<CatchRule> catchRules = Collections.emptyList();
        List<MiscRule> miscRule = Collections.emptyList();

        int points = new Player(runsScored, wicketsTaken, catchesTaken, isManOfTheMatch, runsRules, wicketRules, catchRules, miscRule)
                .calculatePoints();
        assertEquals(40, points);
    }

    @Test
    public void aPlayerEarns20AdditionalPointsFor3WicketsTaken() {
        int wicketsTaken = 3;
        int runsScored = 0;
        int catchesTaken = 0;
        boolean isManOfTheMatch = false;

        List<RunsRule> runsRules = Collections.emptyList();
        List<WicketRule> wicketRules = Arrays.asList(new RuleForEachWicket(), new RuleFor3Wickets());
        List<CatchRule> catchRules = Collections.emptyList();
        List<MiscRule> miscRule = Collections.emptyList();

        int points = new Player(runsScored, wicketsTaken, catchesTaken, isManOfTheMatch, runsRules, wicketRules, catchRules, miscRule)
                .calculatePoints();
        assertEquals(140, points);
    }

    @Test
    public void aPlayerEarnsPointsForBattingAndBowling() {
        int wicketsTaken = 3;
        int runsScored = 26;
        int catchesTaken = 0;
        boolean isManOfTheMatch = false;

        List<RunsRule> runsRules = Arrays.asList(new RuleForDuck(), new RuleForLessThan25(), new RuleFor25Runs());
        List<WicketRule> wicketRules = Arrays.asList(new RuleForEachWicket(), new RuleFor3Wickets());
        List<CatchRule> catchRules = Collections.emptyList();
        List<MiscRule> miscRule = Collections.emptyList();

        int points = new Player(runsScored, wicketsTaken, catchesTaken, isManOfTheMatch, runsRules, wicketRules, catchRules, miscRule)
                .calculatePoints();
        assertEquals(176, points);
    }

    @Test
    public void aPlayerEarns10PointsForTakingACatch() {
        int wicketsTaken = 0;
        int runsScored = 0;
        int catchesTaken = 4;
        boolean isManOfTheMatch = false;

        List<RunsRule> runsRules = Collections.emptyList();
        List<WicketRule> wicketRules = Collections.emptyList();
        List<CatchRule> catchRules = Arrays.asList(new RuleForEachCatch());
        List<MiscRule> miscRule = Collections.emptyList();

        int points = new Player(runsScored, wicketsTaken, catchesTaken, isManOfTheMatch, runsRules, wicketRules, catchRules, miscRule)
                .calculatePoints();
        assertEquals(40, points);
    }

    @Test
    public void aPlayerEarns50PointsIfHeIsManOfTheMatch() {
        int wicketsTaken = 0;
        int runsScored = 0;
        int catchesTaken = 0;
        boolean isManOfTheMatch = true;

        List<RunsRule> runsRules = Collections.emptyList();
        List<WicketRule> wicketRules = Collections.emptyList();
        List<CatchRule> catchRules = Collections.emptyList();
        List<MiscRule> miscRule = Arrays.asList(new RuleForManOfTheMatch());

        int points = new Player(runsScored, wicketsTaken, catchesTaken, isManOfTheMatch, runsRules, wicketRules, catchRules, miscRule)
                .calculatePoints();
        assertEquals(50, points);
    }
}

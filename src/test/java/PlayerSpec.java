import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerSpec {

    private Player player;
    private List<BonusApplier> bonusAppliers;

    @Before
    public void setUp() throws Exception {
        bonusAppliers = Arrays.asList(new BonusApplierFor25Runs(), new BonusApplierFor50Runs(),
                new BonusApplierFor75Runs(), new BonusApplierFor100Runs(), new BonusApplierForDuck());
        player = new Player(bonusAppliers);
    }

    @Test
    public void playerShouldHaveInitialPointsAsZero(){

        assertEquals(0, player.getPoints());
    }

    @Test
    public void playerShouldEarn1PointFor1RunScored(){
        player.scoreRuns(1);
        assertEquals(1, player.getPoints());
        player.scoreRuns(1);
        assertEquals(2, player.getPoints());
    }

    @Test
    public void playerShouldEarn10BonusPointsForFirst25Runs(){
        player.scoreRuns(24);
        assertEquals(24, player.getPoints());
        player.scoreRuns(1);
        assertEquals(35, player.getPoints());
    }

    @Test
    public void playerShouldEarn25BonusPointsForFirst50Runs(){
        player.scoreRuns(49);
        assertEquals(59, player.getPoints());
        player.scoreRuns(1);
        assertEquals(85, player.getPoints());
    }

    @Test
    public void playerShouldEarn20PointsForFirst75Runs(){
        player.scoreRuns(74);
        assertEquals(109, player.getPoints());
        player.scoreRuns(1);
        assertEquals(130, player.getPoints());
    }


    @Test
    public void playerShouldLost5PointsForDuck(){
        player.scoreRuns(0);
        assertEquals(-5, player.getPoints());
    }
}

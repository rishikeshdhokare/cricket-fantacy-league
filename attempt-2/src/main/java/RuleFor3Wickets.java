/**
 * Created by anujm on 19/7/16.
 */
public class RuleFor3Wickets  implements WicketRule{
    @Override
    public int apply(int wickets) {
        if(wickets == 3){
            return 20;
        }
        return 0;
    }
}

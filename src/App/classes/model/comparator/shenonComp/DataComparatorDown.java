package App.classes.model.comparator.shenonComp;

import App.classes.model.POJO.Data;
import App.classes.model.comparator.BaseComparator;

import java.util.Comparator;

/**
 * Created by Arthur 29.11.2017 19:05.
 */
public class DataComparatorDown extends BaseComparator<Data> {

    @Override
    public int compare(Data o1, Data o2) {
        if (o1.getChance() <= o2.getChance())
            return 1;
        else
            return -1;
    }
}

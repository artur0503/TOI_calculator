package App.core.classes.model.comparator.shenonComp;

import App.core.classes.model.POJO.Data;
import App.core.classes.model.comparator.BaseComparator;

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

package App.core.classes.model.comparator.huffmanComp;

import App.core.classes.model.comparator.BaseComparator;
import App.core.classes.model.models.DataDraw;

public class DataDrawComporatorDown extends BaseComparator<DataDraw> {
    @Override
    public int compare(DataDraw o1, DataDraw o2) {
        if (o1.getChance() <= o2.getChance())
            return 1;
        else
            return -1;
    }
}

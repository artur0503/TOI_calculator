package App.core.classes.model.comparator.huffmanComp;

import App.core.classes.model.POJO.Data;
import App.core.classes.model.comparator.BaseComparator;

/**
 * Created by Arthur 29.11.2017 19:05.
 */
public class IndexComparatorDown extends BaseComparator<Data> {

    @Override
    public int compare(Data o1, Data o2) {
        if (o1.getIndex() < o2.getIndex())
            return 1;
        else
            return -1;
    }
}
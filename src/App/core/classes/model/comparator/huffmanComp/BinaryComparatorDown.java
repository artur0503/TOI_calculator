package App.core.classes.model.comparator.huffmanComp;

import App.core.classes.model.comparator.BaseComparator;
import App.core.classes.model.models.Data;

public class BinaryComparatorDown extends BaseComparator<Data> {
    @Override
    public int compare(Data o1, Data o2) {
        if (o1.getCodeBinary().length() > o2.getCodeBinary().length())
            return 1;
        else
            return -1;
    }
}

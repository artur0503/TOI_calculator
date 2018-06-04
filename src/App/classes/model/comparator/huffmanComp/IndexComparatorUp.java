package App.classes.model.comparator.huffmanComp;

import App.classes.model.POJO.Data;

import java.util.Comparator;

/**
 * Created by Arthur 29.11.2017 19:05.
 */
public class IndexComparatorUp implements Comparator<Data> {

    @Override
    public int compare(Data o1, Data o2) {
        if (o1.getIndex() < o2.getIndex())
            return 1;
        else
            return -1;
    }
}

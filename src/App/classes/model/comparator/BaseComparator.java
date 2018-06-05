package App.classes.model.comparator;

import java.util.Comparator;

public abstract class BaseComparator<T> implements Comparator<T> {

    @Override
    public abstract int compare(T o1, T o2);

}

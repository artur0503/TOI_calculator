package App.classes.model.comparator.huffmanComp;

import App.classes.model.POJO.Node;
import App.classes.model.comparator.BaseComparator;

/**
 * Created by Arthur 29.11.2017 19:05.
 */
public class NodeComparatorUp extends BaseComparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        if (o1.getData().getChance() > o2.getData().getChance())
            return 1;
        else
            return -1;
    }
}

package App.classes.model.core.coding;

import App.classes.model.comparator.huffmanComp.DataComparatorUp;
import App.classes.model.comparator.huffmanComp.IndexComparatorDown;
import App.classes.model.comparator.huffmanComp.NodeComparatorUp;
import App.classes.model.POJO.Data;
import App.classes.model.POJO.Node;
import App.interfaces.model.coding.ModelCodingTree;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by Artur 26.03.2018
 */
public class Huffman implements ModelCodingTree {

    private LinkedList<Data> list = new LinkedList<>();
    private LinkedList<Data> listOld = new LinkedList<>();
    private LinkedList<Node> listNode = new LinkedList<>();
    private Node root;

    @Override
    public LinkedList<Data> dataForDrawing() {
        return list;
    }

    @Override
    public LinkedList<Data> dataResult() {
        return listOld;
    }

    @Override
    public void create(LinkedList<Data> list) {
        this.list = list;
    }

    @Override
    public void sortCh() {
        list.sort(new DataComparatorUp());
    }

    @Override
    public void sortInd() {
        list.sort(new IndexComparatorDown());
    }

    private void sortNode(){
        listNode.sort(new NodeComparatorUp());
    }

    @Override
    public boolean check() {
        return !(sum(list) != 1);
    }

    /**SUM OF CHANCES**/
    private double sum(LinkedList<Data> list){
        double sum = 0;
        for (Data aList : list) {
            sum = sum + aList.getChance();
            sum = new BigDecimal(sum).setScale(4, RoundingMode.HALF_UP).doubleValue();
        }
        return sum;
    }

    @Override
    public void tree() {
            while (!list.isEmpty()){
                listOld.add(list.getFirst());
                listNode.add(new Node(list.poll()));
            }
            growTree(listNode);
            giveCode(root);
    }

    @Override
    public void showConsole() {
        for (int i = 0; i < dataResult().size(); i++) {
            double chance = new BigDecimal((dataResult().get(i).getChance()))
                    .setScale(4, RoundingMode.HALF_UP)
                    .doubleValue();
            System.out.println(dataResult().get(i).getNameS()
                    + " (" + chance + ") "
                    + ": " + dataResult().get(i).getCodeBinary());
        }
    }

    private void growTree(LinkedList<Node> listNode){
        double sumCh;
        String sumN;
        while (listNode.size() != 1){
            Node node = new Node(new Node.Left(listNode.get(1)), new Node.Right(listNode.get(0)));

            sumN = listNode.get(0).getData().getNameS() + listNode.get(1).getData().getNameS();

            sumCh = Objects.requireNonNull(listNode.poll()).getData().getChance() + listNode.getFirst().getData().getChance();

            node.setData(new Data(sumCh, sumN, listNode.getLast().getData().getIndex() + 1));
            listNode.removeFirst();
            sortNode();
            listNode.add(node);
            sortNode();
            if (listNode.size() == 1){ root = listNode.getLast(); }
        }
    }

    private void giveCode(Node node){
        if (node.getRight() != null){
            node.getRight().getNode().getData().setCodeBinary(node.getData().getCodeBinary() + "0");
            giveCode(node.getRight().getNode());
        }

        list.add(node.getData());

        if (node.getLeft() != null){
            node.getLeft().getNode().getData().setCodeBinary(node.getData().getCodeBinary() + "1");
            giveCode(node.getLeft().getNode());
        }
    }
}

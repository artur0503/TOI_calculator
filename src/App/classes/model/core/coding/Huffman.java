package App.classes.model.core.coding;

import App.classes.model.comparator.huffmanComp.DataComparatorUp;
import App.classes.model.comparator.huffmanComp.IndexComparatorDown;
import App.classes.model.comparator.huffmanComp.NodeComparatorUp;
import App.classes.model.POJO.Data;
import App.classes.model.POJO.Node;
import App.interfaces.model.coding.ModelCodingTree;

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
        return null;
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
        double sum = 0;
        if (!list.isEmpty()) {
            for (Data aList : list) {
                sum = sum + aList.getChance();
            }
        }else {
            for (Data aList : listOld) {
                sum = sum + aList.getChance();
            }
        }
        return !(sum != 100);
    }

    @Override
    public void tree() {
//        if(check()){
            while (!list.isEmpty()){
                listOld.add(list.getFirst());
                listNode.add(new Node(list.poll()));
            }
            growTree(listNode);
            giveCode(root);
//        }else
//            System.out.println("ERROR (SUM < 1)");
    }

    @Override
    public void showConsole() {
        for (Data aListOld : listOld) {
            System.out.println(aListOld.getNameS() + " (" + aListOld.getChance() + ") " + ": " + aListOld.getCode());
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
            node.getRight().getNode().getData().setCode(node.getData().getCode() + "0");
            giveCode(node.getRight().getNode());
        }

        list.add(node.getData());

        if (node.getLeft() != null){
            node.getLeft().getNode().getData().setCode(node.getData().getCode() + "1");
            giveCode(node.getLeft().getNode());
        }
    }
}

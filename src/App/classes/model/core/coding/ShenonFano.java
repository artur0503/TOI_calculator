package App.classes.model.core.coding;

import App.classes.model.comparator.shenonComp.DataComparatorDown;
import App.classes.model.comparator.shenonComp.IndexComparatorUp;
import App.classes.model.POJO.Data;
import App.classes.model.POJO.Node;
import App.interfaces.model.coding.ModelCodingTree;

import java.util.LinkedList;

/**
 * Created by Arthur 29.11.2017 19:44.
 */
public class ShenonFano implements ModelCodingTree {

    private LinkedList<Data> list = new LinkedList<>();
    private LinkedList<Data> oldList = new LinkedList<>();
//    private int k = 0;
    private int index;

    /**GET DATA FOR DRAWING TREE**/
    @Override
    public LinkedList<Data> dataForDrawing() {
        return list;
    }

    /**GET DATA WITH RESULT**/
    @Override
    public LinkedList<Data> dataResult() {
        return makeDataResult();
    }

    private LinkedList<Data> makeDataResult(){
        for (Data anOldList : oldList) {
            for (Data aList : list) {
                if (anOldList.getNameS().equals(aList.getNameS())) {
                    anOldList.setCode(aList.getCode());
                }
            }
        }
        return oldList;
    }

    /**CREATE**/
    @Override
    public void create(LinkedList<Data> list) {
        this.list = list;
    }

    /**SORTING**/
    @Override
    public void sortCh(){
        list.sort(new DataComparatorDown());
    }

    /**SORTING**/
    @Override
    public void sortInd(){
        list.sort(new IndexComparatorUp());
    }

//    /**ADDING INT**/
//    @Override
//    public void add(int chance, int name){
//        list.add(new Data(chance, name, k++));
//    }
//
//    /**ADDING STRING**/
//    @Override
//    public void add(double chance, String name){
//        list.add(new Data(chance, name, k++));
//    }

    /**SHOW**/
    @Override
    public void showConsole(){
        sortCh();
        for (int i = 0; i < dataResult().size(); i++) {
            System.out.println(dataResult().get(i).getNameS() + " (" + dataResult().get(i).getChance() + ") " + ": " + dataResult().get(i).getCode());
        }
    }

    /**CHECK**/
    @Override
    public boolean check(){
        double sum = 0;
        for (Data aList : list) {
            sum = sum + aList.getChance();
        }
        return !(sum != 100);
    }

    /**CREATE TREE**/
    @Override
    public void tree(){
        if (check()){
            oldList.addAll(list);
            Node root = new Node(convertToData(list));
            divide(list, root);
            list.clear();
            giveCode(root);
        }else
            System.out.println("ERROR (SUM < 1)");
    }


    /**GIVE A CODE**/
    private void giveCode(Node node){
        if (node.getLeft() != null){
            node.getLeft().getNode().getData().setCode(node.getData().getCode() + "0");
            giveCode(node.getLeft().getNode());
        }

        list.add(node.getData());

        if (node.getRight() != null){
            node.getRight().getNode().getData().setCode(node.getData().getCode() + "1");
            giveCode(node.getRight().getNode());
        }
    }

    /**SUM OF CHANCES**/
    private double sum(LinkedList<Data> list){
        double sum = 0;
        for (Data aList : list) {
            sum = sum + aList.getChance();
        }
        return sum;
    }

    /**CONVERT DATA TO EXECUTE**/
    private Data convertToData(LinkedList<Data> list) {
        double sumChance = 0;
        StringBuilder sumName = new StringBuilder();

        for (Data aList : list) {
            sumName.append(aList.getNameS());
            sumChance = sumChance + aList.getChance();
        }
        return new Data(sumChance, sumName.toString(), index++);
    }

    /**DIVIDE**/
    private void divide(LinkedList<Data> list, Node node){
        try {
            LinkedList<Data> left = new LinkedList<>();
            LinkedList<Data> right = new LinkedList<>();

            double mid = Math.round((sum(list) / 2) * 100) / 100.0d;
            double ind = mid;
            double n = mid - list.getLast().getChance();
            double indT;

            for (Data aList : list) {
                indT = ind;
                ind = Math.abs(ind - aList.getChance());
                if (indT < ind) {
                    ind = indT;
                    ind = Math.round(ind * 100) / 100.0d;
                    break;
                }
            }

            if (n <= 0) {
                right.add(list.getLast());
                left.add(list.getFirst());
            }
            else {
                right.add(list.getLast());
                for (int i = list.size() - 2; i >= 0; i--) {
                    double e1 = (Math.round((sum(right) + list.get(i).getChance()) * 100) / 100.0d);
                    double e2 = (Math.round((mid + ind) * 100) / 100.0d);
                    if (e1 <= e2) {
                        right.add(list.get(i));
                    } else {
                        left.add(list.get(i));
                    }
                }
            }
            if (right.isEmpty()){
                right.add(left.pollLast());
            }
            if (left.isEmpty()){
                left.add(right.pollLast());
            }

            right.sort(new IndexComparatorUp());
            right.sort(new DataComparatorDown());
            left.sort(new IndexComparatorUp());
            left.sort(new DataComparatorDown());

            node.setLeft(new Node.Left(new Node(convertToData(left))));

            node.setRight(new Node.Right(new Node(convertToData(right))));

            if (left.size() > 1)
                divide(left, node.getLeft().getNode());


            if (right.size() > 1)
                divide(right, node.getRight().getNode());

//            //вывод на консоль-----------------------------------------
//            System.out.println("\n");
//
//            for (Data aLeft : left) {
//                System.out.print(aLeft.getIndex() + " ");
//            }
//
//            System.out.print("      ");
//
//            for (Data aRight : right) {
//                System.out.print(aRight.getIndex() + " ");
//            }

//            System.out.println(sum(left));
//            System.out.println(sum(right));
//            //--------------------------------------------------------
        }catch (Exception ignored){

        } catch (OutOfMemoryError e){
            System.out.println("ERROR");
        }
    }

}

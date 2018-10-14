package App.core.classes.model.logic.coding;

import App.core.classes.model.comparator.shenonComp.DataComparatorDown;
import App.core.classes.model.comparator.shenonComp.IndexComparatorUp;
import App.core.classes.model.models.Data;
import App.core.classes.model.models.Node;
import App.core.interfaces.model.coding.ModelCodingTree;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

/**
 * Created by Arthur 29.11.2017 19:44.
 */
public class ShenonFano implements ModelCodingTree {

    private LinkedList<Data> list;
    private LinkedList<Data> oldList = new LinkedList<>();
    private int index;

    /**GET DATA FOR DRAWING TREE**/
    @Override
    public LinkedList<String[]> dataForDrawing() {
        return drawingData(oldList);
    }

    private LinkedList<String[]> drawingData(LinkedList<Data> listData){
        LinkedList<String[]> drawer = new LinkedList<>();
        int max = 0;
        for (Data data : listData){
            int temp = data.getCodeBinary().split("").length;
            if (temp >= max)
                max = temp;
        }
        int j = 0;
        while (drawer.size() != max) {
            String[] arr = new String[listData.size()];
            for (int i = 0; i < listData.size(); i++) {
                try {
                    arr[i] = listData.get(i).getCodeBinary().split("")[j];
                }
                catch (ArrayIndexOutOfBoundsException exp){
                    arr[i] = "";
                }
            }
            j++;
            drawer.add(arr);
        }
        for (String[] str : drawer){
            for (String s : str){
                System.out.print(s);
            }
            System.out.println();
        }
        return drawer;
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
                    anOldList.setCodeBinary(aList.getCodeBinary());
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

    /**SHOW**/
    @Override
    public void showConsole(){
        sortCh();
        for (int i = 0; i < dataResult().size(); i++) {
            double chance = new BigDecimal((dataResult().get(i).getChance()))
                    .setScale(4, RoundingMode.HALF_UP)
                    .doubleValue();
            System.out.println(dataResult().get(i).getNameS()
                    + " (" + chance + ") "
                    + ": " + dataResult().get(i).getCodeBinary());
        }
    }

    /**CHECK**/
    @Override
    public boolean check(){
        return !(sum(list) != 1);
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
            node.getLeft().getNode().getData().setCodeBinary(node.getData().getCodeBinary() + "0");
            giveCode(node.getLeft().getNode());
        }

        list.add(node.getData());

        if (node.getRight() != null){
            node.getRight().getNode().getData().setCodeBinary(node.getData().getCodeBinary() + "1");
            giveCode(node.getRight().getNode());
        }
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

            double mid = Math.round((sum(list) / 2) * 1000) / 1000.0d;
            double ind = mid;
            double n = mid - list.getLast().getChance();
            double indT;

            for (Data aList : list) {
                indT = ind;
                ind = Math.abs(ind - aList.getChance());
                if (indT < ind) {
                    ind = indT;
                    ind = Math.round(ind * 1000) / 1000.0d;
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
                    double e1 = (Math.round((sum(right) + list.get(i).getChance()) * 1000) / 1000.0d);
                    double e2 = (Math.round((mid + ind) * 1000) / 1000.0d);
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

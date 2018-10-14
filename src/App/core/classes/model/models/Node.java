package App.core.classes.model.models;

/**
 * Created by Arthur 20.03.2018 18:47.
 */
public class Node {

    private Data data;
    private Left left;
    private Right right;

//    public Node() {
//    }

    public Node(Data data) {
        this.data = data;
    }

//    public Node(Data data, Left left, Right right) {
//        this.data = data;
//        this.left = left;
//        this.right = right;
//    }

    public Node(Left left, Right right) {
        this.left = left;
        this.right = right;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Left getLeft() {
        return left;
    }

    public Right getRight() {
        return right;
    }

    public void setLeft(Left left) {
        this.left = left;
    }

    public void setRight(Right right) {
        this.right = right;
    }

    public static class Left {

        private Node node;

        public Left(Node node) {
            this.node = node;
        }

        public Node getNode() {
            return node;
        }
    }

    public static class Right {

        private Node node;

        public Right(Node node) {
            this.node = node;
        }

        public Node getNode() {
            return node;
        }
    }

}

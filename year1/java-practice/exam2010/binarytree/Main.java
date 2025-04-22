package exam2010.binarytree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        for (Integer i : tree) {
            System.out.print(i + " ");
        }

        System.out.println();
    }
}

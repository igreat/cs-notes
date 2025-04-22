package exam2010.binarytree;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    private static class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        public Node(E value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }
        if (value.compareTo(node.value) < 0) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null) {
            return false;
        }
        if (value.compareTo(node.value) == 0) {
            return true;
        }
        if (value.compareTo(node.value) < 0) {
            return contains(node.left, value);
        }
        return contains(node.right, value);
    }

    public Iterator<T> iterator() {
        return new BinaryTreeIterator();
    }

    private class BinaryTreeIterator implements Iterator<T> {
        private Node<T> current;
        private Stack<Node<T>> stack;

        public BinaryTreeIterator() {
            current = root;
            stack = new Stack<>();
        }

        public boolean hasNext() {
            return current != null || !stack.isEmpty();
        }

        public T next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            T value = current.value;
            current = current.right;
            return value;
        }
    }
}

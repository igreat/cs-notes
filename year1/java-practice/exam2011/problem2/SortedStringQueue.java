package exam2011.problem2;

import java.util.ArrayList;
import java.util.List;

public class SortedStringQueue {
    private List<String> queue;

    public SortedStringQueue() {
        queue = new ArrayList<>();
    }

    public String get() throws SortedStringQueueException {
        if (queue.isEmpty()) {
            throw new SortedStringQueueException("Cannot get from an empty queue");
        }
        return queue.removeLast();
    }

    public void add(String item) {
        for (int i = 0; i < queue.size(); i++) {
            if (item.compareTo(queue.get(i)) < 0) {
                queue.add(i, item);
                return;
            }
        }
        queue.add(item);
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        SortedStringQueue queue = new SortedStringQueue();
        queue.add("3");
        queue.add("2");
        queue.add("5");
        queue.add("1");
        queue.add("4");
        // queue now contains 1, 2, 3, 4, 5, and thus it should get in order 5 4 3 2 1
        while (!queue.isEmpty()) {
            try {
                System.out.print(queue.get() + " ");
            } catch (SortedStringQueueException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
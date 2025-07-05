import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class JavaCollections {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(1);
        set.add(2);
        set.add(99);

        Map<String, Integer> map = new HashMap<>(); // HashTable --> Unsorted
        Map<Integer, String> map2 = new TreeMap<>(); // Tree Form --> Sorted
        map.put("Arpit", 1);
        map.put("Santrup", 2);
        map.put("Palak", 3);
        System.out.println(map.get("Arpit"));
        map2.put(1, "Arpit");
        map2.put(2, "Santrup");
        map2.put(3, "Palak");
        map2.put(4, "Raj");

        Queue<String> queue = new LinkedList<>();
        queue.add("task1");
        queue.add("task2");
        queue.add("task3");
        queue.add("task4");
        System.out.println(queue.poll());

        Stack<String> stack = new Stack<>();
        stack.add("task1");
        stack.add("task2");
        stack.add("task3");
        stack.add("task4");

        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);

//        System.out.println(arr);
//        System.out.println(set);
//        System.out.println(map);
//        System.out.println(map2);
//        System.out.println(queue);
//        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(deque);
    }
}

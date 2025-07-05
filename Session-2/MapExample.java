import java.util.*;

public class MapExample {
    public static void main(String[] args) {
	    ArrayList<Integer>arr = new ArrayList<>(Arrays.asList(4, 7, 1, 2, 99, 3, 5, 8, 9, 10, 99));
	    Map<Integer, Integer>map = new WeakHashMap<>();
	    for(Integer a: arr) {
	        if(map.containsKey(a)) {
	            map.put(a, map.get(a)+1);
	        } else {
	            map.put(a, 1);
	        }
	    }
	    System.out.println(map);
	}
}

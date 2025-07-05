import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "eeat";
        String str2 = "teea";
        System.out.println(isTwoStringAnagram(str1, str2));
    }

    private static boolean isTwoStringAnagram(String str1, String str2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        if(str1.length() != str2.length()) {
            return false;
        }

        for(int i=0; i<str1.length(); i++) {
            if(map1.containsKey(str1.charAt(i))) {
                map1.put(str1.charAt(i), map1.get(str1.charAt(i))+1);
            } else {
                map1.put(str1.charAt(i), 1);
            }
        }

        for(int i=0; i<str2.length(); i++) {
            if(map2.containsKey(str2.charAt(i))) {
                map2.put(str2.charAt(i), map1.get(str2.charAt(i))+1);
            } else {
                map2.put(str2.charAt(i), 1);
            }
        }
        if(map1.size() == map2.size()) {
            return true;
        }
        return false;
    }
}

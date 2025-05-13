import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.sort;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            sort(chars);
            String sorted = new String(chars);

            if (!groups.containsKey(sorted)) {
                groups.put(sorted, new ArrayList<>());
            }

            groups.get(sorted).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : groups.keySet()) {
            result.add(groups.get(key));
        }

        return result;
    }
}

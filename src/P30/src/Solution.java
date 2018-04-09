import java.util.*;

class Solution {

    public void initMap(String[] words, Map<String, Integer> map) {
        for (int i = 0;i < words.length;i++) {
            if (map.containsKey(words[i])) map.put(words[i], map.get(words[i]) + 1);
            else map.put(words[i], 1);
        }

    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Integer> tmp = new HashMap<String, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int length = words[0].length();

        initMap(words, map);

        for (int i = 0; i < length;i++) {

            for (int i = 0;i <= s.length() - words.length * length;i++) {
                int index = 0;
                tmp.clear();

                while (true) {
                    String word = s.substring(i + index * length, i + (index + 1) * length);

                    if (!map.containsKey(word)) break;

                    if (!tmp.containsKey(word)) tmp.put(word, 1);
                    else tmp.put(word, tmp.get(word) + 1);

                    if (tmp.get(word) > map.get(word)) break;

                    index++;

                    if (index == words.length) {
                        list.add(i);
                        break;
                    }
                }
            }
        }

        return list;

    }
}




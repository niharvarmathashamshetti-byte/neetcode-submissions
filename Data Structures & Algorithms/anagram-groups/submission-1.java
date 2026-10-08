

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        String[] sorted = new String[strs.length];

      
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            sorted[i] = new String(arr);
        }

        // Step 2: sorted string -> indexes
        HashMap<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < sorted.length; i++) {

            if (map.containsKey(sorted[i])) {
                map.get(sorted[i]).add(i);
            } 
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(sorted[i], list);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<Integer> indexes : map.values()) {

            List<String> group = new ArrayList<>();

            for (int index : indexes) {
                group.add(strs[index]);
            }

            result.add(group);
        }

        return result;
    }
}
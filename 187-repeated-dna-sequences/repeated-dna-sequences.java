class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();

        // convert to the stringbuilder for more better performance.
        StringBuilder str = new StringBuilder(s);
        // to store the DNA sequences
        List<String> resultList = new ArrayList<>(); 
        // edge case.

        HashMap<String , Integer> map = new HashMap<>();

        if(n <= 10){
            return resultList;
        }

        int i = 0, j = 9;
        while(j < n){
            String substr = str.substring(i , j+1);
            map.put(substr , map.getOrDefault(substr , 0) + 1);
            i++;
            j++;
        }

        for (String key : map.keySet()) {
            if(map.get(key) >= 2){
                resultList.add(key);
            }
        }

        return resultList;
    }
}
       
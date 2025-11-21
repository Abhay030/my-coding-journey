class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();

        // convert to the stringbuilder for more better performance.
        StringBuilder str = new StringBuilder(s);
        // to store the DNA sequences
        List<String> resultList = new ArrayList<>(); 
        // edge case.

        HashMap<String , Integer> map = new HashMap<>();

        // if length is less than or equal to 10 :- then no DNA is possible as DNA length is 10.
        if(n <= 10){
            return resultList;
        }

        // Step 1:- store the DNA in the Hashmap
        int i = 0, j = 9;
        while(j < n){
            String substr = str.substring(i , j+1);
            map.put(substr , map.getOrDefault(substr , 0) + 1);
            i++;
            j++;
        }

        // Step 2:- find all the DNA in the map who has 2 or greater than 2 repetition.
        for (String key : map.keySet()) {
            if(map.get(key) >= 2){
                resultList.add(key);
            }
        }

        return resultList;
    }
}
       
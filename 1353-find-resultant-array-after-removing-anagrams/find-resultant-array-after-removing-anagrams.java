class Solution {
    public List<String> removeAnagrams(String[] words) {
        
        List<String> afterRemoved = new ArrayList<>();
        afterRemoved.add(words[0]);

        for(int i = 1; i < words.length; i++){
            if(!isAnagram(words[i] , words[i-1])){
                afterRemoved.add(words[i]);
            }
        }

        return afterRemoved;
    }

    private boolean isAnagram(String s1 , String s2){
         s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if (s1.length() != s2.length()) {
            return false;
        }

        // Step 3: Convert to char arrays and sort them
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Step 4: Compare sorted arrays
        return Arrays.equals(arr1, arr2);
    }
}


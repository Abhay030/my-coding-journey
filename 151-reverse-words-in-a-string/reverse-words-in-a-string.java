class Solution {
    public String reverseWords(String s) {
        // Step 1: Remove leading and trailing spaces
        s = s.trim();

        // Step 2: Split on one-or-more spaces -> gives clean word array, no empty strings
        String[] words = s.split("\\s+");

        // Step 3: Reverse the array in-place using two pointers
        int start = 0;
        int end = words.length - 1;

        while (start < end) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }

        // Step 4: Join words with a single space — no trailing space, no fragile hacks
        return String.join(" ", words);
    }
}
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] input = s.split("\\s+");

        int start = 0;
        int end = input.length-1;

        while(start < end){
            String temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for(String str: input){
            if (str.equals("")) continue;
            sb.append(str + " ");
        }
        String ans = sb.toString();
        return ans.substring(0 , ans.length()-1);

    }
}
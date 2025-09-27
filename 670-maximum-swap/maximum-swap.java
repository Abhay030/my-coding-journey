class Solution {
    static int maxResult;

    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        maxResult = num;
        maximumValue(arr, 1, 0); // allow at most 1 swap
        return maxResult;
    }

    private void maximumValue(char[] arr, int k, int start) {
        if (k == 0 || start == arr.length - 1) {
            int cand = Integer.parseInt(new String(arr));
            if (cand > maxResult) {
                maxResult = cand;
            }
            return;
        }

        char maxChar = findMaxElement(arr, start); // ✅ separate method

        // agar already max char hai, swap ki zarurat nahi
        if (maxChar == arr[start]) {
            maximumValue(arr, k, start + 1);
            return;
        }

        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] == maxChar) {
                swap(arr, start, i);
                maximumValue(arr, k - 1, start + 1);
                swap(arr, start, i); // backtrack
            }
        }
    }

    private char findMaxElement(char[] arr, int start) {
        char maxi = arr[start];
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] > maxi) {
                maxi = arr[i];
            }
        }
        return maxi;
    }

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}

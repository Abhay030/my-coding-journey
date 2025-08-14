class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;

        // Row 0: [1]
        res.add(Arrays.asList(1));

        // Build rows 1..numRows-1
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = res.get(i - 1);
            List<Integer> row = new ArrayList<>(i + 1);

            row.add(1); // first element
            for (int j = 1; j < i; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1); // last element

            res.add(row);
        }
        return res;
    }
}
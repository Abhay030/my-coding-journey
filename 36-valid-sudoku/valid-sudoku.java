class Solution {
    public boolean isValidSudoku(char[][] board) {
        // 9 sets for rows, 9 for cols, 9 for boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // initialize all sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') continue; // skip empty cells

                int boxIndex = (r / 3) * 3 + (c / 3);

                // check and insert into row set
                if (!rows[r].add(val)) return false;

                // check and insert into col set
                if (!cols[c].add(val)) return false;

                // check and insert into box set
                if (!boxes[boxIndex].add(val)) return false;
            }
        }

        return true;
    }
}
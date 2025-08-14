class Solution {
    public String convert(String s, int numRows) {
        // Step 1: Handle special case
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // Step 2: Create a list of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Step 3: Iterate through characters
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // If at top or bottom row, change direction
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Step 4: Merge all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
